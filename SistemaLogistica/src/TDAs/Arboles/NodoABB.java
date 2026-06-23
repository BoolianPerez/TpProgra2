package TDAs.Arboles;

import Modelos.Producto;

public class NodoABB {

    Producto producto;
    NodoABB hijoIzq;
    NodoABB hijoDer;

    public NodoABB(Producto producto) {
        this.producto = producto;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
}
