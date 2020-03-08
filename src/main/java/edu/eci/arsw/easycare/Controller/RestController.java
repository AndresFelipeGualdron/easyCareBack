package edu.eci.arsw.easycare.Controller;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.*;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExcepcionServiciosEasyCare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class RestController {

    private final EasyCareService easyCareService;

    public RestController(EasyCareService easyCareService) {
        this.easyCareService = easyCareService;
    }

    @GetMapping("")
    public String holaMundo(Model model){
        return "hola";
    }

    @GetMapping("/Clients")
    public ResponseEntity<?> getClientes(){
        try {
            return new ResponseEntity<>(easyCareService.getAllClintes(), HttpStatus.ACCEPTED);
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/Clients/{documento}/{tdoc}")
    public ResponseEntity<?> getClienteByDocument(@PathVariable Long documento, @PathVariable String tdoc){
        try{
            return new ResponseEntity<>(easyCareService.getCliente(documento,tdoc), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe el cliente solicitado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Clients")
    public ResponseEntity<?> postCliente(@Valid @RequestBody Cliente cliente){
        try {
            easyCareService.saveCliente(cliente);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>("No se pudo crear el cliente", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/Mascotas")
    public ResponseEntity<?> getMascotas(){
        try {
            return new ResponseEntity<>(easyCareService.getMascotas(),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontraron mascotas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Mascotas/{id}")
    public ResponseEntity<?> getMascota(@PathVariable Long id){
        try {
            return new ResponseEntity<>(easyCareService.getMascota(id),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No se encontró la mascota requerida",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Mascotas")
    public ResponseEntity<?> postMascota(@Valid @RequestBody Mascota mascota){
        try {
            easyCareService.saveMascota(mascota);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("No fue posible adicionar la mascota",HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/Paseos")
    public ResponseEntity<?> getPaseos(){
        try {
            return new ResponseEntity<>(easyCareService.getPaseos(),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de paseos", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Paseos/{id}")
    public ResponseEntity<?> getPaseo(@PathVariable Long id){
        try {
            return new ResponseEntity<>(easyCareService.getPaseo(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseo solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Paseos")
    public ResponseEntity<?> postPaseo(@Valid @RequestBody Paseo paseo){
        try {
            easyCareService.savePaseo(paseo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("No fue posible adicionar el paseo",HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/Paseadores")
    public ResponseEntity<?> getPaseadores(){
        try {
            return new ResponseEntity<>(easyCareService.getPaseadores(),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de paseadores", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Paseadores/{documento}/{tdoc}")
    public ResponseEntity<?> getPaseador(@PathVariable Long documento, @PathVariable String tdoc){
        try {
            return new ResponseEntity<>(easyCareService.getPaseador(documento,tdoc), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Paseadores")
    public ResponseEntity<?> postPaseador(@Valid @RequestBody Paseador paseador){
        try {
            easyCareService.savePaseador(paseador);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("No fue posible adicionar el paseador",HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/Subastas")
    public ResponseEntity<?> getSubastas(){
        try {
            return new ResponseEntity<>(easyCareService.getSubastas(),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de subastas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Subastas/{id}")
    public ResponseEntity<?> getSubasta(@PathVariable Long id){
        try {
            return new ResponseEntity<>(easyCareService.getSubasta(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Subastas")
    public ResponseEntity<?> postSubasta(@Valid @RequestBody Subasta subasta){
        try {
            easyCareService.saveSubasta(subasta);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("No fue posible adicionar la subasta",HttpStatus.FORBIDDEN);
        }
    }
}
