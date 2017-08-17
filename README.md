# flagwind
> 这是一个java maven多模块项目 ssm 框架学习

> Intellij配置、ssm说明 文件仅供参考

## 数据库 flagwind
```

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for loginlog
-- ----------------------------
DROP TABLE IF EXISTS `loginlog`;
CREATE TABLE `loginlog` (
  `LogId` bigint(20) NOT NULL AUTO_INCREMENT,
  `UserId` bigint(20) NOT NULL,
  `Ip` varchar(23) DEFAULT NULL,
  `LoginDateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`LogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginlog
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Name` varchar(30) DEFAULT NULL COMMENT '名称',
  `Credits` int(11) DEFAULT '0' COMMENT '学分',
  `Password` varchar(32) DEFAULT NULL COMMENT '密码',
  `LastVisit` datetime DEFAULT NULL COMMENT '最后访问时间',
  `LastIp` varchar(23) DEFAULT NULL COMMENT '最后登录Ip',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '1', '123456', null, null);

```