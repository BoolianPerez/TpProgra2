package TDAs.Colas;

import Interfaces.IColaPrioridadMantenimiento;
import Modelos.OrdenMantenimiento;

public class ColaPrioridadMantenimiento implements IColaPrioridadMantenimiento {
    private NodoPrioridad frente;
    private int tamano;

    public ColaPrioridadMantenimiento() {
        frente = null;
        tamano = 0;
    }

    @Override
    public boolean estaVacia() {
        return frente == null;
    }

    @Override
    public void encolarOrden(OrdenMantenimiento orden) {

        NodoPrioridad nuevo = new NodoPrioridad(orden);

        if (frente == null ||
                orden.getPrioridad().getValor() >
                        frente.orden.getPrioridad().getValor()) {

            nuevo.siguiente = frente;
            frente = nuevo;
            tamano++;
            return;
        }

        NodoPrioridad actual = frente;

        while (actual.siguiente != null &&
                actual.siguiente.orden.getPrioridad().getValor() >=
                        orden.getPrioridad().getValor()) {

            actual = actual.siguiente;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        tamano++;
    }

    @Override
    public OrdenMantenimiento desencolarOrden() {

        if (estaVacia()) {
            return null;
        }

        OrdenMantenimiento orden = frente.orden;
        frente = frente.siguiente;
        tamano--;
        return orden;
    }

    @Override
    public OrdenMantenimiento verFrente() {

        if (estaVacia()) {
            return null;
        }

        return frente.orden;
    }

    @Override
    public void mostrarOrdenes() {

        NodoPrioridad actual = frente;

        while (actual != null) {

            OrdenMantenimiento o = actual.orden;

            System.out.println(
                            "ID: " + o.getIdOrden() +
                            " | Pasillo: " + o.getIdPasillo() +
                            " | Prioridad: " + o.getPrioridad() +
                            " | Descripcion: " + o.getDescripcion()
            );

            actual = actual.siguiente;
        }
    }

    @Override
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}
