package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("Model Paseo")
public class Paseo {
    @NotNull
    @ApiModelProperty(value = "Identificador del Paseo", required = true)
    private Long id;
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
}
