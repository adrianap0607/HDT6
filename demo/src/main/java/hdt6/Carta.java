package hdt6;

public class Carta implements Comparable<Carta> {
    private String nombre;
    private String tipo;
    private Integer cantidad = 0;

    // Constructor que toma la cadena completa y divide nombre y tipo
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

    // Métodos getter para obtener el nombre y el tipo
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer aumentarCantidad() {
        this.cantidad++;
        return cantidad;
    }

    @Override
    public int compareTo(Carta otraCarta) {
        return this.nombre.compareTo(otraCarta.nombre);
    }
}
