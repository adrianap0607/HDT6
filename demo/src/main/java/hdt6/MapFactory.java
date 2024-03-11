package hdt6;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;


public class MapFactory {
    public static Map<Carta, Integer> crearMap(String tipo) {
        switch (tipo.toUpperCase()) {
            case "HASHMAP":
                return new HashMap<>();
            case "TREEMAP":
                return new TreeMap<>();
            case "LINKEDHASHMAP":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de Map no válido: " + tipo);
        }
    }
}
