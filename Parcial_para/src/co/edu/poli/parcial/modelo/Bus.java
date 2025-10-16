package co.edu.poli.parcial.modelo;

/**
 * Representa un vehículo de tipo Bus que hereda de Vehiculo.
 * Incluye información específica sobre el número de pasajeros.
 * 
 * @author Sarah Chaves
 * @version 1.0
 */
public class Bus extends Vehiculo {
    private int numPasajeros;
    
    /**
     * Constructor para crear un objeto Bus.
     * 
     * @param placa Placa del bus
     * @param marca Marca del bus
     * @param modelo Modelo del bus
     * @param capacidadCarga Capacidad de carga en kg
     * @param conductor Conductor asignado al bus
     * @param numPasajeros Número máximo de pasajeros
     */
    public Bus(String placa, String marca, String modelo, double capacidadCarga, 
               Conductor conductor, int numPasajeros) {
        super(placa, marca, modelo, capacidadCarga, conductor);
        this.numPasajeros = numPasajeros;
    }
    
    /**
     * Obtiene el número de pasajeros del bus.
     * 
     * @return Número de pasajeros
     */
    public int getNumPasajeros() {
        return numPasajeros;
    }
    
    /**
     * Establece el número de pasajeros del bus.
     * 
     * @param numPasajeros Número de pasajeros
     */
    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
    
    /**
     * Devuelve una representación en String de la información del bus.
     * 
     * @return String con toda la información del bus
     */
    @Override
    public String mostrarInfo() {
        return "Bus[Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Modelo: " + getModelo() + 
               ", Capacidad Carga: " + getCapacidadCarga() + ", Conductor: " + getConductor().getNombre() + 
               ", Num Pasajeros: " + numPasajeros + "]";
    }
}