package org.iesalanadalus.programacion.tallermecanico.modelo.negocio;
import org.iesalanadalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalanadalus.programacion.tallermecanico.modelo.dominio.Trabajo;
import org.iesalanadalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import java.time.LocalDate;
import java.util.List;


public interface ITrabajos {
    List<Trabajo> get();

    List<Trabajo> get(Cliente cliente);

    List<Trabajo> get(Vehiculo vehiculo);

    void insertar(Trabajo trabajo) ;

    void anadirHoras(Trabajo trabajo, int horas) ;

    void anadirPrecioMaterial(Trabajo trabajo, float precioMaterial)  ;

    void cerrar(Trabajo trabajo, LocalDate fechaFin) ;

    Trabajo buscar(Trabajo trabajo);

    void borrar(Trabajo trabajo) ;
}
