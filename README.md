# Getting Started

### Technology Stack
Component         | Technology
---               | ---
Frontend          | [Angular 6](https://github.com/angular/angular)
Backend (REST)    | [SpringBoot](https://projects.spring.io/spring-boot) (Java)
Security          | Token Based (Spring Security and [JWT](https://github.com/auth0/java-jwt) )
REST Documentation| [Swagger UI] 
In Memory DB      | H2 
Client Build Tools| [angular-cli](https://github.com/angular/angular-cli), Webpack, npm
Server Build Tools| Maven(Java)

## Virtual Machine OS
* CentOS 7
## Prerequisites
Ensure you have this installed before proceeding further
* JDK 1.8 
* Maven 3.8 
* Docker 1.13 
* Nodejs 14.16 
## Create a directory for the Application
```
mkdir Application
```
## Pull the Code from the github Repository
```
git clone URL of the repo
```
## Install the Nodejs Packages for frontend application
```
npm install  
```
## Build the project using Maven
```
mvn clean install
```
## Building the Docker Image of the application
To build the image, we will use docker build command and tag it. 
```
docker build -t app-name:verion .
```
## Pulling the MySql and PHPMYADMIN  Docker Image
```
docker pull mysql:5.7.20 
```
```
docker pull phpmyadmin/phpmyadmin 
```
## Running The Docker Container using docker compose
We can simply run our docker containers  as below;
```
docker-compose up -d
```
### Accessing Application
Cpmponent         | URL                                      | Credentials
---               | ---                                      | ---
BCAD Application  |  http://localhost:8080                   |  User Name:`root` Password: `root`
Phpmyadmin        |  http://localhost:5001                   |  User Name:`root` Password: `root`

