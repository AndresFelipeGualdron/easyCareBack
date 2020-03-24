package edu.eci.arsw.easycare.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("Model Mascota")
public class Mascota implements Serializable {

    @NotNull
    @ApiModelProperty(value = "Id de la mascota", required = true)
    private int id;
    @NotNull
    @ApiModelProperty(value = "Nombre de la mascota", required = true)
    private String nombre;
    @NotNull
    @ApiModelProperty(value = "Raza de la mascota", required = true)
    private String raza;
    @NotNull
    @ApiModelProperty(value = "Edad de la mascota", required = true)
    private int edad;
    @NotNull
    @ApiModelProperty(value = "Genero de la mascota", required = true)
    private String genero;

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
}
