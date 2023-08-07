# Bonds Management Application

This repository contains our final capstone training project for a bond management system.


# Let's get the back-end running!


## Prerequisites


1.Download and Install OpenJDK 13 ([OpenJDK](http://jdk.java.net/java-se-ri/13)). For installation instructions, refer this [link](https://www.codejava.net/java-se/download-and-install-jdk-13-openjdk-and-oracle-jdk)

Make sure following Environment Variables are defined:

	JAVA_HOME = G:\JDK\OpenJDK\jdk-13
	
	PATH = %JAVA_HOME%\bin;…

2.Download and Install ([Maven](https://maven.apache.org/install.html))

   
# Getting Started
In this project, we build a Spring Boot Rest CRUD API with Maven that use Spring Data JPA to interact with MySQL/H2 database. 

# Project Flow

![This is an image](Business-Service-Controller-and-Repository.jpg)

# Database 

H2 is an open-source lightweight Java database. It can be embedded in Java applications or run in the client-server mode

**Data**

To populate data into tables, we have used data.sql which has insert statements.

	java-api\src\main\resources\data.sql

**Database Connection Details**

Connection details are mentioned in the application.properties 

	java-api\src\main\resources\application.properties


# Steps to run the project on local machine

Git clone the code to local machine

	DELL@DESKTOP-ORE3T13 MINGW64 /c/DEV/GITHUB/project-arrakis/skeleton/java-api (java-skeleton)
	$ pwd
	/c/DEV/GITHUB/project-arrakis/skeleton/java-api

To run the maven project use following mvn command

	DELL@DESKTOP-ORE3T13 MINGW64 /c/DEV/GITHUB/project-arrakis/skeleton/java-api (java-skeleton)
	$ mvn clean spring-boot:run

**Once project is running :**

**REST API are exposed as:**

	http://localhost:8080/api/v1/<endpoint>

![REST API](REST_API_URL.PNG)

**H2 Database Console:**

	http://localhost:8080/h2-console
	


**Swagger Console**

Swagger2 is an open source project used to generate the REST API documents for RESTful web services. It provides a user interface to access our RESTful web services via the web browser. 

You also test the APIs using this.
	

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#boot-features-developing-web-applications)
