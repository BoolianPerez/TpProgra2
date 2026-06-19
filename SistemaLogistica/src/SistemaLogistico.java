import Pedidos.*;

public class SistemaLogistico {
    public static void main(String[] args) {
        ColaDespacho cola = new ColaDespacho();

        Pedido pedido1 = new Pedido(1, "Cliente A");
        Pedido pedido2 = new Pedido(2, "Cliente B");

        Producto producto1 = new Producto(1, "Mouse gamer", "Mouse", 10);
        Producto producto2 = new Producto(2, "Teclado mecanico", "Teclado", 5);

        pedido1.agregarProducto(producto1);
        pedido2.agregarProducto(producto2);

        cola.encolar(pedido1);
        cola.encolar(pedido2);

        System.out.println("Pedidos en cola:");
        cola.mostrarPedidos();

        System.out.println("Pedido despachado:");
        System.out.println(cola.desencolar());

        System.out.println("Pedidos restantes:");
        cola.mostrarPedidos();
    }
}