package Modelos;

import static Modelos.EstadoPasillo.OPERATIVO;

public class Pasillo {
    private int idPasillo;
    private String descripcion;
    private String tipoPasillo;
    private int distancia;
    private Conexion destino;
    private EstadoPasillo estado;


    public Pasillo(int idPasillo, String descripcion, String tipoPasillo, int distancia, Conexion destino) {
        this.idPasillo = idPasillo;
        this.descripcion = descripcion;
        this.tipoPasillo = tipoPasillo;
        this.distancia = distancia;
        this.destino = destino;
        this.estado = OPERATIVO;
    }

    public int getIdPasillo() {
        return idPasillo;
    }

    public void setIdPasillo(int idPasillo) {
        this.idPasillo = idPasillo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoPasillo() {
        return tipoPasillo;
    }

    public void setTipoPasillo(String tipoPasillo) {
        this.tipoPasillo = tipoPasillo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Conexion getDestino() {
        return destino;
    }

    public void setDestino(Conexion destino) {
        this.destino = destino;
    }

    public EstadoPasillo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPasillo estado) {
        this.estado = estado;
    }
}
