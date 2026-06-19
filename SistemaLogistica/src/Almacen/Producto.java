package Almacen;
public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private int stockActual;

    public Producto(int id, String descripcion, String nombre, int stockActual) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.stockActual = stockActual;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getStockActual() { return stockActual; }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
}
