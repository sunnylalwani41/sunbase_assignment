## Sunbase

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqlqJcsVPgclNQn9J15EwRK8D36WbK5Zwj7Q&s" />

## Customer Detail Service

 **Web SERVICE**

The **Sunbase Assignment** is a Web Service and it is integrate with REST API by which easily perform tasks:  **Add Customer**, **Update Customer**, **Delete Customer** and **Search Customer**.

The API's primary objective is to provide to the customer details **with a seamless experience and user-friendly environment.**

The API's Services consist the following points with HTTP Methods:

|S.No. | End Point | HTTP Method |
|:-----:|:-------|:----------:|
| 1 | ```/customers/customerAdd``` | POST |
| 2 | ```/customers/customerUpdate``` | POST |
| 3 | ```/customers/getCustomerList``` | GET |
| 4 | ```/customers/getCustomerById/{uuId}``` | GET |
| 5 | ```/customers/deleteCustomer/{uuId}``` | DELETE |
| 6 | ```/customers/getCustomerByRemoteApi``` | POST |
| 7 | ```/customers/getAllCustomer``` | GET |


## Tech Stack

- JAVA
- SPRINGBOOT
- MAVEN
- SPRING SECURITY
- JWT TOKEN
- MYSQL

## Dependencies

- SPRING BOOT DEVTOOLS
- SPRING WEB
- LOMBOK
- JSP
- MYSQL CONNECTOR
- SPRING DATA JPA
- SPRING SECURITY
- JWT
  
## Modules

- Admin Module
- Customer Module
- Jsp Page Mapping Module
- Exception Handler Module

## System Structure

The Web Service allows a Admin to **Add Customer**, **Update Customer**, **Delete Customer**, **Get All Customers** & **Sort and Find Customer** through the **browser**.

## About
This assignment is for **Sunbase**, This is a Customer Detail Information Web Service. We built this Web Service with Rest API assignment Within 2 days and Please [click here for Demo Video](https://drive.google.com/file/d/1N2zoV6LmyX9ZOvNnPh7P9I8K1L8xFg9H/view?usp=drive_link).

## Feature
- Add Customer
- Update Customer
- Delete Customer
- Get All Customers
- Sort And Find Customer

## Installation And Run Project

- copy this https://github.com/sunnylalwani41/Portone_Assignment.git
- Select path where you want to store the project in your pc
- open the corresponding file / folder with editor
- open terminal of your editor
- use command --> git clone (paste link) <-- 
- after project cloned to your folder
- go to StripePaymentGatewayIntegrationApplication.java file inside io.portone folder/package
- Before the run this project, ensure LOMBOK should be proper installed in the IDE.
- run as Spring Boot
- This application run on the port 4050
- After the project run, [click here](http://localhost:4050/swagger-ui/index.html) to view the project in swagger-ui

### Postman link of Stripe Payment Gateway Integration
click here to see in the [Postman](https://www.postman.com/material-geologist-27820143/workspace/stripe-payment-gateway).

### Deploy Link
[Click here](http://34.0.8.234:4020/swagger-ui/index.html) to see deploy in GCP (Google cloud platform).

## Screenshot

### Swagger UI Page
<img src="images/Swagger UI.PNG" alt="Swagger UI" />

### Payment Intent Parameter
<img src="images/Payment Intent Create.PNG" alt="Payment Intent Create" />

### Response Body
<img src="images/Successfull response.PNG" alt="Successfull response" />

### Schemas
<img src="images/Schemas.PNG" alt="Schemas" />
