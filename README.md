# Control de Despensa API

## 1. Nombre de la actividad

**Desarrollo de una API REST para el Control de una Despensa**

Proyecto académico desarrollado con Java y Spring Boot para gestionar productos y consultar información del inventario.

## 2. Descripción del problema

El control de los productos de una despensa es importante para conocer las existencias disponibles, sus precios y el valor económico del inventario.

Cuando esta información se administra manualmente, pueden presentarse dificultades para consultar los productos, realizar cálculos y determinar cuáles representan un mayor valor económico.

Para abordar esta necesidad, se desarrolla una API REST denominada **Control de Despensa API**, que permite gestionar información de productos y obtener un resumen del inventario.

El proyecto utiliza almacenamiento temporal en memoria, por lo que los datos registrados se pierden al detener la aplicación.

## 3. Tecnologías utilizadas

El proyecto Control de Despensa API fue desarrollado utilizando las siguientes tecnologías:

- **Java 17:** Lenguaje de programación principal.
- **Spring Boot:** Framework utilizado para desarrollar la API REST.
- **Spring Web:** Dependencia para implementar los servicios HTTP.
- **Apache Maven:** Herramienta para administrar las dependencias del proyecto.
- **JSON:** Formato utilizado para intercambiar información.
- **Postman:** Herramienta para realizar pruebas de los endpoints.
- **Git y GitHub:** Herramientas para el control de versiones y almacenamiento del código.

## 4. Requisitos para ejecutar el proyecto

Para ejecutar correctamente la aplicación se necesita:

- Java Development Kit (JDK) 17.
- Visual Studio Code, IntelliJ IDEA u otro entorno compatible con Java.
- Maven Wrapper, incluido en el proyecto.
- Postman para probar los endpoints.
- Conexión a Internet para descargar las dependencias necesarias.
## 5. Estructura principal

```text
control-despensa-api/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/estudiante/despensa/
│   │   │       ├── ControlDespensaApiApplication.java
│   │   │       ├── controller/
│   │   │       │   └── ProductoController.java
│   │   │       └── model/
│   │   │           ├── Producto.java
│   │   │           └── ResumenInventario.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── evidencias/
│   └── Evidencias_API_Despensa_NombreApellido.docx
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## 6. Explicación de las clases

### ControlDespensaApiApplication.java

Es la clase principal del proyecto. Contiene el método `main`, encargado de iniciar la aplicación mediante Spring Boot.

### ProductoController.java

Es el controlador responsable de recibir las solicitudes HTTP relacionadas con los productos y devolver las respuestas correspondientes.

También permite acceder a las operaciones de consulta y análisis del inventario que estén implementadas.

### Producto.java

Es la clase modelo que representa un producto de la despensa.

Permite organizar los atributos utilizados para identificar y describir cada producto.

### ResumenInventario.java

Es la clase modelo encargada de representar los resultados del análisis del inventario.

Se utiliza para organizar la información resumida que devuelve la aplicación.

## 7. Tabla de endpoints

La API REST cuenta con seis endpoints que permiten consultar y analizar la información de los productos registrados en la despensa.

| Operación | Método | Ruta | Estado esperado |
|---|---|---|---|
| Listar productos | GET | `/api/productos` | 200 |
| Buscar por identificador | GET | `/api/productos/{id}` | 200 o 404 |
| Buscar por categoría | GET | `/api/productos/categoria/{categoria}` | 200 |
| Consultar stock bajo | GET | `/api/productos/stock-bajo` | 200 |
| Consultar producto de mayor valor | GET | `/api/productos/mayor-valor` | 200 |
| Obtener resumen | GET | `/api/productos/resumen` | 200 |

### Descripción de los endpoints

**1. Listar productos**

Permite consultar todos los productos registrados en la despensa.

`GET http://localhost:8080/api/productos`

**2. Buscar por identificador**

Permite buscar un producto específico utilizando su identificador.

`GET http://localhost:8080/api/productos/1`

**3. Buscar por categoría**

Permite consultar los productos que pertenecen a una categoría determinada.

`GET http://localhost:8080/api/productos/categoria/Alimentos`

**4. Consultar stock bajo**

Permite identificar los productos que tienen pocas unidades disponibles.

`GET http://localhost:8080/api/productos/stock-bajo`

**5. Consultar producto de mayor valor**

Permite identificar el producto cuyo valor total de inventario es el más alto.

`GET http://localhost:8080/api/productos/mayor-valor`

**6. Obtener resumen**

Permite consultar información general y estadísticas del inventario.

`GET http://localhost:8080/api/productos/resumen`

### Códigos de respuesta HTTP

- **200 OK:** La solicitud se procesó correctamente.
- **404 Not Found:** No se encontró el producto solicitado.
## 8. Instrucciones para ejecutar la aplicación

**Paso 1.** Descargar o clonar el repositorio de GitHub.

**Paso 2.** Abrir la carpeta `control-despensa-api` en el entorno de desarrollo.

**Paso 3.** Verificar que el JDK esté instalado y configurado correctamente.

**Paso 4.** Abrir una terminal en la carpeta principal del proyecto.

**Paso 5.** Ejecutar el siguiente comando en Windows:

```bash
.\mvnw.cmd spring-boot:run
```

En Linux o macOS:

```bash
./mvnw spring-boot:run
```

**Paso 6.** Esperar a que Spring Boot inicie correctamente.

**Paso 7.** Abrir Postman y realizar las solicitudes HTTP a las rutas implementadas.

Si no se ha configurado otro puerto, la aplicación estará disponible en:

`http://localhost:8080`

## 9. Ejemplos de respuestas JSON

Los siguientes ejemplos son ilustrativos y deben sustituirse por las respuestas reales obtenidas en Postman.

### Ejemplo de información de un producto

```json
{
  "id": 1,
  "nombre": "Arroz",
  "precio": 12.50,
  "cantidad": 10
}
```

### Ejemplo de resumen del inventario

```json
{
  "cantidadProductos": 2,
  "valorTotalInventario": 225.00,
  "productoMayorValor": "Arroz"
}
```

Estos ejemplos muestran una posible representación JSON. Los nombres de las propiedades y la estructura definitiva dependerán de las clases implementadas.

## 10. Nombre completo y número de carné

**Nombre completo:** [Escribir nombre completo]

**Número de carné:** [Escribir número de carné]

---

## Conclusión

El desarrollo de Control de Despensa API permite aplicar conocimientos de programación orientada a objetos, creación de servicios REST y manejo de solicitudes HTTP mediante Spring Boot.

Asimismo, facilita la comprensión del procesamiento de información en memoria, el uso de modelos de datos y la generación de respuestas JSON.

Este proyecto constituye una base para futuras mejoras, como la implementación de una base de datos PostgreSQL que permita almacenar los productos de forma permanente.

## Nombre:
Melvin Apolonio Mazariegos López
## Carné:
9941 25 25174
