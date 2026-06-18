package BusquedaProductos;

public class ArbolAVL_Stock implements IArbolAVL_Stock {

    private NodoAVL raiz;

    public ArbolAVL_Stock() {
        this.raiz = null;
    }

    private int obtenerAltura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return obtenerAltura(nodo.hijoIzq) - obtenerAltura(nodo.hijoDer);
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.hijoIzq;
        NodoAVL temp = x.hijoDer;

        x.hijoDer = y;
        y.hijoIzq = temp;

        y.altura = Math.max(obtenerAltura(y.hijoIzq), obtenerAltura(y.hijoDer)) + 1;
        x.altura = Math.max(obtenerAltura(x.hijoIzq), obtenerAltura(x.hijoDer)) + 1;

        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.hijoDer;
        NodoAVL temp = y.hijoIzq;

        y.hijoIzq = x;
        x.hijoDer = temp;

        x.altura = Math.max(obtenerAltura(x.hijoIzq), obtenerAltura(x.hijoDer)) + 1;
        y.altura = Math.max(obtenerAltura(y.hijoIzq), obtenerAltura(y.hijoDer)) + 1;

        return y;
    }

    @Override
    public void insertar(Producto producto) {
        this.raiz = insertarRecursivo(this.raiz, producto);
    }

    private NodoAVL insertarRecursivo(NodoAVL nodoActual, Producto producto) {
        if (nodoActual == null) {
            return new NodoAVL(producto);
        }

        if (producto.getStockActual() < nodoActual.producto.getStockActual()) {
            nodoActual.hijoIzq = insertarRecursivo(nodoActual.hijoIzq, producto);
        } else {
            nodoActual.hijoDer = insertarRecursivo(nodoActual.hijoDer, producto);
        }

        nodoActual.altura = 1 + Math.max(obtenerAltura(nodoActual.hijoIzq), obtenerAltura(nodoActual.hijoDer));

        int balance = obtenerBalance(nodoActual);

        if (balance > 1 && producto.getStockActual() < nodoActual.hijoIzq.producto.getStockActual()) {
            return rotacionDerecha(nodoActual);
        }

        if (balance < -1 && producto.getStockActual() >= nodoActual.hijoDer.producto.getStockActual()) {
            return rotacionIzquierda(nodoActual);
        }

        if (balance > 1 && producto.getStockActual() >= nodoActual.hijoIzq.producto.getStockActual()) {
            nodoActual.hijoIzq = rotacionIzquierda(nodoActual.hijoIzq);
            return rotacionDerecha(nodoActual);
        }

        if (balance < -1 && producto.getStockActual() < nodoActual.hijoDer.producto.getStockActual()) {
            nodoActual.hijoDer = rotacionDerecha(nodoActual.hijoDer);
            return rotacionIzquierda(nodoActual);
        }

        return nodoActual;
    }

    @Override
    public void eliminar(Producto producto) {
        this.raiz = eliminarRecursivo(this.raiz, producto);
    }

    private NodoAVL eliminarRecursivo(NodoAVL nodoActual, Producto producto) {
        if (nodoActual == null) {
            return null;
        }

        if (producto.getStockActual() < nodoActual.producto.getStockActual()) {

            nodoActual.hijoIzq = eliminarRecursivo(nodoActual.hijoIzq, producto);

        } else if (producto.getStockActual() > nodoActual.producto.getStockActual()) {

            nodoActual.hijoDer = eliminarRecursivo(nodoActual.hijoDer, producto);

        } else {
            if (producto.getId() != nodoActual.producto.getId()) {

                nodoActual.hijoDer = eliminarRecursivo(nodoActual.hijoDer, producto);

            } else {

                if (nodoActual.hijoIzq == null) {
                    return nodoActual.hijoDer;
                } else if (nodoActual.hijoDer == null) {
                    return nodoActual.hijoIzq;
                }

                nodoActual.producto = obtenerMenorProducto(nodoActual.hijoDer);

                nodoActual.hijoDer = eliminarRecursivo(nodoActual.hijoDer, nodoActual.producto);
            }
        }

        if (nodoActual == null) {
            return null;
        }

        nodoActual.altura = 1 + Math.max(obtenerAltura(nodoActual.hijoIzq), obtenerAltura(nodoActual.hijoDer));

        int balance = obtenerBalance(nodoActual);

        if (balance > 1 && obtenerBalance(nodoActual.hijoIzq) >= 0) {
            return rotacionDerecha(nodoActual);
        }

        if (balance > 1 && obtenerBalance(nodoActual.hijoIzq) < 0) {
            nodoActual.hijoIzq = rotacionIzquierda(nodoActual.hijoIzq);
            return rotacionDerecha(nodoActual);
        }

        if (balance < -1 && obtenerBalance(nodoActual.hijoDer) <= 0) {
            return rotacionIzquierda(nodoActual);
        }

        if (balance < -1 && obtenerBalance(nodoActual.hijoDer) > 0) {
            nodoActual.hijoDer = rotacionDerecha(nodoActual.hijoDer);
            return rotacionIzquierda(nodoActual);
        }

        return nodoActual;
    }

    private Producto obtenerMenorProducto(NodoAVL nodo) {
        Producto menor = nodo.producto;
        while (nodo.hijoIzq != null) {
            menor = nodo.hijoIzq.producto;
            nodo = nodo.hijoIzq;
        }
        return menor;
    }

    @Override
    public void modificarStock(Producto producto, int nuevoStock) {
        this.raiz = eliminarRecursivo(this.raiz, producto);
        producto.setStockActual(nuevoStock);
        insertar(producto);
    }

    @Override
    public void mostrarStock() {
        mostrarInorden(this.raiz);
    }

    private void mostrarInorden(NodoAVL nodo) {
        if (nodo != null) {
            mostrarInorden(nodo.hijoIzq);
            System.out.println("Stock: " + nodo.producto.getStockActual() + " | ID: " + nodo.producto.getId() + " - " + nodo.producto.getNombre());
            mostrarInorden(nodo.hijoDer);
        }
    }

    @Override
    public Producto obtenerMinStock() {
        if (this.raiz == null)
            return null;
        NodoAVL actual = this.raiz;
        while (actual.hijoIzq != null) {
            actual = actual.hijoIzq;
        }
        return actual.producto;
    }

    @Override
    public Producto obtenerMaxStock() {
        if (this.raiz == null)
            return null;
        NodoAVL actual = this.raiz;
        while (actual.hijoDer != null) {
            actual = actual.hijoDer;
        }
        return actual.producto;
    }
}
