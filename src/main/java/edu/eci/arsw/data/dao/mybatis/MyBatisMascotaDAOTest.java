package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.MascotaDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.MascotaMapper;
import edu.eci.arsw.easycare.model.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisMascotaDAOTest implements MascotaDAO {

    @Autowired
    @Qualifier("mascotaMapperTest")
    MascotaMapper mascota;

    @Override
    public Mascota getMascota(Long id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Mascota> getMascotas() throws PersistenceException {
        return null;
    }

    @Override
    public void save(Mascota mascota) throws PersistenceException {

    }
}
