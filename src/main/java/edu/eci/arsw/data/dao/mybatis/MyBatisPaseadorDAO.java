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
        try{
            Paseador pa = paseador.getPaseador(documento,tdoc);
            if(pa == null) throw new PersistenceException("no se ha podido encontrar al paseador");
            return pa;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public List<Paseador> getPaseadores() throws PersistenceException {
        try{
            List<Paseador> ls = paseador.getPaseadores();
            if(ls.size() == 0) throw new PersistenceException("no hay paseadores registrados");
            return ls;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public void save(Paseador paseador) throws PersistenceException {
        try{
            this.paseador.save(paseador);
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    //SETS AND GETTERS

    public void setPaseador(PaseadorMapper paseador){
        this.paseador = paseador;
    }
}
