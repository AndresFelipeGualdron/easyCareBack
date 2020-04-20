package edu.eci.arsw.easycare.model;

import java.io.Serializable;
import java.util.ArrayList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


@ApiModel("Model Cliente")
public class Cliente implements Serializable{

    @ApiModelProperty(value = "el documento del cliente (Hace parte del la primaria compuesta)", required = true)
    private String documento;
    @ApiModelProperty(value = "el tipo de documeto del cliente (Hace parte de la primaria compuesta)", required = true)
    private String tipoDocumento;
    @ApiModelProperty(value = "el nombre del cliente", required = true)
    private String nombre;
    @ApiModelProperty(value = "el correo del cliente", required = true)
    private String correo;
    @ApiModelProperty(value = "el telefono del cliente", required = true)
    private String telefono;
    @ApiModelProperty(value = "Subastas que ha creado el cliente", required = true)
    private ArrayList<Subasta> subastas;
    @ApiModelProperty(value = "Paseos que ha solicitado el cliente", required = true)
    private ArrayList<Paseo> paseos;
    @ApiModelProperty(value = "Mascotas del cliente", required = true)
    private ArrayList<Mascota> mascotas;
    @ApiModelProperty(value = "Subastas a las que se ha unido el cliente", required = true)
    private ArrayList<Subasta> subastasUnidas;
    @ApiModelProperty(value = "Rutas que ha establecido el cliente en los paseos", required = true)
    private ArrayList<Ruta> rutasEstablecidas;
    @ApiModelProperty(value = "Password del cliente", required = true)
    private String password;
    @ApiModelProperty(value = "Ubicacion del cliente" , required = true)
    private Ubicacion ubicacion;



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

    public ArrayList<Subasta> getSubastasUnidas() {
        return subastasUnidas;
    }

    public void setSubastasUnidas(ArrayList<Subasta> subastasUnidas) {
        this.subastasUnidas = subastasUnidas;
    }

    public ArrayList<Ruta> getRutasEstablecidas() {
        return rutasEstablecidas;
    }

    public void setRutasEstablecidas(ArrayList<Ruta> rutasEstablecidas) {
        this.rutasEstablecidas = rutasEstablecidas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
