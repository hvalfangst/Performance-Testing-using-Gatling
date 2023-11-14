#!/bin/sh

createDatabaseContainer() {
   docker-compose -f "db/heroes/docker-compose.yml" up -d
}

runSpringBoot() {
   createDatabaseContainer
    mvn spring-boot:run -f spring-boot-jdbc/pom.xml
}

runWebFlux() {
    createDatabaseContainer
    mvn spring-boot:run -f spring-boot-webflux-r2dbc/pom.xml
}

# Check if a command-line argument is provided
if [ $# -eq 1 ] && [ "$1" = "spring-boot" ]; then
    runSpringBoot
elif [ $# -eq 1 ] && [ "$1" = "webflux" ]; then
    runWebFlux
else
    echo "Invalid or missing argument."
fi
