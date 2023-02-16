# base docker image
FROM openjdk:17
LABEL maintainer = "autograder.net"
ADD target/RestrictedEnvironment-0.0.1-SNAPSHOT.jar RestrictedEnvironment.jar
ENTRYPOINT ["java", "-jar", "RestrictedEnvironment.jar"]