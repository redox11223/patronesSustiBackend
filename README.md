# Sistema de Gestión de Pedidos

## Instalación

### 1. Clonar el repositorio

```bash
  git clone https://github.com/redox11223/patronesSustiBackend
```

### 2. Configurar la Base de Datos

#### Crear la base de datos PostgreSQL en Dbeaver o similar:

```sql
CREATE DATABASE susti;
```

#### Configurar las credenciales:

Edita el archivo `src/main/resources/application.properties` con tus credenciales de PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5436/susti
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 4. Compilar el proyecto

```bash
 ./mvnw clean install
```

## Ejecución

```bash
 ./mvnw spring-boot:run
```

La aplicación se ejecutará en: `http://localhost:8080`

## Uso de la API

### 1. Autenticación

#### Login

Obtén un token JWT para acceder a los endpoints protegidos:

**Endpoint:** `POST /public/login`

**Body:**

```json
{
  "username": "admin",
  "password": "admin123"
}
```

**Respuesta:**

```json
{
  "token": "eyJh........"
}
```

### 2. Usar el Token

Para acceder a endpoints protegidos, incluye el token en el header de autorización:

```
Authorization: Bearer <token-jwt>
```

### 3. Endpoints Principales para Probar

#### Usuarios

- `POST /api/usuarios` - Crear nuevo usuario

#### Pedidos

- `GET /api/pedidos` - Listar pedidos (en este caso solo es uno por temas de simplicidad)
- `POST /api/pedidos` - Crear nuevo pedido
- `PUT /api/pedidos/{id}/cancelar` - Cancelar pedido

#### Precios

- `GET /api/precio` - Obtiene la configuración actual de precios
- `PUT /api/precio` - Actualiza la configuración de precios
 
