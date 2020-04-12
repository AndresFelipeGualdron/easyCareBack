package edu.eci.arsw.easycare.Controller;


import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.model.Paseador;
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
            subasta.setPermitirMasMascotas(json.getJSONObject("subasta").getBoolean("permitirMasMascotas"));
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
            this.simpMessagingTemplate.convertAndSend("/topic/cerrar/subasta."+numSubasta, sub);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @MessageMapping("/subasta.{numSubasta}")
    public void subastaEvent(Paseador paseador, @DestinationVariable int numSubasta){
        try {
            System.out.println(numSubasta);
            Subasta subasta = new Subasta();
            subasta.setId(numSubasta);
            this.easyCareService.entrarASubasta(paseador, subasta);
            this.simpMessagingTemplate.convertAndSend("/topic/subasta."+numSubasta, paseador);
        } catch (ExceptionServiciosEasyCare exceptionServiciosEasyCare) {
            exceptionServiciosEasyCare.printStackTrace();
        }
    }

    @MessageMapping("/salirsubasta.{numSubasta}")
    public void salirSubastaEvent(Paseador paseador, @DestinationVariable int numSubasta){
        try{
            System.out.println("eliminando paseador de subasta: "+numSubasta);
            Subasta subasta = new Subasta();
            subasta.setId(numSubasta);
            this.easyCareService.salirDeSubasta(paseador,subasta);
            this.simpMessagingTemplate.convertAndSend("/topic/eliminarpaseador/subasta."+numSubasta, paseador);
        }catch (ExceptionServiciosEasyCare exceptionServiciosEasyCare){
            exceptionServiciosEasyCare.printStackTrace();
        }
    }

    @MessageMapping("/agregaroferta/subasta.{numSubasta}")
    public void agregarOfertaSubasta(String datos, @DestinationVariable int numSubasta){
        try{
            System.out.println(datos);
            JSONObject json = new JSONObject(datos);
            Subasta subasta = new Subasta();
            subasta.setId(json.getJSONObject("subasta").getInt("id"));
            Paseador paseador = this.easyCareService.getPaseador(json.getJSONObject("ofertor").getString("correo"));
            int oferta = json.getInt("oferta");
            this.easyCareService.agregarOfertaSubasta(subasta,paseador,oferta);
            this.simpMessagingTemplate.convertAndSend("/topic/agregaroferta/subasta."+numSubasta,datos);
        }catch (ExceptionServiciosEasyCare exceptionServiciosEasyCare){
            exceptionServiciosEasyCare.printStackTrace();
        }
    }
}
