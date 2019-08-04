FROM openjdk:12-alpine

COPY target/boot-webflux-0.0.1-SNAPSHOT.jar /home/boot-webflux-0.0.1-SNAPSHOT.jar

EXPOSE 8080
CMD ["java", "-jar", "/home/boot-webflux-0.0.1-SNAPSHOT.jar", "--spring.data.mongodb.uri=mongodb://mongo:27017/test"]

