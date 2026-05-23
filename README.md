## What This Project Is

This is a backend-only authentication demo built with Spring Boot for `generic aplications`.
It currently handles:
- user registration
- user login
- JWT token generation
- JWT-based request authentication
- MySQL persistence for users

The public auth endpoints are under:

- `POST /api/auth/register`
- `POST /api/auth/login`

Everything outside `/api/auth/**` is protected by Spring Security and expects a valid JWT.

## Database

This demo uses **MySQL**.

Current datasource config:

- database: `LegoStore`
- url: `jdbc:mysql://localhost:3306/AUTHDEMO?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC`
- username: `AuthDemoBackend`
- driver: `com.mysql.cj.jdbc.Driver`

Important note:
- `spring.jpa.hibernate.ddl-auto=create` means the schema is recreated on startup.
- That is fine for a demo, but change to `update` if using it.

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
  To reduce boilerplate code like constructors, builders, and getters/setters.

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

1. MySQL is running locally
2. a database exists and its connected in application.properties
3. change `ddl-auto=create` to something safer for non-demo use
4. the user for the database exists and has access
5. the password in `application.properties` matches your local setup

Then run the app normally with Maven or from your IDE.


## Things To Clean Up Later

- remove FreeMarker dependencies and config
- update the project so it's even easier to get started.
- move secrets out of `application.properties`
