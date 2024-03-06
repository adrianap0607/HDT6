package hdt6;

public class Carta {
    private String nombre;
    private String tipo;

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

    public static void main(String[] args) {
        // Ejemplo de uso
        String cadena = "Abyssal Designator|Hechizo";
        Carta carta = new Carta(cadena);

        // Obtener y mostrar el nombre y el tipo
        System.out.println("Nombre: " + carta.getNombre());
        System.out.println("Tipo: " + carta.getTipo());
    }
}
