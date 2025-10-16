package co.edu.poli.parcial.modelo;

public class Vehiculo implements java.io.Serializable {
    private String placa;
    private String marca;
    private String modelo;
    private double capacidadCarga;
    private Conductor conductor;
    
    public Vehiculo(String placa, String marca, String modelo, double capacidadCarga, Conductor conductor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadCarga = capacidadCarga;
        this.conductor = conductor;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public double getCapacidadCarga() {
        return capacidadCarga;
    }
    
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    
    public Conductor getConductor() {
        return conductor;
    }
    
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    
    public String mostrarInfo() {
        return "Vehiculo[Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo + 
               ", Capacidad Carga: " + capacidadCarga + ", Conductor: " + conductor.getNombre() + "]";
    }
}