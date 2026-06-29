package Interfaces;

import Modelos.OrdenMantenimiento;

public interface IColaPrioridadMantenimiento {
    boolean estaVacia();
    void encolarOrden(OrdenMantenimiento orden);
    OrdenMantenimiento desencolarOrden();
    OrdenMantenimiento verFrente();
    int getTamano();
    void mostrarOrdenes();
}
