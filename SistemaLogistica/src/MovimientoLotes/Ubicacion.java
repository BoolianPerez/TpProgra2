package MovimientoLotes;

import Almacen.Pasillo;

public class Ubicacion {

    private Pasillo pasillo;
    private int estanteria;
    private int nivel;

    public Ubicacion(Pasillo pasillo, int estanteria, int nivel) {
        this.pasillo = pasillo;
        this.estanteria = estanteria;
        this.nivel = nivel;
    }

    public Pasillo getPasillo() {
        return pasillo;
    }

    public void setPasillo(Pasillo pasillo) {
        this.pasillo = pasillo;
    }

    public int getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(int estanteria) {
        this.estanteria = estanteria;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
