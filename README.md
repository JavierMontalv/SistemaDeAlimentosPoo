# Sistema de Gestión de Alimentos en Java

Este proyecto es una aplicación desarrollada en Java con programación orientada a objetos (POO) y una interfaz gráfica usando **Swing**. Permite gestionar diferentes tipos de alimentos organizados en categorías como frutas y verduras, grasas e hidratos de carbono.

## 🛠️ Tecnologías utilizadas

- Java
- IntelliJ IDEA (recomendado)

## 📂 Estructura del proyecto

El código fuente se encuentra en la carpeta `src`. Las clases están organizadas de la siguiente manera:

- `Alimento`: clase abstracta base
- `FrutaVerdura`, `Grasa`, `HidratoCarbono`: subclases de Alimento
- `AuthService`: clase encargada de la autenticación
- `LoginFrame`, `MenuPrincipal`, `VentanaGestion`: interfaz gráfica
- `AlimentoException`: excepción personalizada

## 🔑 Autenticación

- **Usuario**: admin
- **Contraseña**: 1234

## ▶️ Cómo ejecutar el proyecto

1. Ejecuta `LoginFrame.java` como clase principal.
2. Ingresa con las credenciales mencionadas arriba.

## 📌 Notas

- Puedes modificar y agregar nuevos alimentos desde la ventana principal.
- Se aplican principios de herencia, polimorfismo, interfaces y manejo de excepciones.
