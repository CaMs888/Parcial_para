package co.edu.poli.parcial.modelo;

/**
 * Representa un vehículo de tipo Camión que hereda de Vehiculo.
 * Incluye información específica sobre el tipo de mercancía que transporta.
 * 
 * @author Sarah Chaves
 * @version 1.0
 */
public class Camion extends Vehiculo {
    private String tipoMercancia;
    
    /**
     * Constructor para crear un objeto Camión.
     * 
     * @param placa Placa del camión
     * @param marca Marca del camión
     * @param modelo Modelo del camión
     * @param capacidadCarga Capacidad de carga en kg
     * @param conductor Conductor asignado al camión
     * @param tipoMercancia Tipo de mercancía (LIGERA, PESADA, PERECEDERA)
     */
    public Camion(String placa, String marca, String modelo, double capacidadCarga, 
                  Conductor conductor, String tipoMercancia) {
        super(placa, marca, modelo, capacidadCarga, conductor);
        this.tipoMercancia = tipoMercancia;
    }
    
    /**
     * Obtiene el tipo de mercancía del camión.
     * 
     * @return Tipo de mercancía
     */
    public String getTipoMercancia() {
        return tipoMercancia;
    }
    
    /**
     * Establece el tipo de mercancía del camión.
     * 
     * @param tipoMercancia Tipo de mercancía
     */
    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }
    
    /**
     * Devuelve una representación en String de la información del camión.
     * 
     * @return String con toda la información del camión
     */
    @Override
    public String mostrarInfo() {
        return "Camion[Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Modelo: " + getModelo() + 
               ", Capacidad Carga: " + getCapacidadCarga() + ", Conductor: " + getConductor().getNombre() + 
               ", Tipo Mercancia: " + tipoMercancia + "]";
    }
}