package TDAs.Colas;

import Modelos.Pedido;

public class ColaDespacho {
    private NodoPedido frente;
    private NodoPedido fin;
    private int cantidad;

    public ColaDespacho() {
        this.frente = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void registrarPedido(Pedido pedido) {
        NodoPedido nuevoNodo = new NodoPedido(pedido);

        if (estaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }

        cantidad++;
    }

    public Pedido despacharPedido() {
        if (estaVacia()) {
            return null;
        }

        Pedido pedido = frente.getPedido();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        cantidad--;
        return pedido;
    }

    public Pedido verPrimero() {
        if (estaVacia()) {
            return null;
        }

        return frente.getPedido();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void mostrarPedidos() {
        if (estaVacia()) {
            System.out.println("No hay pedidos en la cola.");
            return;
        }

        NodoPedido actual = frente;

        while (actual != null) {
            System.out.println(actual.getPedido());
            actual = actual.getSiguiente();
        }
    }
}