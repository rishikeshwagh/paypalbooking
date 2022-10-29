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

## Assignment
We would like you to enhance the existing project and see you complete the following requirements:

- `booking.json` has only `name`, and `id` elements. Please add `date of birth`, `checkin_datetime`, `checkout_datetime`, `totalprice`, `deposit` and `address` elements to the `Booking` resource. Address will have `line1`, `line2`, `city`, `state` and `zip_code` elements. `line2` is an optional element.
- Add one more operation in `BookingResource` to Get All the bookings. `BookingResource` will have two operations, one to create, and another to retrieve all bookings.
- Implement create and get all the bookings operations in `BookingResourceImpl.java`.
- Please add the unit tests to validate your implementation.
- Please use h2 in-memory database or any other in-memory database to persist the `Booking` resource. Dependency for h2 in-memory database is already added to the parent pom.
- Please make sure the validations done for the requests.*
- Response codes are as per rest guidelines.
- Error handling in case of failures.
- Implement idempotency logic to avoid duplicate resource creation.*

## Assignment submission
Thank you very much for your time to take this test. Please upload this complete solution in Github and send us the link to `bfs-sor-interview@paypal.com`.

## Relaxation For 90 minutes Online Assignment Only
- If you are not comfortable with jsonschema2pojo plugin, you can create your own POJOs
- *Validations & Idempotency check are not mandatory for 90 minutes online test. However, if you complete it then you would be getting extra points for that.

