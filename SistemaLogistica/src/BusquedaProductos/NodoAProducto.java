package BusquedaProductos;

public class NodoAProducto{

    Producto producto;
    NodoAProducto hijoIzq;
    NodoAProducto hijoDer;

    public NodoAProducto(Producto producto) {
        this.producto = producto;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
}
