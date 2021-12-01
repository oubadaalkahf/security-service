FROM maven as security
COPY . /securityservice/

WORKDIR /securityservice

RUN mvn package -Dmaven.test.skip

FROM openjdk
COPY --from=security /securityservice/target/*.jar /securityservice/app.jar
EXPOSE 9090

#s'execute au lancement de l'image d'un container de l'image (docker run)
CMD ["java", "-jar", "/securityservice/app.jar"]