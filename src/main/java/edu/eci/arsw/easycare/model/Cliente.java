package edu.eci.arsw.easycare.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private Long documento;
    private String tDoc;
    private String nombre;
    private String email;
    private String telefono;

    private ArrayList<Subasta> subastas;

    private ArrayList<Paseo> paseos;

    private ArrayList<Mascota> mascotas;

    public Cliente(){

    }
}
