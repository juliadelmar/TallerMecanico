package org.iesalanadalus.programacion.tallermecanico;

import org.iesalanadalus.programacion.tallermecanico.controlador.Controlador;
import org.iesalanadalus.programacion.tallermecanico.modelo.Modelo;
import org.iesalanadalus.programacion.tallermecanico.vista.Vista;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(modelo,vista);

        controlador.comenzar();
    }

}
