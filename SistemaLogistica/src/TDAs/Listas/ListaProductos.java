package TDAs.Listas;

import Modelos.Producto;
import Interfaces.IListaProductos;

public class ListaProductos implements IListaProductos {
    private NodoProducto primero;

    public ListaProductos() {
        this.primero = null;
    }

    @Override
    public boolean estaVacia() {
        return primero == null;
    }

    @Override
    public void agregarProducto(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto);

        if (estaVacia()) {
            primero = nuevoNodo;
        } else {
            NodoProducto actual = primero;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevoNodo);
        }
    }

    @Override
    public void mostrarProductos() {
        if (estaVacia()) {
            System.out.println("No hay productos en la lista.");
            return;
        }

        NodoProducto actual = primero;

        while (actual != null) {
            System.out.println(actual.getProducto());
            actual = actual.getSiguiente();
        }
    }

    @Override
    public NodoProducto getPrimero() {
        return primero;
    }
}