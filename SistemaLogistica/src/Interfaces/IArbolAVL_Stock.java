package Interfaces;

import Modelos.Producto;

public interface IArbolAVL_Stock {
    void insertar(Producto producto);
    void eliminar(Producto producto);
    void modificarStock(Producto producto, int nuevoStock);
    void mostrarStock();
    // Lista productos con stock menor al umbral provisto
    void listarProductosConStockMenorQue(int umbral);
    Producto obtenerMinStock();
    Producto obtenerMaxStock();
}
