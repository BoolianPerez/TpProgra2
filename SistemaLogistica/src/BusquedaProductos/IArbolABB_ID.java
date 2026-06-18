package BusquedaProductos;

public interface IArbolABB_ID {
    void insertar(Producto producto);
    Producto buscar(int idProducto);
    void mostrarInOrden();
    void eliminarProducto(int idProducto);
}
