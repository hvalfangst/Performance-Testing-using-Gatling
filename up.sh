#!/bin/sh

createDatabaseContainer() {
   docker-compose -f "db/heroes/docker-compose.yml" up -d
}

runSpringBootWithJDBC() {
   createDatabaseContainer
    mvn spring-boot:run -f spring-boot-jdbc/pom.xml
}

runSpringBootWithWebFluxAndR2DBC() {
    createDatabaseContainer
    mvn spring-boot:run -f spring-boot-webflux-r2dbc/pom.xml
}


runGolangWithGinAndBun() {
    createDatabaseContainer
    go build -o gin_api go-gin-bun/src/main.go
    ./go-gin-bun/src/gin_api
}

# Check if a command-line argument is provided
if [ $# -eq 1 ] && [ "$1" = "spring-boot" ]; then
    runSpringBootWithJDBC
elif [ $# -eq 1 ] && [ "$1" = "webflux" ]; then
    runSpringBootWithWebFluxAndR2DBC
elif [ $# -eq 1 ] && [ "$1" = "go-gin-bun" ]; then
    runGolangWithGinAndBun
else
    echo "Invalid or missing argument."
fi
