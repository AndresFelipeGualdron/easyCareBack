package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.PaseadorDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.PaseadorMapper;
import edu.eci.arsw.easycare.model.Paseador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisPaseadorDAO implements PaseadorDAO {

    @Autowired
    PaseadorMapper paseador;

    @Override
    public Paseador getPaseador(String documento, String tdoc) throws PersistenceException {
        return null;
    }

    @Override
    public List<Paseador> getPaseadores() throws PersistenceException {
        return null;
    }

    @Override
    public void save(Paseador paseador) throws PersistenceException {

    }
}
