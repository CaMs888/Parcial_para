package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.modelo.Vehiculo;

public class ImplementacionOperacionCRUD implements OperacionCRUD {
    private Vehiculo[] almacenamiento;
    private int cantidad;
    
    public ImplementacionOperacionCRUD() {
        this.almacenamiento = new Vehiculo[100];
        this.cantidad = 0;
    }
    
    @Override
    public boolean crear(Vehiculo vehiculo) {
        if (cantidad < almacenamiento.length) {
            almacenamiento[cantidad] = vehiculo;
            cantidad++;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean eliminar(String placa) {
        for (int i = 0; i < cantidad; i++) {
            if (almacenamiento[i].getPlaca().equals(placa)) {
                for (int j = i; j < cantidad - 1; j++) {
                    almacenamiento[j] = almacenamiento[j + 1];
                }
                almacenamiento[cantidad - 1] = null;
                cantidad--;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean actualizar(Vehiculo vehiculo) {
        for (int i = 0; i < cantidad; i++) {
            if (almacenamiento[i].getPlaca().equals(vehiculo.getPlaca())) {
                almacenamiento[i] = vehiculo;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Vehiculo leer(String placa) {
        for (int i = 0; i < cantidad; i++) {
            if (almacenamiento[i].getPlaca().equals(placa)) {
                return almacenamiento[i];
            }
        }
        return null;
    }
    
    public Vehiculo[] leerTodos() {
        Vehiculo[] resultado = new Vehiculo[cantidad];
        for (int i = 0; i < cantidad; i++) {
            resultado[i] = almacenamiento[i];
        }
        return resultado;
    }
    
    public boolean serializar() {
        try {
            java.io.FileOutputStream fileOut = new java.io.FileOutputStream("vehiculos.dat");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fileOut);
            out.writeInt(cantidad);
            for (int i = 0; i < cantidad; i++) {
                out.writeObject(almacenamiento[i]);
            }
            out.close();
            fileOut.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al serializar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deserializar() {
        try {
            java.io.FileInputStream fileIn = new java.io.FileInputStream("vehiculos.dat");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fileIn);
            cantidad = in.readInt();
            for (int i = 0; i < cantidad; i++) {
                almacenamiento[i] = (Vehiculo) in.readObject();
            }
            in.close();
            fileIn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            return false;
        }
    }
}