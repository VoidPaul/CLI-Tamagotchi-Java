package org.pauloalvarez.view;

/**
 *
 * @author Paulo Giovanni Alvarez Ramos
 */
import java.util.Scanner;
import org.pauloalvarez.model.Menus;
import org.pauloalvarez.util.ScannerSingleton;


public class MenuGeneral {
    private static MenuGeneral instancia;

    TamagotchiView tamagotchiV = TamagotchiView.getInstancia();
    Scanner input = ScannerSingleton.getInstancia();
    Menus menu = Menus.getInstancia();
    int op;
    boolean flag = true;

    public static synchronized MenuGeneral getInstancia() {
        if (instancia == null) {
            instancia = new MenuGeneral();
        }
        return instancia;
    }

    public void iniciar() {
        /**
         * @param flag se utiliza para controlar los menus. mientras flag sea
         * verdadero el menú ejecutará su proceso
         *
         */

        tamagotchiV.inicioTamagotchi();
        menuPrincipal();
    }

    public void menuPrincipal() {
        /**
         * @param tamagotchiV llama a la clase TamagotchiView
         * @param tamagotchiControl se encuentra dentro de TamagotchiView
         * @param tamagotchi se encuentra en TamagotchiController
         * @param personaje forma en la que muestro el personaje (personalmente
         * pienso pudo hacerse mejor, cómo se muesta. El personaje quedó bien
         * :D)
         */
        tamagotchiV.getPersonaje();
        
        while (flag) {
            System.out.println(tamagotchiV.personaje);
            System.out.println(tamagotchiV.tamagotchiControl.getMensaje());
            System.out.println(menu.mPrincipal());
            op = input.nextInt();
            input.nextLine();
            switch (op) {
                case 1:
                    menuOpciones();
                    break;
                case 2:
                    tamagotchiV.tamagotchiControl.setMensaje(tamagotchiV.tamagotchiControl.getEstado());
                    break;
                case 3:
                    flag = false;
                    break;
                case 4:
                    tamagotchiV.tamagotchiControl.dormir();
                    break;
            }
        }
    }

    public void menuOpciones() {
        while (flag) {
            System.out.println(tamagotchiV.personaje);
            System.out.println(tamagotchiV.tamagotchiControl.getMensaje());
            System.out.println(menu.mOpciones());
            op = input.nextInt();
            switch (op) {
                case 1:
                    menuAlimentar();
                    break;
                case 2:
                    menuActividad();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void menuAlimentar() {
        while (flag) {
            System.out.println(tamagotchiV.personaje);
            System.out.println(tamagotchiV.tamagotchiControl.getMessage());
            System.out.println(menu.mAlimentar());
            op = input.nextInt();
            switch (op) {
                case 1:
                    tamagotchiV.menuComida();
                    break;
                case 2:
                    tamagotchiV.menuBocadillo();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void menuActividad() {
        while (flag) {
            System.out.println(tamagotchiV.personaje);
            System.out.println(tamagotchiV.tamagotchiControl.getMessage());
            System.out.println(menu.mActividad());
            op = input.nextInt();
            input.nextLine();
            switch (op) {
                case 1:
                    tamagotchiV.menuJuego();
                    break;
                case 2:
                    tamagotchiV.menuEstudiar();
                    break;
                case 3:
                    return;
            }
        }
    }

}
