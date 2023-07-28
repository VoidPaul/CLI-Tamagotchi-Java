package org.pauloalvarez.controller;

import java.util.TimerTask;

/**
 * 
 * @author Paulo Giovanni Alvarez Ramos
 */

public class Dormir extends TimerTask {
    private TamagotchiController tamagotchiController;

    public Dormir(TamagotchiController tamagotchiController) {
        this.tamagotchiController = tamagotchiController;
    }

    @Override
    public void run() {
        if (tamagotchiController != null && tamagotchiController.tamagotchi != null) {
            tamagotchiController.tamagotchi.setSalud(tamagotchiController.tamagotchi.getSalud() + 10);
            tamagotchiController.tamagotchi.setHambre(tamagotchiController.tamagotchi.getHambre() + 10);
            tamagotchiController.tamagotchi.setFelicidad(tamagotchiController.tamagotchi.getFelicidad() + 2);
            // Guardar los cambios en el estado del Tamagotchi
            tamagotchiController.guardarTamagotchi();
        }
    }
}
