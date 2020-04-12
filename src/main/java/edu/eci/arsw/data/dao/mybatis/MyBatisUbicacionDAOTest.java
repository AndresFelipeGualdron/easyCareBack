package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.mybatis.mappers.SubastaMapper;
import edu.eci.arsw.data.dao.mybatis.mappers.UbicacionMapper;
import edu.eci.arsw.easycare.model.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyBatisUbicacionDAOTest extends MyBatisUbicacionDAO {

    @Autowired
    @Qualifier("ubicacionMapperTest")
    UbicacionMapper ubicacionMapper;

    @Override
    public void saveUbicacion(Ubicacion ubicacion) throws PersistenceException {
        super.setUbicacionMapper(ubicacionMapper);
        super.saveUbicacion(ubicacion);
    }
}
