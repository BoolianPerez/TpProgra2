package Main;

import Modelos.*;
import TDAs.Colas.ColaDespacho;
import TDAs.Grafo.GrafoAlmacen;
import TDAs.Arboles.ArbolAVL_Stock;
import TDAs.Arboles.ArbolProductos;
import TDAs.Listas.ListaProductos;
import TDAs.Listas.NodoProducto;
import TDAs.Pila.PilaMovimientos;

import java.util.Scanner;
import java.util.Date;

public class SistemaLogistico {
    private GrafoAlmacen almacen;
    private ArbolAVL_Stock stock;
    private ArbolProductos productos;
    private PilaMovimientos movimientos;
    private ColaDespacho colaDespacho;
    private Scanner scanner;

    public SistemaLogistico() {
        almacen = new GrafoAlmacen();
        stock = new ArbolAVL_Stock();
        productos = new ArbolProductos();
        movimientos = new PilaMovimientos();
        colaDespacho = new ColaDespacho();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n==================================================================");
            System.out.println("       SISTEMA INTEGRADO DE GESTIÓN LOGÍSTICA Y DISTRIBUCIÓN     ");
            System.out.println("==================================================================");
            System.out.println("1. Gestión de Almacén (Grafo)");
            System.out.println("2. Gestión Integrada de Productos y Stock (ABB + AVL Sincronizados)");
            System.out.println("3. Cola de Despacho");
            System.out.println("4. Pila de Movimientos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerInt();
            
            switch (opcion) {
                case 1:
                    menuAlmacen();
                    break;
                case 2:
                    menuStock();
                    break;
                case 3:
                    menuDespacho();
                    break;
                case 4:
                    menuMovimientos();
                    break;
                case 5:
                    salir = true;
                    System.out.println("\nSistema finalizado. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void menuAlmacen() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIÓN DE ALMACÉN (GRAFO) ---");
            System.out.println("1. Insertar conexión");
            System.out.println("2. Insertar pasillo");
            System.out.println("3. Verificar si existe conexión");
            System.out.println("4. Verificar si existe pasillo");
            System.out.println("5. Buscar pasillo por ID");
            System.out.println("6. Recorrido BFS");
            System.out.println("7. Recorrido DFS");
            System.out.println("8. Mostrar grafo completo");
            System.out.println("9. Eliminar pasillo");
            System.out.println("10. Eliminar conexión");
            System.out.println("11. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("ID Conexión a insertar: ");
                    int idConexionIns = leerInt();
                    almacen.insertarConexion(idConexionIns);
                    System.out.println("Conexión insertada correctamente.");
                    break;
                case 2:
                    System.out.print("ID Origen: ");
                    int idOrigen = leerInt();
                    System.out.print("ID Destino: ");
                    int idDestino = leerInt();
                    System.out.print("ID Pasillo: ");
                    int idPasillo = leerInt();
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Distancia: ");
                    int distancia = leerInt();
                    almacen.insertarPasillo(idOrigen, idDestino, idPasillo, desc, tipo, distancia);
                    System.out.println("Pasillo insertado correctamente.");
                    break;
                case 3:
                    System.out.print("ID Conexión: ");
                    int idConexion = leerInt();
                    boolean existe = almacen.existeConexion(idConexion);
                    System.out.println("¿Existe conexión " + idConexion + "?: " + (existe ? "Sí" : "No"));
                    break;
                case 4:
                    System.out.print("ID Origen: ");
                    int id1 = leerInt();
                    System.out.print("ID Destino: ");
                    int id2 = leerInt();
                    boolean existePasillo = almacen.existePasillo(id1, id2);
                    System.out.println("¿Existe pasillo " + id1 + "->" + id2 + "?: " + (existePasillo ? "Sí" : "No"));
                    break;
                case 5:
                    System.out.print("ID Pasillo a buscar: ");
                    int idBusPasillo = leerInt();
                    Pasillo pasilloEncontrado = almacen.buscarPasilloPorId(idBusPasillo);
                    if (pasilloEncontrado != null) {
                        System.out.println("Pasillo encontrado: " + pasilloEncontrado.getDescripcion() +
                                         " | Distancia: " + pasilloEncontrado.getDistancia());
                    } else {
                        System.out.println("Pasillo no encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("ID Inicio para BFS: ");
                    int inicioBFS = leerInt();
                    System.out.println("Recorrido BFS desde " + inicioBFS + ":");
                    almacen.recorridoBFS(inicioBFS);
                    break;
                case 7:
                    System.out.print("ID Inicio para DFS: ");
                    int inicioDFS = leerInt();
                    System.out.println("Recorrido DFS desde " + inicioDFS + ":");
                    almacen.recorridoDFS(inicioDFS);
                    break;
                case 8:
                    System.out.println("\nGrafo Completo:");
                    almacen.mostrarGrafo();
                    break;
                case 9:
                    System.out.print("ID Origen: ");
                    int id3 = leerInt();
                    System.out.print("ID Destino: ");
                    int id4 = leerInt();
                    almacen.eliminarPasillo(id3, id4);
                    System.out.println("Pasillo eliminado.");
                    break;
                case 10:
                    System.out.print("ID Conexión a eliminar: ");
                    int idElim = leerInt();
                    almacen.eliminarConexion(idElim);
                    System.out.println("Conexión eliminada.");
                    break;
                case 11:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void menuStock() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIÓN INTEGRADA DE PRODUCTOS Y STOCK ---");
            System.out.println("(ABB por ID + AVL por Stock - Sincronizados)");
            System.out.println("1. Insertar producto (en ambos árboles)");
            System.out.println("2. Buscar producto por ID");
            System.out.println("3. Actualizar stock de producto");
            System.out.println("4. Eliminar producto (de ambos árboles)");
            System.out.println("5. Mostrar catálogo (ABB - Ordenado por ID)");
            System.out.println("6. Mostrar productos (AVL - Ordenado por Stock)");
            System.out.println("7. Buscar productos con stock menor que un umbral");
            System.out.println("8. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerInt();
            
            switch (opcion) {
                case 1:
                    insertarProducto();
                    break;
                case 2:
                    System.out.print("ID Producto a buscar: ");
                    int idBusProd = leerInt();
                    Producto prodEncontrado = productos.buscar(idBusProd);
                    if (prodEncontrado != null) {
                        System.out.println("Producto: " + prodEncontrado.getNombre() + 
                                         " | Stock: " + prodEncontrado.getStockActual());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    actualizarStockProducto();
                    break;
                case 4:
                    eliminarProductoSincronizado();
                    break;
                case 5:
                    System.out.println("\nCatálogo de Productos (ABB - Ordenado por ID):");
                    productos.mostrarInOrden();
                    break;
                case 6:
                    System.out.println("\nProductos (AVL - Ordenado por Stock):");
                    stock.mostrarStock();
                    break;
                case 7:
                    System.out.print("Nivel de stock umbral (mostrar productos con stock < umbral): ");
                    int umbral = leerInt();
                    if (umbral >= 0) {
                        System.out.println("\nProductos con stock menor a " + umbral + ":");
                        stock.listarProductosConStockMenorQue(umbral);
                    } else {
                        System.out.println("Umbral inválido.");
                    }
                    break;
                case 8:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }



    private void actualizarStockProducto() {
        System.out.print("ID Producto: ");
        int idProd = leerInt();
        
        Producto prodEncontrado = productos.buscar(idProd);
        
        if (prodEncontrado != null) {
            System.out.println("Stock actual: " + prodEncontrado.getStockActual());
            System.out.print("Nuevo stock: ");
            int nuevoStock = leerInt();

            int stockAnterior = prodEncontrado.getStockActual();

            Producto temp = new Producto(prodEncontrado.getId(), prodEncontrado.getDescripcion(), prodEncontrado.getNombre(), stockAnterior);
            stock.eliminar(temp);

            prodEncontrado.setStockActual(nuevoStock);
            stock.insertar(prodEncontrado);

            System.out.println("Stock actualizado en ambos árboles (ABB y AVL sincronizados)");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void eliminarProductoSincronizado() {
        System.out.print("ID Producto a eliminar: ");
        int idElimProd = leerInt();
        
        Producto prodEncontrado = productos.buscar(idElimProd);
        
        if (prodEncontrado != null) {
            productos.eliminarProducto(idElimProd);
            stock.eliminar(prodEncontrado);
            System.out.println("Producto eliminado de ambos árboles.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private void insertarProducto() {
        System.out.print("ID Producto: ");
        int idProd = leerInt();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Stock Inicial: ");
        int stockProd = leerInt();
        
        Producto prod = new Producto(idProd, nombre, descripcion, stockProd);

        productos.insertar(prod);

        stock.insertar(prod);
        
        System.out.println("Producto insertado en ABB (indexado por ID)");
        System.out.println("Producto indexado en AVL (por Stock - balanceado automáticamente)");
    }

    private void menuDespacho() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- COLA DE DESPACHO ---");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Despachar pedido");
            System.out.println("3. Ver primer pedido");
            System.out.println("4. Mostrar todos los pedidos");
            System.out.println("5. Cantidad de pedidos");
            System.out.println("6. ¿Está vacía?");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerInt();
            
            switch (opcion) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    Pedido pedidoSaliente = colaDespacho.despacharPedido();
                    if (pedidoSaliente != null) {
                        ListaProductos lista = pedidoSaliente.getProductos();
                        NodoProducto nodo = lista.getPrimero();
                        while (nodo != null) {
                            Producto prod = nodo.getProducto();
                            int stockAnterior = prod.getStockActual();
                            int nuevoStock = Math.max(0, stockAnterior - 1);

                            Producto temp = new Producto(prod.getId(), prod.getDescripcion(), prod.getNombre(), stockAnterior);
                            stock.eliminar(temp);

                            prod.setStockActual(nuevoStock);

                            stock.insertar(prod);

                            nodo = nodo.getSiguiente();
                        }

                        System.out.println("Pedido despachado: " + pedidoSaliente);
                    } else {
                        System.out.println("No hay pedidos para despachar.");
                    }
                    break;
                case 3:
                    Pedido primero = colaDespacho.verPrimero();
                    if (primero != null) {
                        System.out.println("Primer pedido: " + primero);
                    } else {
                        System.out.println("Cola vacía.");
                    }
                    break;
                case 4:
                    System.out.println("\nPedidos en cola:");
                    colaDespacho.mostrarPedidos();
                    break;
                case 5:
                    System.out.println("Cantidad de pedidos: " + colaDespacho.getCantidad());
                    break;
                case 6:
                    System.out.println("¿Cola vacía?: " + (colaDespacho.estaVacia() ? "Sí" : "No"));
                    break;
                case 7:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void registrarPedido() {
        System.out.print("ID Pedido: ");
        int idPed = leerInt();
        System.out.print("Cliente: ");
        String cliente = scanner.nextLine();
        
        Pedido pedido = new Pedido(idPed, cliente);
        
        System.out.print("¿Desea agregar productos? (s/n): ");
        String respuesta = scanner.nextLine();
        
        if (respuesta.equalsIgnoreCase("s")) {
            boolean agregarMas = true;
            while (agregarMas) {
                System.out.print("ID Producto a agregar: ");
                int idProd = leerInt();
                
                Producto prodEncontrado = productos.buscar(idProd);
                if (prodEncontrado != null) {
                    pedido.agregarProducto(prodEncontrado);
                    System.out.println("Producto agregado: " + prodEncontrado.getNombre());
                } else {
                    System.out.println("Producto no encontrado.");
                }
                
                System.out.print("¿Agregar otro producto? (s/n): ");
                agregarMas = scanner.nextLine().equalsIgnoreCase("s");
            }
        }
        
        colaDespacho.registrarPedido(pedido);
        System.out.println("Pedido encolado correctamente.");
    }

    private void menuMovimientos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- PILA DE MOVIMIENTOS ---");
            System.out.println("1. Registrar movimiento");
            System.out.println("2. Deshacer último movimiento");
            System.out.println("3. Ver tope");
            System.out.println("4. Mostrar movimientos");
            System.out.println("5. Tamaño de pila");
            System.out.println("6. ¿Está vacía?");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerInt();
            
            switch (opcion) {
                case 1:
                    registrarMovimiento();
                    break;
                case 2:
                    Movimiento movExtraido = movimientos.deshacerUltimoMovimiento();
                    if (movExtraido != null) {
                        System.out.println("Movimiento extraído ID: " + movExtraido.getIdMovimiento());
                    } else {
                        System.out.println("Pila vacía.");
                    }
                    break;
                case 3:
                    Movimiento tope = movimientos.verTope();
                    if (tope != null) {
                        System.out.println("Tope: ID=" + tope.getIdMovimiento() + 
                                         ", Tipo=" + tope.getTipo() + 
                                         ", Cantidad=" + tope.getCantidad());
                    } else {
                        System.out.println("Pila vacía.");
                    }
                    break;
                case 4:
                    System.out.println("\nMovimientos en pila:");
                    movimientos.mostrarMovimientos();
                    break;
                case 5:
                    System.out.println("Tamaño de pila: " + movimientos.tamaño());
                    break;
                case 6:
                    System.out.println("¿Pila vacía?: " + (movimientos.estaVacia() ? "Sí" : "No"));
                    break;
                case 7:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void registrarMovimiento() {
        System.out.print("ID Movimiento: ");
        int idMov = leerInt();
        System.out.print("Tipo (Entrada/Salida): ");
        String tipo = scanner.nextLine();
        System.out.print("ID Producto: ");
        int idProd = leerInt();
        System.out.print("Cantidad: ");
        int cantMov = leerInt();
        System.out.print("Pasillo: ");
        int pasillo = leerInt();
        Pasillo p = almacen.buscarPasilloPorId(pasillo);
        System.out.print("Estantería: ");
        int estante = leerInt();
        System.out.println("Nivel: ");
        int nivel = leerInt();

        Producto prodEncontrado = productos.buscar(idProd);
        
        if (prodEncontrado != null) {
            Ubicacion ubicacion = new Ubicacion(p, estante, nivel);
            Lote lote = new Lote(
                idMov, new Date(), prodEncontrado, cantMov, ubicacion);
            
            Movimiento movimiento = new Movimiento(
                idMov, new Date(), tipo, lote, cantMov);
            
            movimientos.registrarMovimiento(movimiento);
            System.out.println("Movimiento agregado con producto: " + prodEncontrado.getNombre());
        } else {
            System.out.println("Producto con ID " + idProd + " no encontrado.");
        }
    }

    private int leerInt() {
        try {
            int valor = Integer.parseInt(scanner.nextLine());
            return valor;
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor ingrese un número.");
            return -1;
        }
    }

    public GrafoAlmacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(GrafoAlmacen almacen) {
        this.almacen = almacen;
    }

    public ArbolAVL_Stock getStock() {
        return stock;
    }

    public void setStock(ArbolAVL_Stock stock) {
        this.stock = stock;
    }

    public ArbolProductos getProductos() {
        return productos;
    }

    public void setProductos(ArbolProductos productos) {
        this.productos = productos;
    }

    public PilaMovimientos getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(PilaMovimientos movimientos) {
        this.movimientos = movimientos;
    }

    public ColaDespacho getColaDespacho() {
        return colaDespacho;
    }

    public void setColaDespacho(ColaDespacho colaDespacho) {
        this.colaDespacho = colaDespacho;
    }

    public static void main(String[] args) {
        SistemaLogistico sistema = new SistemaLogistico();
        sistema.mostrarMenuPrincipal();
    }
}