package BusquedaProductos;

public class NodoAVL {
    Producto producto;
    NodoAVL hijoIzq;
    NodoAVL hijoDer;
    int altura;

    public NodoAVL(Producto producto) {
        this.producto = producto;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.altura = 1;
    }
}
