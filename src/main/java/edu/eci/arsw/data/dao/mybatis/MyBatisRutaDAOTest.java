package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.mybatis.mappers.RutaMapper;
import edu.eci.arsw.data.dao.mybatis.mappers.UbicacionMapper;
import edu.eci.arsw.easycare.model.Ruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyBatisRutaDAOTest extends MyBatisRutaDAO {

    @Autowired
    @Qualifier("rutaMapperTest")
    RutaMapper rutaMapper;

    @Override
    public int nextId() throws PersistenceException {
        super.setRutaMapper(this.rutaMapper);
        return super.nextId();
    }

    @Override
    public void saveRuta(Ruta ruta) throws PersistenceException {
        super.setRutaMapper(this.rutaMapper);
        super.saveRuta(ruta);
    }

    @Override
    public Ruta getRuta(int id) throws PersistenceException {
        super.setRutaMapper(this.rutaMapper);
        return super.getRuta(id);
    }
}
