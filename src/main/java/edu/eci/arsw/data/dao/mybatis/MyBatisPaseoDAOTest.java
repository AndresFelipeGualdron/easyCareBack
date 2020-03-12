package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.PaseoDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.PaseoMapper;
import edu.eci.arsw.easycare.model.Paseo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisPaseoDAOTest implements PaseoDAO {

    @Autowired
    @Qualifier("paseoMapperTest")
    PaseoMapper paseo;

    @Override
    public Paseo getPaseo(Long id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Paseo> getPaseos() throws PersistenceException {
        return null;
    }

    @Override
    public void save(Paseo paseo) throws PersistenceException {

    }
}
