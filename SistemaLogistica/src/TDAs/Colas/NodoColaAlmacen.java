package TDAs.Colas;

import Modelos.Conexion;

public class NodoColaAlmacen {
    public Conexion conexion;
    public NodoColaAlmacen siguiente;

    public NodoColaAlmacen(Conexion conexion) {
        this.conexion = conexion;
        this.siguiente = null;
    }
}
