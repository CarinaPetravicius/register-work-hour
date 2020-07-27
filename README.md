# Register Work Hours

A Demo Spring Boot project with Clean Arch, Maven multi modules, Kotlin, JVM level 13, JPA, Actuator, Swagger, Postgres, Liquibase and Docker Compose. To start the project:

* Install openjdk 13 or larger.
* Install the last IntellinJ Commmunity version, to have the last version of Kotlin.
* Install Docker.
* Open the project, and set the jvm level compile do 13.
* Set the Kotlin Compile JVM level to 13.
* Execute the clean install in Maven.
* Start the spring boot project in RegisterWorkHourApplication.

1. Check Docker and Docker-compose

       docker -v
       docker-compose -v
     
2. Check OpenJdk 14 and maven 3

       java -version
       mvn -v
     
3. Execute Maven

       mvn clean install
       
4. Start the Postgres with docker-compose

       docker-compose up


# API Routes

| Method | URL                 | Functionality                      |
|--------|---------------------|------------------------------------|
| GET    | /actuator/health    | Spring actuator health check       | 
| GET    | /swagger-ui.html    | Endpoint with API documentation    | 
| POST   | /v1/employee        | Endpoint do create an employee     |
| GET    | /v1/employee        | Endpoint do get an active employee |
