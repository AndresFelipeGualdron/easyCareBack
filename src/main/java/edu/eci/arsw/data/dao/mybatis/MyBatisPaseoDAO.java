package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.PaseoDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.PaseoMapper;
import edu.eci.arsw.easycare.model.Paseo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisPaseoDAO implements PaseoDAO {

    @Autowired
    PaseoMapper paseo;

    @Override
    public Paseo getPaseo(int id) throws PersistenceException {
        try{
            Paseo pa = paseo.getPaseo(id);
            return pa;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public List<Paseo> getPaseos() throws PersistenceException {
        try{
            List<Paseo> ls = paseo.getPaseos();
            return ls;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public void save(Paseo paseo) throws PersistenceException {
        try {
            this.paseo.save(paseo);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public int nextId() throws PersistenceException {
        return this.paseo.nexId();
    }

    @Override
    public void update(Paseo paseo) throws PersistenceException {
        this.paseo.update(paseo);
    }

    //SET AND GETTERS
    public void setPaseo(PaseoMapper paseo) {
        this.paseo = paseo;
    }
}
