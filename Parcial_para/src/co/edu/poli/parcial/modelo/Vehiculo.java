package co.edu.poli.parcial.modelo;

/**
 * Clase base que representa un vehículo genérico en el sistema.
 * Contiene los atributos comunes a todos los vehículos.
 * 
 * @author Sarah Chaves
 * @version 1.0
 */
public class Vehiculo implements java.io.Serializable {
    private String placa;
    private String marca;
    private String modelo;
    private double capacidadCarga;
    private Conductor conductor;
    
    /**
     * Constructor para crear un objeto Vehiculo.
     * 
     * @param placa Placa del vehículo
     * @param marca Marca del vehículo
     * @param modelo Modelo del vehículo
     * @param capacidadCarga Capacidad de carga en kg
     * @param conductor Conductor asignado al vehículo
     */
    public Vehiculo(String placa, String marca, String modelo, double capacidadCarga, Conductor conductor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadCarga = capacidadCarga;
        this.conductor = conductor;
    }
    
    /**
     * Obtiene la placa del vehículo.
     * 
     * @return Placa del vehículo
     */
    public String getPlaca() {
        return placa;
    }
    
    /**
     * Establece la placa del vehículo.
     * 
     * @param placa Placa del vehículo
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    /**
     * Obtiene la marca del vehículo.
     * 
     * @return Marca del vehículo
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Establece la marca del vehículo.
     * 
     * @param marca Marca del vehículo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Obtiene el modelo del vehículo.
     * 
     * @return Modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * Establece el modelo del vehículo.
     * 
     * @param modelo Modelo del vehículo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Obtiene la capacidad de carga del vehículo.
     * 
     * @return Capacidad de carga en kg
     */
    public double getCapacidadCarga() {
        return capacidadCarga;
    }
    
    /**
     * Establece la capacidad de carga del vehículo.
     * 
     * @param capacidadCarga Capacidad de carga en kg
     */
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    
    /**
     * Obtiene el conductor asignado al vehículo.
     * 
     * @return Conductor del vehículo
     */
    public Conductor getConductor() {
        return conductor;
    }
    
    /**
     * Establece el conductor asignado al vehículo.
     * 
     * @param conductor Conductor del vehículo
     */
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    
    /**
     * Devuelve una representación en String de la información básica del vehículo.
     * 
     * @return String con la información básica del vehículo
     */
    public String mostrarInfo() {
        return "Vehiculo[Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + 
               ", Capacidad Carga: " + capacidadCarga + ", Conductor: " + conductor.getNombre() + "]";
    }
}