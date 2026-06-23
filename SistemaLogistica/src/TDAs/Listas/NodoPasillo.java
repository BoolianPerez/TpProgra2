package TDAs.Listas;

import Modelos.Pasillo;

public class NodoPasillo {

    public Pasillo pasillo;
    public NodoPasillo siguiente;

    public NodoPasillo(Pasillo pasillo) {
        this.pasillo = pasillo;
        this.siguiente = null;
    }
}
