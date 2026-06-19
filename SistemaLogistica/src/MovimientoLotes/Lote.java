package MovimientoLotes;

import BusquedaProductos.Producto;

import java.util.Date;

public class Lote {
    private int idLote;
    private Date fechaIngreso;
    private Producto producto;
    private int cantidad;
    private Ubicacion ubicacion;

    public Lote(int idLote, Date fechaIngreso, Producto producto, int cantidad, Ubicacion ubicacion) {
        this.idLote = idLote;
        this.fechaIngreso = fechaIngreso;
        this.producto = producto;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
