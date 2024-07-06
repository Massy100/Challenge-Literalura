# Proyecto Literalura
Proyecto desarrollado para el Challenge 2 de Alura-Oracle.

# Descripción
Literalura es una aplicación que utiliza la API Gutendex para listar libros, autores y realizar búsquedas por título y otros filtros. La aplicación está construida con Spring Boot y utiliza Thymeleaf para las vistas.

# Funcionalidades
Listar Libros: Muestra una lista de libros disponibles.
Buscar Libro: Permite buscar libros por título.
Listar Autores: Muestra una lista de autores disponibles.
Listar Autores Vivos: Muestra una lista de autores vivos.
Listar Libros por Idioma: Permite filtrar libros por idioma.

# Tecnologías Utilizadas
Java 17
Spring Boot
Spring Web
Spring WebFlux
Thymeleaf
WebClient para integración con API externa

# Configuración del Proyecto
Requisitos:
JDK 17 o superior
Maven
PostgreSQL (para el almacenamiento de datos, si es aplicable)

# Configuración
Clona este repositorio.
Importa el proyecto en tu IDE preferido como un proyecto Maven existente.
Asegúrate de tener todas las dependencias actualizadas. Puedes revisar el archivo pom.xml para verificarlas.
Configura las credenciales de acceso a la base de datos en application.properties, si es necesario.
Ejecuta la aplicación desde tu IDE o con Maven usando mvn spring-boot:run.

# Uso
Una vez que la aplicación esté en ejecución, puedes acceder a las siguientes URLs:

http://localhost:8080/: Página principal.
http://localhost:8080/buscar-libro: Página para buscar libros por título.
http://localhost:8080/listar-libros: Página para listar todos los libros.
http://localhost:8080/listar-autores: Página para listar todos los autores.
http://localhost:8080/listar-autores-vivos: Página para listar autores vivos.
http://localhost:8080/listar-libros-por-idioma: Página para listar libros por idioma.

# Contribuciones
¡Las contribuciones son bienvenidas! Si deseas mejorar este proyecto, por favor abre un issue o una pull request en este repositorio.
