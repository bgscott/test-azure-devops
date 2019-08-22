FROM openjdk:latest
VOLUME /tmp
RUN mkdir -p /opt/app/testapp /opt/app/testapp/logs /opt/app/logs

WORKDIR /opt/app/testapp

EXPOSE 8080

ADD ./maven/gs-spring-boot-docker-0.1.0.jar /opt/app/testapp/hello-world.jar
ENTRYPOINT ["java","-jar","/opt/app/testapp/hello-world.jar"]
