# Pull base image
FROM openjdk:8-alpine

# Maintainer
MAINTAINER "Manuel Resinas <resinas@us.es">

# Set variables
ENV PORT 8080

# Copy to images tomcat path
ADD target/hello-java-0.1.0.jar /opt/webapp/
WORKDIR /opt/webapp

# Launch the server
CMD java -jar hello-java-0.1.0.jar 
