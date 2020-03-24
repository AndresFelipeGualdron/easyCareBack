package edu.eci.arsw.easycare.Controller;

import edu.eci.arsw.easycare.service.EasyCareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/clients")
@Api(value = "servicio Paseos")
public class PaseosController {

    @Autowired
    private final EasyCareService easyCareService;

    public PaseosController(EasyCareService easyCareService) {
        this.easyCareService = easyCareService;
    }

    @GetMapping("/paseos")
    @ApiOperation(value = "Obtiene todos los paseos",notes = "devuelve todos los paseos")
    public ResponseEntity<?> getPaseos(){
        try {
            return new ResponseEntity<>(easyCareService.getPaseos(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de paseos", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/paseos/{id}")
    @ApiOperation(value = "Encuentra un paseo",notes = "devuelve un paseo por id")
    public ResponseEntity<?> getPaseo(@PathVariable int id){
        try {
            return new ResponseEntity<>(easyCareService.getPaseo(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseo solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }
}
