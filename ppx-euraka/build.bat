mvn clean package
docker rmi atai2/ppx-eureka:v1
docker build . atai2/ppx-eureka:v1