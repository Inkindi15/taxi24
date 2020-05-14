# TAXI 24 REST API

> What am I  building?

I am  building an application,that will help the taxi industry in Rwanda to manage their fleet of drivers and allocate drivers to passengers. 

> What are the required features?

- View all Drivers
- View available Drivers
- View all available Drivers within a specific Location
- View a specific Driver
- Create a Trip
- Complete a Trip and create an invoice
- View all Trips
- View all active Trips
- View all Riders
- View a specific Rider
- View a list of the 3 closest drivers for a specific rider 


### API Endpoints

| Request Routes         | Methods |                            Description                                | Completed |
| :--------------------- | :-----: | -------------------------------------:                                | :-------: |
| /drivers                | GET     |user can view all drivers                                              |    Yes    |
| /drivers/available                 | GET     |View available Drivers                                         |    Yes    |
| /drivers/around?distance=3&longitude=30.094131&latitude=-1.956250                | GET     |user can View all available Drivers within a specific Location |    Yes    |
| /drivers/1                | GET    |user can View a specific Driver                                            |    Yes    |
| /trips?rider_id=1&driver_id=2&dest_lat=-1.943192&dest_long=30.058145                | POST    |user can create a Trip                                            |    Yes    |
| /trips/active                | GET     |user can view all active Trips                                       |    Yes    |
| /trips/1/complete                | PUT     |user can complete a Trip and view the created invoice                                       |    Yes    |
| /riders               | GET     |user can view all riders                                               |    Yes    |
| /riders               | POST     |user can create riders                                               |    Yes    |
| /riders/1                | GET     |user can view a specific rider                                                 |    Yes    |                  
| /riders/2/closest-drivers                | GET     |user can view a list of the 3 closest drivers for a specific rider                                                |    Yes    |                  



### Backend, Frameworks and other tools used

- Spring Boot
- JUnit

### Installation Guide   

To use this project locally you must install VS Code, then clone the project using

```
> git clone https://github.com/Inkindi15/taxi24.git
```

after cloning the project, you must install all the project dependencies using

```
> mvn compile
> mvn clean install
```

to test endpoints you will use a tool called postman.
and finally to run tests you can use

```
> mvn test
```

### Running the application locally

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
> mvn spring-boot:run
```

### Built With

 - Maven    Dependency Management.

 - git      Free and Open-Source distributed version control system.

 - Lombok   Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much  more.

### Packages

* **models** — to hold our entities;

* **repositories** — to communicate with the database;

* **services** — to hold our business logic

* **controllers** — to listen to the client;

## Contributor

Inkindi Umutoni Raissa Macrine [inkindiraissa@gmail.com](inkindiraissa@gmail.com)


## Copyright

Copyright (c) IURM 2020
