# Proyecto de librería con Spring Boot
Proyecto de gestión de libros simple en Spring boot

## Características
- Gestión de modelos Nacionalidad, Autor y Libro
    - Conexión de entidades a una base de datos con JPA
    - Manejo de entidades (Lombok)
    - Relación entre modelos (@OneToMany, @ManyToOne)
- Búsqueda de libros por id, título y autor
- Implementación de una arquitectura limpia
- Manejo de errores mediante @RestControllerAdvice
- Autenticación del sistema con Spring Security
    - Encriptado de contraseña 
    - Generación de token JWT y filtro de consultas HTTP

## Instalación
1. Clone el repositorio del proyecto
2. Agregue una clave key para JWT y el siguiente path para el servidor
    ```bash
    jwt.secret.key=thisissupersecretkeyformyprojectdevelopment
    ```
3. Inicie el proyecto
