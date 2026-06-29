package TDAs.Pila;

import Interfaces.IPilaHistorial;
import Modelos.OrdenMantenimiento;

public class PilaHistorial implements IPilaHistorial {
    private NodoHistorial tope;
    private int tamano;

    public PilaHistorial() {
        tope = null;
        tamano = 0;
    }

    @Override
    public boolean estaVacia() {
        return tope == null;
    }

    @Override
    public void agregarOrden(OrdenMantenimiento orden) {

        NodoHistorial nuevo = new NodoHistorial(orden);

        nuevo.siguiente = tope;
        tope = nuevo;
        tamano++;
    }

    @Override
    public OrdenMantenimiento quitarOrden() {

        if (estaVacia()) {
            return null;
        }

        OrdenMantenimiento orden = tope.orden;
        tope = tope.siguiente;
        tamano--;
        return orden;
    }

    @Override
    public void mostrarHistorial() {

        NodoHistorial actual = tope;

        while (actual != null) {

            OrdenMantenimiento o = actual.orden;

            System.out.println(
                    "ID: " + o.getIdOrden() +
                            " | Pasillo: " + o.getIdPasillo() +
                            " | Prioridad: " + o.getPrioridad()
            );

            actual = actual.siguiente;
        }
    }

    @Override
    public OrdenMantenimiento verTope(){
        return tope.orden;
    }

    @Override
    public int getTamano() {
        return tamano;
    }
}

