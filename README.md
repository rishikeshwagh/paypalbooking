# bookingserv

## Application Overview
bookingserv is a spring boot rest application which would provide the CRUD operations for `Booking` resource.

There are two modules in this application
- bookingservApi - This module contains the interface.
    - `v1/schema/booking.json` defines the booking resource.
    - `jsonschema2pojo-maven-plugin` is being used to create `Booking POJO` from json file. For more details on plugin please refer `https://github.com/joelittlejohn/jsonschema2pojo#readme`
    - `BookingResource.java` is the interface for CRUD operations on `Booking` resource.
        - POST `/v1/bfs/booking` endpoint defined to create the resource.
- bookingservImplementation - This module contains the implementation for the rest endpoints.
    - `BookingResourceImpl.java` implements the `BookingResource` interface.

## How to run the application
- Please have Maven version `3.3.3` & Java 8 on your system.
- Use command `mvn clean install` to build the project.
- Use command `mvn spring-boot:run` from `bookingservImplementation` folder to run the project.
- Use postman or curl to access `http://localhost:8080/v1/bfs/booking` POST or GET endpoint.
