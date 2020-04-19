package edu.eci.arsw.easycare.Controller;

import edu.eci.arsw.easycare.model.Mascota;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/mascotas")
@Api(value = "servicio Mascotas")
public class MascotasController {

    @Autowired
    private final EasyCareService easyCareService;

    public MascotasController(EasyCareService easyCareService) {
        this.easyCareService = easyCareService;
    }

    @GetMapping("")
    @ApiOperation(value = "Obtiene todas las mascotas",notes = "devuelve todas las mascotas")
    public ResponseEntity<?> getMascotas(){
        try {
            return new ResponseEntity<>(easyCareService.getMascotas(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontraron mascotas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "encuentra una mascota",notes = "devuelve una mascota por id")
    public ResponseEntity<?> getMascota(@PathVariable int id){
        try {
            return new ResponseEntity<>(easyCareService.getMascota(id),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontró la mascota requerida",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "Registra mascota", notes = "No retorna algún valor")
    public ResponseEntity<?> postMascota(@RequestBody Mascota mascota){
        try{
            System.out.println("entre");
            easyCareService.saveMascota(mascota);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No fue posible registrar la mascota", HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/mascota")
    @ApiOperation(value = "Permite actualizar la mascota", notes = "No devuelve algún valor")
    public ResponseEntity<?> actualizarMascota(@Valid @RequestBody Mascota mascota){
        try {
            System.out.println(mascota.getNombre());
            easyCareService.updateMascota(mascota);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No fue posible actualizar la mascota", HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/mascota/{id}")
    @ApiOperation(value = "Permite eliminar la mascota deseada de la base de datos", notes = "No devueve algún valor")
    public ResponseEntity<?> deletemascota(@PathVariable int id){
        try {
            System.out.println(id);
            easyCareService.deleteMascota(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No fue posible eliminar la mascota", HttpStatus.FORBIDDEN);
        }
    }

}
