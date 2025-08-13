# Inventory Management API

Inventory management system developed with Spring Boot, implementing hexagonal architecture.

## 📋 General Information

- **Project Name**: Inventory Management API
- **Version**: 1.0.0
- **Port**: 8082
- **Database**: H2 (In-memory)
- **Java Version**: 21
- **Spring Boot Version**: 3.5.4

## 🛠️ Technologies Used

- **Framework**: Spring Boot 3.5.4
- **Database**: H2 Database (In-memory)
- **API Documentation**: SpringDoc OpenAPI (Swagger)
- **Mapping**: MapStruct
- **Validation**: Bean Validation
- **Architecture**: Hexagonal
- **Containerization**: Docker

## 📁 Project Structure

```
inventory/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/challenge/inventory/
│   │   │       ├── InventoryApplication.java
│   │   │       ├── application/               # Application layer
│   │   │       │   ├── dto/
│   │   │       │   │   ├── request/
│   │   │       │   │   └── response/
│   │   │       │   ├── handler/
│   │   │       │   └── mapper/
│   │   │       ├── domain/                   # Business logic
│   │   │       │   ├── api/
│   │   │       │   ├── enums/
│   │   │       │   ├── model/
│   │   │       │   ├── spi/
│   │   │       │   └── usecase/
│   │   │       └── infrastructure/           # Adapters
│   │   │           ├── adapters/
│   │   │           │   ├── jpa/
│   │   │           │   │   ├── entity/
│   │   │           │   │   ├── mapper/
│   │   │           │   │   └── repository/
│   │   │           │   └── rest/
│   │   │           └── configuration/
│   │   └── resources/
│   │       └── application.yml
│
├── build/
    └── libs/                                 # Generated JARs
```

## 🚀 Execution Instructions

### Prerequisites

- Java 21 JDK
- Docker

### Option 1: Docker Execution

1. **Build the project with Gradle**
   ```bash
   ./gradlew build
   ```

2. **Build Docker image**
   ```bash
   docker build -t spring-boot-api .
   ```

3. **Run the container**
   ```bash
   docker run -p 8082:8082 spring-boot-api
   ```

### Option 2: Local Execution (Without Docker)

1. **Build and run directly**
   ```bash
   ./gradlew bootRun
   ```

2. **Or build JAR and execute**
   ```bash
   ./gradlew build
   java -jar build/libs/inventory-0.0.1-SNAPSHOT.jar
   ```

## 🌐 Application Access

Once the application is running, you can access:

### Swagger UI (API Documentation)
```
http://localhost:8082/swagger-ui/index.html
```

### API Documentation
Complete API documentation is available in Swagger UI with interactive examples and data schemas.

### Main Endpoints

**Base URL**: `http://localhost:8082/api`

#### Users (`/users`)
- `POST /api/users` - Create user
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `GET /api/users/username/{username}` - Get user by username
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Health Check
```
http://localhost:8082/actuator/health
```

## 📊 Technical Features

### Database
- **Type**: H2 (In-memory) - Only accessible from the application
- **Recreation**: Database is recreated on each startup (`ddl-auto: create-drop`)
- **Connection pool**: Maximum 10 connections (HikariCP)
- **Note**: Data persists only during application execution

### Logging
- **Log level**: DEBUG for main package
- **SQL**: Enabled with formatting

### Hexagonal Architecture
The project implements hexagonal architecture with clear layer separation:

**Domain (Core)**:
- `model/`: Domain entities (User)
- `api/`: Input ports (UserServicePort)
- `spi/`: Output ports (UserPersistencePort)
- `usecase/`: Business logic (UserUseCase)
- `enums/`: Domain enumerations (Role)

**Application (Use Cases)**:
- `dto/`: Data transfer objects
- `handler/`: Use case coordinators
- `mapper/`: Transformers between DTOs and models

**Infrastructure (Adapters)**:
- `adapters/rest/`: REST controllers
- `adapters/jpa/`: JPA/Hibernate persistence
- `configuration/`: Bean and dependency configuration

## 🔍 Usage Examples

### Create a User
```bash
curl -X POST http://localhost:8082/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_doe",
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@example.com"
  }'
```

### Get All Users
```bash
curl http://localhost:8082/api/users
```

### Update User
```bash
curl -X PUT "http://localhost:8082/api/users/{id}?firstName=John&lastName=Smith"
```

## 🐳 Useful Docker Commands

### View running containers
```bash
docker ps
```

### Stop container
```bash
docker stop <container_id>
```

### View container logs
```bash
docker logs <container_id>
```

### Remove image
```bash
docker rmi spring-boot-api
```

## 🛠️ Development

### Rebuild after changes
```bash
./gradlew build
docker build -t spring-boot-api .
docker run -p 8082:8082 spring-boot-api
```

## 📝 Additional Notes

- The application uses an H2 in-memory database, so all data is lost on restart
- Port 8082 must be available on your system
- Swagger documentation is automatically generated based on controllers
- MapStruct automatically generates mapper implementations during compilation

## ❓ Troubleshooting

### Port 8082 occupied
```bash
# Windows
netstat -ano | findstr :8082
taskkill /PID <PID> /F

# Linux/Mac
lsof -ti:8082 | xargs kill -9
```