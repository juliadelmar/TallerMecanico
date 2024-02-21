package org.iesalanadalus.programacion.tallermecanico.vista;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum  Opcion {
    INSERTAR_CLIENTE("Insertar cliente",11),
    BUSCAR_CLIENTE("Buscar cliente",12),
    BORRAR_CLIENTE("Borra cliente",13),
    LISTAR_CLIENTES("Listar clientes",14),
    MODIFICAR_CLIENTE("Modificar Clientes",15 ),
    INSERTAR_VEHICULO("Insertar vehiculo",21),
    BUSCAR_VEHICULO("Buscar vehiculo",22),
    BORRAR_VEHICULO("Insertar vehiculo",23),
    LISTAR_VEHICULOS("Listar vehiculos",24),
    INSERTAR_REVISION("Insertar revision",31),
    BUSCAR_REVISION("Buscar revision",32),
    BORRAR_REVISION("Borrar revision",33),
    LISTAR_REVISIONES("Listar revisiones",34),
    LISTAR_REVISIONES_CLIENTES("Listar revisiones por clientes",35),
    LISTAR_REVISIONES_VEHICULOS("Listar revisiones por vehiculos",36),
    ANADIR_HORAS_REVISION("Añadir horas revision ",37),
    ANADIR_PRECIO_MATERIAL_REVISON("Añadir precio material revision ",38),
    CERRAR_REVISION("Cerrar revision",39),
    SALIR("Salir",0);
    private  String nombre;
    private  Integer numeroOpcion;
    private static final Map<Integer, Opcion> opciones = new HashMap<>();
    static {
        for (Opcion opcion:values()) {
            opciones.put(opcion.numeroOpcion, opcion);
        }
    }
    Opcion(String nombre, Integer opcion) {
        this.nombre = nombre;
        this.numeroOpcion = opcion;
    }
    public static boolean esValida(int numeroOpcion) {
        Objects.requireNonNull(numeroOpcion,"El numero no es valido");
        return opciones.containsKey(numeroOpcion);
    }

    public static Opcion get(int numeroOpcion) {
        if (!esValida(numeroOpcion)) {
            throw new IllegalArgumentException("Opción inválida");
        }
        return opciones.get(numeroOpcion);
    }

    @Override
    public String toString() {
        return String.format("%s. %s ", this.numeroOpcion, this.nombre);
    }
}
