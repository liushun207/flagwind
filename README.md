# flagwind
> 这是一个java maven多模块项目 ssm 框架学习


## 数据库
```

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` bigint(20) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Age` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '测试', '15');

```