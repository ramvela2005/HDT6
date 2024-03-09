package uvg.ed.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CartaManager {
    private final Map<String, Carta> cartas;

    public CartaManager(Map<String, Carta> cartas) {
        this.cartas = cartas;
    }

    public void cargarCartasDesdeArchivo(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String nombre = parts[0].trim();
                    String tipo = parts[1].trim();
                    cartas.put(nombre, new CartaImpl(nombre, tipo));
                }
            }
        }
    }

    public void agregarCarta(String nombreCarta) {
        Carta carta = cartas.get(nombreCarta);
        if (carta != null) {
            cartas.put(nombreCarta, carta);
        } else {
            System.out.println("Error: La carta no se encuentra disponible.");
        }
    }

    public String obtenerTipoDeCarta(String nombreCarta) {
        Carta carta = cartas.get(nombreCarta);
        return (carta != null) ? carta.getTipo() : "Carta no encontrada";
    }

    public void mostrarTodasLasCartas() {
        for (Carta carta : cartas.values()) {
            System.out.println("Nombre: " + carta.getNombre() + ", Tipo: " + carta.getTipo());
        }
    }

    public void mostrarCartasOrdenadasPorTipo() {
        Map<String, List<Carta>> cartasPorTipo = new HashMap<>();
        for (Carta carta : cartas.values()) {
            String tipo = carta.getTipo();
            cartasPorTipo.computeIfAbsent(tipo, k -> new ArrayList<>()).add(carta);
        }
        cartasPorTipo.forEach((tipo, listaCartas) -> {
            System.out.println("Tipo: " + tipo);
            for (Carta carta : listaCartas) {
                System.out.println("Nombre: " + carta.getNombre() + ", Tipo: " + carta.getTipo());
            }
        });
    }
}

