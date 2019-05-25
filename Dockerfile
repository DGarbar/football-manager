FROM openjdk:12-alpine

#RUN apt-get update -q \
# && apt-get upgrade -q -y \
# && apt-get install -q -y

COPY target/mvc-dataJpa-1.0-SNAPSHOT.war /home/mvc-dataJpa-1.0-SNAPSHOT.war

EXPOSE 8080
CMD ["java", "-jar", "/home/hotel-booking-0.0.1-SNAPSHOT.jar"]

