package BusquedaProductos;

public interface IArbolAVL_Stock {
    void insertar(Producto producto);
    void eliminar(Producto producto);
    void modificarStock(Producto producto, int nuevoStock);
    void mostrarStock();
    Producto obtenerMinStock();
    Producto obtenerMaxStock();
}
