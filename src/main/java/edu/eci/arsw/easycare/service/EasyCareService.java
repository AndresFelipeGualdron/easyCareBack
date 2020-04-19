package edu.eci.arsw.easycare.service;


import edu.eci.arsw.easycare.model.*;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface EasyCareService {
    Cliente getCliente(String doocumento, String tdoc) throws ExceptionServiciosEasyCare;

    Cliente getCliente(String correo) throws ExceptionServiciosEasyCare;

    List<Cliente> getAllClintes() throws ExceptionServiciosEasyCare;

    void saveCliente(Cliente cliente) throws ExceptionServiciosEasyCare;

    Mascota getMascota(int id) throws ExceptionServiciosEasyCare;

    List<Mascota> getMascotas() throws ExceptionServiciosEasyCare;

    List<Mascota> getMascotas(String cliente) throws ExceptionServiciosEasyCare;

    void saveMascota(Mascota mascota) throws ExceptionServiciosEasyCare;

    void updateMascota(Mascota mascota) throws ExceptionServiciosEasyCare;

    void deleteMascota(int id) throws ExceptionServiciosEasyCare;

    Paseador getPaseador(String documento, String tdoc) throws ExceptionServiciosEasyCare;

    Paseador getPaseador(String correo) throws ExceptionServiciosEasyCare;

    List<Paseador> getPaseadores() throws ExceptionServiciosEasyCare;

    List<Paseador> getPaseadoresOrder(String order) throws ExceptionServiciosEasyCare;

    void savePaseador(Paseador paseador) throws ExceptionServiciosEasyCare;

    Paseo getPaseo(int id) throws ExceptionServiciosEasyCare;

    List<Paseo> getPaseos() throws ExceptionServiciosEasyCare;

//    void savePaseo(Paseo paseo, String latitud, String longitud) throws ExceptionServiciosEasyCare;

    Subasta getSubasta(int id) throws ExceptionServiciosEasyCare;

    List<Subasta> getSubastas() throws ExceptionServiciosEasyCare;

    void saveSubasta(Subasta subasta,String latitud, String longitud) throws ExceptionServiciosEasyCare;

    Collection<Subasta> getSubastasIniciadas() throws ExceptionServiciosEasyCare;

    void actualizar() throws ExceptionServiciosEasyCare;

    void addSubasta(Subasta subasta) throws ExceptionServiciosEasyCare;

    void cerrarSubasta(int id) throws ExceptionServiciosEasyCare;

    List<Paseador> getPaseadoresEnSubasta(Subasta subasta) throws ExceptionServiciosEasyCare;

    void entrarASubasta(Paseador paseador, Subasta subasta) throws ExceptionServiciosEasyCare;

    void salirDeSubasta(Paseador paseador, Subasta subasta) throws ExceptionServiciosEasyCare;

    void agregarOfertaSubasta(Subasta subasta, Paseador paseador, int oferta) throws ExceptionServiciosEasyCare;

    List<Oferta> getOfertasSubasta(Subasta subasta) throws ExceptionServiciosEasyCare;

    ConcurrentHashMap<Integer, Subasta> getSubastasEnCurso() throws ExceptionServiciosEasyCare;
}
