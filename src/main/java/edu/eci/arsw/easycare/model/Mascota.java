package edu.eci.arsw.easycare.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("Model Mascota")
public class Mascota implements Serializable {

    @ApiModelProperty(value = "Id de la mascota", required = true)
    private int id;
    @ApiModelProperty(value = "Nombre de la mascota", required = true)
    private String nombre;
    @ApiModelProperty(value = "Raza de la mascota", required = true)
    private String raza;
    @ApiModelProperty(value = "Edad de la mascota", required = true)
    private int edad;
    @ApiModelProperty(value = "Genero de la mascota", required = true)
    private String genero;
    @ApiModelProperty(value = "Dueño de la mascota", required = true)
    private Cliente cliente;
    @ApiModelProperty(value = "Paseador de la mascota en el momento de un paseo", required = true)
    private Paseador paseador;
    @ApiModelProperty(value = "Paseo en curso de la mascota", required = true)
    private PaseoEnCurso paseoEnCurso;

    public Mascota(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Paseador getPaseador() {
        return paseador;
    }

    public void setPaseador(Paseador paseador) {
        this.paseador = paseador;
    }

    public PaseoEnCurso getPaseoEnCurso() {
        return paseoEnCurso;
    }

    public void setPaseoEnCurso(PaseoEnCurso paseoEnCurso) {
        this.paseoEnCurso = paseoEnCurso;
    }
}
