package org.iesalanadalus.programacion.tallermecanico.modelo.negocio.memoria;

import org.iesalanadalus.programacion.tallermecanico.modelo.negocio.IClientes;
import org.iesalanadalus.programacion.tallermecanico.modelo.negocio.IFuenteDatosMemoria;
import org.iesalanadalus.programacion.tallermecanico.modelo.negocio.ITrabajos;
import org.iesalanadalus.programacion.tallermecanico.modelo.negocio.IVehiculos;

public class FuenteDatosMemoria implements IFuenteDatosMemoria {
    @Override
    public IClientes crearClientes(){
        return new Clientes();
    }
    @Override
    public IVehiculos crearVehiculo(){
        return new Vehiculos();
    }
    @Override
    public ITrabajos crearTrabajo(){
        return new Trabajos();
    }
}
