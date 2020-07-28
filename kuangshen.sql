/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.19 : Database - kuangstudy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kuangstudy` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kuangstudy`;

/*Table structure for table `ks_blog` */

DROP TABLE IF EXISTS `ks_blog`;

CREATE TABLE `ks_blog` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `bid` varchar(200) NOT NULL COMMENT '博客id',
  `title` varchar(200) NOT NULL COMMENT '博客标题',
  `content` longtext NOT NULL COMMENT '博客内容',
  `sort` int(1) NOT NULL DEFAULT '0' COMMENT '排序 0 普通  1 置顶',
  `views` int(10) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `author_id` varchar(200) NOT NULL COMMENT '作者id',
  `author_name` varchar(200) NOT NULL COMMENT '作者名',
  `author_avatar` varchar(500) NOT NULL COMMENT '作者头像',
  `category_id` int(10) NOT NULL COMMENT '问题分类id',
  `category_name` varchar(50) NOT NULL COMMENT '问题分类名称',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_update` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Table structure for table `ks_blog_category` */

DROP TABLE IF EXISTS `ks_blog_category`;

CREATE TABLE `ks_blog_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `category` varchar(50) NOT NULL COMMENT '博客分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Table structure for table `ks_comment` */

DROP TABLE IF EXISTS `ks_comment`;

CREATE TABLE `ks_comment` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `comment_id` varchar(200) NOT NULL COMMENT '评论唯一id',
  `topic_category` int(1) NOT NULL COMMENT '1博客 2问答',
  `topic_id` varchar(200) NOT NULL COMMENT '评论主题id',
  `user_id` varchar(200) NOT NULL COMMENT '评论者id',
  `user_name` varchar(200) NOT NULL COMMENT '评论者昵称',
  `user_avatar` varchar(500) NOT NULL COMMENT '评论者头像',
  `content` longtext NOT NULL COMMENT '评论内容',
  `gmt_create` datetime NOT NULL COMMENT '评论创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;

/*Table structure for table `ks_download` */

DROP TABLE IF EXISTS `ks_download`;

CREATE TABLE `ks_download` (
  `dname` varchar(100) NOT NULL COMMENT '资源名',
  `ddesc` varchar(500) NOT NULL COMMENT '资源链接',
  `dcode` varchar(50) NOT NULL COMMENT '提取码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ks_invite` */

DROP TABLE IF EXISTS `ks_invite`;

CREATE TABLE `ks_invite` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `code` varchar(200) NOT NULL COMMENT '邀请码',
  `uid` varchar(200) DEFAULT NULL COMMENT '用户id',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态 0 未使用 1 使用',
  `active_time` datetime DEFAULT NULL COMMENT '激活时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1217 DEFAULT CHARSET=utf8;

/*Table structure for table `ks_question` */

DROP TABLE IF EXISTS `ks_question`;

CREATE TABLE `ks_question` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `qid` varchar(200) NOT NULL COMMENT '问题id',
  `title` varchar(200) NOT NULL COMMENT '问题标题',
  `content` longtext NOT NULL COMMENT '问题内容',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态 0 未解决 1 已解决',
  `sort` int(1) NOT NULL DEFAULT '0' COMMENT '排序 0 普通  1 置顶',
  `views` int(10) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `author_id` varchar(200) NOT NULL COMMENT '作者id',
  `author_name` varchar(200) NOT NULL COMMENT '作者名',
  `author_avatar` varchar(500) NOT NULL COMMENT '作者头像',
  `category_id` int(10) NOT NULL COMMENT '问题分类id',
  `category_name` varchar(50) NOT NULL COMMENT '问题分类名称',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_update` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Table structure for table `ks_question_category` */

DROP TABLE IF EXISTS `ks_question_category`;

CREATE TABLE `ks_question_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `category` varchar(50) NOT NULL COMMENT '问题分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Table structure for table `ks_say` */

DROP TABLE IF EXISTS `ks_say`;

CREATE TABLE `ks_say` (
  `id` varchar(200) NOT NULL COMMENT '唯一id',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `content` varchar(5000) NOT NULL COMMENT '内容',
  `gmt_create` datetime NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ks_user` */

DROP TABLE IF EXISTS `ks_user`;

CREATE TABLE `ks_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uid` varchar(200) NOT NULL COMMENT '用户编号',
  `role_id` int(10) NOT NULL COMMENT '角色编号',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `avatar` varchar(500) NOT NULL DEFAULT '/images/avatar/avatar-1.jpg' COMMENT '头像',
  `login_date` datetime NOT NULL COMMENT '登录时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=840 DEFAULT CHARSET=utf8;

/*Table structure for table `ks_user_donate` */

DROP TABLE IF EXISTS `ks_user_donate`;

CREATE TABLE `ks_user_donate` (
  `uid` varchar(200) NOT NULL COMMENT '用户id',
  `donate_json` varchar(2000) NOT NULL COMMENT '赞赏二维码信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ks_user_info` */

DROP TABLE IF EXISTS `ks_user_info`;

CREATE TABLE `ks_user_info` (
  `uid` varchar(200) NOT NULL COMMENT '用户id',
  `nickname` varchar(80) DEFAULT NULL COMMENT '用户昵称',
  `realname` varchar(80) DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(200) DEFAULT NULL COMMENT 'WeChat',
  `email` varchar(500) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `work` varchar(200) DEFAULT NULL COMMENT '工作',
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  `hobby` varchar(500) DEFAULT NULL COMMENT '爱好',
  `intro` varchar(2000) DEFAULT NULL COMMENT '自我介绍'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `ks_user_role` */

DROP TABLE IF EXISTS `ks_user_role`;

CREATE TABLE `ks_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `name` varchar(200) NOT NULL COMMENT '角色名称',
  `description` varchar(500) NOT NULL DEFAULT '无描述...' COMMENT '角色描述',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
