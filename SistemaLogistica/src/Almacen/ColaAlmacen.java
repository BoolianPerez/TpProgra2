package Almacen;

public class ColaAlmacen {
    private NodoCola frente;
    private NodoCola fin;

    public ColaAlmacen() {
        this.frente = null;
        this.fin = null;
    }



        public void encolar(Conexion conexion) {
            NodoCola nuevo = new NodoCola(conexion);
            if (estaVacia()) {
                frente = nuevo;
                fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
        }

        public Conexion desencolar() {
            if (estaVacia()) {
                return null;
            }
            Conexion conexion = frente.conexion;
            frente = frente.siguiente;
            if (frente == null) {
                fin = null;
            }
            return conexion;
        }

        public boolean estaVacia() {
            return frente == null;
        }

}
