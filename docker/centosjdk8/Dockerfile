#生成的新镜像以centos镜像为基础
FROM atai2/centos_sshd:v1
MAINTAINER by atai2

ADD jdk-8u191-linux-x64.tar.gz /usr/local/
ADD profile /etc/

ENV JAVA_HOME /usr/local/jdk1.8.0_191
ENV CLASSPATH $JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ENV PATH $PATH:$JAVA_HOME/bin

EXPOSE 22

CMD ["/usr/sbin/sshd","-D"]


# docker build -t centos_ssh:v1 .
# docker build -t atai2/centos_ssh:v1 .
# docker push atai2/centos_sshd:v1
