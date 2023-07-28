package org.pauloalvarez.model;

import java.io.Serializable;

public class Tamagotchi implements Serializable {
    private String nickname;
    private int salud;
    private int hambre;
    private int felicidad;
    private int inteligencia;
    private boolean genero;

    public Tamagotchi() {
    }

    public Tamagotchi(String nickname, int salud, int hambre, int felicidad, int inteligencia, boolean genero) {
        this.nickname = nickname;
        this.salud = salud;
        this.hambre = hambre;
        this.felicidad = felicidad;
        this.inteligencia = inteligencia;
        this.genero = genero;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = Math.max(0, Math.min(salud, 100));
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = Math.max(0, Math.min(hambre, 100));
    }

    public int getFelicidad() {
        return felicidad;
    }

    public void setFelicidad(int felicidad) {
        this.felicidad = Math.max(0, Math.min(felicidad, 100));
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    
    
}
