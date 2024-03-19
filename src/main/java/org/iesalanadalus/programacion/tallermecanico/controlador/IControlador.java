package org.iesalanadalus.programacion.tallermecanico.controlador;

import org.iesalanadalus.programacion.tallermecanico.vista.eventos.Evento;
import org.iesalanadalus.programacion.tallermecanico.vista.eventos.ReceptorEventos;

import javax.naming.OperationNotSupportedException;

public interface IControlador extends ReceptorEventos {
    void comenzar() throws OperationNotSupportedException;

    void terminar();

    void actualizarEvento(Evento evento);
}
