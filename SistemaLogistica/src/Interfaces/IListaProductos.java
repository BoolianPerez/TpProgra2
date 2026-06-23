package Interfaces;

import Modelos.Producto;
import TDAs.Listas.NodoProducto;

public interface IListaProductos {
    boolean estaVacia();
    void agregarProducto(Producto producto);
    void mostrarProductos();
    NodoProducto getPrimero();
}