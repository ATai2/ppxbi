mvn clean package
docker rmi atai2/ppx-usermgt:v1
docker build . atai2/ppx-usermgt:v1