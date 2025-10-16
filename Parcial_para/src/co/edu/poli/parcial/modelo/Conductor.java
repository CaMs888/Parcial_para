package co.edu.poli.parcial.modelo;

public class Conductor implements java.io.Serializable {
    private String id;
    private String nombre;
    private String licencia;
    
    public Conductor(String id, String nombre, String licencia) {
        this.id = id;
        this.nombre = nombre;
        this.licencia = licencia;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getLicencia() {
        return licencia;
    }
    
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
    
    public String mostrarInfo() {
        return "Conductor[ID: " + id + ", Nombre: " + nombre + ", Licencia: " + licencia + "]";
    }
}