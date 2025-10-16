package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.modelo.Vehiculo;

/**
 * Interfaz que define las operaciones CRUD básicas para la gestión de vehículos.
 * 
 * @author Sarah Chaves
 * @version 1.0
 */
public interface OperacionCRUD {
    /**
     * Crea un nuevo vehículo en el sistema.
     * 
     * @param vehiculo Vehículo a crear
     * @return true si se creó exitosamente, false en caso contrario
     */
    boolean crear(Vehiculo vehiculo);
    
    /**
     * Elimina un vehículo del sistema por su placa.
     * 
     * @param placa Placa del vehículo a eliminar
     * @return true si se eliminó exitosamente, false en caso contrario
     */
    boolean eliminar(String placa);
    
    /**
     * Actualiza la información de un vehículo existente.
     * 
     * @param vehiculo Vehículo con la información actualizada
     * @return true si se actualizó exitosamente, false en caso contrario
     */
    boolean actualizar(Vehiculo vehiculo);
    
    /**
     * Busca y devuelve un vehículo por su placa.
     * 
     * @param placa Placa del vehículo a buscar
     * @return El vehículo encontrado o null si no existe
     */
    Vehiculo leer(String placa);
    
    /**
     * Obtiene todos los vehículos registrados en el sistema.
     * 
     * @return Array con todos los vehículos
     */
    Vehiculo[] leerTodos();
    
    /**
     * Guarda los vehículos en un archivo mediante serialización.
     * 
     * @return true si se serializó exitosamente, false en caso contrario
     */
    boolean serializar();
    
    /**
     * Carga los vehículos desde un archivo mediante deserialización.
     * 
     * @return true si se deserializó exitosamente, false en caso contrario
     */
    boolean deserializar();
}