package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModel;

@ApiModel("Model Ubicacion")
public class Ubicacion {

    private String latitud;
    private String longitud;

    public Ubicacion(){

    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
