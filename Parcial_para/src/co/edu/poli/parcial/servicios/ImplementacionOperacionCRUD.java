package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.modelo.Vehiculo;
import java.io.*;

public class ImplementacionOperacionCRUD implements OperacionCRUD {
    private Vehiculo[] almacenamiento;
    private int cantidad;
    private static final String ARCHIVO = "vehiculos.dat";
    
    public ImplementacionOperacionCRUD() {
        this.almacenamiento = new Vehiculo[100];
        this.cantidad = 0;
    }
    
    @Override
    public boolean crear(Vehiculo vehiculo) {
        if (cantidad >= almacenamiento.length) {
            System.out.println("No hay espacio disponible");
            return false;
        }
        
        // Verificar si ya existe la placa
        for (int i = 0; i < cantidad; i++) {
            if (almacenamiento[i].getPlaca().equals(vehiculo.getPlaca())) {
                System.out.println("Ya existe un vehículo con esta placa");
                return false;
            }
        }
        
        almacenamiento[cantidad] = vehiculo;
        cantidad++;
        return true;
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
    
    @Override
    public Vehiculo[] leerTodos() {
        Vehiculo[] resultado = new Vehiculo[cantidad];
        for (int i = 0; i < cantidad; i++) {
            resultado[i] = almacenamiento[i];
        }
        return resultado;
    }
    
    @Override
    public boolean serializar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            // Primero guardamos la cantidad
            oos.writeInt(cantidad);
            // Luego guardamos cada vehículo
            for (int i = 0; i < cantidad; i++) {
                oos.writeObject(almacenamiento[i]);
            }
            System.out.println("Datos serializados correctamente. Vehículos guardados: " + cantidad);
            return true;
        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean deserializar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            // Primero leemos la cantidad
            int cantGuardada = ois.readInt();
            // Luego leemos cada vehículo
            for (int i = 0; i < cantGuardada; i++) {
                if (i < almacenamiento.length) {
                    almacenamiento[i] = (Vehiculo) ois.readObject();
                }
            }
            cantidad = Math.min(cantGuardada, almacenamiento.length);
            System.out.println("Datos deserializados correctamente. Vehículos cargados: " + cantidad);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se iniciará con datos vacíos.");
            return false;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            return false;
        }
    }
    
    // Método para obtener la cantidad actual (útil para debug)
    public int getCantidad() {
        return cantidad;
    }
}