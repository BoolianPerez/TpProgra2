package Modelos;

import TDAs.Listas.ListaPasillos;

public class Conexion {
    private int idConexion;
    private ListaPasillos adyacentes;
    public boolean visitado;

    public Conexion(int idConexion) {
        this.idConexion = idConexion;
        this.adyacentes = new ListaPasillos();
        this.visitado = false;
    }

    public int getIdConexion() {
        return idConexion;
    }

    public void setIdConexion(int idConexion) {
        this.idConexion = idConexion;
    }

    public ListaPasillos getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(ListaPasillos adyacentes) {
        this.adyacentes = adyacentes;
    }
}
