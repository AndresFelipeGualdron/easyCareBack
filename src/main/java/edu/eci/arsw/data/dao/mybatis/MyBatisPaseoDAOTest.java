package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.mybatis.mappers.PaseoMapper;
import edu.eci.arsw.easycare.model.Paseo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisPaseoDAOTest extends MyBatisPaseoDAO {

    @Autowired
    @Qualifier("paseoMapperTest")
    PaseoMapper paseo;

    @Override
    public Paseo getPaseo(int id) throws PersistenceException {
        super.setPaseo(paseo);
        return super.getPaseo(id);
    }

    @Override
    public List<Paseo> getPaseos() throws PersistenceException {
        super.setPaseo(paseo);
        return super.getPaseos();
    }

    @Override
    public void save(Paseo paseo) throws PersistenceException {
        super.setPaseo(this.paseo);
        super.save(paseo);
    }

    @Override
    public int nextId() throws PersistenceException {
        super.setPaseo(this.paseo);
        return super.nextId();
    }

    @Override
    public void update(Paseo paseo) throws PersistenceException {
        super.setPaseo(this.paseo);
        super.update(paseo);
    }
}
