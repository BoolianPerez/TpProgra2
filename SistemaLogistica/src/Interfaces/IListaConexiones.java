package Interfaces;

import Modelos.Conexion;

public interface IListaConexiones {
    void insertar(Conexion conexion);
    void eliminarPorId(int idConexion);
}