Jakarta Persistance:

    The Jakarta Persistence API (JPA) defines a standard interface to manage data over relational
    databases; there are several frameworks that implement the JPA specification, such as the Hibernate
    framework. JPA offers a specification for ORM (object-relational mapping).

Things needed in Spring Initializr:

    Spring Web, Thymeleaf, Spring Data JPA, H2 Database, and Validation

    or for MySQL

    Spring Web, Spring Data JPA, MySQL driver, DevTools and Validation

Docker commands for a MySQL instance:

    docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:5.7

    docker start mysql5

    docker exec -it mysql5 mysql


JPA concepts:

    Folders for entity, controller, repository, service
    Service uses an interface then in another folder impl we store the implementations

Postman:

    Very good utility to test REST Apis

Dockerize with docker-composer tutorial:

    https://www.bezkoder.com/docker-compose-spring-boot-mysql/