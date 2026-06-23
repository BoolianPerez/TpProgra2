package Interfaces;

import Modelos.Conexion;
import Modelos.Pasillo;

public interface IGrafoAlmacen {
    void insertarConexion(int idConexion);
    void insertarPasillo(int idOrigen, int idDestino, int idPasillo, String desc, String tipo, int distancia);
    boolean existeConexion(int idConexion);
    Conexion buscarConexion(int idConexion);
    boolean existePasillo(int idOrigen, int idDestino);
    void eliminarPasillo(int idOrigen, int idDestino);
    void eliminarConexion(int idConexion);
    void mostrarGrafo();
    Pasillo buscarPasilloPorId(int idPasillo);
    boolean existePasilloPorId(int idPasillo);
    void recorridoDFS(int idInicio);
    void recorridoBFS(int idInicio);
}