package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("Model Ruta")
public class Subasta {

    @NotNull
    @ApiModelProperty(value = "Identificador de la subasta", required = true)
    private int id;
    @NotNull
    @ApiModelProperty(value = "Valor que se dió como resultado de la subasta", required = true)
    private int oferta;

    public Subasta(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }
}
