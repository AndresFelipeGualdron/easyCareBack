package edu.eci.arsw.easycare.service;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.*;

import java.util.List;

public interface EasyCareService {

    Cliente getCliente(String doocumento, String tdoc) throws PersistenceException;

    List<Cliente> getAllClintes() throws PersistenceException;

    void saveCliente(Cliente cliente) throws PersistenceException;

    Mascota getMascota(Long id) throws PersistenceException;

    List<Mascota> getMascotas() throws PersistenceException;

    void saveMascota(Mascota mascota) throws PersistenceException;

    Paseador getPaseador(String documento, String tdoc) throws PersistenceException;

    List<Paseador> getPaseadores() throws PersistenceException;

    void savePaseador(Paseador paseador) throws PersistenceException;

    Paseo getPaseo(Long id) throws PersistenceException;

    List<Paseo> getPaseos() throws PersistenceException;

    void savePaseo(Paseo paseo) throws PersistenceException;

    Subasta getSubasta(Long id) throws PersistenceException;

    List<Subasta> getSubastas() throws PersistenceException;

    void saveSubasta(Subasta subasta) throws PersistenceException;
}
