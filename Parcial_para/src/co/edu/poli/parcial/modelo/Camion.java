package co.edu.poli.parcial.modelo;

public class Camion extends Vehiculo {
    private String tipoMercancia;
    
    public Camion(String placa, String marca, String modelo, double capacidadCarga, 
                  Conductor conductor, String tipoMercancia) {
        super(placa, marca, modelo, capacidadCarga, conductor);
        this.tipoMercancia = tipoMercancia;
    }
    
    public String getTipoMercancia() {
        return tipoMercancia;
    }
    
    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }
    
    @Override
    public String mostrarInfo() {
        return "Camion[Placa: " + getPlaca() + ", Marca: " + getMarca() + ", Modelo: " + getModelo() + 
               ", Capacidad Carga: " + getCapacidadCarga() + ", Conductor: " + getConductor().getNombre() + 
               ", Tipo Mercancia: " + tipoMercancia + "]";
    }
}
