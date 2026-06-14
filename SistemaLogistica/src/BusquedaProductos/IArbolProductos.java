package BusquedaProductos;

public interface IArbolProductos {
    void insertar(Producto producto);
    Producto buscar(int idProducto);
    void mostrarInOrden();
    void eliminarProducto(int idProducto);
}
