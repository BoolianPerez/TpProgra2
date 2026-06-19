package MovimientoLotes;

public class PilaMovimientos {
    private NodoMovimiento tope;

    public PilaMovimientos() {
        this.tope = null;
    }

    public NodoMovimiento getTope() {
        return tope;
    }

    public void agregar(Movimiento movimiento) {
        NodoMovimiento nuevoNodo = new NodoMovimiento(movimiento);
        if (tope != null) {
            nuevoNodo.siguiente = tope;
            tope.anterior = nuevoNodo;
        }
        tope = nuevoNodo;
    }

    public Movimiento extraer() {
        if (estaVacia()) {
            return null;
        }
        Movimiento movimiento = tope.movimiento;
        tope = tope.siguiente;
        if (tope != null) {
            tope.anterior = null;
        }
        return movimiento;
    }

    public Movimiento verTope() {
        if (estaVacia()) {
            return null;
        }
        return tope.movimiento;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int tamaño() {
        int count = 0;
        NodoMovimiento actual = tope;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

    public void mostrarMovimientos() {
        NodoMovimiento actual = tope;
        int posicion = 1;
        while (actual != null) {
            Movimiento m = actual.movimiento;
            System.out.println("Posición " + posicion + ": ID=" + m.getIdMovimiento() +
                    ", Tipo=" + m.getTipo() + ", Cantidad=" + m.getCantidad() +
                    ", Fecha=" + m.getFecha());
            actual = actual.siguiente;
            posicion++;
        }
    }
}
