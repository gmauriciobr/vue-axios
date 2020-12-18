FROM openjdk:8
VOLUME /tmp
ADD ./jar/loja.jar /opt/loja/
EXPOSE 8080
WORKDIR /opt/loja/
CMD ["java", "-jar", "loja.jar"]
