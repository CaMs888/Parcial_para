package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.modelo.Vehiculo;

public interface OperacionCRUD {
    boolean crear(Vehiculo vehiculo);
    boolean eliminar(String placa);
    boolean actualizar(Vehiculo vehiculo);
    Vehiculo leer(String placa);
}
