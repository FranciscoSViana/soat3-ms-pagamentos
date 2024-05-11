FROM openjdk:17

WORKDIR /app

COPY target/soat3-ms-pagamentos-0.0.1-SNAPSHOT.jar /app/soat.jar

EXPOSE 8082

ENTRYPOINT [ "java", "-jar", "soat3-ms-pagamentos.jar" ]