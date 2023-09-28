Naming conventions:

    groupId:
        in style of reverse domain and java packages
        uniquely identifies your project across all projects (imagine if it gets uploaded into mvn repository)
        example: org.apache.maven

    artifactId:
        lowercase name and no strange symbols
        it's the name of the jar


Check POM and see if version of compiler is 17 as java

Maven commands:

    mvn package #get dependencies, compiles the project and creates the jar
    mvn exec:java -Dexec.mainClass="" -Dexec.args=""


.gitignore templates:

    https://github.com/github/gitignore

Tutorial to share docker images to quickly deploy in another system:

    https://docs.docker.com/get-started/04_sharing_app/

Portainer:

    Web interface to manage docker without using CLI or something like Docker Desktop
    Good when you can't install desktop apps

Docker composer:

    When deployment environments require several interdependent services, mapped into different containers.

    Tutorial:
    https://docs.docker.com/compose/gettingstarted/



Notas da aula prática:

    glassfish
    pavara
    wildfly
    undertow.io

    O professor da prática diz para usar java -jar para executar a aplicação, temos que garantir que o package está atualizado

    Porto 8080 é frequentemente usado para servidores, mas depois pode ser redirecionado para outro porto. Assim ficam todos os servidores a usar a 8080.