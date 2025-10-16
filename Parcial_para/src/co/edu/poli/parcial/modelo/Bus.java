package co.edu.poli.parcial.modelo;

public class Bus extends Vehiculo {
    private int numPasajeros;
    
    public Bus(String placa, String marca, String modelo, double capacidadCarga, 
               Conductor conductor, int numPasajeros) {
        super(placa, marca, modelo, capacidadCarga, conductor);
        this.numPasajeros = numPasajeros;
    }
    
    public int getNumPasajeros() {
        return numPasajeros;
    }
    
    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
    
    @Override
    public String mostrarInfo() {
        return "Bus[Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Modelo: " + getModelo() + 
               ", Capacidad Carga: " + getCapacidadCarga() + ", Conductor: " + getConductor().getNombre() + 
               ", Num Pasajeros: " + numPasajeros + "]";
    }
}