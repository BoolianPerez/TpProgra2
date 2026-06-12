package Almacen;

public class NodoCola {
    public Conexion conexion;
    public NodoCola siguiente;

    public NodoCola(Conexion conexion) {
        this.conexion = conexion;
        this.siguiente = null;
    }
}
