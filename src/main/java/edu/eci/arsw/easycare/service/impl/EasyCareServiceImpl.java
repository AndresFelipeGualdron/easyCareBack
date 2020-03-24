package edu.eci.arsw.easycare.service.impl;

import edu.eci.arsw.data.dao.*;
import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.*;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@Component
@Primary
public class EasyCareServiceImpl implements  EasyCareService{

    @Autowired
    private ClienteDAO cliente;
    @Autowired
    private MascotaDAO mascota;
    @Autowired
    private PaseadorDAO paseador;
    @Autowired
    private PaseoDAO paseo;
    @Autowired
    private SubastaDAO subasta;


    @Override
    public Cliente getCliente(String id, String tdoc) throws ExceptionServiciosEasyCare {
        try {
            return this.cliente.getCliente(id, tdoc);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public Cliente getCliente(String correo) throws ExceptionServiciosEasyCare {
        try{
//            return new Cliente();
            return this.cliente.getCliente(correo);
        }catch (PersistenceException e){
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
//            return null;
        }
    }

    @Override
    public List<Cliente> getAllClintes() throws ExceptionServiciosEasyCare {
        try {
            return this.cliente.getClientes();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public void saveCliente(Cliente cliente) throws ExceptionServiciosEasyCare {
        try {
            this.cliente.save(cliente);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new ExceptionServiciosEasyCare("No se ha podido completar la operación",e);
        }
    }

    @Override
    public Mascota getMascota(int id) throws ExceptionServiciosEasyCare {
        try {
            return this.mascota.getMascota(id);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("No se ha podido realizar la consulta", e);
        }
    }

    @Override
    public List<Mascota> getMascotas() throws ExceptionServiciosEasyCare {
        try {
            return this.mascota.getMascotas();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Mascota> getMascotas(String cliente) throws ExceptionServiciosEasyCare {
        try{
            Cliente cliente1 = this.getCliente(cliente);
            return this.mascota.getMascotas(cliente1.getDocumento(), cliente1.getTipoDocumento());
        }catch (PersistenceException e){
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public void saveMascota(Mascota mascota) throws ExceptionServiciosEasyCare {
        try {
            this.mascota.save(mascota);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la operacioón",e);
        }
    }

    @Override
    public Paseador getPaseador(String documento, String tdoc) throws ExceptionServiciosEasyCare {
        try {
            return this.paseador.getPaseador(documento, tdoc);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public Paseador getPaseador(String correo) throws ExceptionServiciosEasyCare {
        try{
            return this.paseador.getPaseador(correo);
        }catch (PersistenceException e){
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Paseador> getPaseadores() throws ExceptionServiciosEasyCare {
        try {
            return this.paseador.getPaseadores();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Paseador> getPaseadoresOrder(String order) throws ExceptionServiciosEasyCare {
        try{
            return this.paseador.getPaseadores(order);
        }catch (PersistenceException e){
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public void savePaseador(Paseador paseador) throws ExceptionServiciosEasyCare {
        try {
            this.paseador.save(paseador);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la operación",e);
        }
    }

    @Override
    public Paseo getPaseo(int id) throws ExceptionServiciosEasyCare {
        try {
            return this.paseo.getPaseo(id);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Paseo> getPaseos() throws ExceptionServiciosEasyCare {
        try {
            return this.paseo.getPaseos();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public void savePaseo(Paseo paseo) throws ExceptionServiciosEasyCare {
        try {
            this.paseo.save(paseo);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la operación",e);
        }
    }

    @Override
    public Subasta getSubasta(int id) throws ExceptionServiciosEasyCare {
        try {
            return this.subasta.getSubasta(id);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Subasta> getSubastas() throws ExceptionServiciosEasyCare {
        try {
            return this.subasta.getSubastas();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public void saveSubasta(Subasta subasta) throws ExceptionServiciosEasyCare {
        try {
            this.subasta.save(subasta);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la ooperación",e);
        }
    }

//    TESTS

    public void setCliente(ClienteDAO cliente) {
        this.cliente = cliente;
    }

    public void setMascota(MascotaDAO mascota) {
        this.mascota = mascota;
    }

    public void setPaseador(PaseadorDAO paseador) {
        this.paseador = paseador;
    }

    public void setPaseo(PaseoDAO paseo) {
        this.paseo = paseo;
    }

    public void setSubasta(SubastaDAO subasta) {
        this.subasta = subasta;
    }


}