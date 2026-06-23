package TDAs.Listas;

import Modelos.Conexion;
import Interfaces.IListaConexiones;

public class ListaConexiones implements IListaConexiones {
    public NodoConexion primero;

    public ListaConexiones() {
        this.primero = null;
    }

    @Override
    public void insertar(Conexion conexion) {
        NodoConexion nuevo = new NodoConexion(conexion);
        if (primero == null) {
            primero = nuevo;
        } else {
            NodoConexion aux = primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    @Override
    public void eliminarPorId(int idConexion) {
        if (primero == null) {
            return;
        }

        if (primero.conexion.getIdConexion() == idConexion) {
            primero = primero.siguiente;
            return;
        }

        NodoConexion actual = primero;
        NodoConexion anterior = null;

        while (actual != null && actual.conexion.getIdConexion() != idConexion) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            anterior.siguiente = actual.siguiente;
        }
    }
}
