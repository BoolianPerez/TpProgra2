package Modelos;

import java.util.Date;

public class Movimiento {
    private int idMovimiento;
    private Date fecha;
    private String tipo;
    private Lote lote;
    private int cantidad;


    public Movimiento(int idMovimiento, Date fecha, String tipo, Lote lote, int cantidad) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.tipo = tipo;
        this.lote = lote;
        this.cantidad = cantidad;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
