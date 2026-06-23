package TDAs.Listas;

import Modelos.Conexion;

public class NodoConexion {
    public Conexion conexion;
    public NodoConexion siguiente;

    public NodoConexion(Conexion conexion) {
        this.conexion = conexion;
        this.siguiente = null;
    }
}
