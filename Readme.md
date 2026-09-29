API RESTful para la gestión de productos construida bajo los principios de **Arquitectura Hexagonal (Ports and Adapters)**.

Cómo ejecutar el proyecto
1. tener MySQL corriendo en el puerto 3306.
2. No es necesario crear tablas a mano. Al arrancar el proyecto, la base de datos `prueba_db` y sus tablas se crearán automáticamente gracias a la URL de conexión y Flyway.
3. Ejecutar la aplicación desde el IDE o con Maven: `mvn spring-boot:run`

Documentación de la API
Una vez iniciada la aplicación, puedes probar los endpoints desde Swagger UI:
* **Swagger:** `http://localhost:8080/swagger-ui.html`

