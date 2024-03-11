# Gestor de Cartas - HDT6

Este proyecto es un gestor de cartas implementado en Java. Permite al usuario realizar diversas operaciones relacionadas con la gestión de cartas, como agregar cartas a una colección, conocer el tipo de una carta, mostrar las cartas en la colección, entre otras.

## Funcionalidades

- **Selección de implementación de mapa:** El usuario puede seleccionar entre tres implementaciones de mapas: HashMap, TreeMap y LinkedHashMap.
- **Gestión de colección de cartas:** El usuario puede agregar cartas a su colección y conocer el tipo de una carta específica.
- **Visualización de cartas:** El usuario puede ver las cartas en su colección y ordenarlas por tipo.

## Estructura del Proyecto

El proyecto está estructurado en varios archivos Java:

- **App.java:** Clase principal que inicia la aplicación y maneja la interacción con el usuario.
- **Carta.java:** Clase que representa una carta de juego y proporciona métodos para acceder a su nombre, tipo y cantidad.
- **FileParser.java:** Clase que proporciona un método para leer las líneas de un archivo de texto.
- **MapFactory.java:** Clase que proporciona un método para crear diferentes implementaciones de mapas.

## Cómo Usar

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu entorno de desarrollo Java preferido.
3. Ejecuta la clase `App.java`.
4. Sigue las instrucciones en la consola para interactuar con el gestor de cartas.
