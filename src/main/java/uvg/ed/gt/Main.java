package uvg.ed.gt;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de MAP a utilizar:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");
        int choice = scanner.nextInt();
        Map<String, Carta> mapa = FactoryMap.getMap(choice);
        CartaManager cartaManager = new CartaManager(mapa);
        try {
            cartaManager.cargarCartasDesdeArchivo("Cartas.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar las cartas desde el archivo.");
            return;
        }
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar una carta a la colección del usuario.");
            System.out.println("2. Mostrar el tipo de una carta específica.");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección.");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo.");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes.");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre de la carta que desea agregar: ");
                    String nombreCarta = scanner.nextLine();
                    cartaManager.agregarCarta(nombreCarta);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la carta: ");
                    nombreCarta = scanner.nextLine();
                    System.out.println("Tipo de la carta: " + cartaManager.obtenerTipoDeCarta(nombreCarta));
                    break;
                case 3:
                    System.out.println("Cartas en la colección del usuario:");
                    cartaManager.mostrarTodasLasCartas();
                    break;
                case 4:
                    System.out.println("Cartas en la colección del usuario ordenadas por tipo:");
                    cartaManager.mostrarCartasOrdenadasPorTipo();
                    break;
                case 5:
                    System.out.println("Todas las cartas disponibles:");
                    cartaManager.mostrarTodasLasCartas();
                    break;
                case 6:
                    System.out.println("Todas las cartas disponibles ordenadas por tipo:");
                    cartaManager.mostrarCartasOrdenadasPorTipo();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

