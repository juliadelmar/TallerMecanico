package org.iesalanadalus.programacion.tallermecanico.modelo;

import org.iesalanadalus.programacion.tallermecanico.modelo.cascada.ModeloCascada;
import org.iesalanadalus.programacion.tallermecanico.modelo.negocio.memoria.FabricaFuenteDatos;

public enum FabricaModelo {
    CASCADA{
        @Override
        public Modelo crear(FabricaFuenteDatos fabricaFuenteDatos) {
            return new ModeloCascada(fabricaFuenteDatos);
        }
    };
    public abstract Modelo crear(FabricaFuenteDatos fabricaFuenteDatos);
}
