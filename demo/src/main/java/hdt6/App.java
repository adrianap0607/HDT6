package hdt6;

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;

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

    public static void main( String[] args )
    {
        lineasCartas = parser.leerLineas("cards_desc.txt");
        for(String linea:lineasCartas){
            cartas.add(new Carta(linea));
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Hola querido!!!\n" + "¿Qué deseas hacer?");
        systemON = true;
        while(systemON){
            System.out.println("1. Seleccionar tipo de implementación\n" + "2. Salir del programa");
            System.out.println("----------------------------------------------------------");

            String decision = sc.nextLine();
            switch(decision){
                case "1":
                    System.out.println("----------------------------------------------------------");   
                    System.out.println("¿Qué implementación deseas usar?");
                    systemON2 = true;
                    while(systemON2){
                        System.out.println("1. HashMap\n" + "2. TreeMap\n" + "3. LinkedHashMap");
                        System.out.println("(Recuerda, únicamente debes seleccionar el número de la opción que deseas)");
                        System.out.println("----------------------------------------------------------");
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
                                System.out.println("Por favor, asegurate que estás seleccionando una opción válida.");
                                System.out.println("Recuerda que solo debes colocar el número de la opción que deseas");
                                break;
                        }
                    }
                    System.out.println("Has decidido utilizar la implementación de " + tipoMap + " .");
                    mapUtilizado = factory.crearMap(tipoMap);
                    System.out.println();
                    System.out.println("---------------INGRESANDO AL MENÚ---------------");
                    systemON3 = true;
                    while(systemON3){
                        System.out.println("----------------------------------------------------------");
                        System.out.println("1. Agregar carta a la colección\n" + "2. Conocer el tipo de una carta\n" + "3. Mostrar el nombre, tipo y cantidad de cada carta en tu colección\n" + "4. Mostrar el nombre, tipo y cantidad de cada carta de tu colección ordenada por tipo\n" + "5. Mostrar el nombre y tipo de todas las cartas existentes\n" + "6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo\n" + "7. Salir del menú");
                        System.out.println("----------------------------------------------------------");
                        String decision2 = sc.nextLine();
                        switch(decision2){
                            case "1":
                                
                                break;

                            case "2":
                                
                                break;

                            case "3":
                                
                                break;

                            case "4":
                                
                                break;

                            case "5":
                                System.out.println("Estás son todas las cartas que existen: \n");
                                System.out.println("----------------------------------------------------------");
                                for(Carta carta: cartas){
                                    System.out.println(carta.getNombre() + "|" + carta.getTipo());
                                }
                                System.out.println("----------------------------------------------------------");
                                break;

                            case "6":
                                
                                break;

                            case "7":
                                System.out.println("Regresando al menú anterior");
                                systemON3 = false;
                                break;

                            default:
                                System.out.println("Por favor, asegurate de que estés ingresando una opción válida :)");
                                
                                

                        }
                    }
                    break;

                case "2":
                    System.out.println("----------------------------------------------------------");   
                    System.out.println("Que tenga un muy buen día!!!");
                    System.out.println("----------------------------------------------------------");
                    systemON = false;
                    break;

                default:
                    System.out.println("Por favor, asegurate que estás seleccionando una opción válida.");
                    System.out.println("Recuerda que solo debes colocar el número de la opción que deseas");
                    System.out.println("----------------------------------------------------------");
                    break;
            }
        }

    }
}
