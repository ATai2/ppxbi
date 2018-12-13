#生成的新镜像以centos镜像为基础
FROM atai2/centos_sshd:v1
MAINTAINER by atai2

ADD jdk-8u144-linux-x64.tar.gz /usr/local/

ENV JAVA_HOME /usr/local/jdk1.8.0_144
ENV CLASSPATH $JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ENV PATH $PATH:$JAVA_HOME/bin

EXPOSE 22

CMD ["/usr/sbin/sshd","-D"]


#docker build -t atai2/centos_ssh:v1 .
# docker push atai2/centos_sshd:v1


#RUN yum -y update
##安装openssh-server
#RUN yum -y install openssh-server
##修改/etc/ssh/sshd_config
#RUN sed -i 's/UsePAM yes/UsePAM no/g' /etc/ssh/sshd_config
##将密钥文件复制到/etc/ssh/目录中
##ADD id_rsa /etc/ssh/ssh_host_rsa_key
##ADD id_rsa.pub /etc/ssh/ssh_host_rsa_key.pub
#RUN mkdir -p /root/.ssh
##ADD authorized_keys /root/.ssh/authorized_keys
##将ssh服务启动脚本复制到/usr/local/sbin目录中，并改变权限为755
#ADD run.sh /usr/local/sbin/run.sh
#RUN chmod 755 /usr/local/sbin/run.sh
##变更root密码为test
#RUN echo "root:root"| chpasswd
##开放窗口的22端口
#EXPOSE 22
##运行脚本，启动sshd服务
#CMD ["/usr/local/sbin/run.sh"]