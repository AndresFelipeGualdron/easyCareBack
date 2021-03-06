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

}
