
* 排除安全框架的异常
> @SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class})

*  processes 目录
>   activiti:
      database-schema-update: true
      check-process-definitions: true
      
   可以设置为false

* activiti引擎的启动，默认初始化类，在包spring.factory中。





