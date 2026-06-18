# Book Management API

A RESTful Backend Application built using Spring Boot and MySQL for managing books.

## Features

- Create Book
- Get All Books
- Get Book By Id
- Update Book
- Delete Book
- Search Book By Title
- Search Book By Category
- Pagination
- Sorting
- Validation
- Global Exception Handling
- Swagger/OpenAPI Documentation
- Logging

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger/OpenAPI

## Project Structure

```
src/main/java
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── config
```

## API Endpoints

### Create Book

```http
POST /api/books
```

### Get All Books

```http
GET /api/books
```

### Get Book By Id

```http
GET /api/books/{id}
```

### Update Book

```http
PUT /api/books/{id}
```

### Delete Book

```http
DELETE /api/books/{id}
```

### Search By Title

```http
GET /api/books/title/{title}
```

### Search By Category

```http
GET /api/books/category/{category}
```

### Pagination

```http
GET /api/books/page?page=0&size=5
```

### Sorting

```http
GET /api/books/sort?field=price
```

## Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE bookdb;
```

Configure `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Swagger Documentation

After starting the application:

```text
http://localhost:8080/swagger-ui/index.html
```

## How to Run

Clone the repository:

```bash
git clone <repository-url>
```

Move into project:

```bash
cd book-management-api
```

Run:

```bash
mvn spring-boot:run
```

## Future Enhancements

- JWT Authentication
- Spring Security
- Role Based Authorization
- Docker Support
- Unit Testing
- CI/CD Pipeline

## Author

Harsh
