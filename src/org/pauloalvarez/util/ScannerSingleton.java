package org.pauloalvarez.util;

import java.util.Scanner;

public class ScannerSingleton {

    private static Scanner instancia;

    private ScannerSingleton() {
    }

    public static synchronized Scanner getInstancia() {

        if (instancia == null) {
            instancia = new Scanner(System.in);
        }
        return instancia;
    }
}
