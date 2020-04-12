package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.RutaDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.RutaMapper;
import edu.eci.arsw.easycare.model.Ruta;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisRutaDAO implements RutaDAO {

    @Autowired
    RutaMapper rutaMapper;




    public void setRutaMapper(RutaMapper rutaMapper){
        this.rutaMapper = rutaMapper;
    }

    @Override
    public int nextId() throws PersistenceException {
        return this.rutaMapper.nextId();
    }

    @Override
    public void saveRuta(Ruta ruta) throws PersistenceException {
        this.rutaMapper.saveRuta(ruta);
    }

    @Override
    public Ruta getRuta(int id) throws PersistenceException {
        return null;
    }
}
