package TDAs.Pila;

import Modelos.OrdenMantenimiento;

public class NodoHistorial {
    public OrdenMantenimiento orden;
    public NodoHistorial siguiente;

    public NodoHistorial(OrdenMantenimiento orden) {
        this.orden = orden;
        this.siguiente = null;
    }
}
