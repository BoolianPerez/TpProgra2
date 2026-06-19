package Pedidos;

public class Pedido {
    private int idPedido;
    private String cliente;
    private ListaProductos productos;

    public Pedido(int idPedido, String cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.productos = new ListaProductos();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public ListaProductos getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.agregarProducto(producto);
    }

    @Override
    public String toString() {
        return "Pedido #" + idPedido + " - Cliente: " + cliente;
    }
}