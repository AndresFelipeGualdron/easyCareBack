package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Paseador;
import edu.eci.arsw.easycare.model.Subasta;

import java.util.List;

public interface PaseadorDAO {

    Paseador getPaseador(String documento, String tdoc) throws PersistenceException;

    Paseador getPaseador(String correo) throws PersistenceException;

    List<Paseador> getPaseadores() throws PersistenceException;

    List<Paseador> getPaseadores(String order) throws PersistenceException;

    void save(Paseador paseador) throws PersistenceException;

    List<Paseador> getPaseadoresEnSubasta(Subasta subasta) throws PersistenceException;

    void entrarEnSubasta(Paseador paseador, Subasta subasta) throws PersistenceException;
}
