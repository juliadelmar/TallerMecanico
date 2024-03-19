package org.iesalanadalus.programacion.tallermecanico.modelo.negocio.memoria;

import org.iesalanadalus.programacion.tallermecanico.modelo.dominio.*;
import org.iesalanadalus.programacion.tallermecanico.modelo.negocio.ITrabajos;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trabajos implements ITrabajos {
    private List<Trabajo> coleccionTrabajos;

    public Trabajos() {
        coleccionTrabajos = new ArrayList<>();
    }

    @Override
    public List<Trabajo> get() {
        return new ArrayList<>(coleccionTrabajos);
    }

    @Override
    public List<Trabajo> get(Cliente cliente) {
        List<Trabajo> listaTemporal = new ArrayList<>();

        for (Trabajo trabajo : coleccionTrabajos) {
            if (trabajo.getCliente().equals(cliente)) {
                listaTemporal.add(trabajo);
            }
        }
        return listaTemporal;
    }

    @Override
    public List<Trabajo> get(Vehiculo vehiculo) {
        List<Trabajo> listaTemporal = new ArrayList<>();
        for (Trabajo trabajo : coleccionTrabajos) {
            if (trabajo.getVehiculo().equals(vehiculo)) {
                listaTemporal.add(trabajo);
            }
        }
        return listaTemporal;
    }

    private void comprobarTrabajo(Cliente cliente, Vehiculo vehiculo, LocalDate fechaTrabajo) throws OperationNotSupportedException {
        for (Trabajo trabajo : coleccionTrabajos) {
            if (trabajo.getCliente().equals(cliente) && !trabajo.estaCerrado()) {
                throw new OperationNotSupportedException("El cliente tiene otro trabajo en curso.");
            }
            if (trabajo.getVehiculo().equals(vehiculo) && !trabajo.estaCerrado()) {
                throw new OperationNotSupportedException("El vehículo está actualmente en el taller.");
            }
            if (trabajo.estaCerrado() && trabajo.getCliente().equals(cliente) && !fechaTrabajo.isAfter(trabajo.getFechaFin())) {
                throw new OperationNotSupportedException("El cliente tiene otro trabajo posterior.");
            }
            if (trabajo.estaCerrado() && trabajo.getVehiculo().equals(vehiculo) && !fechaTrabajo.isAfter(trabajo.getFechaFin())) {
                throw new OperationNotSupportedException("El vehículo tiene otro trabajo posterior.");
            }
        }
    }
    private Trabajo getTrabajoAbierto(Vehiculo vehiculo){
        Trabajo trabajoAbierto = null;
        for (Trabajo trabajo : coleccionTrabajos){
            if( (trabajo.getVehiculo().equals(vehiculo)) && (trabajo.getFechaFin() == null )){
                trabajoAbierto = trabajo;
            }
        }
        return trabajoAbierto;
    }


    @Override
    public void insertar(Trabajo trabajo)  {
        Objects.requireNonNull(trabajo, "No se puede insertar un trabajo nulo.");

        Cliente cliente = trabajo.getCliente();
        Vehiculo vehiculo = trabajo.getVehiculo();
        LocalDate fechaRevision = trabajo.getFechaInicio();

        try {
            comprobarTrabajo(cliente, vehiculo, fechaRevision);
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }

        coleccionTrabajos.add(trabajo);
    }


    @Override
    public void anadirHoras(Trabajo trabajo, int horas)  {
        Objects.requireNonNull(trabajo, "No puedo añadir horas a un trabajo nulo.");
        if (getTrabajoAbierto(trabajo.getVehiculo()) == null){
            try {
                throw new OperationNotSupportedException("No existe ningún trabajo abierto para dicho vehículo.");
            } catch (OperationNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        if (!coleccionTrabajos.contains(trabajo)) {
            try {
                throw new OperationNotSupportedException("No existe ningún trabajo abierto para dicho vehículo.");
            } catch (OperationNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        trabajo.anadirHoras(horas);
    }

    @Override
    public void anadirPrecioMaterial(Trabajo trabajo, float precioMaterial)  {
        Objects.requireNonNull(trabajo, "No puedo añadir precio del material a un trabajo nulo.");

        if (getTrabajoAbierto(trabajo.getVehiculo()) == null){
            try {
                throw new OperationNotSupportedException("No existe ningún trabajo abierto para dicho vehículo.");
            } catch (OperationNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        if (!coleccionTrabajos.contains(trabajo)) {
            try {
                throw new OperationNotSupportedException("No existe ningún trabajo abierto para dicho vehículo.");
            } catch (OperationNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        if (trabajo instanceof Mecanico mecanico){
          mecanico.anadirPrecioMaterial(precioMaterial);
        } else {

            try {
                throw new OperationNotSupportedException("No se puede añadir precio al material para este tipo de trabajos.");
            } catch (OperationNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void cerrar(Trabajo trabajo, LocalDate fechaFin) {
        Objects.requireNonNull(trabajo, "No puedo cerrar un trabajo nulo.");

        Objects.requireNonNull(fechaFin, "La fecha de fin no puede ser nula.");
        if (!coleccionTrabajos.contains(trabajo)) {
            try {
                throw new OperationNotSupportedException("No existe ningún trabajo abierto para dicho vehículo.");
            } catch (OperationNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        trabajo.cerrar(fechaFin);
    }

    @Override
    public Trabajo buscar(Trabajo trabajo) {
        Objects.requireNonNull(trabajo, "No se puede buscar un trabajo nulo.");
        int indice = coleccionTrabajos.indexOf(trabajo);
        Trabajo aux = null;
        if (indice != -1) {
            aux = coleccionTrabajos.get(indice);

        }
        return aux;
    }

    @Override
    public void borrar(Trabajo trabajo)  {
        Objects.requireNonNull(trabajo, "No se puede borrar un trabajo nulo.");

        int indice = coleccionTrabajos.indexOf(trabajo);

        if (indice == -1) {
            try {
                throw new OperationNotSupportedException("No existe ningún trabajo igual.");
            } catch (OperationNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        coleccionTrabajos.remove(indice);
    }
}