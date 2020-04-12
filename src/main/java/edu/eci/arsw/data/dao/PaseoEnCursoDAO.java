package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;

public interface PaseoEnCursoDAO {

    int nextId() throws PersistenceException;
}
