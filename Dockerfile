FROM openjdk:8-jre-alpine3.9

# copy only the artifacts we need from the first stage and discard the rest
COPY /target/lib/guava-30.1.1-jre.jar /lib/guava.jar
COPY /target/StringOperator-1.0-SNAPSHOT.jar /StringOperator.jar

# set the startup command to execute the jar
CMD ["java", "-cp", "/StringOperator.jar:/lib/*", "stringop.StringOperator"]