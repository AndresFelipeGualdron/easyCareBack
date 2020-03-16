package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("Model Ruta")
public class Ruta {
    @NotNull
    @ApiModelProperty(value = "Identificador de la ruta", required = true)
    private Long id;
    @NotNull
    @ApiModelProperty(value = "Partida de la ruta", required = true)
    private String puntoPartida;
    @NotNull
    @ApiModelProperty(value = "Llegada de la ruta", required = true)
    private String puntoLlegada;
}
