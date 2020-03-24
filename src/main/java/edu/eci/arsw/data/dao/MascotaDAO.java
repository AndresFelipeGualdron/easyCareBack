package edu.eci.arsw.data.dao;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.Mascota;

import java.util.List;

public interface MascotaDAO {

    Mascota getMascota(Long id) throws PersistenceException;

    List<Mascota> getMascotas() throws PersistenceException;

    List<Mascota> getMascotas(String documento, String tipoDocumento) throws PersistenceException;

    void save(Mascota mascota) throws PersistenceException;
}
