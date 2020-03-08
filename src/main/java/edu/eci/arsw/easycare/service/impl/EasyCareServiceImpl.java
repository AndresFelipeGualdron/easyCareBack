package edu.eci.arsw.easycare.service.impl;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.data.dao.mybatis.mappers.*;
import edu.eci.arsw.easycare.model.*;
import edu.eci.arsw.easycare.service.EasyCareService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@Component
public class EasyCareServiceImpl implements  EasyCareService{

    @Autowired
    private  ClienteMapper cliente;
    @Autowired
    private MascotaMapper mascota;
    @Autowired
    private PaseadorMapper paseador;
    @Autowired
    private PaseoMapper paseo;
    @Autowired
    private SubastaMapper subasta;


    @Override
    public Cliente getCliente(String id, String tdoc) throws PersistenceException {
        return this.cliente.getCliente(id, tdoc);
    }

    @Override
    public List<Cliente> getAllClintes() throws PersistenceException {

        return this.cliente.getClientes();
    }

    @Override
    public void saveCliente(Cliente cliente) throws PersistenceException {
        this.cliente.save(cliente);
    }

    @Override
    public Mascota getMascota(Long id) throws PersistenceException {
        return this.mascota.getMascota(id);
    }

    @Override
    public List<Mascota> getMascotas() throws PersistenceException {
        return this.mascota.getMascotas();
    }

    @Override
    public void saveMascota(Mascota mascota) throws PersistenceException {
        this.mascota.save(mascota);
    }

    @Override
    public Paseador getPaseador(String documento, String tdoc) throws PersistenceException {
        return this.paseador.getPaseador(documento, tdoc);
    }

    @Override
    public List<Paseador> getPaseadores() throws PersistenceException {
        return this.paseador.getPaseadores();
    }

    @Override
    public void savePaseador(Paseador paseador) throws PersistenceException {
        this.paseador.save(paseador);
    }

    @Override
    public Paseo getPaseo(Long id) throws PersistenceException {
        return this.paseo.getPaseo(id);
    }

    @Override
    public List<Paseo> getPaseos() throws PersistenceException {
        return this.paseo.getPaseos();
    }

    @Override
    public void savePaseo(Paseo paseo) throws PersistenceException {
        this.paseo.save(paseo);
    }

    @Override
    public Subasta getSubasta(Long id) throws PersistenceException {
        return this.subasta.getSubasta(id);
    }

    @Override
    public List<Subasta> getSubastas() throws PersistenceException {
        return this.subasta.getSubastas();
    }

    @Override
    public void saveSubasta(Subasta subasta) throws PersistenceException {
        this.subasta.save(subasta);
    }


}