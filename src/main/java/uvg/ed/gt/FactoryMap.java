package uvg.ed.gt;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class FactoryMap {
    public static Map<String, Carta> getMap(int choice) {
        switch (choice) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Opción no válida");
        }
    }
}

