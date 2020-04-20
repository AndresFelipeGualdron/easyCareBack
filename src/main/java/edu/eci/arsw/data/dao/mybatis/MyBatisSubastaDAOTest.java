package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.mybatis.mappers.SubastaMapper;
import edu.eci.arsw.easycare.model.Cliente;
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
    public Subasta getSubasta(int id) throws PersistenceException {
        super.setSubasta(subasta);
        return super.getSubasta(id);
    }

    @Override
    public List<Subasta> getSubastas() throws PersistenceException {
        super.setSubasta(subasta);
        return super.getSubastas();
    }

    @Override
    public Cliente getCreador(Subasta subasta) throws PersistenceException {
        super.setSubasta(this.subasta);
        return super.getCreador(subasta);
    }

    @Override
    public void save(Subasta subasta) throws PersistenceException {
        super.setSubasta(this.subasta);
        super.save(subasta);
    }

    @Override
    public int nextId() throws PersistenceException {
        super.setSubasta(this.subasta);
        return super.nextId();
    }

    @Override
    public void cerrarSubasta(int id) throws PersistenceException {
        super.setSubasta(this.subasta);
        super.cerrarSubasta(id);
    }

    @Override
    public void updateSubasta(Subasta subasta) throws PersistenceException {
        super.setSubasta(this.subasta);
        super.updateSubasta(subasta);
    }
}
