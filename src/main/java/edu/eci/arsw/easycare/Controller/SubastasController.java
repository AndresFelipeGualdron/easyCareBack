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
public class SubastasController {

    @Autowired
    private final EasyCareService easyCareService;

    public SubastasController(EasyCareService easyCareService) {
        this.easyCareService = easyCareService;
    }

    @GetMapping("/subastas")
    @ApiOperation(value = "Obtine todas las subastas",notes = "Devuelve todas las subastas")
    public ResponseEntity<?> getSubastas(){
        try {
            return new ResponseEntity<>(easyCareService.getSubastas(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de subastas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/subastas/{id}")
    @ApiOperation(value = "Encuentra una subasta",notes = "Devuelve una subasta por id")
    public ResponseEntity<?> getSubasta(@PathVariable Long id){
        try {
            return new ResponseEntity<>(easyCareService.getSubasta(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }
}
