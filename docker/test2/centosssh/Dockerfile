#生成的新镜像以centos镜像为基础
FROM centos
MAINTAINER by atai2
#升级系统
RUN yum install openssh-server -y

#修改root用户密码
#用以下命令修改密码时，密码中最好不要包含特殊字符，如"!"，否则可能会失败；
RUN /bin/echo "asdf" | passwd --stdin root

#生成密钥
RUN ssh-keygen -t rsa -f /etc/ssh/ssh_host_rsa_key \
    && ssh-keygen -t rsa -f /etc/ssh/ssh_host_ecdsa_key \
    && ssh-keygen -t rsa -f /etc/ssh/ssh_host_ed25519_key

#修改配置信息
RUN /bin/sed -i 's/.*session.*required.*pam_loginuid.so.*/session optional pam_loginuid.so/g' /etc/pam.d/sshd \
    && /bin/sed -i 's/UsePAM yes/UsePAM no/g' /etc/ssh/sshd_config \
    && /bin/sed -i "s/#UsePrivilegeSeparation.*/UsePrivilegeSeparation no/g" /etc/ssh/sshd_config


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