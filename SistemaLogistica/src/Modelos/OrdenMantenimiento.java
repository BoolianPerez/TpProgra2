package Modelos;

import java.time.LocalDate;

public class OrdenMantenimiento {
    private int idOrden;
    private int idPasillo;
    private String descripcion;
    private PrioridadMantenimiento prioridad;
    private LocalDate fecha;

    public OrdenMantenimiento(int idOrden, int idPasillo, String descripcion, PrioridadMantenimiento prioridad) {
        this.idOrden = idOrden;
        this.idPasillo = idPasillo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fecha = LocalDate.now();
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
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

    public PrioridadMantenimiento getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadMantenimiento prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
