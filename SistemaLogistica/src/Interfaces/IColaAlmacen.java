package Interfaces;

import Modelos.Conexion;

public interface IColaAlmacen {
    void encolar(Conexion conexion);
    Conexion desencolar();
    boolean estaVacia();
}