package edu.eci.arsw.easycare.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{

    private String documento;
    private String tipoDocumento;
    private String nombre;
    private String correo;
    private String telefono;

    private ArrayList<Subasta> subastas;

    private ArrayList<Paseo> paseos;

    private ArrayList<Mascota> mascotas;

    public Cliente(){

    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Subasta> getSubastas() {
        return subastas;
    }

    public void setSubastas(ArrayList<Subasta> subastas) {
        this.subastas = subastas;
    }

    public ArrayList<Paseo> getPaseos() {
        return paseos;
    }

    public void setPaseos(ArrayList<Paseo> paseos) {
        this.paseos = paseos;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
