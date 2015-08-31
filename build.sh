# Run mongo DB
#docker run --name bagofood-mongo -d mongo

# Build bagofood-server
mvn clean install
docker build -t laloutre42/docker-bagofood-server .

# Run bagofood-server
docker stop bagofood-server
docker rm bagofood-server
docker run --name bagofood-server -d -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod --link bagofood-mongo:mongo laloutre42/docker-bagofood-server