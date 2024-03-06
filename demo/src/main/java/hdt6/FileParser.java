package hdt6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {
    public static ArrayList<String> leerLineas(String archivo) {
    ArrayList<String> lineas = new ArrayList<>();
    
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error al leer el archivo: " + archivo);
    }
    
    return lineas;
}
}
