package hdt6;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

/**
 * La clase MapFactory proporciona un método para crear diferentes implementaciones de Map.
 */
public class MapFactory {

    /**
     * Crea y devuelve un mapa basado en el tipo proporcionado.
     * @param tipo El tipo de mapa a crear (HashMap, TreeMap o LinkedHashMap).
     * @return Un nuevo mapa del tipo especificado.
     * @throws IllegalArgumentException Si se proporciona un tipo de mapa no válido.
     */
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
