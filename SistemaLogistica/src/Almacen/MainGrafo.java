package Almacen;

public class MainGrafo {
    public static void main(String[] args) {

        GrafoAlmacen almacen = new GrafoAlmacen();

        System.out.println("--- ARMANDO EL ALMACÉN (GRILLA 3x3) ---");

        for (int i = 1; i <= 9; i++) {
            almacen.insertarConexion(i);
        }

        almacen.insertarPasillo(1, 2, 101, "Fila 1 - Izq", "Horizontal", 10);
        almacen.insertarPasillo(2, 3, 102, "Fila 1 - Der", "Horizontal", 10);
        almacen.insertarPasillo(4, 5, 103, "Fila 2 - Izq", "Horizontal", 10);
        almacen.insertarPasillo(5, 6, 104, "Fila 2 - Der", "Horizontal", 10);
        almacen.insertarPasillo(7, 8, 105, "Fila 3 - Izq", "Horizontal", 10);
        almacen.insertarPasillo(8, 9, 106, "Fila 3 - Der", "Horizontal", 10);

        almacen.insertarPasillo(1, 4, 201, "Columna 1 - Arriba", "Vertical", 15);
        almacen.insertarPasillo(4, 7, 202, "Columna 1 - Abajo", "Vertical", 15);
        almacen.insertarPasillo(2, 5, 203, "Columna 2 - Arriba", "Vertical", 15);
        almacen.insertarPasillo(5, 8, 204, "Columna 2 - Abajo", "Vertical", 15);
        almacen.insertarPasillo(3, 6, 205, "Columna 3 - Arriba", "Vertical", 15);
        almacen.insertarPasillo(6, 9, 206, "Columna 3 - Abajo", "Vertical", 15);

        System.out.println("\n--- ESTADO DEL GRAFO ---");
        almacen.mostrarGrafo();

        System.out.println("\n--- RECORRIDO BFS (Búsqueda en Anchura desde 1) ---");
        almacen.recorridoBFS(1);

        System.out.println("\n--- RECORRIDO DFS (Búsqueda en Profundidad desde 1) ---");
        almacen.recorridoDFS(1);

        System.out.println("\n--- CORTANDO UN PASILLO ---");
        System.out.println("Eliminamos el pasillo horizontal central (5 a 6)");
        almacen.eliminarPasillo(5, 6);
        almacen.recorridoBFS(1);
    }

}
