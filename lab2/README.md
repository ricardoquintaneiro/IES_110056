Java Servlet:

    A Servlet is a Java class that runs at the server, handles (client) requests processes them, and reply with a response. A servlet must be deployed into a (multithreaded) Servlet Container to be usable. Containers handle multiple requests concurrently.

Application servers:

    Jetty servers are embedded servers while servers like Tomcat are high-performance, dedicated application servers.


Docker-compose or Dockerfile:

    Docker-compose on IntelliJ: https://www.jetbrains.com/help/idea/docker-tutorial-tomcat-debug.html#clone_sample_project

    docker-compose method is preferable as it propagates updates.
    
    Dockerfile method: https://www.baeldung.com/docker-deploy-java-war

Spring Boot:

    Spring Initializr creates project already with the chosen dependencies:
        https://start.spring.io/

    We use Spring Web dependency often.

    It's good too change default port to avoid conflicts -> src/main/resources/application.properties
        server.port=<new_port>

    Html pages like index.html should be in src/main/resources/templates/

    Spring boot command to run project:
        ./mvnw spring-boot:run

    @RestController allows Rest APIs to return JSON data. We can use java record to return valid JSON.
