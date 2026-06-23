package TDAs.Colas;

import Modelos.Conexion;

public class ColaAlmacen {
    private NodoColaAlmacen frente;
    private NodoColaAlmacen fin;

    public ColaAlmacen() {
        this.frente = null;
        this.fin = null;
    }

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

    public boolean estaVacia() {
            return frente == null;
        }

}
