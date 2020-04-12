package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Ubicacion;

public interface UbicacionDAO {

    void saveUbicacion(Ubicacion ubicacion) throws PersistenceException;

}
