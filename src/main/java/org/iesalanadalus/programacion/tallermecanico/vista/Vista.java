package org.iesalanadalus.programacion.tallermecanico.vista;

import org.iesalanadalus.programacion.tallermecanico.controlador.Controlador;
import org.iesalanadalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalanadalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalanadalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.Objects;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        Objects.requireNonNull(controlador,"EL controlador no puede ser nulo");
        this.controlador = controlador;
    }
    public  void comenzar() throws OperationNotSupportedException {
        Consola.mostrarCabecera("Taller mecánico");
        Opcion opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcion();
            ejecutar(opcion);
        }while (opcion != Opcion.SALIR);

    }
    public  void terminar(){
        System.out.println("Fin");
    }
    private void ejecutar(Opcion opcion) throws OperationNotSupportedException {
        switch (opcion){
            case BORRAR_CLIENTE -> borrarCliente();
            case SALIR -> salir();
            case BUSCAR_CLIENTE -> buscarCliente();
            case BORRAR_REVISION -> borrarRevision();
            case BORRAR_VEHICULO -> borrarVehiculo();
            case BUSCAR_REVISION -> buscarRevision();
            case BUSCAR_VEHICULO -> buscarVehiculo();
            case CERRAR_REVISION -> cerrarRevision();
            case LISTAR_CLIENTES -> listarClientes();
            case INSERTAR_CLIENTE -> insertarCliente();
            case LISTAR_VEHICULOS -> listarVehiculo();
            case INSERTAR_REVISION -> insertarRevision();
            case INSERTAR_VEHICULO -> insertarVehiculo();
            case LISTAR_REVISIONES -> listarRevision();
            case MODIFICAR_CLIENTE -> modificarCliente();
            case ANADIR_HORAS_REVISION -> anadirHoras();
            case LISTAR_REVISIONES_CLIENTES -> listarRevisionesCliente();
            case LISTAR_REVISIONES_VEHICULOS -> listarRevisionesVehiculo();
            case ANADIR_PRECIO_MATERIAL_REVISON -> anadirPrecioMaterial();
        }
    }
    private void cerrarRevision(){
        Revision revision = Consola.leerRevision();
        LocalDate localDate = Consola.leerFechaCierre();
        controlador.cerrar(revision,localDate);
        System.out.println("La revision" + revision + "ha sido cerrada a las " + localDate);
    }
    private void salir(){
        controlador.terminar();
    }
    private void insertarCliente(){
        Consola.mostrarCabecera("Insertar cliente ");
        Cliente cliente = Consola.leerCliente();
            controlador.insertar(cliente);
        System.out.println("El cliente:" + cliente + "ha sido añadido a la lista .");
    }
    private void insertarVehiculo(){
        Consola.mostrarCabecera("Insertar vehiculo ");

        Vehiculo vehiculo = Consola.leerVehiculo();
            controlador.insertar(vehiculo);
        System.out.println("El vehiculo:" + vehiculo + "ha sido añadido a la lista.");

    }
    private void insertarRevision(){
        Consola.mostrarCabecera("Insertar revision ");

        Revision revision = Consola.leerRevision();
        controlador.insertar(revision);
        System.out.println("La revision: " + revision + "ha sido añadida a la lista.");

    }
    private void borrarCliente() throws OperationNotSupportedException {
        Consola.mostrarCabecera("Borrar cliente ");

        Cliente cliente = Consola.leerCliente();
        controlador.borrar(cliente);

        System.out.println("El cliente : " + cliente + "ha sido borrado.");
    }
    private void borrarVehiculo() throws OperationNotSupportedException {
        Consola.mostrarCabecera("Borrar vehiculo ");
        Vehiculo vehiculo = Consola.leerVehiculo();
        controlador.borrar(vehiculo);

        System.out.println("El vehiculo : " + vehiculo + "ha sido borrado");
    }
    private void borrarRevision() throws OperationNotSupportedException {
        Consola.mostrarCabecera("Borrar revision ");
        Revision revision = Consola.leerRevision();

            controlador.borrar(revision);

        System.out.println("La revision "+ revision + "ha sido borrada.");
    }
    private void buscarCliente(){
        Consola.mostrarCabecera("Buscar cliente ");
        Cliente cliente = Consola.leerCliente();
        controlador.buscar(cliente);
        System.out.println("El cliente : " + cliente + "ha sido encontrado.");

    }
    private void buscarVehiculo(){
        Consola.mostrarCabecera("Buscar vehiculo ");
        Vehiculo vehiculo = Consola.leerVehiculo();
        controlador.buscar(vehiculo);
        System.out.println("El vehiculo : " + vehiculo + "ha sido encontrado");
    }
    private void buscarRevision(){
        Consola.mostrarCabecera("Buscar revision ");
        Revision revision = Consola.leerRevision();
        controlador.buscar(revision);
        System.out.println("La revision "+ revision + "ha sido encontrado.");

    }
    private void listarClientes(){
        Consola.mostrarCabecera("Listar cliente ");
        controlador.getClientes();
    }
    private void listarVehiculo(){
        Consola.mostrarCabecera("Listar vehiculo ");

        controlador.getVehiculos();
    }
    private void listarRevision(){
        Consola.mostrarCabecera("Listar revision ");

        controlador.getRevisiones();
    }
    private void  modificarCliente() throws OperationNotSupportedException {
        Consola.mostrarCabecera("Modificar cliente ");

        controlador.modificar(Consola.leerClieneDni(),Consola.leerNuevoNombre(),Consola.leerNuevoTelefono());

    }
    private void anadirHoras(){
        Consola.mostrarCabecera("Añadir horas ");

        Revision revision = Consola.leerRevision();
        int horas = Consola.leerHoras();
        controlador.anadirHoras(revision,horas);
        System.out.println("Se han añadido" + horas + "a la revision" + revision);
    }
    private void anadirPrecioMaterial() throws OperationNotSupportedException {
        Consola.mostrarCabecera("Añadir precio material ");
        Revision revision = Consola.leerRevision();
        float precioMaterial = Consola.leerPrecioMaterial();

        controlador.anadirPrecioMaterial(revision, precioMaterial);

        System.out.println("Se han añadido" + precioMaterial + "a la revision" + revision);
    }
    public void listarRevisionesCliente(){

        Consola.mostrarCabecera("Listar revisiones cliente ");
        controlador.getRevisiones(Consola.leerCliente());
    }
    public void listarRevisionesVehiculo(){
        Consola.mostrarCabecera("Listar revisiones vehiculo ");
        controlador.getRevisiones(Consola.leerVehiculo());
    }

}
