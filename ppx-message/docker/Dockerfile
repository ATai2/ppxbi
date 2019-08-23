FROM openjdk:8-jre-alpine
MAINTAINER atai2 <1114677814@qq.com>


#ENV WORK_PATH /usr/share/myservice
ADD ppx-message-v1.jar ppx-message-v1.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "./ppx-message-v1.jar"]
EXPOSE 8900

