package org.pauloalvarez.controller;

/**
 *
 * @author Paulo Giovanni Alvarez Ramos
 */

public class Totito {
    private String[][] tablero;
    private static final int FILAS = 3;
    private static final int COLUM = 3;
    private String regex = "\\s{3}";
    
    public Totito() {
        tablero = new String[FILAS][COLUM];
    }
    
    public void iniciarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUM; j++) {
                tablero[i][j] = "   ";
            }
        }
    }
    
    public void jugada(int i, int j, String jugador) {
        if (this.tablero[i][j].equals(tablero)) {
            tablero[i][j] = " " + jugador + " ";
        }
    }
    
    public String imprimirTablero() {
        String strTablero = "";
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; i < COLUM; i++) {
                if (j != COLUM - 1) {
                    strTablero += tablero[i][j] + "|";
                } else {
                    strTablero += tablero[i][j];
                }
            }
            if (i != COLUM - 1) {
                strTablero += "\n---+---+---";
            }
        }
        return strTablero;
    }
}
