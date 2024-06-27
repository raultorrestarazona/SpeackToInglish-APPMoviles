package com.example.appmovilspeakinglish.Entidad;

import java.io.Serializable;

public class Diccionario implements Serializable {
    private int codDiccionario;
    private String palabraesp, palabraingl;

    public Diccionario(int codDiccionario, String palabraesp, String palabraingl) {
        this.codDiccionario = codDiccionario;
        this.palabraesp = palabraesp;
        this.palabraingl = palabraingl;
    }
    public Diccionario(){

    }


    public int getCodDiccionario() {
        return codDiccionario;
    }

    public void setCodDiccionario(int codDiccionario) {
        this.codDiccionario = codDiccionario;
    }

    public String getPalabraesp() {
        return palabraesp;
    }

    public void setPalabraesp(String palabraesp) {
        this.palabraesp = palabraesp;
    }

    public String getPalabraingl() {
        return palabraingl;
    }

    public void setPalabraingl(String palabraingl) {
        this.palabraingl = palabraingl;
    }
}
