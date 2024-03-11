package hdt6;

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase principal que ejecuta la aplicación de gestión de cartas.
 */
public class App {
    private static boolean systemON = true;
    private static boolean systemON2 = true;
    private static boolean systemON3 = true;
    private static MapFactory factory = new MapFactory();
    private static FileParser parser = new FileParser();
    private static String tipoMap = "";
    private static Scanner sc = new Scanner(System.in);
    private static Map<Carta, Integer> mapUtilizado;
    private static ArrayList<String> lineasCartas = new ArrayList();
    private static ArrayList<Carta> cartas = new ArrayList();
    private static String nombreCarta;
    private static boolean cartaEncontrada;
    private static String[] tiposCarta = {"Monstruo", "Trampa", "Hechizo"};

    /**
     * Método principal que inicia la aplicación.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main( String[] args )
    {
        // Leer las líneas de las cartas desde el archivo
        lineasCartas = parser.leerLineas("cards_desc.txt");
        // Crear objetos de carta a partir de las líneas leídas
        for(String linea:lineasCartas){
            cartas.add(new Carta(linea));
        }
        // Mostrar mensaje de bienvenida
        System.out.println("----------------------------------------------------------");
        System.out.println("Hola querido!!!\n" + "¿Qué deseas hacer?");
        systemON = true;
        while(systemON){
            // Mostrar opciones principales
            System.out.println("1. Seleccionar tipo de implementación\n" + "2. Salir del programa");
            System.out.println("----------------------------------------------------------");

            // Leer la decisión del usuario
            String decision = sc.nextLine();
            switch(decision){
                case "1":
                    System.out.println("----------------------------------------------------------");   
                    System.out.println("¿Qué implementación deseas usar?");
                    systemON2 = true;
                    while(systemON2){
                        // Mostrar opciones de implementación de mapa
                        System.out.println("1. HashMap\n" + "2. TreeMap\n" + "3. LinkedHashMap");
                        System.out.println("(Recuerda, únicamente debes seleccionar el número de la opción que deseas)");
                        System.out.println("----------------------------------------------------------");
                        // Leer la decisión de implementación del usuario
                        switch(tipoMap = sc.nextLine()){
                            case "1":
                                tipoMap = "HashMap";
                                systemON2 = false;
                                break;
                            case "2":
                                tipoMap = "TreeMap";
                                systemON2 = false;
                                break;
                            case "3":
                                tipoMap = "LinkedHashMap";
                                systemON2 = false;
                                break;
                            default:
                                // Mensaje de error para una opción inválida
                                System.out.println("Por favor, asegurate que estás seleccionando una opción válida.");
                                System.out.println("Recuerda que solo debes colocar el número de la opción que deseas");
                                break;
                        }
                    }
                    // Confirmación de la selección de implementación
                    System.out.println("Has decidido utilizar la implementación de " + tipoMap + " .");
                    mapUtilizado = factory.crearMap(tipoMap);
                    System.out.println();
                    // Entrar al menú de opciones secundarias
                    System.out.println("---------------INGRESANDO AL MENÚ---------------");
                    systemON3 = true;
                    while(systemON3){
                        // Mostrar opciones del menú secundario
                        System.out.println("----------------------------------------------------------");
                        System.out.println("1. Agregar carta a la colección\n" + "2. Conocer el tipo de una carta\n" + "3. Mostrar el nombre, tipo y cantidad de cada carta en tu colección\n" + "4. Mostrar el nombre, tipo y cantidad de cada carta de tu colección ordenada por tipo\n" + "5. Mostrar el nombre y tipo de todas las cartas existentes\n" + "6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo\n" + "7. Salir del menú");
                        System.out.println("----------------------------------------------------------");
                        // Leer la decisión del usuario en el menú secundario
                        String decision2 = sc.nextLine();
                        switch(decision2){
                            case "1":
                                // Agregar una carta a la colección del usuario
                                System.out.println("¿Cuál carta quieres agregar a tu colección?");
                                nombreCarta = sc.nextLine();
                                cartaEncontrada = false;
                                for(Carta carta: cartas){
                                    if(carta.getNombre().equals(nombreCarta)){
                                        mapUtilizado.put(carta, carta.aumentarCantidad());
                                        cartaEncontrada = true;
                                        System.out.println("Se ha agregado la carta a tu colección.");
                                    }
                                }
                                if(!cartaEncontrada){
                                    System.out.println("Lamentamos informarte que no hemos encontrado la carta que has solicitado.");
                                }
                                break;

                            case "2":
                                // Conocer el tipo de una carta específica
                                System.out.println("¿De qué carta deseas saber su tipo?");
                                nombreCarta = sc.nextLine();
                                cartaEncontrada = false;
                                for(Carta carta: cartas){
                                    if(carta.getNombre().equals(nombreCarta)){
                                        System.out.println("El tipo de la carta " + carta.getNombre() + " es " + carta.getTipo() + ".");
                                        cartaEncontrada = true;
                                    }
                                }
                                if(!cartaEncontrada){
                                    System.out.println("Lamentamos informarte que no hemos encontrado la carta que has solicitado.");
                                }
                                break;

                            case "3":
                                // Mostrar el nombre, tipo y cantidad de cada carta en la colección del usuario
                                int indice = 1;
                                for(Map.Entry<Carta, Integer> entry: mapUtilizado.entrySet()){
                                    Carta carta = entry.getKey();
                                    int cantidad1 = entry.getValue();
                                    System.out.println(indice + ". " + carta.getNombre() + "|" + carta.getTipo() + " - se tiene/tienen " + cantidad1 + " carta/cartas.\n");
                                    indice++;
                                }                                
                                break;

                            case "4":
                                // Mostrar el nombre, tipo y cantidad de cada carta de la colección ordenada por tipo
                                int indice2 = 1;
                                for(String tipo: tiposCarta){
                                    for(Map.Entry<Carta, Integer> entry: mapUtilizado.entrySet()){
                                        Carta carta = entry.getKey();
                                        int cantidad1 = entry.getValue();
                                        if(carta.getTipo().equals(tipo)){
                                            System.out.println(indice2 + ". " + carta.getNombre() + "|" + carta.getTipo() + " - se tiene/tienen " + cantidad1 + " carta/cartas.\n");
                                            indice2++;
                                        }
                                    }
                                }
                                break;

                            case "5":
                                // Mostrar el nombre y tipo de todas las cartas existentes
                                System.out.println("Estás son todas las cartas que existen: \n");
                                System.out.println("----------------------------------------------------------");
                                for(Carta carta: cartas){
                                    System.out.println(carta.getNombre() + "|" + carta.getTipo());
                                }
                                System.out.println("----------------------------------------------------------");
                                break;

                            case "6":
                                // Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo
                                System.out.println("----------------------------------------------------------");
                                for(String tipo: tiposCarta){
                                    for(Carta carta: cartas){
                                        if(carta.getTipo().equals(tipo)){
                                            System.out.println(carta.getNombre() + "|" + carta.getTipo());
                                        }
                                    }
                                }
                                System.out.println("----------------------------------------------------------");
                                break;

                            case "7":
                                // Salir del menú secundario y regresar al menú principal
                                System.out.println("Regresando al menú anterior");
                                systemON3 = false;
                                break;

                            default:
                                // Mensaje de error para una opción inválida
                                System.out.println("Por favor, asegurate de que estés ingresando una opción válida :)");
                        }
                    }
                    break;

                case "2":
                    // Salir del programa
                    System.out.println("----------------------------------------------------------");   
                    System.out.println("Que tenga un muy buen día!!!");
                    System.out.println("----------------------------------------------------------");
                    systemON = false;
                    break;

                default:
                    // Mensaje de error para una opción inválida
                    System.out.println("Por favor, asegurate que estás seleccionando una opción válida.");
                    System.out.println("Recuerda que solo debes colocar el número de la opción que deseas");
                    System.out.println("----------------------------------------------------------");
                    break;
            }
        }
    }
}
