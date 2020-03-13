package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.SubastaDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.SubastaMapper;
import edu.eci.arsw.easycare.model.Subasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisSubastaDAO implements SubastaDAO {

    @Autowired
    SubastaMapper subasta;

    @Override
    public Subasta getSubasta(Long id) throws PersistenceException {
        try{
            Subasta su = subasta.getSubasta(id);
            if(su == null) throw new PersistenceException("no se pudo encontrar la subasta");
            return su;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public List<Subasta> getSubastas() throws PersistenceException {
        try {
            List<Subasta> ls = subasta.getSubastas();
            if(ls.size()==0) throw new PersistenceException("no hay subastas registradas");
            return ls;
        }catch (Exception E){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public void save(Subasta subasta) throws PersistenceException {
        try{
            this.subasta.save(subasta);
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    //SET AND GETTERS
    public void setSubasta(SubastaMapper subasta) {
        this.subasta = subasta;
    }
}
