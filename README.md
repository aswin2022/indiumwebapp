# Getting Started
## Virtual Machine OS
* CentOS 7
## Install the following in your VM :
* JDK 1.8 
* Maven 3.8 
* Docker 1.13 
* Nodejs 14.16 
## Create a directory for the Application
mkdir Application
## Pull the Code from the github Repository
git clone URL of the repo
## Install the Nodejs Packages for frontend application
npm install  
## Build the project using Maven
mvn clean install
## Building the Docker Image of the application
To build the image, we will use docker build command and tag it. 
docker build -t app-name:verion .
## Pulling the MySql and PHPMYADMIN  Docker Image
docker pull mysql:5.7.20 
docker pull phpmyadmin/phpmyadmin 

## Running The Docker Container using docker compose
We can simply run our docker containers  as below;
docker-compose up -d
## Accessing the Application
* Ip of the vm:8080  - to access the webapplication
* Ip of the vm:5001   -to access phpMyAdmin page
