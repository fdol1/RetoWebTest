# Automatización Web Demoblaze

## Descripción del Proyecto
Este proyecto tiene como objetivo la automatización de pruebas E2E (end-to-end) en una plataforma web llamada **Demoblaze**. El robot de pruebas está diseñado para simular el comportamiento de un usuario que realiza una compra en línea.

### Capacidades del Robot:
1. Abrir el navegador en la página principal de Demoblaze.
2. Buscar productos por nombre.
3. Ingresar la información de facturación y verificar los costos.
5. Confirmar el pago.
6. Verificar el mensaje de confirmación al finalizar la compra.

## Requisitos Previos
Antes de ejecutar las pruebas automatizadas, asegúrate de cumplir con los siguientes requisitos:

### Requisitos de Software:
- **JDK 19** (Corretto 19.0.2).
- **Gradle** (para gestionar la construcción y dependencias del proyecto).
- **Git** (para el control de versiones).

> Se recomienda utilizar **Corretto 19.0.2** debido a la compatibilidad y estabilidad con las dependencias del proyecto.

### Requisitos de Herramientas:
- **IntelliJ IDEA** (IDE recomendado para ejecutar las pruebas).
- - **Visual Studio Code** (IDE recomendado para ejecutar las pruebas).
- **Navegadores Web**: El proyecto está configurado para ejecutarse con **Selenium WebDriver**, lo que requiere que tengas los controladores adecuados para los navegadores que deseas utilizar.
-  También es posible ejecutar este robot de pruebas en Mozilla Firefox

## Instrucciones de Instalación

### 1. Clonar el repositorio:
Clona este proyecto en tu máquina local utilizando el siguiente comando:

  
    git clone https://github.com/fdol1/RetoWebTest


## Instalar dependencias:
Navega a la carpeta raíz del proyecto y ejecuta el siguiente comando para instalar las dependencias con Gradle:


    gradle build

## Configurar el entorno:
Asegúrate de tener configuradas las variables de entorno adecuadas para el navegador y el WebDriver que se utilizarán en las pruebas (ChromeDriver, GeckoDriver, etc.).

## Ejecución de Pruebas
1. Abrir el proyecto en IntelliJ IDEA.
Abre el proyecto en IntelliJ IDEA y asegúrate de que las dependencias estén correctamente descargadas.
2. Ejecutar las pruebas:

Dirígete a la ruta ubicada en la raíz del proyecto:


    src/test/java/com/automatizacion/runners

En este directorio encontrarás la clase que pemite la ejecución de las pruebas automatizadas. Dentro de IntelliJ IDEA, simplemente ejecuta la clase runner correspondiente para iniciar las pruebas.

### Nota: El correcto funcionamiento de las pruebas no depende del orden de ejecución.

### Descripción de las Pruebas Automatizadas
Este proyecto está basado en el patrón Screenplay Pattern, utilizando las siguientes tecnologías y bibliotecas:

1. Serenity BDD: Para la gestión y generación de reportes de las pruebas automatizadas. (Versión: 4.2.9).
2. Cucumber: Para la definición de los escenarios en lenguaje Gherkin. (Versión: 4.2.9).
3. Selenium WebDriver: Para la automatización de interacciones con el navegador.
4. Gradle: Para la construcción del proyecto y manejo de dependencias.
5. Java: Lenguaje principal de desarrollo.
6. Serenity Gradle Plugin: Para integrar Serenity BDD con Gradle. (Versión: 4.2.11).
7. Las pruebas están diseñadas para simular un flujo de compra completo en Open Cart, que incluye la búsqueda de productos, verificación de costos, ingreso de datos de facturación y la confirmación del pago.

## Estructura del Proyecto

- src
  - main
    - java
      - com.co.certificacion.retowebtest
          - tasks
          - Interactions
          - userinterfaces
          - Questions
          - utils
  - test
    - java
      - com.co.certificacion.retowebtest
          - runners
          - stepdefinitions
    - resources
      - features

### Descripción de las carpetas:

#### tasks: Contiene las acciones que el actor realiza en la aplicación (ej. buscar productos, agregar al carrito).
#### Interactions: Contiene las interacciones del usuario con los elementos de la pagina
#### Questions: Contiene las validaciones de información que se realizan en el flujo.

#### userinterfaces: Define los elementos de la interfaz de usuario (UI) con los que interactúan las pruebas.
#### utils: Utilidades y clases de soporte para la automatización.

## Configuración

### Configuración de WebDriver:

#### Asegúrate de tener los controladores de navegador (como ChromeDriver o GeckoDriver) correctamente configurados en tu máquina y que estén disponibles en el PATH o en el directorio src/test/resources.

### Cambios importantes:
- **Versión de Java**: He actualizado la versión de Java a **Corretto 19.0.2**.
- **Serenity y Cucumber**: Se especifican las versiones correctas de **Serenity BDD** y **Cucumber** (4.2.9).
- **Serenity Gradle Plugin**: Se menciona la versión **4.2.11** del plugin para Serenity en Gradle.
- **Gradle**: Se incluye el fragmento del archivo `build.gradle` con las dependencias y plugins correctos.
