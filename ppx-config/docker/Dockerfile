FROM openjdk:8-jre-alpine
MAINTAINER atai2 <1114677814@qq.com>


#ENV WORK_PATH /usr/share/myservice
ADD ppx-config-v1.jar ppx-config-v1.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "./ppx-config-v1.jar"]
EXPOSE 8761

