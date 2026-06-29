package TDAs.Colas;

import Modelos.OrdenMantenimiento;

public class NodoPrioridad {
    public OrdenMantenimiento orden;
    public NodoPrioridad siguiente;

    public NodoPrioridad(OrdenMantenimiento orden) {
        this.orden = orden;
        this.siguiente = null;
    }
}
