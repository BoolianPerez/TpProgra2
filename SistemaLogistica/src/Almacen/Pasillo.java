package Almacen;

public class Pasillo {

    private int idPasillo;
    private String descripcion;

    public Pasillo(int idPasillo, String descripcion) {
        this.idPasillo = idPasillo;
        this.descripcion = descripcion;
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
}
