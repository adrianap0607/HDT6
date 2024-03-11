package hdt6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La clase FileParser proporciona un método para leer las líneas de un archivo de texto.
 */
public class FileParser {
    
    /**
     * Lee las líneas de un archivo de texto y las devuelve como una lista de cadenas.
     * @param archivo El nombre del archivo que se va a leer.
     * @return Una lista de cadenas que representa las líneas del archivo.
     */
    public static ArrayList<String> leerLineas(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            // Imprimir la traza de la excepción y mostrar un mensaje de error
            e.printStackTrace();
            System.out.println("Error al leer el archivo: " + archivo);
        }
        
        return lineas;
    }
}
