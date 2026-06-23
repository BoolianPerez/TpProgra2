package TDAs.Colas;

import Modelos.Conexion;
import Interfaces.IColaAlmacen;

public class ColaAlmacen implements IColaAlmacen {
    private NodoColaAlmacen frente;
    private NodoColaAlmacen fin;

    public ColaAlmacen() {
        this.frente = null;
        this.fin = null;
    }

    @Override
    public void encolar(Conexion conexion) {
        NodoColaAlmacen nuevo = new NodoColaAlmacen(conexion);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    @Override
    public Conexion desencolar() {
        if (estaVacia()) {
            return null;
        }
        Conexion conexion = frente.conexion;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return conexion;
    }

    @Override
    public boolean estaVacia() {
            return frente == null;
        }

}
