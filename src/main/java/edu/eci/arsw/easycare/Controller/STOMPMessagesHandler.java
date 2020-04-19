package edu.eci.arsw.easycare.Controller;


import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.model.Paseador;
import edu.eci.arsw.easycare.model.Subasta;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class STOMPMessagesHandler {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private EasyCareService easyCareService;

    private Timer timer;
    private TimerTask timerTask;
    private ConcurrentHashMap<String, Cliente> sesiones = new ConcurrentHashMap<>();

    public STOMPMessagesHandler(){

//        this.timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                easyCareService.getSubastasEnCurso().forEach((numSubasta, subasta) -> {
//                    simpMessagingTemplate.convertAndSend("/subasta/"+numSubasta+"/"+subasta.getCreador());
//                    simpMessagingTemplate.
//                });
//            }
//        };

    }

    @MessageMapping("/nuevaSubasta")
    public void nuevaSubastaEvent(String datos, SessionSubscribeEvent sessionSubscribeEvent){
        try {
            System.out.println(datos);
            System.out.println(sessionSubscribeEvent.toString());
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
            this.simpMessagingTemplate.convertAndSendToUser("migue24co@gmail.com","subasta",subasta);
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

    @EventListener
    private void handleSessionConnect(SessionConnectedEvent event){
        System.out.println("Conectadoooooooooooooooo "+event.getMessage().getHeaders());
        System.out.println("Conectadoooooooooooooooo "+event.getUser());
        System.out.println("Conectadoooooooooooooooo "+event.getSource());
        System.out.println("Conectadoooooooooooooooo "+event.getTimestamp());
        System.out.println("Conectadoooooooooooooooo "+event.getMessage());
    }

    @EventListener
    private void handleSessionDesconnect(SessionDisconnectEvent event){
        System.out.println("Desconectadooooooooooooooooooo" + event.toString());
    }

    @SubscribeMapping("/subasta/{numSubasta}/{user}")
    private void handleSessionSubscription(@DestinationVariable int numSubasta, @DestinationVariable String user){
        System.out.println("Conectadoooooooooooooooo Subscriptoooooooooooooorrrrrrrrrrrrrrr "+user+" "+numSubasta);
    }

    @EventListener
    private void handleSessionSubscription(SessionUnsubscribeEvent event){
        System.out.println("Desconectadooooooooooooooooooo Subscriptoooooooooooooooooooooooor "+event.getMessage());
    }
}
