FROM openjdk:8
VOLUME ["/tmp","/log"]
COPY ./target/ChangLe_Community-0.0.1-SNAPSHOT.jar ChangLe_Community-0.0.1-SNAPSHOT.jar
EXPOSE 9900
ENTRYPOINT ["java","-jar","-Xmx400m","./ChangLe_Community-0.0.1-SNAPSHOT.jar","&"]
