# courses-app

##Goal

This is a Spring Boot project that allows us to manage Students, Mentors and Courses through an user interface. 
Firstly, we need to add a few Courses, Students and Mentors. Then, we have the posibility to manipulate the data through CRUD fucntions.
The project uses Spring Boot, Spring Data JPA, JavaScript and HTML. The project is using an H2 embedded database, but you can connect it to a local database through the application.properties file.

##Dependencies and Technologies Used:
Spring Boot 2.2.0.BUILD-SNAPSHOT
Corresponding Spring Version 5.2.0.BUILD-SNAPSHOT
spring-boot-starter-web : Starter for building web, including RESTful, applications using Spring MVC. 
Uses Tomcat as the default embedded container.
spring-boot-starter-tomcat : Starter for using Tomcat as the embedded servlet container. 
Default servlet container starter used by spring-boot-starter-web.
tomcat-embed-jasper 9.0.21: Core Tomcat implementation.
com.fasterxml.jackson.core for executing json files

JDK 1.8
Maven 4.0.0
By default, the application listens on port 80 - http://localhost:8080

##Setup
To run this project you should clone or download the courses-app repository, import the project to your IDE and run it.
In order to have some data for testing, i included json files for each class (Courses, Mentors and Students) which will be executed once the application is running. 
