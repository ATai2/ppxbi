token处理

redis:
token   
key   ---token
value ---userId
token临时唯一不重复id

分布式事务解决方案
* XA（数据库提供，缺点性能）
* 2pc
* 3pc
* tcc
* mq（补偿机制，重试）
* 回调

 解决数据一致性问题
框架lcn  (http://www.txlcn.org/zh-cn/)

* CPA

可用性---响应降级，负载均衡）
分区容错性---
* base
* 柔性事务
* 刚性事务

2pc  atomiko  不适合微服务
3pc  
全局事务
本地事务
xa
jta

===========
框架：
lcn
gts(ali)   -》FESCAR(ali)


分布式中实现数据一致性的方法



[限流算法之漏桶算法、令牌桶算法](https://www.cnblogs.com/SUNSHINEC/p/9577682.html)


