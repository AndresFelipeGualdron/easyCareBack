package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PaseoEnCurso {

    @ApiModelProperty(value = "Identificador del paseo en curso", required = true)
    private int id;
    @ApiModelProperty(value = "Ubicación actual del tiempo real", required = true)
    private List<String> UbicacionActual;

    public PaseoEnCurso(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getUbicacionActual() {
        return UbicacionActual;
    }

    public void setUbicacionActual(List<String> ubicacionActual) {
        UbicacionActual = ubicacionActual;
    }
}
