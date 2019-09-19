##社区

##资料
[Spring 文档](http://spring.io/guides)
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[Spring](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html)
##工具
[Git](https://git-scm.com/download)
[Lombok](https://www.projectlombok.org)
##脚本
...sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` char(36) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
...


...