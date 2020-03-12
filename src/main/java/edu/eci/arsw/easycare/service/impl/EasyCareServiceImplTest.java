package edu.eci.arsw.easycare.service.impl;

import edu.eci.arsw.data.dao.*;
import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.*;
import edu.eci.arsw.easycare.service.EasyCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("test")
public class EasyCareServiceImplTest implements EasyCareService{


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

    @Override
    public Cliente getCliente(String doocumento, String tdoc) throws PersistenceException {
        return null;
    }

    @Override
    public List<Cliente> getAllClintes() throws PersistenceException {
        return cliente.getClientes();
    }

    @Override
    public void saveCliente(Cliente cliente) throws PersistenceException {

    }

    @Override
    public Mascota getMascota(Long id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Mascota> getMascotas() throws PersistenceException {
        return null;
    }

    @Override
    public void saveMascota(Mascota mascota) throws PersistenceException {

    }

    @Override
    public Paseador getPaseador(String documento, String tdoc) throws PersistenceException {
        return null;
    }

    @Override
    public List<Paseador> getPaseadores() throws PersistenceException {
        return null;
    }

    @Override
    public void savePaseador(Paseador paseador) throws PersistenceException {

    }

    @Override
    public Paseo getPaseo(Long id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Paseo> getPaseos() throws PersistenceException {
        return null;
    }

    @Override
    public void savePaseo(Paseo paseo) throws PersistenceException {

    }

    @Override
    public Subasta getSubasta(Long id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Subasta> getSubastas() throws PersistenceException {
        return null;
    }

    @Override
    public void saveSubasta(Subasta subasta) throws PersistenceException {

    }
}
