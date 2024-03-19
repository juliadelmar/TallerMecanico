package org.iesalanadalus.programacion.tallermecanico.modelo.negocio.memoria;

import org.iesalanadalus.programacion.tallermecanico.modelo.negocio.IFuenteDatosMemoria;
import org.iesalanadalus.programacion.tallermecanico.modelo.negocio.memoria.FuenteDatosMemoria;

public enum FabricaFuenteDatos {
    MEMORIA{
        @Override
        public IFuenteDatosMemoria crear() {
            return new FuenteDatosMemoria();
        }
    };
    public abstract IFuenteDatosMemoria crear();
}
