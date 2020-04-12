package edu.eci.arsw.easycare.Controller;

import com.google.gson.Gson;
import edu.eci.arsw.easycare.model.Subasta;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.impl.JwtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicReference;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/subastas")
@Api(value = "servicio Paseos")
public class SubastasController {

    @Autowired
    private final EasyCareService easyCareService;
    @Autowired
    private JwtService jwtService;

    public SubastasController(EasyCareService easyCareService) {
        this.easyCareService = easyCareService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Obtine todas las subastas",notes = "Devuelve todas las subastas")
    public ResponseEntity<?> getSubastas(){
        try {
            return new ResponseEntity<>(easyCareService.getSubastas(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de subastas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Encuentra una subasta",notes = "Devuelve una subasta por id")
    public ResponseEntity<?> getSubasta(@PathVariable int id){
        try {
            return new ResponseEntity<>(easyCareService.getSubasta(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/iniciadas")
    public ResponseEntity<?> getSubastasIniciadas(@RequestHeader("Authorization") String token){
        try{
            String correo = jwtService.user(token);
            if(correo.length() > 0){
                return new ResponseEntity<>(this.easyCareService.getSubastasIniciadas(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No autorizado",HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{subasta}/ofertas")
    public ResponseEntity<?> getOfertasSubasta(@PathVariable int subasta){
        try{
            Subasta subasta1 = new Subasta();
            subasta1.setId(subasta);
            System.out.println(this.easyCareService.getOfertasSubasta(subasta1).size() +" siiiiiiii");
            return new ResponseEntity<>(this.easyCareService.getOfertasSubasta(subasta1), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
