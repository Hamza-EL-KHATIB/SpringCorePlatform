# ✨ Spring Boot RESTful API Showcase ✨

> *"Good code is its own best documentation."* — But great projects deserve a README that sparks joy!

Welcome to this vibrant demonstration of Spring Boot RESTful API development! This project showcases a secure,
well-structured API with user authentication, city management, and file handling capabilities—all wrapped in a
developer-friendly package.

![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.6.3-green.svg)
![Java](https://img.shields.io/badge/Java-8-orange.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue.svg)
![JWT](https://img.shields.io/badge/JWT-Authentication-purple.svg)
![Swagger](https://img.shields.io/badge/Swagger-Documentation-black.svg)

## 🚀 60-Second Quickstart

Get up and running in less than a minute:

1. Clone → `git clone https://github.com/your-username/spring-boot-restful-api.git`
2. Start PostgreSQL → `docker-compose up -d`
3. Run → `./mvnw spring-boot:run`
4. Explore API → `http://localhost:8080/swagger-ui/index.html`

✨ Boom! You're running a fully-secured RESTful API!

---

## 🌟 Project Overview

This project demonstrates a modern Spring Boot application with a layered architecture, secure authentication, and a
clean approach to API design. It's built to showcase best practices in Java backend development while providing
practical functionality.

```
🌱 From Backend Developer to Backend Developer

This project grew from my own journey learning Spring Boot's best practices.
Each feature represents a solution to challenges I faced while building real-world
applications. I hope it helps your journey too!
```

## ✨ Features

- 🔐 **JWT Authentication & Authorization**: Secure user login and role-based access
- 👤 **User Management**: Complete CRUD operations with data validation
- 🏙️ **City Management**: CSV data loading and database storage
- 📁 **File Uploads**: Secure file storage with validation
- 📝 **Swagger Documentation**: Auto-generated API documentation
- 🐳 **Docker Integration**: Containerized PostgreSQL database
- 🧪 **Unit Testing**: Test coverage for service layer
- ⚙️ **Graceful Error Handling**: Consistent error responses

## 🌈 Architecture Overview

![Editor _ Mermaid Chart-2025-03-24-113900.png](assets/img/Editor%20_%20Mermaid%20Chart-2025-03-24-113900.png)

## 🛠️ Technology Stack


### Backend Framework

- Spring Boot 2.6.3
- Java 8
- Spring Data JPA

### Security

- Spring Security
- JWT (io.jsonwebtoken:jjwt:0.9.1)
- BCrypt password encoding

### Database

- PostgreSQL
- Hibernate ORM
- Docker containerization
- pgAdmin for database management

### Development Tools

- Maven
- Lombok
- Spring DevTools
- JUnit & Mockito for testing
- Swagger/Springfox for API documentation

### API Features

- REST controllers
- DTO pattern
- Exception handling
- Clean Java implementation

## 🎓 Learning Pathways

Explore the codebase based on what you want to learn:

| If you want to learn about... | Start by exploring...                                                                      |
|-------------------------------|--------------------------------------------------------------------------------------------|
| JWT Authentication            | 1. `WebSecurity.java` <br> 2. `AuthenticationFilter.java` <br> 3. `SecurityConstants.java` |
| REST Controller Design        | 1. `UserController.java` <br> 2. `CityController.java`                                     |
| Exception Handling            | 1. `AppExceptionHandler.java` <br> 2. `UserServiceException.java`                          |
| Data Persistence              | 1. `UserEntity.java` <br> 2. `UserRepository.java` <br> 3. `UserServiceImpl.java`          |
| File Handling                 | 1. `FileServiceImpl.java` <br> 2. `CityController.java` (upload endpoint)                  |
| DTO Pattern                   | 1. `UserDto.java` <br> 2. `CityDto.java`                                                   |

## 🚀 Getting Started

### Prerequisites

- Java 8 JDK
- Docker & Docker Compose
- Maven
- IDE (IntelliJ IDEA recommended)

### Setup Steps

  <summary>1. Clone the repository</summary>

  ```bash
  git clone https://github.com/yourusername/spring-boot-restful-showcase.git
  cd spring-boot-restful-showcase
  ```

  <summary>2. Start the PostgreSQL database</summary>

  ```bash
  docker-compose up -d
  ```

This will start:

- PostgreSQL on port 5432
- pgAdmin on port 5050 (access at http://localhost:5050)
    - Email: pgadmin4@pgadmin.org
    - Password: admin


  <summary>3. Build and run the application</summary>

  ```bash
  ./mvnw spring-boot:run
  ```

The application will start on port 8080.

  <summary>4. Access the Swagger UI</summary>

Open your browser and navigate to:

  ```
  http://localhost:8080/swagger-ui/index.html
  ```

Here you can explore and test all available API endpoints.

## 📊 API Endpoints

  <summary>🔍 View detailed API endpoints</summary>

![Editor _ Mermaid Chart-2025-03-24-113924.png](assets/img/Editor%20_%20Mermaid%20Chart-2025-03-24-113924.png)

### Authentication Endpoints

- **POST /users** - Register a new user
    - Body: `{ "firstName": "John", "lastName": "Doe", "email": "john@example.com", "password": "securePassword" }`
    - Returns: User details with userId

- **POST /users/login** - Authenticate and receive JWT token
    - Body: `{ "email": "john@example.com", "password": "securePassword" }`
    - Returns: JWT token in Authorization header

### User Management Endpoints

- **GET /users/{userId}** - Retrieve user by ID
    - Returns: User details

- **PUT /users/{userId}** - Update user information
    - Body: `{ "firstName": "John", "lastName": "Smith" }`
    - Returns: Updated user details

- **DELETE /users/{userId}** - Delete a user
    - Returns: Operation status

- **GET /users?page=0&limit=25** - Get paginated list of users
    - Returns: Array of users

### City Management Endpoints

- **GET /city** - Get all cities
    - Returns: Array of city data

- **POST /city/newCity** - Add a new city
    - Body: `{ "latD": "41", "ns": "N", "longD": "80", "ew": "W", "city": "Youngstown", "state": "OH" }`
    - Returns: Saved city details

- **POST /city/newRandomCity** - Generate and add a random city
    - Returns: Generated city details

- **POST /city/upload** - Upload city data file
    - Form-data: `file=@your_file.csv`
    - Returns: Upload status message

## 🔐 Authentication Flow

  <summary>View authentication sequence diagram</summary>

![Editor _ Mermaid Chart-2025-03-24-113942.png](assets/img/Editor%20_%20Mermaid%20Chart-2025-03-24-113942.png)

## 🗃️ Project Structure


```
com.springcoreplatform
├── RestApplication.java                  # Main application entry point
├── SpringApplicationContext.java         # Application context for dependency injection
├── SwaggerConfig.java                    # Swagger documentation configuration
│
├── exceptions                            # Exception handling
│   ├── AppExceptionHandler.java          # Global exception handler
│   └── UserServiceException.java         # Custom service exceptions
│
├── io                                    # Data access layer
│   ├── entity                            # JPA entities
│   │   ├── CityEntity.java
│   │   ├── FileEntity.java
│   │   └── UserEntity.java
│   └── repositories                      # Spring Data repositories
│       ├── CityRepository.java
│       └── UserRepository.java
│
├── presentationlayer                     # Controller layer
│   ├── controller                        # REST controllers
│   │   ├── CityController.java
│   │   └── UserController.java
│   └── model                             # Request/Response models
│       ├── request
│       │   ├── UserDetailsRequestModel.java
│       │   └── UserLoginRequestModel.java
│       └── response
│           ├── ErrorMessage.java
│           ├── ErrorMessages.java
│           ├── FileUploadResponseMessage.java
│           ├── OperationStatusModel.java
│           ├── RequestOperationName.java
│           ├── RequestOperationStatus.java
│           └── UserRest.java
│
├── security                              # Security configuration
│   ├── AppProperties.java                # Application properties
│   ├── AuthenticationFilter.java         # JWT authentication filter
│   ├── AuthorizationFilter.java          # JWT authorization filter
│   ├── SecurityConstants.java            # Security constants
│   └── WebSecurity.java                  # Spring Security configuration
│
├── service                               # Service layer interfaces
│   ├── CityService.java
│   ├── FileService.java
│   ├── UserService.java
│   └── impl                              # Service implementations
│       ├── CityServiceImpl.java
│       ├── FileServiceImpl.java
│       └── UserServiceImpl.java
│
└── shared                                # Shared utilities
    ├── Utils.java                        # Utility methods
    └── dto                               # Data transfer objects
        ├── CityDto.java
        └── UserDto.java
```


## 💡 Development Insights & Best Practices

This project demonstrates several Spring Boot best practices:

### 🧠 Layered Architecture

The application follows a clean separation of concerns with distinct layers:

- **Controllers** handle HTTP requests/responses
- **Services** implement business logic
- **Repositories** manage data persistence
- **DTOs** transfer data between layers
- **Entities** map to database tables

### 🔒 Security Implementation

The JWT implementation provides:

- Stateless authentication
- Token-based authorization
- Password encryption with BCrypt
- Protection against common web vulnerabilities

### 🧩 Code Quality Features

- **Lombok** reduces boilerplate code
- **Exception handling** provides consistent error responses
- **Unit testing** ensures code reliability
- **DTO pattern** provides clean data transfer
- **Consistent Java style** throughout the codebase

## 🚨 What Could Be Improved

<details>

After analyzing the codebase, here are some potential improvements:

### Security Updates

- **Dependency Versions**: Spring Boot 2.6.3 and JJWT 0.9.1 have known vulnerabilities. Upgrade to newer versions.
- **Token Refresh**: Implement refresh token mechanism for better security.
- **CORS Configuration**: Add proper CORS handling for cross-domain requests.

### Architecture Improvements

- **Transaction Management**: Add @Transactional annotations to service methods.
- **Validation**: Implement more robust input validation using Bean Validation.
- **API Versioning**: Consider implementing API versioning for future compatibility.

### Testing Enhancements

- **Controller Tests**: Add integration tests for REST controllers.
- **Test Coverage**: Implement test coverage reporting with JaCoCo.
- **Boundary Testing**: Add tests for edge cases and error scenarios.

### Other Enhancements

- **Logging**: Implement structured logging with SLF4J.
- **Caching**: Add caching for frequently accessed data.
- **Documentation**: Add more detailed Swagger annotations.
- **Monitoring**: Integrate Spring Actuator for health and metrics.

</details>

## 🧪 Testing Your Application


  <summary>View testing guide and examples</summary>

The project includes unit tests for the service layer. To run tests:

```bash
./mvnw test
```

### Example Test

```java

@Test
void getUser_UserEntityNotNull() {
    // Setup test data
    UserEntity userEntity = new UserEntity();
    userEntity.setUserId("654");
    userEntity.setEmail("a@a.a");
    userEntity.setFirstName("John");
    userEntity.setLastName("Doe");
    userEntity.setEncryptedPassword("123");

    // Mock repository response
    Mockito.when(userRepository.findByEmail(anyString()))
            .thenReturn(userEntity);

    // Call service method
    UserDto userDto = userServiceImpl.getUser("a@a.a");

    // Verify results
    assertNotNull(userDto);
    assertEquals(userEntity.getUserId(), userDto.getUserId());
}
```

### Test Coverage

For comprehensive testing:

1. **Unit Tests**: Test individual components in isolation
2. **Integration Tests**: Test interactions between components
3. **API Tests**: Test endpoints using MockMvc or REST Assured
4. **Security Tests**: Verify authentication and authorization

### Test Best Practices

- Use meaningful test names that describe the scenario
- Follow the Arrange-Act-Assert pattern
- Test both happy paths and error cases
- Use annotations like @MockBean for Spring context


## 🌐 Docker Integration


The project uses Docker Compose to set up:

1. A PostgreSQL database
2. pgAdmin for database management

### Docker Compose File

```yaml
services:
  postgres:
    container_name: api-postgres
    image: postgres:16-alpine
    restart: unless-stopped
    environment:
      POSTGRES_PASSWORD: ${DB_PASSWORD:-password}
      POSTGRES_USER: ${DB_USER:-helk}
      POSTGRES_DB: rest_api_db
      PGDATA: /var/lib/postgresql/data
    volumes:
      - postgres_data:/var/lib/postgresql/data
      - ./init-scripts:/docker-entrypoint-initdb.d
    ports:
      - "5432:5432"
    networks:
      - backend
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U ${DB_USER:-helk} -d rest_api_db"]
      interval: 10s
      timeout: 5s
      retries: 5
      start_period: 10s
    deploy:
      resources:
        limits:
          cpus: '1'
          memory: 1G

  pgadmin:
    container_name: api-pgadmin
    image: dpage/pgadmin4:latest
    restart: unless-stopped
    environment:
      PGADMIN_DEFAULT_EMAIL: ${PGADMIN_EMAIL:-admin@example.com}
      PGADMIN_DEFAULT_PASSWORD: ${PGADMIN_PASSWORD:-admin}
      PGADMIN_CONFIG_SERVER_MODE: 'False'
    volumes:
      - pgadmin_data:/var/lib/pgadmin
    ports:
      - "5050:80"
    networks:
      - backend
    depends_on:
      postgres:
        condition: service_healthy
    deploy:
      resources:
        limits:
          cpus: '0.5'
          memory: 500M

networks:
  backend:
    driver: bridge
    name: api_backend_network
    ipam:
      driver: default
      config:
        - subnet: 172.28.0.0/16

volumes:
  postgres_data:
    name: api_postgres_data
  pgadmin_data:
    name: api_pgadmin_data
```

### Database Connection

The application connects to PostgreSQL using the following properties (from application.yml):

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/rest_api_db?useSSL=false&allowMultiQueries=true&serverTimezone=UTC
    username: helk
    password: password
  jpa:
    hibernate:
      ddl-auto: create
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
```

### Using pgAdmin

1. Access pgAdmin at http://localhost:5050
2. Login with:
    - Email: admin@example.com
    - Password: admin
3. Add a new server connection:
    - Host: postgres
    - Port: 5432
    - Username: helk
    - Password: password


## 🔍 Future Enhancements

Potential features to consider adding:

1. **OAuth2 Integration**: For third-party authentication
2. **API Rate Limiting**: To prevent abuse
3. **Caching Layer**: For improved performance
4. **Event-Driven Architecture**: Using Spring Events
5. **Microservices Transformation**: Breaking down into smaller services
6. **CI/CD Pipeline**: For automated testing and deployment
7. **Monitoring & Metrics**: With Spring Actuator and Prometheus
8. **Internationalization**: For multi-language support

## 📚 Learning Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Security Guide](https://docs.spring.io/spring-security/reference/index.html)
- [JWT Authentication Tutorial](https://www.bezkoder.com/spring-boot-jwt-authentication/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

⭐ If you find this project helpful, please consider giving it a star on GitHub! ⭐

---

<div align="center">

### 💡 Design Philosophy

**Simplicity is the ultimate sophistication.**  
Great code feels intuitive, like it couldn't have been written any other way.

**Make complexity feel effortless.**  
The best systems hide their complexity behind clean, expressive interfaces.

**Tell a story through every interaction.**  
Your API should guide users through a journey that feels natural and delightful.

</div>
