
## Getting Started
### Prerequisites
* Maven build-tool
* Java 17
* Local or cloud postgresSQL database

### Clone repository

```
git clone https://github.com/dasbjoern/IV1201ProjectGroup8.git

```
### Add config file for (postgresSQL) Database to run locally
In folder '\IV1201ProjectGroup8\src\main\resources\'

Create file config.properties and add the following lines:
```
spring.datasource.url=url
spring.datasource.username=username
spring.datasource.password=password
```
Swap out url, username and password with credentials for the local or cloud database.

### Build and start web application
In terminal

Go into /IV1201ProjectGroup8 directory

Build with maven to install and compile, files and dependencies
```
mvn clean install
```
Run
```
mvn Spring-boot:run
```
The web application will now run locally on:

http://localhost:8080/

## Development

Use the development branch for development.
```
git switch development
```
To merge with main a pull request must be created, easiest done directly within the repository on github.com

## Deployment

To deploy the web application, simply push or merge into the deploy Branch

The web application will then automatically be deployed to the azure cloud:

    https://recruitment-iv1201-pg8.azurewebsites.net/

See main_recruitment-iv1201-pg8.yml in .github\workflow for more info.

Secrets for the azure cloud authentication are saved in the repositories settings, secrets and variables, action secrets



