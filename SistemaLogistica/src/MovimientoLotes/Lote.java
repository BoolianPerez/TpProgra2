package MovimientoLotes;

import Almacen.Producto;

import java.util.Date;

public class Lote {
    private int idLote;
    private Date fecha;
    private Producto producto;
    private int cantidad;
    private Ubicacion ubicacion;

    public Lote(int idLote, Date fecha, Producto producto, int cantidad, Ubicacion ubicacion) {
        this.idLote = idLote;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
