package edu.eci.arsw.easycare.service;

import edu.eci.arsw.data.dao.ClienteDAO;
import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.*;

import java.util.List;

public interface EasyCareService {
    Cliente getCliente(String doocumento, String tdoc) throws ExceptionServiciosEasyCare;

    Cliente getCliente(String correo) throws ExceptionServiciosEasyCare;

    List<Cliente> getAllClintes() throws ExceptionServiciosEasyCare;

    void saveCliente(Cliente cliente) throws ExceptionServiciosEasyCare;

    Mascota getMascota(Long id) throws ExceptionServiciosEasyCare;

    List<Mascota> getMascotas() throws ExceptionServiciosEasyCare;

    List<Mascota> getMascotas(String cliente) throws ExceptionServiciosEasyCare;

    void saveMascota(Mascota mascota) throws ExceptionServiciosEasyCare;

    Paseador getPaseador(String documento, String tdoc) throws ExceptionServiciosEasyCare;

    Paseador getPaseador(String correo) throws ExceptionServiciosEasyCare;

    List<Paseador> getPaseadores() throws ExceptionServiciosEasyCare;

    List<Paseador> getPaseadoresOrder(String order) throws ExceptionServiciosEasyCare;

    void savePaseador(Paseador paseador) throws ExceptionServiciosEasyCare;

    Paseo getPaseo(Long id) throws ExceptionServiciosEasyCare;

    List<Paseo> getPaseos() throws ExceptionServiciosEasyCare;

    void savePaseo(Paseo paseo) throws ExceptionServiciosEasyCare;

    Subasta getSubasta(Long id) throws ExceptionServiciosEasyCare;

    List<Subasta> getSubastas() throws ExceptionServiciosEasyCare;

    void saveSubasta(Subasta subasta) throws ExceptionServiciosEasyCare;
}
