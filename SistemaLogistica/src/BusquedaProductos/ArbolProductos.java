package BusquedaProductos;

public class ArbolProductos implements IArbolProductos {

    private NodoAProducto raiz;

    public ArbolProductos() {
        this.raiz = null;
    }

    @Override
    public void insertar(Producto producto) {

        if (this.raiz == null) {
            this.raiz = new NodoAProducto(producto);
        } else {
            insertarRecursivo(this.raiz, producto);
        }

    }

    private void insertarRecursivo(NodoAProducto nodoActual, Producto producto) {
        if (producto.getId() < nodoActual.producto.getId()) {
            if (nodoActual.hijoIzq == null) {
                nodoActual.hijoIzq = new NodoAProducto(producto);
            } else {
                insertarRecursivo(nodoActual.hijoIzq, producto);
            }
        } else if (producto.getId() > nodoActual.producto.getId()) {
            if (nodoActual.hijoDer == null) {
                nodoActual.hijoDer = new NodoAProducto(producto);
            } else {
                insertarRecursivo(nodoActual.hijoDer, producto);
            }
        }
    }

    @Override
    public Producto buscar(int idProducto) {
        NodoAProducto resultado = buscarRecursivo(this.raiz, idProducto);
        if (resultado != null) {
            return resultado.producto;
        }
        return null;
    }

    private NodoAProducto buscarRecursivo(NodoAProducto nodoActual, int idProducto) {

        if (nodoActual == null || nodoActual.producto.getId() == idProducto) {
            return nodoActual;
        }

        if (idProducto < nodoActual.producto.getId()) {
            return buscarRecursivo(nodoActual.hijoIzq, idProducto);
        }

        return buscarRecursivo(nodoActual.hijoDer, idProducto);
    }

    @Override
    public void mostrarInOrden() {
        mostrarInOrdenRecursivo(this.raiz);
    }

    private void mostrarInOrdenRecursivo(NodoAProducto nodoActual) {
        if (nodoActual != null){
            mostrarInOrdenRecursivo(nodoActual.hijoIzq);
            System.out.println("ID: " + nodoActual.producto.getId() + " - " + nodoActual.producto.getNombre());
            mostrarInOrdenRecursivo(nodoActual.hijoDer);
        }
    }
}
