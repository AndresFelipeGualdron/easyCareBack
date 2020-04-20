package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.PaseadorDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.PaseadorMapper;
import edu.eci.arsw.easycare.model.Paseador;
import edu.eci.arsw.easycare.model.Subasta;
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
            return pa;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public Paseador getPaseador(String correo) throws PersistenceException {
        try{
            Paseador pa = paseador.getPaseadorCorreo(correo);
            return pa;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public List<Paseador> getPaseadores() throws PersistenceException {
        try{
            List<Paseador> ls = paseador.getPaseadores();
            return ls;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public List<Paseador> getPaseadores(String order) throws PersistenceException {
        try{
            if(order.equals("ASC")){
                List<Paseador> ls = paseador.getPaseadoresOrderAsc();
                return ls;
            }else{
                List<Paseador> ls = paseador.getPaseadoresOrderDesc();
                return ls;
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public void save(Paseador paseador) throws PersistenceException {
        try{
            this.paseador.save(paseador);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public List<Paseador> getPaseadoresEnSubasta(Subasta subasta) throws PersistenceException {
        try{
            return this.paseador.getPaseadoresEnSubasta(subasta);
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public void entrarEnSubasta(Paseador paseador, Subasta subasta) throws PersistenceException {
        try{
            this.paseador.entrarASubasta(subasta, paseador);
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public void update(Paseador paseador) throws PersistenceException {
        try{
            this.paseador.update(paseador);
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    //SETS AND GETTERS

    public void setPaseador(PaseadorMapper paseador){
        this.paseador = paseador;
    }
}
