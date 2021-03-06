package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.mybatis.mappers.PaseadorMapper;
import edu.eci.arsw.easycare.model.Paseador;
import edu.eci.arsw.easycare.model.Subasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisPaseadorDAOTest extends MyBatisPaseadorDAO {

    @Autowired
    @Qualifier("paseadorMapperTest")
    PaseadorMapper paseador;

    @Override
    public Paseador getPaseador(String documento, String tdoc) throws PersistenceException {
        super.setPaseador(paseador);
        return super.getPaseador(documento,tdoc);
    }

    @Override
    public Paseador getPaseador(String correo) throws PersistenceException{
        super.setPaseador(paseador);
        return super.getPaseador(correo);
    }

    @Override
    public List<Paseador> getPaseadores() throws PersistenceException {
        super.setPaseador(paseador);
        return super.getPaseadores();
    }

    @Override
    public List<Paseador> getPaseadores(String order) throws PersistenceException {
        super.setPaseador(this.paseador);
        return super.getPaseadores(order);
    }

    @Override
    public void save(Paseador paseador) throws PersistenceException {
        super.setPaseador(this.paseador);
        super.save(paseador);
    }

    @Override
    public List<Paseador> getPaseadoresEnSubasta(Subasta subasta) throws PersistenceException {
        super.setPaseador(this.paseador);
        return super.getPaseadoresEnSubasta(subasta);
    }

    @Override
    public void entrarEnSubasta(Paseador paseador, Subasta subasta) throws PersistenceException {
        super.setPaseador(this.paseador);
        super.entrarEnSubasta(paseador, subasta);
    }

    @Override
    public void update(Paseador paseador) throws PersistenceException {
        super.setPaseador(this.paseador);
        super.update(paseador);
    }
}
