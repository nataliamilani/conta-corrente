FROM openjdk:11-jre-slim

WORKDIR /app

EXPOSE 8083

ENV DATABASE_CONNECTION_URL="jdbc:mysql://db:3306/contacorrentedb"
ENV EUREKA_CONNECTION_URL="http://eureka:8761"
ENV CREDITO_URL="http://credito:8081/credito"
ENV DEBITO_URL="http://debito:8082/debito"

COPY target/contacorrente.jar /app/contacorrente.jar

ENTRYPOINT ["java", "-jar", "contacorrente.jar"]