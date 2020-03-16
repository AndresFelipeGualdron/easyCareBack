package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("Model Ruta")
public class Subasta {

    @NotNull
    @ApiModelProperty(value = "Identificador de la subasta", required = true)
    private Long id;
    @NotNull
    @ApiModelProperty(value = "Valor que se dió como resultado de la subasta", required = true)
    private int oferta;

    public Subasta(){

    }
}
