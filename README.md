# Sistema de Gestión de Pedidos

## Instalación y Ejecución
## 1. Pasos con Docker
### 1.1 Clona el repositorio
```bash
  git clone https://github.com/redox11223/patronesSustiBackend
```

### 1.2 Ejecución de la aplicacion
Las imagenes tanto del frontend como el backend estan subidas a Docker Hub, el archivo docker-compose
indica los pasos , la descarga de las imagenes, la ejecucion y comunicacion de los contenedores
. Con el siguiente comando podras ejecutar la aplicacion.
```bash
  docker-compose up -d
```

### 1.3 Ingresa desde el navegador a la siguiente Url:
```bash
  http://localhost:80
```

### 1.4 Usa estas credenciales para probar el sistema
```bash
  "Nombre de usuario": "admin",
  "Contraseña": "admin123"
```

## 2. Instalacióm Normal
### 2.1. Clonar el repositorio

```bash
  git clone https://github.com/redox11223/patronesSustiBackend
```

### 2.2. Configurar la Base de Datos

 Crea la base de datos PostgreSQL en Dbeaver o similar:

```sql
CREATE DATABASE susti;
```

### 2.3 Configurar las credenciales:

Edita el archivo `src/main/resources/application.properties` con tus credenciales de PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5436/susti
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 2.4. Compilar el proyecto

```bash
 ./mvnw clean install
```

### 2.5. Ejecución

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
 
