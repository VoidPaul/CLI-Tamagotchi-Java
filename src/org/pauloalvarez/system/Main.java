package org.pauloalvarez.system;

import org.pauloalvarez.view.MenuGeneral;

/**
 *
 * @author Paulo Giovanni Alvarez Ramos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * @param iniciarMenu llama una gunción en la clase MenuGeneral
         * 
         * Debido a limitaciones de tiempo, no pude documentar todo el programa.
         */
        MenuGeneral iniciarMenu = MenuGeneral.getInstancia();
        
        iniciarMenu.iniciar();
    }
    
}
