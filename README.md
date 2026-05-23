## What This Project Is

This is a backend-only authentication demo built with Spring Boot for `generic applications`.

It currently handles:
- user registration
- user login
- JWT token generation
- JWT-based request authentication
- MySQL persistence for users

The public auth endpoints are:

- `POST /api/auth/register`
- `POST /api/auth/login`

Everything outside `/api/auth/**` is protected by Spring Security and requires a valid JWT.


## Dependencies Used

Main dependencies in this project:

- `spring-boot-starter-security`  
  For authentication, authorization, and password encoding.

- `spring-boot-starter-data-jpa`  
  For database access through JPA/Hibernate.

- `spring-boot-starter-webmvc`  
  For REST controllers and HTTP endpoints.

- `mysql-connector-j`  
  For connecting the app to MySQL.

- `lombok`  
  To reduce boilerplate code such as constructors, builders, and getters/setters.

- `mapstruct`  
  For DTO/entity mapping.

- `jjwt-api`, `jjwt-impl`, `jjwt-jackson`  
  For creating and parsing JWT tokens.

- `swagger-annotations`  
  For endpoint documentation annotations.

- `springdoc-openapi-starter-webmvc-ui`  
  For OpenAPI / Swagger UI support.

- `spring-boot-devtools`  
  For local development convenience.

## How To Run This

Before starting the app, make sure:

1. MySQL is running locally.
2. Make sure the database it's set up in application.properties.

Then run the app normally with Maven or from your IDE.

## Example `application.properties`

```properties
spring.datasource.url=jdbc:mysql://your host:3306/your database?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=your user
spring.datasource.password=your password

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Things To Clean Up Later

- remove FreeMarker dependencies and config
- update the project so it is even easier to get started
- move secrets out of `application.properties`
