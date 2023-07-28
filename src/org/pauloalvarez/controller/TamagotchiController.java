package org.pauloalvarez.controller;

/**
 *
 * @author Paulo Giovanni Alvarez Ramos
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import org.pauloalvarez.model.Tamagotchi;
import org.pauloalvarez.util.Excepciones;
import org.pauloalvarez.util.Logger;

public class TamagotchiController extends Excepciones {
    private static TamagotchiController instancia;
    private String mensaje = "";
    private Timer timer = new Timer();
    public Tamagotchi tamagotchi = new Tamagotchi();
    public boolean primerEjecucion = true;
    
    
    private static final String TAMAGOTCHI_FILE = "tamagotchi.txt";
    
    public TamagotchiController() {
    }
    
    public static synchronized TamagotchiController getInstancia() {
        if (instancia == null) {
            instancia = new TamagotchiController();
        }
        return instancia;
    }
    
    public void nuevoTamagotchi(String nickname, int salud, int hambre, int felicidad, int inteligencia, boolean genero) {
        tamagotchi.setNickname(nickname);
        tamagotchi.setSalud(salud);
        tamagotchi.setHambre(hambre);
        tamagotchi.setFelicidad(felicidad);
        tamagotchi.setInteligencia(inteligencia);
        tamagotchi.setGenero(genero);
        guardarTamagotchi();
    }
    
    public void guardarTamagotchi() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TAMAGOTCHI_FILE))) {
            String datosTamagotchi = tamagotchi.getNickname() + "," + tamagotchi.getSalud() + "," + tamagotchi.getHambre()
                    + "," + tamagotchi.getFelicidad() + "," + tamagotchi.getInteligencia() + ","
                    + (tamagotchi.isGenero() ? "Masculino" : "Femenino");

            writer.write(datosTamagotchi);
            primerEjecucion = false;
        } catch (IOException ex) {
            Logger.log("Error al guardar el Tamagotchi: " + ex.getMessage());
            System.out.println("Disculpa, no se pudo guardar el estado del Tamagotchi.");
        }
    }

    public void cargarTamagotchi() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TAMAGOTCHI_FILE))) {
            String datosTamagotchi = reader.readLine();

            String[] datos = datosTamagotchi.split(",");
            tamagotchi.setNickname(datos[0]);
            tamagotchi.setSalud(Integer.parseInt(datos[1]));
            tamagotchi.setHambre(Integer.parseInt(datos[2]));
            tamagotchi.setFelicidad(Integer.parseInt(datos[3]));
            tamagotchi.setInteligencia(Integer.parseInt(datos[4]));
            tamagotchi.setGenero(datos[5].equalsIgnoreCase("Masculino"));

            primerEjecucion = false;
        } catch (IOException ex) {
            primerEjecucion = true;
        }
    }
    
    public String getGenero() {
        String genero = tamagotchi.isGenero() ? "Masculino" : "Femenino";
        return genero;
    }
    
    public String getEstado() {
        mensaje = "Nombre: " + tamagotchi.getNickname() + " | Salud: " 
            + tamagotchi.getSalud() + "% | Hambre: "
            + tamagotchi.getHambre() + "% | Felicidad: "
            + tamagotchi.getFelicidad() + "% | Inteligencia: "
            + tamagotchi.getInteligencia() + "% | Genero: "
            + getGenero() + " || (4) Dormir ||";
        return mensaje;
    }
    
    public void dormir() {
        Dormir dormirTask = new Dormir(this);
        timer.schedule(dormirTask, 0, 10000);
        timer.cancel();
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getMensaje() {
        if (mensaje == null) {
            mensaje = " ";
        }
        return mensaje;
    }
    
}
