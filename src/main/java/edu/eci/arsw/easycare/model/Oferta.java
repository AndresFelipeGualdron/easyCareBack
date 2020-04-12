package edu.eci.arsw.easycare.model;

public class Oferta {

    private Subasta subasta;
    private Paseador paseador;
    private int oferta;

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public Paseador getPaseador() {
        return paseador;
    }

    public void setPaseador(Paseador paseador) {
        this.paseador = paseador;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }
}
