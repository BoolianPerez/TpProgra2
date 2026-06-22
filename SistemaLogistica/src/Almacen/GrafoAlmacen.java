package Almacen;

public class GrafoAlmacen {
    private ListaConexiones conexiones;


    public GrafoAlmacen() {
        this.conexiones = new ListaConexiones();
    }

    public void insertarConexion(int idConexion) {
        if (existeConexion(idConexion)) {
            return;
        }
        Conexion nueva = new Conexion(idConexion);
        conexiones.insertar(nueva);
    }

    public void insertarPasillo(int idOrigen, int idDestino, int idPasillo, String desc, String tipo, int distancia) {
        insertarConexion(idOrigen);
        insertarConexion(idDestino);

        if (existePasillo(idOrigen, idDestino)) {
            return;
        }

        Conexion origen = buscarConexion(idOrigen);
        Conexion destino = buscarConexion(idDestino);

        if (origen != null && destino != null) {
            Pasillo nuevoPasillo = new Pasillo(idPasillo, desc, tipo, distancia, destino);
            origen.getAdyacentes().insertar(nuevoPasillo);

            Pasillo pasilloVuelta = new Pasillo(idPasillo, desc, tipo, distancia, origen);
            destino.getAdyacentes().insertar(pasilloVuelta);
        }
    }

    public boolean existeConexion(int idConexion) {
        return buscarConexion(idConexion) != null;
    }

    public Conexion buscarConexion(int idConexion) {
        NodoConexion aux = conexiones.primero;
        while (aux != null) {
            if (aux.conexion.getIdConexion() == idConexion) {
                return aux.conexion;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public boolean existePasillo(int idOrigen, int idDestino) {
        Conexion origen = buscarConexion(idOrigen);
        if (origen == null) {
            return false;
        }
        NodoPasillo aux = origen.getAdyacentes().primero;
        while (aux != null) {
            if (aux.pasillo.getDestino().getIdConexion() == idDestino) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    public void eliminarPasillo(int idOrigen, int idDestino) {
        quitarAdyacente(idOrigen, idDestino);
    }

    private void quitarAdyacente(int idOrigen, int idDestino) {
        Conexion origen = buscarConexion(idOrigen);
        if (origen != null) {
            origen.getAdyacentes().eliminarPorDestino(idDestino);
        }

        Conexion destino = buscarConexion(idDestino);
        if (destino != null) {
            destino.getAdyacentes().eliminarPorDestino(idOrigen);
        }
    }

    public void eliminarConexion(int idConexion) {
        if (conexiones.primero == null) {
            return;
        }

        NodoConexion actual = conexiones.primero;
        NodoConexion anterior = null;

        while (actual != null) {
            if (actual.conexion.getIdConexion() == idConexion) {
                if (anterior == null) {
                    conexiones.primero = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                eliminarReferencias(idConexion);
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    private void eliminarReferencias(int idConexionDestino) {
        NodoConexion aux = conexiones.primero;
        while (aux != null) {
            quitarAdyacente(aux.conexion.getIdConexion(), idConexionDestino);
            aux = aux.siguiente;
        }
    }

    public void mostrarGrafo() {
        NodoConexion aux = conexiones.primero;
        while (aux != null) {
            System.out.print("Conexión " + aux.conexion.getIdConexion() + " -> ");
            NodoPasillo ady = aux.conexion.getAdyacentes().primero;

            while (ady != null) {
                System.out.print("[Hacia: " + ady.pasillo.getDestino().getIdConexion() +
                        " | Dist: " + ady.pasillo.getDistancia() + "] ");
                ady = ady.siguiente;
            }
            System.out.println();
            aux = aux.siguiente;
        }

    }

    public Pasillo buscarPasilloPorId(int idPasillo) {
        NodoConexion aux = conexiones.primero;
        while (aux != null) {
            NodoPasillo nodoPasillo = aux.conexion.getAdyacentes().primero;
            while (nodoPasillo != null) {
                if (nodoPasillo.pasillo.getIdPasillo() == idPasillo) {
                    return nodoPasillo.pasillo;
                }
                nodoPasillo = nodoPasillo.siguiente;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public boolean existePasilloPorId(int idPasillo) {
        return buscarPasilloPorId(idPasillo) != null;
    }

    private void limpiarVisitados() {
        NodoConexion aux = conexiones.primero;
        while (aux != null) {
            aux.conexion.visitado = false;
            aux = aux.siguiente;
        }
    }

    public void recorridoDFS(int idInicio) {
        limpiarVisitados();
        Conexion inicio = buscarConexion(idInicio);

        if (inicio == null) {
            System.out.println("La conexión inicial no existe.");
            return;
        }

        System.out.println("Recorrido DFS:");
        dfsRecursivo(inicio);
        System.out.println();
    }

    private void dfsRecursivo(Conexion conexion) {
        conexion.visitado = true;
        System.out.print(conexion.getIdConexion() + " ");

        NodoPasillo ady = conexion.getAdyacentes().primero;
        while (ady != null) {
            Conexion vecino = ady.pasillo.getDestino();
            if (!vecino.visitado) {
                dfsRecursivo(vecino);
            }
            ady = ady.siguiente;
        }
    }

    public void recorridoBFS(int idInicio) {
        limpiarVisitados();
        Conexion inicio = buscarConexion(idInicio);

        if (inicio == null) {
            System.out.println("La conexión inicial no existe.");
            return;
        }

        ColaAlmacen cola = new ColaAlmacen();
        inicio.visitado = true;
        cola.encolar(inicio);

        System.out.println("Recorrido BFS:");

        while (!cola.estaVacia()) {
            Conexion actual = cola.desencolar();
            System.out.print(actual.getIdConexion() + " ");

            NodoPasillo ady = actual.getAdyacentes().primero;
            while (ady != null) {
                Conexion vecino = ady.pasillo.getDestino();
                if (!vecino.visitado) {
                    vecino.visitado = true;
                    cola.encolar(vecino);
                }
                ady = ady.siguiente;
            }
        }
        System.out.println();
    }
    
}
