package co.edu.poli.parcial.vista;

import co.edu.poli.parcial.modelo.*;
import co.edu.poli.parcial.servicios.*;

/**
 * Clase principal que contiene el método main y gestiona la interfaz de usuario
 * para el sistema de gestión de vehículos.
 * 
 * @author Sarah Chaves
 * @version 1.0
 */
public class Principal {
    private static ImplementacionOperacionCRUD operaciones = new ImplementacionOperacionCRUD();
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    private static Conductor conductorPredefinido = new Conductor("C001", "Juan Perez", "B2");
    
    /**
     * Método principal que inicia la aplicación y muestra el menú de opciones.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    crearVehiculo();
                    break;
                case 2:
                    listarVehiculos();
                    break;
                case 3:
                    actualizarVehiculo();
                    break;
                case 4:
                    eliminarVehiculo();
                    break;
                case 5:
                    leerVehiculo();
                    break;
                case 6:
                    serializarDatos();
                    break;
                case 7:
                    deserializarDatos();
                    break;
                case 8:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 8);
    }
    
    /**
     * Muestra el menú principal de opciones al usuario.
     */
    private static void mostrarMenu() {
        System.out.println("\n=== MENU DE OPERACIONES ===");
        System.out.println("1. Crear vehiculo");
        System.out.println("2. Listar todos los vehiculos");
        System.out.println("3. Modificar vehiculos");
        System.out.println("4. Eliminar un vehiculo");
        System.out.println("5. Listar vehiculo especifico");
        System.out.println("6. Guardar en archivo");
        System.out.println("7. Cargar archivo");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    /**
     * Crea un nuevo vehículo (Bus o Camión) solicitando los datos al usuario.
     */
    private static void crearVehiculo() {
        System.out.println("\n=== CREAR VEHICULO ===");
        System.out.println("1. Bus");
        System.out.println("2. Camion");
        System.out.print("Seleccione tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Capacidad de Carga (en Kg y separado por ,): ");
        double capacidad = scanner.nextDouble();
        scanner.nextLine();
        
        Vehiculo vehiculo = null;
        
        if (tipo == 1) {
            System.out.print("Numero de Pasajeros: ");
            int numPasajeros = scanner.nextInt();
            scanner.nextLine();
            vehiculo = new Bus(placa, marca, modelo, capacidad, conductorPredefinido, numPasajeros);
        } else if (tipo == 2) {
            System.out.print("Tipo de Mercancia: ");
            String tipoMercancia = scanner.nextLine();
            vehiculo = new Camion(placa, marca, modelo, capacidad, conductorPredefinido, tipoMercancia);
        }
        
        if (vehiculo != null && operaciones.crear(vehiculo)) {
            System.out.println("Vehiculo creado exitosamente");
        } else {
            System.out.println("Error al crear vehiculo");
        }
    }
    
    /**
     * Lista todos los vehículos registrados en el sistema.
     */
    private static void listarVehiculos() {
        System.out.println("\n=== LISTAR TODOS LOS VEHICULOS ===");
        Vehiculo[] vehiculos = operaciones.leerTodos();
        if (vehiculos.length == 0) {
            System.out.println("No hay vehiculos registrados");
        } else {
            for (int i = 0; i < vehiculos.length; i++) {
                System.out.println((i + 1) + ". " + vehiculos[i].mostrarInfo());
            }
        }
    }
    
    /**
     * Actualiza los datos de un vehículo existente identificado por su placa.
     */
    private static void actualizarVehiculo() {
        System.out.println("\n=== MODIFICAR VEHICULO ===");
        System.out.print("Ingrese la placa del vehiculo a modificar: ");
        String placa = scanner.nextLine();
        
        Vehiculo vehiculoExistente = operaciones.leer(placa);
        if (vehiculoExistente == null) {
            System.out.println("Vehiculo no encontrado");
            return;
        }
        
        System.out.print("Nueva Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Nuevo Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Nueva Capacidad de Carga: ");
        double capacidad = scanner.nextDouble();
        scanner.nextLine();
        
        if (vehiculoExistente instanceof Bus) {
            System.out.print("Nuevo Numero de Pasajeros: ");
            int numPasajeros = scanner.nextInt();
            scanner.nextLine();
            Bus bus = new Bus(placa, marca, modelo, capacidad, conductorPredefinido, numPasajeros);
            if (operaciones.actualizar(bus)) {
                System.out.println("Bus actualizado exitosamente");
            }
        } else if (vehiculoExistente instanceof Camion) {
            System.out.print("Nuevo Tipo de Mercancia: ");
            String tipoMercancia = scanner.nextLine();
            Camion camion = new Camion(placa, marca, modelo, capacidad, conductorPredefinido, tipoMercancia);
            if (operaciones.actualizar(camion)) {
                System.out.println("Camion actualizado exitosamente");
            }
        }
    }
    
    /**
     * Elimina un vehículo del sistema identificado por su placa.
     */
    private static void eliminarVehiculo() {
        System.out.println("\n=== ELIMINAR VEHICULO ===");
        System.out.print("Ingrese la placa del vehiculo a eliminar: ");
        String placa = scanner.nextLine();
        
        if (operaciones.eliminar(placa)) {
            System.out.println("Vehiculo eliminado exitosamente");
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }
    
    /**
     * Busca y muestra la información de un vehículo específico por su placa.
     */
    private static void leerVehiculo() {
        System.out.println("\n=== LEER VEHICULO ESPECIFICO ===");
        System.out.print("Ingrese la placa del vehiculo: ");
        String placa = scanner.nextLine();
        
        Vehiculo vehiculo = operaciones.leer(placa);
        if (vehiculo != null) {
            System.out.println(vehiculo.mostrarInfo());
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }
    
    /**
     * Serializa los datos de los vehículos guardándolos en un archivo.
     */
    private static void serializarDatos() {
        System.out.println("\n=== GUARDAR EN ARCHIVO ===");
        if (operaciones.serializar()) {
            System.out.println("Datos guardados exitosamente");
        } else {
            System.out.println("Error al guardar los datos");
        }
    }
    
    /**
     * Deserializa los datos de los vehículos cargándolos desde un archivo.
     */
    private static void deserializarDatos() {
        System.out.println("\n=== CARGAR ARCHIVO ===");
        if (operaciones.deserializar()) {
            System.out.println("Datos cargados exitosamente");
        } else {
            System.out.println("Error al cargar los datos");
        }
    }
}