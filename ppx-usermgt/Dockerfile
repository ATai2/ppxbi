FROM openjdk:8-jre-alpine
MAINTAINER atai <1114677814@qq.com>

ADD target/ppx-usermgt-v1.jar /usr/share/myservice/ppx-usermgt-v1.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/ppx-usermgt-v1.jar"]
EXPOSE 8900

