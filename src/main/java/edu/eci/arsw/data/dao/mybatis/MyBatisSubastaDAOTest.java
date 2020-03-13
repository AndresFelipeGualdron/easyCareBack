package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.mybatis.mappers.SubastaMapper;
import edu.eci.arsw.easycare.model.Subasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisSubastaDAOTest extends MyBatisSubastaDAO {

    @Autowired
    @Qualifier("subastaMapperTest")
    SubastaMapper subasta;

    @Override
    public Subasta getSubasta(Long id) throws PersistenceException {
        super.setSubasta(subasta);
        return super.getSubasta(id);
    }

    @Override
    public List<Subasta> getSubastas() throws PersistenceException {
        super.setSubasta(subasta);
        return super.getSubastas();
    }

    @Override
    public void save(Subasta subasta) throws PersistenceException {
        super.setSubasta(this.subasta);
        super.save(subasta);
    }
}
