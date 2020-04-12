package edu.eci.arsw.easycare.Controller;

import edu.eci.arsw.easycare.model.Paseo;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.impl.JwtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/paseos")
@Api(value = "servicio Paseos")
public class PaseosController {

    @Autowired
    private final EasyCareService easyCareService;

    @Autowired
    private JwtService jwtService;

    public PaseosController(EasyCareService easyCareService) {
        this.easyCareService = easyCareService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Obtiene todos los paseos",notes = "devuelve todos los paseos")
    public ResponseEntity<?> getPaseos(){
        try {
            return new ResponseEntity<>(easyCareService.getPaseos(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de paseos", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Encuentra un paseo",notes = "devuelve un paseo por id")
    public ResponseEntity<?> getPaseo(@PathVariable int id){
        try {
            return new ResponseEntity<>(easyCareService.getPaseo(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseo solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/paseo/{latitud}/{longitud}")
    @ApiOperation(value = "Guarda un paseo",notes = "crea un nuevo paseo")
    public ResponseEntity<?> savePaseo(@RequestHeader("Authorization") String token, @PathVariable String latitud, @PathVariable String longitud){
        try{
            String correo = jwtService.user(token);
            if(correo.length() > 0){
                Paseo paseo = new Paseo();
                this.easyCareService.savePaseo(paseo, latitud, longitud);
                return new ResponseEntity<>(paseo, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No autorizado",HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("El paseo no se pudo registrar", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
