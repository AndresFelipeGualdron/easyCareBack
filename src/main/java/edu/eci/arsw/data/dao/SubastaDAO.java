package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.model.Subasta;

import java.util.List;

public interface SubastaDAO {

    Subasta getSubasta(int id) throws PersistenceException;

    List<Subasta> getSubastas() throws PersistenceException;

    Cliente getCreador(Subasta subasta) throws PersistenceException;

    void save(Subasta subasta) throws PersistenceException;

    int nextId() throws PersistenceException;

    void cerrarSubasta(int id) throws PersistenceException;

    void updateSubasta(Subasta subasta) throws PersistenceException;
}
