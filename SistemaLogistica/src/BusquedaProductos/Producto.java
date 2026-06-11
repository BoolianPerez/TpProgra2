package BusquedaProductos;

public class Producto {
    private int id; // Este será el criterio de ordenamiento en el árbol
    private String nombre;
    private String descripcion;
    private int stockActual;

    public Producto(int id, String nombre, String descripcion, int stockActual) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stockActual = stockActual;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getStockActual() { return stockActual; }

    public void setStockActual(int stockActual) { this.stockActual = stockActual; }
}
