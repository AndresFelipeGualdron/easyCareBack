package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Paseador;

import java.util.List;

public interface PaseadorDAO {

    public Paseador getPaseador(String documento, String tdoc) throws PersistenceException;

    public Paseador getPaseador(String correo) throws PersistenceException;

    public List<Paseador> getPaseadores() throws PersistenceException;

    public void save(Paseador paseador) throws PersistenceException;
}
