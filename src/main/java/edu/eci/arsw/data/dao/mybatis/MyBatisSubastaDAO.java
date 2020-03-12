package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.SubastaDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.SubastaMapper;
import edu.eci.arsw.easycare.model.Subasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisSubastaDAO implements SubastaDAO {

    @Autowired
    SubastaMapper subasta;

    @Override
    public Subasta getSubasta(Long id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Subasta> getSubastas() throws PersistenceException {
        return null;
    }

    @Override
    public void save(Subasta subasta) throws PersistenceException {

    }
}
