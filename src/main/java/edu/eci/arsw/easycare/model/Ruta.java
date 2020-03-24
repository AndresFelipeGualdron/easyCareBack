package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("Model Ruta")
public class Ruta {
    @NotNull
    @ApiModelProperty(value = "Identificador de la ruta", required = true)
    private int id;
    @NotNull
    @ApiModelProperty(value = "Partida de la ruta", required = true)
    private String puntoPartida;
    @NotNull
    @ApiModelProperty(value = "Llegada de la ruta", required = true)
    private String puntoLlegada;

    public Ruta(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(String puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public String getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoLlegada(String puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }
}
