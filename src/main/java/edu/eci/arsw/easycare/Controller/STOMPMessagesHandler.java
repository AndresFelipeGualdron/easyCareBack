package edu.eci.arsw.easycare.Controller;


import edu.eci.arsw.easycare.model.Subasta;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class STOMPMessagesHandler {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private EasyCareService easyCareService;

    @MessageMapping("/nuevaSubasta")
    public void nuevaSubastaEvent(String datos){
        try {
            System.out.println(datos);
            JSONObject json = new JSONObject(datos);
            Subasta subasta = new Subasta();
            subasta.setCreador(json.getJSONObject("subasta").getString("creador"));
            subasta.setNumMascotas(json.getJSONObject("subasta").getInt("numMascotas"));
            String latitud = String.valueOf(json.getDouble("latitud"));
            String longitud = String.valueOf(json.getDouble("longitud"));
            this.easyCareService.saveSubasta(subasta, latitud, longitud);
            this.simpMessagingTemplate.convertAndSend("/topic/subastas",subasta);
            this.easyCareService.addSubasta(subasta);
        } catch (ExceptionServiciosEasyCare exceptionServiciosEasyCare) {
            exceptionServiciosEasyCare.printStackTrace();
        }
    }

    @MessageMapping("/cerrarSubasta.{numSubasta}")
    public void cerrarSubastaEvent(@DestinationVariable int numSubasta){
        try{
            Subasta sub = this.easyCareService.getSubasta(numSubasta);
            this.easyCareService.cerrarSubasta(numSubasta);
            this.simpMessagingTemplate.convertAndSend("/topic/subastas/cerrar", sub);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
