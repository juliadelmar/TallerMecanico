package org.iesalanadalus.programacion.tallermecanico;

import org.iesalanadalus.programacion.tallermecanico.controlador.Controlador;
import org.iesalanadalus.programacion.tallermecanico.modelo.FabricaModelo;
import org.iesalanadalus.programacion.tallermecanico.modelo.Modelo;
import org.iesalanadalus.programacion.tallermecanico.modelo.negocio.memoria.FabricaFuenteDatos;
import org.iesalanadalus.programacion.tallermecanico.vista.FabricaVista;
import org.iesalanadalus.programacion.tallermecanico.vista.Vista;
public class Main {

    public static void main(String[] args){
    Modelo modelo = FabricaModelo.CASCADA.crear(FabricaFuenteDatos.MEMORIA);
    Vista vista = FabricaVista.TEXTO.crear();

    Controlador controlador = new Controlador(modelo, vista);
    controlador.comenzar();
    }
}
