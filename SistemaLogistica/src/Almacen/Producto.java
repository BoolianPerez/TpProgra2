<<<<<<<< HEAD:SistemaLogistica/src/Almacen/Producto.java
package Almacen;
========
package Pedidos;
>>>>>>>> d933dd533160e33fdf3ff185852b3139f0d77134:SistemaLogistica/src/Pedidos/Producto.java

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
}
