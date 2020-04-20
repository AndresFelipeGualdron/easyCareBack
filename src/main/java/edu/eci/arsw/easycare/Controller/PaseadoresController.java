package edu.eci.arsw.easycare.Controller;


import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.model.Paseador;
import edu.eci.arsw.easycare.model.Subasta;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import edu.eci.arsw.easycare.service.impl.JwtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/paseadores")
@Api(value = "servicio Easy Care Paseadores")
public class PaseadoresController {

    @Autowired
    private final EasyCareService easyCareService;

    @Autowired
    private final JwtService jwtService;

    public PaseadoresController(EasyCareService easyCareService, JwtService jwtService) {
        this.easyCareService = easyCareService;
        this.jwtService = jwtService;
    }


    @GetMapping("")
    @ApiOperation(value = "Obtiene todos los paseadores",notes = "Devuelve todos los paseadores")
    public ResponseEntity<?> getPaseadores(){
        try {
            return new ResponseEntity<>(easyCareService.getPaseadores(),HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de paseadores", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sort/{tipo}")
    @ApiOperation(value = "Obtiene todos los paseadores en un orden específico",notes = "Devuelve todos los paseadores en un orden específico")
    public ResponseEntity<?> getPaseadoresSort(@PathVariable("tipo") String tipo){
        try{
            return new ResponseEntity<>(easyCareService.getPaseadoresOrder(tipo), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("No existe registro de paseadores", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{documento}/{tdoc}")
    @ApiOperation(value = "Obtiene un paseador",notes = "Devuelve un paseador por documento y tipo de documento")
    public ResponseEntity<?> getPaseador(@PathVariable String documento, @PathVariable String tdoc){
        try {
            return new ResponseEntity<>(easyCareService.getPaseador(documento,tdoc), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/whoami")
    @ApiOperation(value = "Obtiene informacion del paseador autenticado", notes = "El paseador solicitado debe estar autenticado")
    public ResponseEntity<?> getPaseador(@RequestHeader("Authorization") String token){
        try{
            String correo = jwtService.user(token);
            if(correo.length() > 0){
                Paseador paseador = easyCareService.getPaseador(correo);
                return new ResponseEntity<>(paseador,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No autenticado", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
            }

        }catch (Exception e){
            return new ResponseEntity<>("Error en la solicitud", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/login/{correo}/{password}")
    public ResponseEntity<?> authenticateUser(@PathVariable String correo, @PathVariable String password) {
        try{
            Paseador ps = easyCareService.getPaseador(correo);
            if(ps!=null && ps.getPassword().equals(password)){
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

    @PostMapping("/login/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token){
        System.out.println(token + " Este es el token que llega");
        if(jwtService.user(token).length() >= 0) return new ResponseEntity<>("ok", HttpStatus.ACCEPTED);
        return new ResponseEntity<>("mal", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    @PostMapping("/register/{correo}/{password}/{nombre}/{cedula}/{telefono}")
    public ResponseEntity<?> registrar(@PathVariable String correo, @PathVariable String password, @PathVariable String nombre, @PathVariable String cedula, @PathVariable String telefono) {
        try {
            System.out.println("yaaaaaaaaaaaaaaaaaaaaaaaaa");
            Paseador paseador = new Paseador();
            paseador.setCorreo(correo);
            paseador.setPassword(password);
            paseador.setNombre(nombre);
            paseador.setTipoDocumento("cedula");
            paseador.setDocumento(cedula);
            paseador.setTelefono(telefono);
            paseador.setCalificacion(Long.valueOf(0));
            easyCareService.savePaseador(paseador);
            List<String> roles = new ArrayList<>();
            roles.add("cliente");
            String tok = jwtService.createToken(paseador.getCorreo(), roles);
            return new ResponseEntity<>(tok, HttpStatus.ACCEPTED);
        } catch (ExceptionServiciosEasyCare e) {
            e.printStackTrace();
            return new ResponseEntity<>("Rechazo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/registrarEnSubasta/{subasta}")
    public ResponseEntity<?> registrarEnSubasta(@RequestHeader("Authorization") String token, @PathVariable int subasta){
        try{
            String correo = jwtService.user(token);
            if(correo.length() > 0){
                Paseador paseador = this.easyCareService.getPaseador(correo);
                Subasta s = this.easyCareService.getSubasta(subasta);
                this.easyCareService.entrarASubasta(paseador,s);
                List<Paseador> paseadores = this.easyCareService.getPaseadoresEnSubasta(s);
                return new ResponseEntity<>(paseadores, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No autenticado", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error en la solicitud", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
