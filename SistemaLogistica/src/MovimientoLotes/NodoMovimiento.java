package MovimientoLotes;

public class NodoMovimiento {

    public Movimiento movimiento;
    public NodoMovimiento siguiente;
    public NodoMovimiento anterior;

    public NodoMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
        this.siguiente = null;
        this.anterior = null;
    }
}
