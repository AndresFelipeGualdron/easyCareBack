package edu.eci.arsw.easycare.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("Model Mascota")
public class Mascota implements Serializable {

    @NotNull
    @ApiModelProperty(value = "Id de la mascota", required = true)
    private Long id;
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
}
