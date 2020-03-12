package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Subasta;

import java.util.List;

public interface SubastaDAO {

    public Subasta getSubasta(Long id) throws PersistenceException;

    public List<Subasta> getSubastas() throws PersistenceException;

    public void save(Subasta subasta) throws PersistenceException;
}
