# DIGITAL-DIVINE-9.7
A Java-based app that provides a RESTful API for convenient and efficient booking of bus tickets.

This repository contains a RESTful bus booking application developed using Java. The application allows users to search for available buses, book tickets, and manage their bookings.

Features
Search for buses by route, date, and time
View available seats and ticket prices
Select seats and book tickets
Manage bookings: view, modify, and cancel

Technologies Used
Java
Spring Boot
Hibernate
MySQL 
RESTful API design principles
Getting Started
Clone the repository:
git clone https://github.com/sobhiT-upadhyay/DIGITAL-DIVINE-9.7.git
Configure the database connection in the application.properties file.

Build and run the application:

Access the application in your web browser at http://localhost:8080.

API Endpoints for User Module
GET :  localhost:8080/api/users?page=0&size=2&sort=email,desc
POST: localhost:8080/api/users/create
PUT : localhost:8080/api/users/1
DELETE : localhost:8080/api/users/1

API Endpoints for User Module Download in form of 

Excel: localhost:8080/api/users/download
Pdf:  localhost:8080/api/users/users/pdf
Csv: localhost:8080/api/users/users/csv



FOr Bus booking Testing has been done by using 

Then Again (Schedule)Post- http://localhost:8080/api/schedules
{
"departureTime": "2023-06-10T08:00:00Z",
"arrivalTime": "2023-09-11T12:00:00Z",
"price": 90.50,
"bus":{
"id":1,
"busType": "Ac",
"totalSeats": 20,
"amenities": " WiFi,Charging ports",
"busOperator":{
"id":1,
"operatorName": "ABC Bus Company",
"contactEmail": "abc@example.com",
"contactPhone": "555-555-5555",
"logoUrl": "https://example.com/logo.png"
}
},
"route": {
"id":2,
"origin": "Mumbai",
"destination": "Chenai",
"distance": 56789.4
}
}

