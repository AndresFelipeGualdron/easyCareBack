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
@Api(value = "servicio Mascotas")
public class MascotasController {

    @Autowired
    private final EasyCareService easyCareService;

    public MascotasController(EasyCareService easyCareService) {
        this.easyCareService = easyCareService;
    }

    @GetMapping("/mascotas")
    @ApiOperation(value = "Obtiene todas las mascotas",notes = "devuelve todas las mascotas")
    public ResponseEntity<?> getMascotas(){
        try {
            return new ResponseEntity<>(easyCareService.getMascotas(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontraron mascotas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/mascotas/{id}")
    @ApiOperation(value = "encuentra una mascota",notes = "devuelve una mascota por id")
    public ResponseEntity<?> getMascota(@PathVariable Long id){
        try {
            return new ResponseEntity<>(easyCareService.getMascota(id),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontró la mascota requerida",HttpStatus.NOT_FOUND);
        }
    }
}
