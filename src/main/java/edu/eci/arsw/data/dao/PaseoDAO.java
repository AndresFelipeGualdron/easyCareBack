package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Paseo;

import java.util.List;

public interface PaseoDAO {

    Paseo getPaseo(int id) throws PersistenceException;

    List<Paseo> getPaseos() throws PersistenceException;

    void save(Paseo paseo) throws PersistenceException;

    int nextId() throws PersistenceException;

    void update(Paseo paseo) throws PersistenceException;
}
