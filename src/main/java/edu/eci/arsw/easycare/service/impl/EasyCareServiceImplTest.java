package edu.eci.arsw.easycare.service.impl;

import edu.eci.arsw.data.dao.*;
import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.*;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("test")
public class EasyCareServiceImplTest extends EasyCareServiceImpl{


    public EasyCareService service;

    @Autowired
    @Qualifier("clienteDAOTest")
    private ClienteDAO cliente;
    @Autowired
    @Qualifier("mascotaDAOTest")
    private MascotaDAO mascota;
    @Autowired
    @Qualifier("paseadorDAOTest")
    private PaseadorDAO paseador;
    @Autowired
    @Qualifier("paseoDAOTest")
    private PaseoDAO paseo;
    @Autowired
    @Qualifier("subastaDAOTest")
    private SubastaDAO subasta;
    @Autowired
    @Qualifier("rutaDAOTest")
    private RutaDAO ruta;
    @Autowired
    @Qualifier("paseoEnCursoDAOTest")
    private PaseoEnCursoDAO paseoEnCurso;
    @Autowired
    @Qualifier("ubicacionDAOTest")
    private UbicacionDAO ubicacion;


    @Override
    public Cliente getCliente(String doocumento, String tdoc) throws ExceptionServiciosEasyCare {
        super.setCliente(cliente);
        return super.getCliente(doocumento,tdoc);
    }

    @Override
    public Cliente getCliente(String correo) throws ExceptionServiciosEasyCare{
        super.setCliente(cliente);
        return super.getCliente(correo);
    }

    @Override
    public List<Cliente> getAllClintes() throws ExceptionServiciosEasyCare {
        super.setCliente(cliente);
        return super.getAllClintes();
    }

    @Override
    public void saveCliente(Cliente cliente) throws ExceptionServiciosEasyCare {
        super.setCliente(this.cliente);
        super.saveCliente(cliente);
    }


    @Override
    public Mascota getMascota(int id) throws ExceptionServiciosEasyCare {
        super.setMascota(this.mascota);
        return super.getMascota(id);
    }

    @Override
    public List<Mascota> getMascotas() throws ExceptionServiciosEasyCare {
        super.setMascota(this.mascota);
        return super.getMascotas();
    }

    @Override
    public List<Mascota> getMascotas(String cliente) throws ExceptionServiciosEasyCare{
        super.setCliente(this.cliente);
        super.setMascota(this.mascota);
        return super.getMascotas(cliente);
    }

    @Override
    public void saveMascota(Mascota mascota) throws ExceptionServiciosEasyCare {
        super.setMascota(this.mascota);
        super.saveMascota(mascota);
    }

    @Override
    public Paseador getPaseador(String documento, String tdoc) throws ExceptionServiciosEasyCare {
        super.setPaseador(this.paseador);
        return this.getPaseador(documento, tdoc);
    }

    @Override
    public Paseador getPaseador(String correo) throws ExceptionServiciosEasyCare {
        super.setPaseador(this.paseador);
        return super.getPaseador(correo);
    }

    @Override
    public List<Paseador> getPaseadores() throws ExceptionServiciosEasyCare {
        super.setPaseador(this.paseador);
        return super.getPaseadores();
    }

    @Override
    public List<Paseador> getPaseadoresOrder(String order) throws ExceptionServiciosEasyCare {
        super.setPaseador(this.paseador);
        return super.getPaseadoresOrder(order);
    }

    @Override
    public void savePaseador(Paseador paseador) throws ExceptionServiciosEasyCare {
        super.setPaseador(this.paseador);
        super.savePaseador(paseador);
    }

    @Override
    public Paseo getPaseo(int id) throws ExceptionServiciosEasyCare {
        super.setPaseo(this.paseo);
        return super.getPaseo(id);
    }

    @Override
    public List<Paseo> getPaseos() throws ExceptionServiciosEasyCare {
        super.setPaseo(this.paseo);
        return super.getPaseos();
    }

    @Override
    public Subasta getSubasta(int id) throws ExceptionServiciosEasyCare {
        super.setSubasta(this.subasta);
        return super.getSubasta(id);
    }

    @Override
    public List<Subasta> getSubastas() throws ExceptionServiciosEasyCare {
        super.setSubasta(this.subasta);
        return super.getSubastas();
    }

    @Override
    public void saveSubasta(Subasta subasta,String latitud, String longitud) throws ExceptionServiciosEasyCare {
        super.setSubasta(this.subasta);
        super.saveSubasta(subasta, latitud, longitud);
    }

    @Override
    public void cerrarSubasta(int id) throws ExceptionServiciosEasyCare {
        super.setSubasta(this.subasta);
        super.cerrarSubasta(id);
    }

    @Override
    public List<Paseador> getPaseadoresEnSubasta(Subasta subasta) throws ExceptionServiciosEasyCare {
        super.setPaseador(this.paseador);
        return super.getPaseadoresEnSubasta(subasta);
    }

    @Override
    public void entrarASubasta(Paseador paseador, Subasta subasta) throws ExceptionServiciosEasyCare {
        super.setPaseador(this.paseador);
        super.entrarASubasta(paseador, subasta);
    }
}
