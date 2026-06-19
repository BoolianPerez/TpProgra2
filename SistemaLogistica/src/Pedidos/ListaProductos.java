package Pedidos;

public class ListaProductos {
    private NodoProducto primero;

    public ListaProductos() {
        this.primero = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

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
}