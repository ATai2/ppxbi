FROM openjdk:8-jre-alpine
MAINTAINER atai2 <1114677814@qq.com>


#ENV WORK_PATH /usr/share/myservice
ADD ppx-util-v1.jar ppx-util-v1.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "./ppx-util-v1.jar"]
EXPOSE 9600

