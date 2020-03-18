package edu.eci.arsw.easycare.Controller;

import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.model.Paseador;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import edu.eci.arsw.easycare.service.impl.JwtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@Api(value = "servicio Easy Care")
public class EasyCareController {

    @Autowired
    private final EasyCareService easyCareService;

    @Autowired
    private final JwtService jwtService;

    public EasyCareController(EasyCareService easyCareService, JwtService jwtService) {
        this.easyCareService = easyCareService;
        this.jwtService = jwtService;
    }



    @GetMapping("")
    public String holaMundo(Model model){
        return "hola";
    }

    @GetMapping("/clients")
    @ApiOperation(value = "Obtener todos los clientes",notes = "retorna todos los clientes")
    public ResponseEntity<?> getClientes(){
        try {
            return new ResponseEntity<>(easyCareService.getAllClintes(), HttpStatus.ACCEPTED);
        } catch (ExceptionServiciosEasyCare e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/clients/{documento}/{tdoc}")
    @ApiOperation(value = "Encuentra un cliente",notes = "devuelve un solo cliente por documento y tipo de documento")
    public ResponseEntity<?> getClienteByDocument(@PathVariable String documento, @PathVariable String tdoc){
        try{
            return new ResponseEntity<>(easyCareService.getCliente(documento,tdoc), HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No existe el cliente solicitado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/mascotas")
    @ApiOperation(value = "Obtiene todas las mascotas",notes = "devuelve todas las mascotas")
    public ResponseEntity<?> getMascotas(){
        try {
            return new ResponseEntity<>(easyCareService.getMascotas(),HttpStatus.ACCEPTED);
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

    @GetMapping("/paseos")
    @ApiOperation(value = "Obtiene todos los paseos",notes = "devuelve todos los paseos")
    public ResponseEntity<?> getPaseos(){
        try {
            return new ResponseEntity<>(easyCareService.getPaseos(),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de paseos", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/paseos/{id}")
    @ApiOperation(value = "Encuentra un paseo",notes = "devuelve un paseo por id")
    public ResponseEntity<?> getPaseo(@PathVariable Long id){
        try {
            return new ResponseEntity<>(easyCareService.getPaseo(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseo solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/paseadores")
    @ApiOperation(value = "Obtiene todos los paseadores",notes = "Devuelve todos los paseadores")
    public ResponseEntity<?> getPaseadores(){
        try {
            return new ResponseEntity<>(easyCareService.getPaseadores(),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de paseadores", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/paseadores/{documento}/{tdoc}")
    @ApiOperation(value = "Obtiene un paseador",notes = "Devuelve un paseador por documento y tipo de documento")
    public ResponseEntity<?> getPaseador(@PathVariable String documento, @PathVariable String tdoc){
        try {
            return new ResponseEntity<>(easyCareService.getPaseador(documento,tdoc), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/subastas")
    @ApiOperation(value = "Obtine todas las subastas",notes = "Devuelve todas las subastas")
    public ResponseEntity<?> getSubastas(){
        try {
            return new ResponseEntity<>(easyCareService.getSubastas(),HttpStatus.ACCEPTED);
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

    @PostMapping("/clients/login/{correo}/{password}")
    public ResponseEntity<?> authenticateUser(@PathVariable String correo, @PathVariable String password) {
        try{
            Cliente cl = easyCareService.getCliente(correo);
            Paseador ps = easyCareService.getPaseador(correo);
            if(cl!=null && cl.getPassword().equals(password)){
                List<String> roles = new ArrayList<>();
                roles.add("cliente");
                String tk = jwtService.createToken(correo,roles);
                System.out.println(tk);
                return new ResponseEntity<>(tk, HttpStatus.OK);
            }
            else if(ps != null && ps.getPassword().equals(password)){
                List<String> roles = new ArrayList<>();
                roles.add("paseador");
                return new ResponseEntity<>(jwtService.createToken(correo,roles), HttpStatus.ACCEPTED);
            }
            else{
                return new ResponseEntity<>("Rechazo", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (ExceptionServiciosEasyCare e){
            return new ResponseEntity<>("Rechazo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/clients/login/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token){
        System.out.println(token + " Este es el token que llega");
        if(jwtService.user(token).length() >= 0) return new ResponseEntity<>("ok", HttpStatus.ACCEPTED);
        return new ResponseEntity<>("mal", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

}
