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
}
