package org.pauloalvarez.view;

/**
 *
 * @author Paulo Giovanni Alvarez Ramos
 */

import java.util.ArrayList;
import java.util.Scanner;
import org.pauloalvarez.controller.EstudioController;
import org.pauloalvarez.controller.TamagotchiController;
import org.pauloalvarez.model.Comida;
import org.pauloalvarez.model.Estudio;
import org.pauloalvarez.model.Menus;
import org.pauloalvarez.model.PersonajeFemenino;
import org.pauloalvarez.model.PersonajeMasculino;
import org.pauloalvarez.util.ScannerSingleton;

public class TamagotchiView {
    private static TamagotchiView instancia;

    public String personaje = "";
    public PersonajeMasculino pMasculino = new PersonajeMasculino();
    public PersonajeFemenino pFemenino = new PersonajeFemenino();
    Scanner input = ScannerSingleton.getInstancia();
    TamagotchiController tamagotchiControl = TamagotchiController.getInstancia();
    EstudioController estudiar = EstudioController.getInstancia();
    Comida alimentos = new Comida();
    Menus menu = Menus.getInstancia();
    
    private String nickname;
    private boolean genero = true;
    public int op;
    public boolean flag = true;

    public static synchronized TamagotchiView getInstancia() {
        if (instancia == null) {
            instancia = new TamagotchiView();
        }
        return instancia;
    }
    
    public void inicioTamagotchi() {
        tamagotchiControl.cargarTamagotchi();
        if (tamagotchiControl.primerEjecucion) {
            mNuevoTamagotchi();
        }
    }
    
    public void getPersonaje() {
    if (tamagotchiControl.tamagotchi.isGenero() == true) {
            personaje = pMasculino.normal();
        } else {
            personaje = pFemenino.normal();
        }
    }
    
    public void mNuevoTamagotchi() {
        flag = true;
        System.out.println(pMasculino.normal());
        String seleccion = "";
        while (flag) {
            menu.cabezera();
            System.out.println(seleccion);
            System.out.println(tamagotchiControl.getMensaje());
            System.out.println(menu.mNuevoTamagotchi());
            op = input.nextInt();
            input.nextLine();
            switch(op) {
            case 1:
                genero = !genero;
                seleccion = genero ? pMasculino.normal() : pFemenino.normal();
                break;
            case 2:
                System.out.print("Ponme un nombre:                       ");
                nickname = input.nextLine();
                tamagotchiControl.nuevoTamagotchi(nickname, 100, 0, 0, 0, genero);
                flag = false;
                break;
            case 3:
                genero = !genero;
                seleccion = genero ? pMasculino.normal() : pFemenino.normal();
                break;
            }
        }
    }
    
    public void mostrarEstats() {
        tamagotchiControl.getEstado();
    }
    
    public void menuComida() {
        flag = true;
        int alimentoSeleccionado = 1;
        String[] comida = new String[]{alimentos.sushi(),
            alimentos.ramen(),alimentos.pizza(), alimentos.filete()};
        
        while (flag) {
            System.out.println(comida[alimentoSeleccionado - 1]);
            System.out.println(tamagotchiControl.getMensaje());
            System.out.println(menu.mComidaBocadillo());
            op = input.nextInt();
            input.nextLine();
            
            switch (op) {
                case 1:
                    alimentoSeleccionado = (alimentoSeleccionado % 4) + 1;
                    break;
                case 2:
                    if (comida[alimentoSeleccionado - 1].equals(0)) {
                        tamagotchiControl.tamagotchi.setHambre(tamagotchiControl.tamagotchi.getHambre() - 5);
                    } else if (comida[alimentoSeleccionado - 1].equals(1)
                        || comida[alimentoSeleccionado - 1].equals(2)) {
                        tamagotchiControl.tamagotchi.setHambre(tamagotchiControl.tamagotchi.getHambre() - 10);
                    } else {
                        tamagotchiControl.tamagotchi.setHambre(tamagotchiControl.tamagotchi.getHambre() - 20);
                    }
                    tamagotchiControl.guardarTamagotchi();
                    flag = false;
                    return;
                case 3:
                    alimentoSeleccionado = (alimentoSeleccionado % 4) + 1;
                    break;
            }
        }
    }
    
    public void menuBocadillo() {
        flag = true;
        int bocadilloSeleccionado = 1;
        String[] bocadillo = new String[]{alimentos.onigiri(),
            alimentos.tempura(),alimentos.helado()};
        
        while (flag) {
            System.out.println(bocadillo[bocadilloSeleccionado - 1]);
            System.out.println(tamagotchiControl.getMensaje());
            System.out.println(menu.mComidaBocadillo());
            op = input.nextInt();
            input.nextLine();
            
            switch (op) {
                case 1:
                    bocadilloSeleccionado = (bocadilloSeleccionado % 3) + 1;
                    break;
                case 2:
                    if (bocadillo[bocadilloSeleccionado - 1].equals(0)) {
                        tamagotchiControl.tamagotchi.setFelicidad(tamagotchiControl.tamagotchi.getFelicidad() + 2);
                    } else if (bocadillo[bocadilloSeleccionado - 1].equals(1)) {
                        tamagotchiControl.tamagotchi.setFelicidad(tamagotchiControl.tamagotchi.getFelicidad() + 5);
                    } else {
                        tamagotchiControl.tamagotchi.setFelicidad(tamagotchiControl.tamagotchi.getFelicidad() + 10);
                    }
                    flag = false;
                    return;
                case 3:
                    bocadilloSeleccionado = (bocadilloSeleccionado % 3) + 1;
                    break;
            }
        }
    }
    
    public void menuJuego() {
        flag = true;
        int juegoSeleccionado = 1;
        String[] juego = new String[]{menu.iTotito(),menu.iTrivia(),menu.iConnect4()};

        while (flag) {
            System.out.println(juego[juegoSeleccionado - 1]);
            System.out.println(tamagotchiControl.getMensaje());
            System.out.println(menu.mJugar());
            op = input.nextInt();
            input.nextLine();
            
            switch(op) {
                case 1:
                    juegoSeleccionado = (juegoSeleccionado % 3) + 1;
                    break;
                case 2:
                    System.out.println("No se pudieron cargar los juegos. Más juegos para el Tamagotchi, pronto!");
                    flag = false;
                    return;
                case 3:
                    juegoSeleccionado = (juegoSeleccionado % 3) + 1;
                    break;
            }
        }
    }
    
    public void menuEstudiar() {
        flag = true;
        while (flag) {
            System.out.println(personaje);
            System.out.println(tamagotchiControl.getMensaje());
            System.out.println(menu.mEstudiar());
            op = input.nextInt();
            input.nextLine();
            switch(op) {
                case 1:
                    System.out.print("Que quieres que aprenda?               ");
                    String dato = input.nextLine();
                    estudiar.aprenderDato(dato);
                    estudiar.guardarDatosAprendidos();
                    tamagotchiControl.tamagotchi.setHambre(tamagotchiControl.tamagotchi.getHambre() + 3);
                    tamagotchiControl.tamagotchi.setInteligencia(tamagotchiControl.tamagotchi.getInteligencia() + 10);
                    tamagotchiControl.tamagotchi.setFelicidad(tamagotchiControl.tamagotchi.getFelicidad() + 5);
                    tamagotchiControl.guardarTamagotchi();
                    flag = false;
                    break;
                case 2:
                    ArrayList<Estudio> arreglo = estudiar.leerDatos();
                    
                    for (int i = 0; i < arreglo.size(); i++) {
                        System.out.println(arreglo.get(i));
                    }
                    System.out.println("Continuar?                        (1) Si | (2) No");
                    op = input.nextInt();
                    flag = op == 1;
                    break;
                case 3:
                    flag = false;
                    return;
                    
            }
        }
    }
    
}
    