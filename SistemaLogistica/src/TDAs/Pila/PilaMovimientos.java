package TDAs.Pila;

import Modelos.Movimiento;
import Interfaces.IPilaMovimientos;

public class PilaMovimientos implements IPilaMovimientos {
    private NodoMovimiento tope;

    public PilaMovimientos() {
        this.tope = null;
    }

    @Override
    public NodoMovimiento getTope() {
        return tope;
    }

    @Override
    public void registrarMovimiento(Movimiento movimiento) {
        NodoMovimiento nuevoNodo = new NodoMovimiento(movimiento);
        if (tope != null) {
            nuevoNodo.siguiente = tope;
            tope.anterior = nuevoNodo;
        }
        tope = nuevoNodo;
    }

    @Override
    public Movimiento deshacerUltimoMovimiento() {
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

    @Override
    public Movimiento verTope() {
        if (estaVacia()) {
            return null;
        }
        return tope.movimiento;
    }

    @Override
    public boolean estaVacia() {
        return tope == null;
    }

    @Override
    public int tamaño() {
        int count = 0;
        NodoMovimiento actual = tope;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

    @Override
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
