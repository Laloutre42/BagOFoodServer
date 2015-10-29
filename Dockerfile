# Set java 8 base image
FROM java:8

# File Author / Maintainer
MAINTAINER Arnaud Zdziobeck <laloutre42@gmail.com>

# Update packages and install maven
RUN  \
  export DEBIAN_FRONTEND=noninteractive && \
  sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list && \
  apt-get update && \
  apt-get -y upgrade && \
  apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
COPY pom.xml /code/pom.xml  
RUN ["mvn", "dependency:resolve"]  
#RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
COPY src /code/src  
RUN ["mvn", "clean"]
RUN ["mvn", "package"]

VOLUME /tmp

#COPY target /
#COPY /target/BagOFoodServer*.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

CMD bash -c 'touch target/BagOFoodServer*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/BagOFoodServer*.jar"]