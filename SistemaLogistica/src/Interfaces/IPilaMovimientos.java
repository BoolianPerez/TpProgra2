package Interfaces;

import Modelos.Movimiento;
import TDAs.Pila.NodoMovimiento;

public interface IPilaMovimientos {
    NodoMovimiento getTope();
    void registrarMovimiento(Movimiento movimiento);
    Movimiento deshacerUltimoMovimiento();
    Movimiento verTope();
    boolean estaVacia();
    int tamaño();
    void mostrarMovimientos();
}