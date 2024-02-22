
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
