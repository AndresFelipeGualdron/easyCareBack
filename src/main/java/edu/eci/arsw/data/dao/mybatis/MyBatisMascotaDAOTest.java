package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.mybatis.mappers.MascotaMapper;
import edu.eci.arsw.easycare.model.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisMascotaDAOTest extends MyBatisMascotaDAO {

    @Autowired
    @Qualifier("mascotaMapperTest")
    MascotaMapper mascota;

    @Override
    public Mascota getMascota(int id) throws PersistenceException {
        super.setMascota(mascota);
        return super.getMascota(id);
    }

    @Override
    public List<Mascota> getMascotas() throws PersistenceException {
        super.setMascota(mascota);
        return super.getMascotas();
    }

    @Override
    public List<Mascota> getMascotas(String documento, String tipoDocumento) throws PersistenceException{
        super.setMascota(mascota);
        return super.getMascotas(documento, tipoDocumento);
    }

    @Override
    public void save(Mascota mascota) throws PersistenceException {
        super.setMascota(this.mascota);
        super.save(mascota);
    }
}
