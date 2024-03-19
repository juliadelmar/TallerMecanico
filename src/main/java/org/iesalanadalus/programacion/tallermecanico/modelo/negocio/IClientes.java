package org.iesalanadalus.programacion.tallermecanico.modelo.negocio;

import org.iesalanadalus.programacion.tallermecanico.modelo.dominio.Cliente;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public interface IClientes {
    List<Cliente> get();

    void insertar(Cliente cliente) throws OperationNotSupportedException;

    Cliente buscar(Cliente cliente);

    boolean modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException;

    void borrar(Cliente cliente) throws OperationNotSupportedException;
}
