# TAXI 24 REST API

> What am i  building?

I am  building an application,that will help the taxi industry in Rwanda to manage their fleet of drivers and allocate drivers to passengers. 

> What are the required features?

- View all Drivers
- View available Drivers
- View all available Drivers within a specific Location
- View a specific Driver's ID
- Create a Trip case
- View all Trips's Status
- View all Riders
- View a specific Rider's ID


# API Endpoints

| Request Routes         | Methods |                            Description                                | Completed |
| :--------------------- | :-----: | -------------------------------------:                                | :-------: |
| /cases/                | GET     |user can view all drivers                                              |    Yes    |
| /cases                 | GET     |user can view driver's status within a specific loaction               |    Yes    |
| /cases                 | GET     |user can view  all driver's ID                                         |    Yes    |
| /cases/                | GET     |user can view all available drivers within 3km for a specific location |    Yes    |
| /cases/                | POST    |user can create a Trip case                                            |    Yes    |
| /cases/                | PUT     |user can update the Trip case                                          |    Yes    |
| /cases/                | GET     |user can view all Trip's status                                        |    Yes    |
| /cases/                | GET     |user can view all riders                                               |    Yes    |
| /cases/                | GET     |user can view rider'ID                                                 |    Yes    |                  



# API Documentation

[Documentation link]()

# Backend, Frameworks and other tools used

- Spring Boot
- JUnit

# Installation Guide   

To use this project locally you must install VS Code, then clone the project using

```
> git clone https://github.com/Inkindi15/taxi24
```

after cloning the project, you must install all the project dependencies using

```
> mvn compile
> mvn clean install
```

after that you are good to go, run the project as follows

```
> mvn exec:java -Dexec.mainClass=com.mycompany.App     
```

to test endpoints you will use a tool called postman.
and finally to run tests you can use

```
>mvn test
```

# Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the
 com.arc.sbtest.SBtemplateApplication  class from your IDE.

Download the zip or clone the Git repository.

Unzip the zip file (if you downloaded one)

Open Command Prompt and Change directory (cd) to folder containing pom.xml

Open VSCODE
File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
Select the project
Choose the Spring Boot Application file (search for @SpringBootApplication)
Right Click on the file and Run as Java Application
Alternatively you can use the Spring Boot Maven plugin like so:

```
>mvn spring-boot:run
```

#Built With

 -Maven    Dependency Management.

 -git      Free and Open-Source distributed version control system.

 -Lombok   Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much  more.
 
 -Swagger  Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

#Packages

models — to hold our entities;

repositories — to communicate with the database;

services — to hold our business logic

controllers — to listen to the client;

### Contributor

Inkindi Umutoni Raissa Macrine [inkindiraissa@gmail.com](inkindiraissa@gmail.com)


### Copyright

Copyright (c) IURM 2020
