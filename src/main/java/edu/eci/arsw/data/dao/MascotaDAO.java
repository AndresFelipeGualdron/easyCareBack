package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Mascota;

import java.util.List;

public interface MascotaDAO {

    Mascota getMascota(Long id) throws PersistenceException;

    public List<Mascota> getMascotas() throws PersistenceException;

    public void save(Mascota mascota) throws PersistenceException;
}
