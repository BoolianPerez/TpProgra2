package Interfaces;

import Modelos.Pedido;

public interface IColaDespacho {
    boolean estaVacia();
    void registrarPedido(Pedido pedido);
    Pedido despacharPedido();
    Pedido verPrimero();
    int getCantidad();
    void mostrarPedidos();
}