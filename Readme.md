# Plan de formación Quality Assurance & Testing

## Kata

- https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements_es.md

## Instalación

- [JDK](https://www.oracle.com/java/technologies/downloads/)
- [JMeter](https://jmeter.apache.org/download_jmeter.cgi)
- [Git](https://git-scm.com/)
- [Node.js LTS](https://nodejs.org)
- [Eclipse](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2024-03/R/eclipse-jee-2024-03-R-win32-x86_64.zip)
- [Visual Studio Code](https://code.visualstudio.com/download#)
- [Selenium IDE](https://chromewebstore.google.com/detail/selenium-ide/mooikfkahbdckldjjndioackbalphokd?hl=es&utm_source=ext_sidebar)

## Imagenes

    docker push mariadb
    docker push docker.io/bitnami/testlink-archived:1
    docker push xlrl/mantisbt:latest
    docker push jamarton/jenkins-maven-docker
    docker push mailhog/mailhog
    docker push sonarqube:latest
    docker push docker:dind
    docker push maven:3.8.6-eclipse-temurin-8

### Test Tools: Testlink & MantisBT

    cd test-tools
    docker compose up -d

## Integración continua

### Instalación Docker

- https://learn.microsoft.com/es-es/windows/wsl/install
- https://docs.docker.com/desktop/install/windows-install/

### Repositorios con ejemplos

- https://github.com/jmagit/demos-devops
- https://github.com/jmagit/demos-frontend-angular
- https://github.com/jmagit/MOCKWebServer

### Entorno CI/CD

#### Desplegar contenedores

- docker network create jenkins
- docker run -d --name mailhog -p 1025:1025 -p 8025:8025 mailhog/mailhog
- docker run -d --name sonarQube --publish 9000:9000 --network jenkins sonarqube:latest
- docker run -d --name jenkins-docker --detach --privileged --network jenkins --network-alias docker --env DOCKER_TLS_CERTDIR=/certs --volume jenkins-docker-certs:/certs/client --volume jenkins-data:/var/jenkins_home --publish 2376:2376 docker:dind --storage-driver overlay2
- docker run --name jenkins --network jenkins --env DOCKER_HOST=tcp://docker:2376 --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 --publish 50080:8080 --publish 50000:50000 --volume %cd%/jenkins_home:/home --volume jenkins-data:/var/jenkins_home --volume jenkins-docker-certs:/certs/client:ro --env JAVA_OPTS="-Dhudson.plugins.git.GitSCM.ALLOW_LOCAL_CHECKOUT=true" jamarton/jenkins-maven-docker

### Comandos

- docker run --rm -it --name maven -v %cd%:/local -v maven-repository:/root/.m2 maven:3.8.6-eclipse-temurin-8 sh

## Ampliaciones

- [Clean Code](https://www.amazon.es/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [TMAP Next](https://www.tmap.net/)
- [Markdown](https://www.markdownguide.org/)

## Repositorios

- [Grupo 1](https://github.com/joanpaneque/LogiRAIL-project)
  - [Emma](https://github.com/ecardosa)
  - [Roman](https://github.com/RomanMysyura)
  - [Joan](https://github.com/joanpaneque)
- [Grupo 2](https://github.com/Yugurto7/Logirail-Project)
  - [Marcos](https://github.com/Yugurto7/Logirail-Marcos)
  - [Anton](https://github.com/remmko/Formacion)
  - [Adrià J.](https://github.com/adriajofre19/LogiRAIL-adria-jofre)
- [Grupo 3](https://github.com/wade079/testing_qa_logirail)
  - [Carlos](https://github.com/Joheartless)
  - [Adrià A.](https://github.com/wade079)
  - [Albert](https://github.com/Necromancer117)
