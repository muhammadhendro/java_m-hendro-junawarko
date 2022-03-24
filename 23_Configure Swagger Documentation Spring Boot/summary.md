# (23) Configure Swagger Documentation Spring Boot

## Resume
Dalam materi ini, mempelajari:
1. API Documentation
2. Swagger

### API Documentation
Konten teknis yang mendokumentasikan API. mencakup petunjuk tentang cara menggunakan dan mengintegrasikan API secara efektif. juga menyediakan pembaruan pada API seperti versi baru. Beberapa aspek dokumentasi API dapat dibuat secara otomatis melalui Swagger atau dokumen lainnya

### Swagger
- OpenAPI specification
- Open Source
- Great API Docs UI for Frontend or mobile developer

### OpenAPI Specification
standar untuk mendefinisikan interface RESTful. OAS memungkinkan pengembang untuk merancang technology-agnostic API interface yang menjadi dasar pengembangan dan konsumsi API.

#### Swagger Dependencies
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>3.0.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

```

#### Swagger Configuration
```java
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}
```

## Task
### 1. Problem 1
Pada task ini, mengimplementasikan CRUD pada spring dan mengintegrasikan dengan Swagger untuk API

[Task.txt](./praktikum/alterra.txt)

output:

![Problem 1](./screenshots/1.PNG)






