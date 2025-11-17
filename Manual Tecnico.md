# Manual Técnico - Sistema de Votación Electrónica Votum

## 1. Introducción

### 1.1 Descripción del Sistema
Votum es un sistema de votación electrónica desarrollado con Spring Boot que permite la creación y gestión de elecciones digitales con control de acceso basado en roles.

### 1.2 Propósito del Manual
Este documento proporciona información técnica detallada sobre la arquitectura, configuración, instalación y mantenimiento del sistema Votum.

### 1.3 Alcance
El sistema permite:
- Registro y autenticación de usuarios
- Creación y gestión de elecciones
- Asignación de votantes a elecciones específicas
- Control de acceso basado en roles (VOTER, ELECTION_ADMIN, ADMIN)

---

## 2. Arquitectura del Sistema

### 2.1 Stack Tecnológico
- **Backend Framework**: Spring Boot 3.5.5
- **Lenguaje**: Java 21
- **Base de Datos**: PostgreSQL
- **Seguridad**: Spring Security + JWT
- **ORM**: Spring Data JPA / Hibernate
- **Gestión de Dependencias**: Maven 3.9.11

### 2.2 Arquitectura en Capas
```
├── Controller Layer (API REST)
│   ├── AuthController
│   ├── EleccionController
│   └── UserController
├── Service Layer (Lógica de Negocio)
│   ├── EleccionService
│   ├── UserService
│   └── CustomUserDetailsService
├── Repository Layer (Acceso a Datos)
│   ├── UserRepository
│   ├── EleccionRepository
│   └── EleccionVotanteRepository
├── Security Layer
│   ├── JwtUtil
│   ├── JwtAuthFilter
│   └── SecurityConfig
└── Model Layer (Entidades)
    ├── User
    ├── Eleccion
    └── EleccionVotante
```

### 2.3 Diagrama de Componentes
```
Cliente (Frontend)
       ↓
   API REST
       ↓
Security Filter (JWT)
       ↓
   Controllers
       ↓
    Services
       ↓
  Repositories
       ↓
   PostgreSQL
```

---

## 3. Modelo de Datos

### 3.1 Entidades Principales

#### User (Usuario)
```java
- id: Long (PK)
- email: String (UNIQUE, NOT NULL)
- password: String (NOT NULL)
- enabled: boolean
- roles: Set<Role>
```

#### Eleccion (Elección)
```java
- id: Long (PK)
- titulo: String (NOT NULL)
- descripcion: String
- fechaInicio: LocalDateTime
- fechaFin: LocalDateTime
- estado: EstadoEleccion
- creador: User (FK)
```

#### EleccionVotante (Relación Many-to-Many)
```java
- id: Long (PK)
- eleccion: Eleccion (FK)
- votante: User (FK)
- haVotado: boolean
- fechaVoto: LocalDateTime
```

### 3.2 Enumeraciones

**Role**
- ROLE_ADMIN
- ROLE_VOTER
- ROLE_ELECTION_ADMIN

**EstadoEleccion**
- CREADA
- INACTIVA
- FINALIZADA

### 3.3 Diagrama Entidad-Relación

<img width="852" height="555" alt="Diagrama Entidad - Relación" src="https://github.com/user-attachments/assets/08940161-191d-4708-a230-63d76ffccd9e" />

---

## 4. Seguridad

### 4.1 Autenticación JWT
El sistema utiliza JSON Web Tokens (JWT) para la autenticación stateless.

**Flujo de Autenticación:**
1. Usuario envía credenciales (email/password) a `/api/auth/login`
2. Sistema valida credenciales con Spring Security
3. Si son válidas, genera un JWT firmado con HS256
4. Token incluye: email, roles, fechas de emisión/expiración
5. Cliente incluye token en header `Authorization: Bearer <token>`

**Configuración JWT:**
- Algoritmo: HS256
- Tiempo de expiración: 1800000 ms (30 minutos)
- Secret: Variable de entorno `JWT_SECRET`

### 4.2 Autorización por Roles

**Endpoints Públicos:**
- `POST /api/auth/register`
- `POST /api/auth/login`

**Endpoints Autenticados:**
- `POST /api/users/become-creator` - Cualquier usuario autenticado
- `POST /api/elections` - Requiere ROLE_ELECTION_ADMIN
- `GET /api/elections` - Requiere ROLE_ELECTION_ADMIN
- `POST /api/elections/{id}/votantes` - Requiere ROLE_ELECTION_ADMIN

### 4.3 CORS Configuration
Permite solicitudes desde:
- `http://localhost:5173` (Frontend en desarrollo)

Métodos permitidos: GET, POST, PUT, DELETE, OPTIONS

---

## 5. API REST

### 5.1 Endpoints de Autenticación

#### POST /api/auth/register
Registra un nuevo usuario con rol VOTER por defecto.

**Request Body:**
```json
{
  "email": "usuario@ejemplo.com",
  "password": "contraseña123"
}
```

**Respuestas:**
- 200: "User created"
- 400: "User already exists"

#### POST /api/auth/login
Autentica usuario y retorna JWT.

**Request Body:**
```json
{
  "email": "usuario@ejemplo.com",
  "password": "contraseña123"
}
```

**Respuestas:**
- 200: `{"token": "eyJhbGc..."}`
- 401: Credenciales incorrectas
- 403: Usuario deshabilitado
- 404: Usuario no encontrado

### 5.2 Endpoints de Usuario

#### POST /api/users/become-creator
Convierte un VOTER en ELECTION_ADMIN.

**Headers:**
```
Authorization: Bearer <token>
```

**Respuesta:**
```json
{
  "message": "Ahora eres creador de elecciones",
  "token": "nuevo_token_con_roles_actualizados"
}
```

### 5.3 Endpoints de Elecciones

#### POST /api/elections
Crea una nueva elección (requiere ROLE_ELECTION_ADMIN).

**Request Body:**
```json
{
  "titulo": "Elección de Presidente",
  "descripcion": "Elección presidencial 2025",
  "fechaInicio": "2025-12-01T08:00:00",
  "fechaFin": "2025-12-01T18:00:00"
}
```

#### GET /api/elections
Lista todas las elecciones del creador autenticado.

#### POST /api/elections/{id}/votantes
Agrega votantes a una elección.

**Request Body:**
```json
{
  "correos": [
    "votante1@ejemplo.com",
    "votante2@ejemplo.com"
  ]
}
```

**Validaciones:**
- El usuario debe ser el creador de la elección
- La elección debe estar en estado CREADA
- No debe haber iniciado

---

## 6. Instalación y Configuración

### 6.1 Requisitos Previos
- Java 21 o superior
- PostgreSQL 12 o superior
- Maven 3.9+
- Git

### 6.2 Clonar el Repositorio
```bash
git clone https://github.com/Eduar-bc/votum/
cd votum
```

### 6.3 Configuración de Variables de Entorno

Crear archivo `.env` en la raíz del proyecto:
```properties
DB_URL=jdbc:postgresql://localhost:5432/votum_db
DB_USERNAME=postgres
DB_PASSWORD=tu_password
JWT_SECRET=tu_clave_secreta_muy_larga_y_segura_minimo_256_bits
```

### 6.4 Configuración de Base de Datos

**Crear base de datos:**
```sql
CREATE DATABASE votum_db;
```

**Nota:** El sistema usa `spring.jpa.hibernate.ddl-auto=create-drop`, que recrea las tablas en cada inicio. Para producción, cambiar a `update` o `validate`.

### 6.5 Compilación y Ejecución

**Con Maven Wrapper (Linux/Mac):**
```bash
./mvnw clean install
./mvnw spring-boot:run
```

**Con Maven Wrapper (Windows):**
```cmd
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

**JAR ejecutable:**
```bash
./mvnw package
java -jar target/votum-0.0.1-SNAPSHOT.jar
```

### 6.6 Verificación de Instalación
```bash
curl http://localhost:8080/api/hello
```

---

## 7. Configuración Avanzada

### 7.1 Ajuste de Propiedades

**application.properties:**
```properties
# Puerto del servidor
server.port=8080

# Base de datos
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.open-in-view=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# JWT
app.jwt.secret=${JWT_SECRET}
app.jwt.expiration-ms=1800000

# Logging
logging.level.com.votum=DEBUG
logging.level.org.springframework.security=DEBUG
```

### 7.2 Configuración para Producción

**Cambios recomendados:**
```properties
# Deshabilitar recreación de esquema
spring.jpa.hibernate.ddl-auto=validate

# Deshabilitar SQL logging
spring.jpa.show-sql=false

# Incrementar expiración JWT (opcional)
app.jwt.expiration-ms=3600000

# Configurar CORS para dominio de producción
# Modificar SecurityConfig.java
```

---

## 8. Desarrollo y Extensión

### 8.1 Agregar Nuevo Endpoint

**1. Crear método en Controller:**
```java
@GetMapping("/mi-endpoint")
public ResponseEntity<?> miMetodo() {
    return ResponseEntity.ok("Respuesta");
}
```

**2. Configurar seguridad en SecurityConfig:**
```java
.requestMatchers("/api/mi-endpoint").hasRole("MI_ROL")
```

### 8.2 Agregar Nueva Entidad

**1. Crear clase en package model:**
```java
@Entity
@Getter @Setter
@Table(name = "mi_tabla")
public class MiEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // campos...
}
```

**2. Crear Repository:**
```java
public interface MiRepository extends JpaRepository<MiEntidad, Long> {
}
```

**3. Crear Service y Controller según necesidad**

### 8.3 Personalizar JWT

Modificar `JwtUtil.java` para agregar claims personalizados:
```java
.claim("miClaim", valor)
```

---

## 9. Pruebas

### 9.1 Ejecución de Tests
```bash
./mvnw test
```

### 9.2 Pruebas con Postman/cURL

**Registro:**
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email":"test@test.com","password":"pass123"}'
```

**Login:**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@test.com","password":"pass123"}'
```

**Crear Elección:**
```bash
curl -X POST http://localhost:8080/api/elections \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <TOKEN>" \
  -d '{"titulo":"Test","fechaInicio":"2025-12-01T08:00:00","fechaFin":"2025-12-01T18:00:00"}'
```

---

## 10. Mantenimiento

### 10.1 Monitoreo
- Revisar logs de aplicación regularmente
- Monitorear conexiones a base de datos
- Verificar espacio en disco

### 10.2 Respaldos
```bash
# Backup de PostgreSQL
pg_dump -U postgres votum_db > backup_$(date +%Y%m%d).sql

# Restauración
psql -U postgres votum_db < backup_YYYYMMDD.sql
```

### 10.3 Actualización de Dependencias
```bash
./mvnw versions:display-dependency-updates
./mvnw versions:use-latest-releases
```

---

## 11. Solución de Problemas

### 11.1 Error de Conexión a Base de Datos
**Síntoma:** `org.postgresql.util.PSQLException: Connection refused`

**Solución:**
- Verificar que PostgreSQL esté ejecutándose
- Comprobar credenciales en `.env`
- Verificar puerto (default: 5432)

### 11.2 Token JWT Inválido
**Síntoma:** 401 Unauthorized

**Solución:**
- Verificar que el token no haya expirado
- Comprobar formato: `Bearer <token>`
- Regenerar token haciendo login nuevamente

### 11.3 Error al Compilar
**Síntoma:** Error de compilación de Lombok

**Solución:**
```bash
./mvnw clean
./mvnw install
```

---

## 12. Glosario

- **JWT**: JSON Web Token - Estándar para autenticación stateless
- **JPA**: Java Persistence API - Especificación para ORM
- **ORM**: Object-Relational Mapping - Mapeo objeto-relacional
- **CORS**: Cross-Origin Resource Sharing - Compartir recursos entre orígenes
- **BCrypt**: Algoritmo de hash para passwords
- **DTO**: Data Transfer Object - Objeto de transferencia de datos

---

## 13. Contacto y Soporte

Para reportar problemas o solicitar ayuda:
- Crear issue en el repositorio
- Contactar al equipo de desarrollo

---

**Versión del documento:** 1.0  
**Fecha:** Noviembre 2025  
**Autor:** Equipo de Desarrollo Votum
