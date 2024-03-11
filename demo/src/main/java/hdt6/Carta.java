package hdt6;

/**
 * La clase Carta representa una carta de un juego y proporciona métodos para acceder a su nombre, tipo y cantidad.
 * Además, implementa la interfaz Comparable para permitir la comparación entre cartas basada en su nombre.
 */
public class Carta implements Comparable<Carta> {
    private String nombre;
    private String tipo;
    private Integer cantidad = 0;

    /**
     * Constructor que toma una cadena completa y divide el nombre y el tipo de la carta.
     * @param cadena La cadena completa que contiene el nombre y el tipo de la carta, separados por '|'.
     * @throws IllegalArgumentException Si la cadena no tiene el formato esperado.
     */
    public Carta(String cadena) {
        // Dividir la cadena usando el carácter '|'
        String[] partes = cadena.split("\\|");

        // Verificar si se dividieron correctamente en nombre y tipo
        if (partes.length == 2) {
            this.nombre = partes[0].trim(); // Eliminar espacios en blanco alrededor
            this.tipo = partes[1].trim();   // Eliminar espacios en blanco alrededor
        } else {
            // Manejar el caso de una cadena mal formateada
            throw new IllegalArgumentException("La cadena no tiene el formato esperado: " + cadena);
        }
    }

    /**
     * Método getter para obtener el nombre de la carta.
     * @return El nombre de la carta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método getter para obtener el tipo de la carta.
     * @return El tipo de la carta.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Incrementa la cantidad de esta carta y devuelve la nueva cantidad.
     * @return La nueva cantidad de esta carta después de incrementarla.
     */
    public Integer aumentarCantidad() {
        this.cantidad++;
        return cantidad;
    }

    /**
     * Método de comparación para ordenar cartas basadas en su nombre.
     * @param otraCarta La otra carta con la que se compara esta carta.
     * @return Un valor negativo si esta carta es menor que la otra, cero si son iguales, y un valor positivo si esta carta es mayor.
     */
    @Override
    public int compareTo(Carta otraCarta) {
        return this.nombre.compareTo(otraCarta.nombre);
    }
}
