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

    @GetMapping("/{documento}/{tdoc}")
    @ApiOperation(value = "Obtiene un paseador",notes = "Devuelve un paseador por documento y tipo de documento")
    public ResponseEntity<?> getPaseador(@PathVariable String documento, @PathVariable String tdoc){
        try {
            return new ResponseEntity<>(easyCareService.getPaseador(documento,tdoc), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/login/{correo}/{password}")
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

    @PostMapping("/login/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token){
        System.out.println(token + " Este es el token que llega");
        if(jwtService.user(token).length() >= 0) return new ResponseEntity<>("ok", HttpStatus.ACCEPTED);
        return new ResponseEntity<>("mal", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }
}
