package edu.eci.arsw.easycare.Controller;

import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.model.Paseo;
import edu.eci.arsw.easycare.model.Subasta;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.impl.JwtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/subastas")
@Api(value = "servicio Paseos")
public class SubastasController {

    @Autowired
    private final EasyCareService easyCareService;
    @Autowired
    private JwtService jwtService;

    public SubastasController(EasyCareService easyCareService) {
        this.easyCareService = easyCareService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Obtine todas las subastas",notes = "Devuelve todas las subastas")
    public ResponseEntity<?> getSubastas(){
        try {
            return new ResponseEntity<>(easyCareService.getSubastas(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("No existe registro de subastas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Encuentra una subasta",notes = "Devuelve una subasta por id")
    public ResponseEntity<?> getSubasta(@PathVariable int id){
        try {
            return new ResponseEntity<>(easyCareService.getSubasta(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/subasta/{paseo}/{mascotas}/{permitirMascotas}")
    public ResponseEntity<?> saveSubasta(@RequestHeader("Authorization") String token,
                                         @PathVariable int paseo,
                                         @PathVariable int mascotas,
                                         @PathVariable boolean permitirMascotas){
        try{
            String correo = jwtService.user(token);
            if(correo.length() > 0){
                Subasta subasta = new Subasta();
                Paseo paseo1 = this.easyCareService.getPaseo(paseo);
                subasta.setCreador(correo);
                subasta.setIdpaseo(paseo1);
                subasta.setOferta(0);
                subasta.setNumMascotas(mascotas);
                subasta.setPermitirMasMascotas(permitirMascotas);
                this.easyCareService.saveSubasta(subasta);
                return new ResponseEntity<>(subasta, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No autorizado",HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/iniciadas")
    public ResponseEntity<?> getSubastasIniciadas(@RequestHeader("Authorization") String token){
        try{
            String correo = jwtService.user(token);
            if(correo.length() > 0){
                return new ResponseEntity<>(this.easyCareService.getSubastasIniciadas(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No autorizado",HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("El paseador solicitado no existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
