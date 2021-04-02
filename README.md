# Music Video Meta Data API

The project uses Spring Boot 2.3.9 with Java 11

Used Spring Modules, Frameworks & Tools in the Project are:
* Spring Data
* Spring Web
* H2 In Memory DB
* Lombok
* MapStruct
* SpringDoc for API documentation
* Swagger3

Project supports custom exception handling to build rest compatible exception messages.

Business logic is heavily handled in MusicVideoService class. That class also includes meta-data validations such as
release year validation, genre name validation etc. that are specified in documentation.

**data.sql** file in the root of the project is used to initialize Genre data at startup automatically.

**Rest API Definition** can be found at:
http://localhost:8080/swagger-ui.html

To test the API, a **postman collection** is provided under the root folder of the project named: 
MusicVideoAPI.postman_collection.json
