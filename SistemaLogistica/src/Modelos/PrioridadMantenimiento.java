package Modelos;

public enum PrioridadMantenimiento {
    CRITICA(4),
    ALTA(3),
    MEDIA(2),
    BAJA(1);

    private int valor;
    PrioridadMantenimiento(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
