import Almacen.GrafoAlmacen;
import BusquedaProductos.ArbolProductos;
import BusquedaProductos.IArbolABB_ID;
import Pedidos.ColaDespacho;
import Pedidos.Pedido;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("   SISTEMA INTEGRADO DE GESTIÓN LOGÍSTICA Y DISTRIBUCIÓN         ");
        System.out.println("==================================================================\n");
        System.out.println(">>> FASE 1: INICIALIZANDO MAPA DE PASILLOS (GRILLA) <<<");
        GrafoAlmacen mapaAlmacen = new GrafoAlmacen();

        // Pasillos Horizontales (Filas 1, 2 y 3)
        mapaAlmacen.insertarPasillo(11, 12, 101, "Pasillo H F1-C1C2", "Herramientas Manuales", 5);
        mapaAlmacen.insertarPasillo(12, 13, 102, "Pasillo H F1-C2C3", "Herramientas Manuales", 5);
        mapaAlmacen.insertarPasillo(21, 22, 103, "Pasillo H F2-C1C2", "Herramientas Eléctricas", 5);
        mapaAlmacen.insertarPasillo(22, 23, 104, "Pasillo H F2-C2C3", "Herramientas Eléctricas", 5);
        mapaAlmacen.insertarPasillo(31, 32, 105, "Pasillo H F3-C1C2", "Insumos", 5);
        mapaAlmacen.insertarPasillo(32, 33, 106, "Pasillo H F3-C2C3", "Insumos", 5);

        // Pasillos Verticales (Columnas 1, 2 y 3)
        mapaAlmacen.insertarPasillo(11, 21, 201, "Pasillo V C1-F1F2", "Herramientas Eléctricas", 8);
        mapaAlmacen.insertarPasillo(21, 31, 202, "Pasillo V C1-F2F3", "Herramientas Eléctricas", 8);
        mapaAlmacen.insertarPasillo(12, 22, 203, "Pasillo V C2-F1F2", "Herramientas Manuales", 8);
        mapaAlmacen.insertarPasillo(22, 32, 204, "Pasillo V C2-F2F3", "Herramientas manuales", 8);
        mapaAlmacen.insertarPasillo(13, 23, 205, "Pasillo V C3-F1F2", "Insumos", 8);
        mapaAlmacen.insertarPasillo(23, 33, 206, "Pasillo V C3-F2F3", "Insumos", 8);

        System.out.println("Estructura física del almacén mapeada.");
        System.out.println("\n[Ruta Optimizada] Planificando recogida desde Esquina (11) usando BFS:");
        mapaAlmacen.recorridoBFS(11);
        System.out.println("------------------------------------------------------------------\n");
        System.out.println("\n[Ruta Profunda] Planificando exploración a fondo desde Esquina (11) usando DFS:");
        mapaAlmacen.recorridoDFS(11);
        System.out.println("------------------------------------------------------------------\n");

        // ======= Pruebas adicionales del Grafo ==================================
        System.out.println("\n[Pruebas Grafo] Mostrando grafo completo:");
        mapaAlmacen.mostrarGrafo();

        System.out.println("Existe conexión 11? " + mapaAlmacen.existeConexion(11));
        System.out.println("Existe pasillo 11->12? " + mapaAlmacen.existePasillo(11, 12));

        System.out.println("\n[Pruebas Grafo] Eliminando pasillo 11-12 y mostrando grafo:");
        mapaAlmacen.eliminarPasillo(11, 12);
        mapaAlmacen.mostrarGrafo();

        System.out.println("\n[Pruebas Grafo] Eliminando conexión 33 y mostrando grafo:");
        mapaAlmacen.eliminarConexion(33);
        mapaAlmacen.mostrarGrafo();
        System.out.println("------------------------------------------------------------------\n");



        // ==========================================================================
        // FASE 2: GESTIÓN DE STOCK EN ESTANTERÍAS (ÁRBOL DE BÚSQUEDA BINARIA - ABB)
        // ==========================================================================
        System.out.println(">>> FASE 2: LOCALIZACIÓN Y CONTROL DE STOCK (ÁRBOL ABB) <<<");
        IArbolABB_ID inventario = new ArbolProductos();

        // Ingresamos stock de mercadería al catálogo indexado (en desorden de ID)
        inventario.insertar(new Producto(50, "Caja de Herramientas", "Kit mecánico", 15));
        inventario.insertar(new Producto(20, "Taladro Inalámbrico", "Batería Litio 18V", 30));
        inventario.insertar(new Producto(75, "Set Destornilladores", "X6 piezas imantadas", 45));
        inventario.insertar(new Producto(10, "Amoladora Angular", "Disco de 4.5 pulgadas", 12));
        inventario.insertar(new Producto(60, "Soldadora Inverter", "Monofásica 160A", 8));

        System.out.println("Catálogo de productos ordenado en el Árbol:");
        inventario.mostrarInOrden();

        // Simulamos la búsqueda de un ítem para recolectar
        int idRequerido = 20;
        System.out.println("\nBuscando artículo ID " + idRequerido + " para preparar pedido...");
        Producto prodEncontrado = inventario.buscar(idRequerido);

        if (prodEncontrado != null) {
            System.out.println("¡Artículo localizado!: " + prodEncontrado.getNombre() + " | Stock actual: " + prodEncontrado.getStockActual());
            System.out.println("[Picking] Extrayendo 1 unidad del estante...");
            prodEncontrado.setStockActual(prodEncontrado.getStockActual() - 1);
            System.out.println("Nuevo stock disponible en sistema: " + prodEncontrado.getStockActual());
        }
        System.out.println("------------------------------------------------------------------\n");

        // ======= Pruebas adicionales del Árbol ==================================
        System.out.println("\n[Pruebas Árbol] Eliminando producto ID 60 y mostrando InOrden:");
        inventario.eliminarProducto(60);
        inventario.mostrarInOrden();
        Producto prodChequeo = inventario.buscar(60);
        System.out.println("Buscar ID 60 tras eliminación: " + (prodChequeo == null ? "No encontrado" : "Encontrado"));
        System.out.println("------------------------------------------------------------------\n");



        // ==========================================================================
        // FASE 3: PREPARACIÓN Y COLA DE DESPACHOS (LISTAS VINCULADAS Y COLAS)
        // ==========================================================================
        System.out.println(">>> FASE 3: ARMADO DE PEDIDOS Y LOGÍSTICA DE SALIDA (COLAS) <<<");

        // Creamos una instancia alternativa de Producto compatible con el constructor del paquete Pedidos
        // Nota: Pasamos los parámetros en el orden exacto de tu clase original (id, descripcion, nombre, stock)
        Pedidos.Producto prodParaPedido1 = new Pedidos.Producto(20, "Batería Litio 18V", "Taladro Inalámbrico", 29);
        Pedidos.Producto prodParaPedido2 = new Pedidos.Producto(60, "Monofásica 160A", "Soldadora Inverter", 8);

        // Generamos las solicitudes de los clientes
        Pedido pedido1 = new Pedido(1, "Distribuidora San Juan");
        pedido1.agregarProducto(prodParaPedido1);

        Pedido pedido2 = new Pedido(2, "Ferretería El Progreso");
        pedido2.agregarProducto(prodParaPedido2);

        // Inicializamos la cola de despacho de los camiones
        ColaDespacho rampaDeCarga = new ColaDespacho();
        System.out.println("¿Camiones en espera en la rampa?: " + (rampaDeCarga.estaVacia() ? "No" : "Sí"));

        System.out.println("\n[Logística] Encolando cargamentos prioritarios...");
        rampaDeCarga.encolar(pedido1);
        rampaDeCarga.encolar(pedido2);

        System.out.println("Cantidad de camiones listos en fila: " + rampaDeCarga.getCantidad());
        System.out.println("\n--- Manifiesto de Carga de la Cola ---");
        rampaDeCarga.mostrarPedidos();
        System.out.println("--------------------------------------");

        // Procesamiento de salida
        System.out.println("\nSiguiente envío autorizado a salir: " + rampaDeCarga.verPrimero());
        Pedido saliendo = rampaDeCarga.desencolar();
        System.out.println("Status: [EN RUTA] -> El " + saliendo + " ha salido del centro de distribución.");

        System.out.println("\nCamiones remanentes en rampa: " + rampaDeCarga.getCantidad());
        System.out.println("==================================================================");
        System.out.println("   SIMULACIÓN LOGÍSTICA FINALIZADA CON ÉXITO                     ");
        System.out.println("==================================================================");
    }
}
