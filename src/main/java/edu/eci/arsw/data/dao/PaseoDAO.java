package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Paseo;

import java.util.List;

public interface PaseoDAO {

    public Paseo getPaseo(Long id) throws PersistenceException;

    public List<Paseo> getPaseos() throws PersistenceException;

    public void save(Paseo paseo) throws PersistenceException;
}
