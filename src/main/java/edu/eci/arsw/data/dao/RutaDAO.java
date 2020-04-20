package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Ruta;

public interface RutaDAO {

    int nextId() throws PersistenceException;

    void saveRuta(Ruta ruta) throws PersistenceException;

    Ruta getRuta(int id) throws PersistenceException;

    void updateRuta(Ruta ruta) throws PersistenceException;

}
