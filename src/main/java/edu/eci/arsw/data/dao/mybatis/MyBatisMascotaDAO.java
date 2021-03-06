package edu.eci.arsw.data.dao.mybatis;

import edu.eci.arsw.data.dao.MascotaDAO;
import edu.eci.arsw.data.dao.mybatis.mappers.MascotaMapper;
import edu.eci.arsw.easycare.model.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisMascotaDAO implements MascotaDAO {

    @Autowired
    MascotaMapper mascota;

    @Override
    public Mascota getMascota(int id) throws PersistenceException {
        try{
            System.out.println(id);
            Mascota ma = mascota.getMascota(id);
            return ma;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }

    }

    @Override
    public List<Mascota> getMascotas() throws PersistenceException {
        try{
            List<Mascota> ls = mascota.getMascotas();
            return ls;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public List<Mascota> getMascotas(String documento, String tipoDocumento) throws PersistenceException {
        try{
            System.out.println(documento + " " + tipoDocumento);
            List<Mascota> ls = mascota.getMascotasCliente(documento, tipoDocumento);
            return ls;
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public void save(Mascota mascota) throws PersistenceException {
        try{
            this.mascota.save(mascota);
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }

    }

    @Override
    public void update(Mascota mascota) throws PersistenceException {
        try {
            this.mascota.update(mascota);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.ERROR_EN_LA_SOLICITUD);
        }
    }

    @Override
    public void delete(int id) throws PersistenceException {
        try {
            this.mascota.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException((PersistenceException.ERROR_EN_LA_SOLICITUD));
        }
    }

    @Override
    public int nextId() throws PersistenceException {
        return this.mascota.nextId();
    }

    //SET AND GETTERS

    public void setMascota(MascotaMapper mascota){
        this.mascota = mascota;

    }
}
