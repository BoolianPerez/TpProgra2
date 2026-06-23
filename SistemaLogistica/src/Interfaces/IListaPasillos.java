package Interfaces;

import Modelos.Pasillo;

public interface IListaPasillos {
    void insertar(Pasillo pasillo);
    void eliminarPorDestino(int idDestino);
}