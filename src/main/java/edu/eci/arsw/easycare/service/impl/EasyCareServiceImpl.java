package edu.eci.arsw.easycare.service.impl;

import edu.eci.arsw.data.dao.*;
import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.model.*;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
//@Data
@Component
@Primary
public class EasyCareServiceImpl implements  EasyCareService{

    @Autowired
    private ClienteDAO cliente;
    @Autowired
    private MascotaDAO mascota;
    @Autowired
    private PaseadorDAO paseador;
    @Autowired
    private PaseoDAO paseo;
    @Autowired
    private SubastaDAO subasta;
    @Autowired
    private RutaDAO ruta;
    @Autowired
    private PaseoEnCursoDAO paseoEnCurso;
    @Autowired
    private UbicacionDAO ubicacion;


    private ConcurrentHashMap<Integer, Subasta> subastas =new ConcurrentHashMap<>();
//    private ConcurrentHashMap<Integer, ConcurrentHashMap<Paseador, Integer>> ofertas = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, List<Oferta>> ofertas = new ConcurrentHashMap<>();


    @Override
    public Cliente getCliente(String id, String tdoc) throws ExceptionServiciosEasyCare {
        try {
            return this.cliente.getCliente(id, tdoc);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public Cliente getCliente(String correo) throws ExceptionServiciosEasyCare {
        try{
//            return new Cliente();
            return this.cliente.getCliente(correo);
        }catch (PersistenceException e){
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
//            return null;
        }
    }

    @Override
    public List<Cliente> getAllClintes() throws ExceptionServiciosEasyCare {
        try {
            return this.cliente.getClientes();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public void saveCliente(Cliente cliente) throws ExceptionServiciosEasyCare {
        try {
            this.cliente.save(cliente);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new ExceptionServiciosEasyCare("No se ha podido completar la operación",e);
        }
    }

    @Override
    public Mascota getMascota(int id) throws ExceptionServiciosEasyCare {
        try {
            return this.mascota.getMascota(id);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("No se ha podido realizar la consulta", e);
        }
    }

    @Override
    public List<Mascota> getMascotas() throws ExceptionServiciosEasyCare {
        try {
            return this.mascota.getMascotas();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Mascota> getMascotas(String cliente) throws ExceptionServiciosEasyCare {
        try{
            Cliente cliente1 = this.getCliente(cliente);
            return this.mascota.getMascotas(cliente1.getDocumento(), cliente1.getTipoDocumento());
        }catch (PersistenceException e){
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public void saveMascota(Mascota mascota) throws ExceptionServiciosEasyCare {
        try {
            int id = this.mascota.nextId();
            mascota.setId(id);
            this.mascota.save(mascota);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la operacioón",e);
        }
    }

    @Override
    public void updateMascota(Mascota mascota) throws ExceptionServiciosEasyCare {
        try {
            this.mascota.update(mascota);
        }catch (PersistenceException e){
            e.printStackTrace();
            throw new ExceptionServiciosEasyCare("No se ha podido realizar la operación",e);
        }
    }

    @Override
    public void deleteMascota(int id) throws ExceptionServiciosEasyCare {
        try {
            this.mascota.delete(id);
        }catch (PersistenceException e){
            e.printStackTrace();
            throw new ExceptionServiciosEasyCare("no se pudo eliminar la mascota",e);
        }
    }

    @Override
    public Paseador getPaseador(String documento, String tdoc) throws ExceptionServiciosEasyCare {
        try {
            return this.paseador.getPaseador(documento, tdoc);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public Paseador getPaseador(String correo) throws ExceptionServiciosEasyCare {
        try{
            return this.paseador.getPaseador(correo);
        }catch (PersistenceException e){
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Paseador> getPaseadores() throws ExceptionServiciosEasyCare {
        try {
            return this.paseador.getPaseadores();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Paseador> getPaseadoresOrder(String order) throws ExceptionServiciosEasyCare {
        try{
            return this.paseador.getPaseadores(order);
        }catch (PersistenceException e){
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public void savePaseador(Paseador paseador) throws ExceptionServiciosEasyCare {
        try {
            this.paseador.save(paseador);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la operación",e);
        }
    }

    @Override
    public Paseo getPaseo(int id) throws ExceptionServiciosEasyCare {
        try {
            return this.paseo.getPaseo(id);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Paseo> getPaseos() throws ExceptionServiciosEasyCare {
        try {
            return this.paseo.getPaseos();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public Subasta getSubasta(int id) throws ExceptionServiciosEasyCare {
        try {
            return this.subasta.getSubasta(id);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public List<Subasta> getSubastas() throws ExceptionServiciosEasyCare {
        try {
            return this.subasta.getSubastas();
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la consulta",e);
        }
    }

    @Override
    public void saveSubasta(Subasta subasta,String latitud, String longitud) throws ExceptionServiciosEasyCare {
        try {
            System.out.println(subasta.getPermitirMasMascotas());
            Paseo paseo = new Paseo();
            paseo.setId(this.paseo.nextId());
            paseo.setDuracion(0);
            Ruta ruta = new Ruta();
            ruta.setId(this.ruta.nextId());
            ruta.setPuntoPartida("lat: "+latitud+", lng: "+longitud);
            ruta.setPuntoLlegada("lat: "+latitud+", lng: "+longitud);
            this.ruta.saveRuta(ruta);
            paseo.setRuta(ruta);
            this.paseo.save(paseo);
            subasta.setId(this.subasta.nextId());
            subasta.setIdpaseo(paseo);
            this.subasta.save(subasta);
        } catch (PersistenceException e) {
            throw new ExceptionServiciosEasyCare("no se ha podido realizar la ooperación",e);
        }
    }

    @Override
    public Collection<Subasta> getSubastasIniciadas() throws ExceptionServiciosEasyCare {
        actualizar();
        Collection<Subasta> s = this.subastas.values();
        return s;
    }

    @Override
    public void actualizar() throws ExceptionServiciosEasyCare {
        try{
            List<Subasta> s = this.subasta.getSubastas();
            this.subastas.clear();
            s.forEach(subasta1 -> {
                subastas.put(subasta1.getId(), subasta1);
            });
        }catch (PersistenceException e){

        }
    }

    @Override
    public void addSubasta(Subasta subasta){
        this.subastas.put(subasta.getId(),subasta);
    }

    @Override
    public void cerrarSubasta(int id) throws ExceptionServiciosEasyCare {
        try {
            this.subasta.cerrarSubasta(id);
            this.subastas.remove(id);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Paseador> getPaseadoresEnSubasta(Subasta subasta) throws ExceptionServiciosEasyCare {
        try {
//            List<Paseador> paseadores = this.paseador.getPaseadoresEnSubasta(subasta);
//            this.subastas.get(subasta.getId()).setPaseadores(paseadores);
            return this.subastas.get(subasta.getId()).getPaseadores();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void entrarASubasta(Paseador paseador, Subasta subasta) throws ExceptionServiciosEasyCare {
        try {
//            this.paseador.entrarEnSubasta(paseador,subasta);
            AtomicBoolean flag = new AtomicBoolean(true);
            this.subastas.get(subasta.getId()).getPaseadores().forEach(paseador1 -> {
                if(paseador1.getCorreo().equals(paseador.getCorreo())){
                    flag.set(false);
                }
            });
            if(flag.get()) {
                this.subastas.get(subasta.getId())
                        .getPaseadores()
                        .add(paseador);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void salirDeSubasta(Paseador paseador, Subasta subasta) throws ExceptionServiciosEasyCare {
        for(int i =0 ; i<this.subastas.get(subasta.getId()).getPaseadores().size(); i++){
            if(this.subastas.get(subasta.getId()).getPaseadores().get(i).getCorreo().equals(paseador.getCorreo())){
                System.out.println("entre para eliminar");
                this.subastas.get(subasta.getId()).getPaseadores().remove(i);
            }
        }
    }

    @Override
    public void agregarOfertaSubasta(Subasta subasta, Paseador paseador, int oferta) throws ExceptionServiciosEasyCare {
        Oferta of = new Oferta();
        of.setOferta(oferta);
        of.setPaseador(paseador);
        of.setSubasta(subasta);
        this.ofertas.get(subasta.getId()).add(of);
    }

    @Override
    public List<Oferta> getOfertasSubasta(Subasta subasta) throws ExceptionServiciosEasyCare {
        if(this.ofertas.get(subasta.getId()) == null){
            System.out.println("no existe un arreglo todavia: " + this.ofertas.size());
            List<Oferta> c = new ArrayList<>();
            this.ofertas.put(subasta.getId(), c);
        }
        System.out.println(this.ofertas.size()+" cooooooooooooooooo "+subasta.getId());
        return this.ofertas.get(subasta.getId());
    }

    @Override
    public ConcurrentHashMap<Integer, Subasta> getSubastasEnCurso() throws ExceptionServiciosEasyCare {
        return this.subastas;
    }

//    TESTS

    public void setCliente(ClienteDAO cliente) {
        this.cliente = cliente;
    }

    public void setMascota(MascotaDAO mascota) {
        this.mascota = mascota;
    }

    public void setPaseador(PaseadorDAO paseador) {
        this.paseador = paseador;
    }

    public void setPaseo(PaseoDAO paseo) {
        this.paseo = paseo;
    }

    public void setSubasta(SubastaDAO subasta) {
        this.subasta = subasta;
    }

    public void setRuta(RutaDAO ruta){
        this.ruta = ruta;
    }

    public void setPaseoEnCurso(PaseoEnCursoDAO paseoEnCurso){
        this.paseoEnCurso = paseoEnCurso;
    }

    public void setUbicacion(UbicacionDAO ubicacion){
        this.ubicacion = ubicacion;
    }


}