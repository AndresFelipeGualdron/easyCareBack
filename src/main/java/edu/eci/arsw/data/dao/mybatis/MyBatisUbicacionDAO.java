package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.UbicacionDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.UbicacionMapper;
import edu.eci.arsw.easycare.model.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisUbicacionDAO implements UbicacionDAO {

    @Autowired
    UbicacionMapper ubicacionMapper;

    @Override
    public void saveUbicacion(Ubicacion ubicacion) throws PersistenceException {

    }



    public void setUbicacionMapper(UbicacionMapper ubicacionMapper){
        this.ubicacionMapper = ubicacionMapper;
    }
}
