package Interfaces;

import Modelos.OrdenMantenimiento;

public interface IPilaHistorial {
    boolean estaVacia();
    void agregarOrden(OrdenMantenimiento orden);
    OrdenMantenimiento quitarOrden();
    OrdenMantenimiento verTope();
    int getTamano();
    void mostrarHistorial();
}
