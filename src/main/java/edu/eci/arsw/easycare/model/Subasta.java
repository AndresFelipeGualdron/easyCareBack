package edu.eci.arsw.easycare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@ApiModel("Model Ruta")
public class Subasta {

    @ApiModelProperty(value = "Identificador de la subasta", required = true)
    private int id;
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
    @ApiModelProperty(value = "Paseadores en la subasta", required = true)
    List<Paseador> paseadores = new ArrayList<>();

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

    public boolean getPermitirMasMascotas() {
        return permitirMasMascotas;
    }

    public void setPermitirMasMascotas(boolean permitirMasMascotas) {
        this.permitirMasMascotas = permitirMasMascotas;
    }

    public List<Paseador> getPaseadores() {
        return paseadores;
    }

    public void setPaseadores(List<Paseador> paseadores) {
        this.paseadores = paseadores;
    }
}
