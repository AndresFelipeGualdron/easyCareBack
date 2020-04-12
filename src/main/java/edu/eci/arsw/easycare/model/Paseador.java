package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@ApiModel("Model Paseador")
public class Paseador {
    @NotNull
    @ApiModelProperty(value = "documento del paseador", required = true)
    private String documento;
    @NotNull
    @ApiModelProperty(value = "tipo de documento del paseador", required = true)
    private String tipoDocumento;
    @NotNull
    @ApiModelProperty(value = "nombre del paseador", required = true)
    private String nombre;
    @NotNull
    @ApiModelProperty(value = "correo del paseador", required = true)
    private String correo;
    @NotNull
    @ApiModelProperty(value = "telefono del paseador", required = true)
    private String telefono;
    @NotNull
    @ApiModelProperty(value = "Clificación del paseador", required = true)
    private Long calificacion;

    @NotNull
    @ApiModelProperty(value = "Los paseos que ha ofertado el paseador", required = true)
    private ArrayList<Paseo> paseosOfrecidos;

    @NotNull
    @ApiModelProperty(value = "subastas en las que ha participado el paseador", required = true)
    private ArrayList<Subasta> subastas;

    @NotNull
    @ApiModelProperty(value = "Mascotas que ha paseado el paseador", required = true)
    private ArrayList<Mascota> mascotas;

    @ApiModelProperty(value = "Paseo que está realizando el paseador", required = true)
    private PaseoEnCurso paseoEnCurso;


    private String password;

    public Paseador(){

    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(Paseador.class)){
            return ((Paseador) obj).getCorreo().equals(this.correo);
        }else {
            return false;
        }
    }

//    @Override
//    public String toString() {
//        String rta = "{\"documento\" :"+this.getDocumento()+" , \"tipoDocumento\" : "+this.getTipoDocumento()+", \"nombre\" : "+this.getNombre()+", \"correo\": "+this.getCorreo()+", \"telefono\" : "+this.getTelefono()+", \"calificacion\" : "+this.getCalificacion()+"}";
//        return rta;
//    }

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

    public ArrayList<Paseo> getPaseosOfrecidos() {
        return paseosOfrecidos;
    }

    public void setPaseosOfrecidos(ArrayList<Paseo> paseosOfrecidos) {
        this.paseosOfrecidos = paseosOfrecidos;
    }

    public ArrayList<Subasta> getSubastas() {
        return subastas;
    }

    public void setSubastas(ArrayList<Subasta> subastas) {
        this.subastas = subastas;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public PaseoEnCurso getPaseoEnCurso() {
        return paseoEnCurso;
    }

    public void setPaseoEnCurso(PaseoEnCurso paseoEnCurso) {
        this.paseoEnCurso = paseoEnCurso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCalificacion(){
        return this.calificacion;
    }

    public void setCalificacion(Long calificacion){
        this.calificacion = calificacion;
    }
}
