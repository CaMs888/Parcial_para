package co.edu.poli.parcial.modelo;

/**
 * Representa a un conductor que puede estar asignado a un vehículo.
 * 
 * @author Sarah Chaves
 * @version 1.0
 */
public class Conductor implements java.io.Serializable {
    private String id;
    private String nombre;
    private String licencia;
    
    /**
     * Constructor para crear un objeto Conductor.
     * 
     * @param id Identificador único del conductor
     * @param nombre Nombre completo del conductor
     * @param licencia Número de licencia de conducción
     */
    public Conductor(String id, String nombre, String licencia) {
        this.id = id;
        this.nombre = nombre;
        this.licencia = licencia;
    }
    
    /**
     * Obtiene el ID del conductor.
     * 
     * @return ID del conductor
     */
    public String getId() {
        return id;
    }
    
    /**
     * Establece el ID del conductor.
     * 
     * @param id ID del conductor
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtiene el nombre del conductor.
     * 
     * @return Nombre del conductor
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del conductor.
     * 
     * @param nombre Nombre del conductor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la licencia del conductor.
     * 
     * @return Número de licencia
     */
    public String getLicencia() {
        return licencia;
    }
    
    /**
     * Establece la licencia del conductor.
     * 
     * @param licencia Número de licencia
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
    
    /**
     * Devuelve una representación en String de la información del conductor.
     * 
     * @return String con toda la información del conductor
     */
    public String mostrarInfo() {
        return "Conductor[ID: " + id + ", Nombre: " + nombre + ", Licencia: " + licencia + "]";
    }
}