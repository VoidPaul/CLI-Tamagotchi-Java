package org.pauloalvarez.controller;

/**
 *
 * @author Paulo Giovanni Alvarez Ramos
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import org.pauloalvarez.model.Estudio;
import org.pauloalvarez.util.Excepciones;
import org.pauloalvarez.util.Logger;

public class EstudioController extends Excepciones {
    
    private static EstudioController instancia;
    private ArrayList<Estudio> datosAprendidos = new ArrayList<>();
    
    private static final String DATOS_FILE = "datos.txt";
    
    public EstudioController() {
    }
    
    public static synchronized EstudioController getInstancia() {
        if (instancia == null) {
            instancia = new EstudioController();
        }
        return instancia;
    }
    
    public void aprenderDato(String datoAprendido) {
        leerDatos();
        
        Estudio learn = new Estudio(datoAprendido);
        datosAprendidos.add(learn);
    }
    
    public void guardarDatosAprendidos() {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(DATOS_FILE))) {
            objectOut.writeObject(datosAprendidos);
            System.out.println("                              Listo! Ya lo aprend\u00ed.");
        } catch (FileNotFoundException ex) {
            Logger.log("Error al guardar los datos" + ex.getMessage());
            System.out.println("                           Disculpa, no pude aprender esto. \n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de Ejecuci\u00f2n: " + ex.getMessage());
        }
    }
    
    public ArrayList<Estudio> leerDatos() {
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(DATOS_FILE))) {
            datosAprendidos = (ArrayList)objectIn.readObject();
        } catch (FileNotFoundException ex) {
            datosAprendidos = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.log("Error al cargar los datos aprendidos: " + ex.getMessage());
            System.out.println("Existi\u00f2 un error al recuparar la informaci\u00f2n, no se encontr\u00f2 la clase.");
        }
        return datosAprendidos;
    }
}
