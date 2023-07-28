package org.pauloalvarez.model;

import java.io.Serializable;

public class Estudio extends Tamagotchi implements Serializable {

    private String datoAprendido;

    public Estudio(String datoAprendido) {
        this.datoAprendido = datoAprendido;
    }

    public Estudio(String datoAprendido, String nickname, int salud, int hambre, int felicidad, int inteligencia, boolean genero) {
        super(nickname, salud, hambre, felicidad, inteligencia, genero);
        this.datoAprendido = datoAprendido;
    }

    public String getDatoAprendido() {
        return datoAprendido;
    }

    public void setDatoAprendido(String datoAprendido) {
        this.datoAprendido = datoAprendido;
    }
    
}
