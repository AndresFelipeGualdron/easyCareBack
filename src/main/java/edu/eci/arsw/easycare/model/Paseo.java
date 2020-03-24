package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("Model Paseo")
public class Paseo {
    @NotNull
    @ApiModelProperty(value = "Identificador del Paseo", required = true)
    private int id;
    @NotNull
    @ApiModelProperty(value = "Ruta del paseo correspondiente", required = true)
    private String ruta;
    @ApiModelProperty(value = "Duración del paseo", required = true)
    private int duracion;
    @NotNull
    @ApiModelProperty(value = "Especificaciones del paseo", required = true)
    private String especificaciones;

    public Paseo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }
}
