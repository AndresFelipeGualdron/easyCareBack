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
    @ApiModelProperty(value = "Creador de la subasta", required = true)
    private String creador;
    @ApiModelProperty(value = "paseo de la subasta", required = true)
    private Paseo idpaseo;
    @ApiModelProperty(value = "cantidad de mascotas de la subasta", required = true)
    private int numMascotas;
    @ApiModelProperty(value = "se permitio mas mascotas en la subasta", required = true)
    private boolean permitirMasMascotas;

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

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public Paseo getIdpaseo() {
        return idpaseo;
    }

    public void setIdpaseo(Paseo idpaseo) {
        this.idpaseo = idpaseo;
    }

    public int getNumMascotas() {
        return numMascotas;
    }

    public void setNumMascotas(int numMascotas) {
        this.numMascotas = numMascotas;
    }

    public boolean isPermitirMasMascotas() {
        return permitirMasMascotas;
    }

    public void setPermitirMasMascotas(boolean permitirMasMascotas) {
        this.permitirMasMascotas = permitirMasMascotas;
    }
}
