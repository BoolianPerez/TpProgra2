package TDAs.Listas;

import Modelos.Pasillo;
import Interfaces.IListaPasillos;

public class ListaPasillos implements IListaPasillos {
    public NodoPasillo primero;

    public ListaPasillos() {
        primero = null;
    }

    @Override
    public void insertar(Pasillo pasillo) {
        NodoPasillo nuevo = new NodoPasillo(pasillo);
        if (primero == null) {
            primero = nuevo;
        } else {
            NodoPasillo aux = primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    @Override
    public void eliminarPorDestino(int idDestino) {
        if (primero == null) {
            return;
        }

        if (primero.pasillo.getDestino().getIdConexion() == idDestino) {
            primero = primero.siguiente;
            return;
        }

        NodoPasillo actual = primero;
        NodoPasillo anterior = null;

        while (actual != null && actual.pasillo.getDestino().getIdConexion() != idDestino) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            anterior.siguiente = actual.siguiente;
        }
    }
}
