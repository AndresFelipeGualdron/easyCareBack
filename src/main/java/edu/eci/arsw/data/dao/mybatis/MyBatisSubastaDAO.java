package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.SubastaDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.SubastaMapper;
import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.model.Paseo;
import edu.eci.arsw.easycare.model.Subasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisSubastaDAO implements SubastaDAO {

    @Autowired
    SubastaMapper subasta;

    @Override
    public Subasta getSubasta(int id) throws PersistenceException {
        try{
            Subasta su = subasta.getSubasta(id);
            Cliente c = subasta.getCreador(su);
            su.setCreador(c);
            return su;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public List<Subasta> getSubastas() throws PersistenceException {
        try {
            List<Subasta> ls = subasta.getSubastas();
            ls.forEach(sub -> {
                Cliente c = subasta.getCreador(sub);
                Paseo p = subasta.getPaseo(sub);
                System.out.println(c.getCorreo() + " **************");
                sub.setCreador(c);
                sub.setPaseo(p);
            });
            return ls;
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public Cliente getCreador(Subasta subasta) throws PersistenceException {
        return this.subasta.getCreador(subasta);
    }

    @Override
    public void save(Subasta subasta) throws PersistenceException {
        try{
            this.subasta.save(subasta);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public int nextId() throws PersistenceException {
        return this.subasta.nextId();
    }

    @Override
    public void cerrarSubasta(int id) throws PersistenceException {
        this.subasta.cerrarSubasta(id);
    }

    @Override
    public void updateSubasta(Subasta subasta) throws PersistenceException {
        this.subasta.updateSubasta(subasta);
    }

    //SET AND GETTERS
    public void setSubasta(SubastaMapper subasta) {
        this.subasta = subasta;
    }
}
