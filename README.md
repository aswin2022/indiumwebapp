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
## Install the following in your VM :
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
Frontend          |  http://localhost:9119                   | `demo/demo`
H2 Database       |  http://localhost:9119/h2-console        |  Driver:`org.h2.Driver` <br/> JDBC URL:`jdbc:h2:mem:demo` <br/> User Name:`sa`
Swagger (API Ref) |  http://localhost:9119/swagger-ui.html   | 
Redoc (API Ref)   |  http://localhost:9119/redoc/index.html  |
Swagger Spec      |  http://localhost:9119/api-docs          |

## Accessing the Application
* Ip of the vm:8080  - to access the webapplication
* Ip of the vm:5001   -to access phpMyAdmin page
