FROM java:8

WORKDIR /code

# Adding source, compile and package into a fat jar
ADD . /code
RUN ["./gradlew", "build"]

EXPOSE 4567
CMD ["/usr/lib/jvm/java-8-opdockerenjdk-amd64/bin/java", "-jar", "build/libs/LemPortService-1.0.0.jar"]