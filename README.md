# CHANLLENGE FORO HUB

<p>
    <img src="https://img.shields.io/badge/STATUS-EN PROCESO-orange">
    <img src="https://img.shields.io/badge/SPRING BOOT-3.3.1-green">
    <img src="https://img.shields.io/badge/DATABASE-MySQL-blue">

</p>

## Descripción

API que simula un foro, en el cual se agrega un título y mensaje por parte del usuario registrado.
La fecha y el id del foro es generada por la aplicación al momento de crear el mismo.  
Cuando se ejecuta la app de Spring Boot se crean las tablas llamadas: `autor` y `topicos` en la base de datos `one_foro_hub`.
El CRUD solo se realiza en la tabla `topicos`. Los autores deben ser previamente registrados.

###

### Datos:

Campos de la tabla `autor` de la base de datos:

| Entidad Backend      | Campos de la tabla SQL |
|----------------------|------------------------|
| Long id              | id bigint(20) PK       |
| String nombre        | nombre varchar(255)    |
| String apellido      | apellido varchar(255)  |

<br>
Campos de la tabla `topicos` de la base de datos:

| Entidad Backend    | Campos de la tabla SQL            |
|--------------------|-----------------------------------|
| Long id            | id bigint(20) PK (auto_increment) |
| String titulo      | titulo varchar(255)               |
| String mensaje     | mensaje varchar(255)              |
| Date fechaCreacion | datetime(6)                       |
| Long autorId       | autor_id bigint(20) (FK)          |

###

### Endpoints

| Método | Ruta            | Descripción                        |
|--------|-----------------|------------------------------------|
| GET    | `/topicos`      | Obtiene todos los tópicos de la db |
| GET    | `/topicos/{id}` | Obtiene un tópico por su Id        |
| POST   | `/topicos`      | Guarda un nuevo tópico             |
| PUT    | `/topicos/{id}` | Actualiza un tópico por su Id      |
| DELETE | `topicos/{id}`  | Elimina a un tópico por su Id      |

## 

## Reglas de negocio
- Todos los campos (tópicos) son obligatorios
- La API no permite el registro de tópicos duplicados (con el mismo título y mensaje).

## Desarrollador:

| [<img src="https://avatars.githubusercontent.com/u/120583187?v=4" width=115><br><sub>José Luis Paternina Martínez</sub>](https://github.com/JosePater) 
|:------------------------------------------------------------------------------------------------------------------------------------------------------:| 

