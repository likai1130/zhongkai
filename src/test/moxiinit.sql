-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 192.168.1.108    Database: moxi
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_customer`
--

DROP TABLE IF EXISTS `t_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(300) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer`
--

LOCK TABLES `t_customer` WRITE;
/*!40000 ALTER TABLE `t_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_customer_return_list`
--

DROP TABLE IF EXISTS `t_customer_return_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer_return_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` float NOT NULL,
  `amount_payable` float NOT NULL,
  `customer_return_date` datetime DEFAULT NULL,
  `customer_return_number` varchar(100) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl0ahdwa8slkocbfe57opembfx` (`customer_id`) USING BTREE,
  KEY `FKd55ju83f0ntixagdvdrsmw10c` (`user_id`) USING BTREE,
  CONSTRAINT `FKd55ju83f0ntixagdvdrsmw10c` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKl0ahdwa8slkocbfe57opembfx` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `t_customer_return_list_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_customer_return_list_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer_return_list`
--

LOCK TABLES `t_customer_return_list` WRITE;
/*!40000 ALTER TABLE `t_customer_return_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_customer_return_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_customer_return_list_goods`
--

DROP TABLE IF EXISTS `t_customer_return_list_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer_return_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `customer_return_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtqt67mbn96lxn8hvtl4piblhi` (`customer_return_list_id`) USING BTREE,
  KEY `FK4sm5si4swbj3gae46jfk441yx` (`type_id`) USING BTREE,
  CONSTRAINT `FK4sm5si4swbj3gae46jfk441yx` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `FKtqt67mbn96lxn8hvtl4piblhi` FOREIGN KEY (`customer_return_list_id`) REFERENCES `t_customer_return_list` (`id`),
  CONSTRAINT `t_customer_return_list_goods_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `t_customer_return_list_goods_ibfk_2` FOREIGN KEY (`customer_return_list_id`) REFERENCES `t_customer_return_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer_return_list_goods`
--

LOCK TABLES `t_customer_return_list_goods` WRITE;
/*!40000 ALTER TABLE `t_customer_return_list_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_customer_return_list_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_damage_list`
--

DROP TABLE IF EXISTS `t_damage_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_damage_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `damage_date` datetime DEFAULT NULL,
  `damage_number` varchar(100) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpn094ma69sch1icjc2gu7xus` (`user_id`) USING BTREE,
  CONSTRAINT `FKpn094ma69sch1icjc2gu7xus` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_damage_list_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_damage_list`
--

LOCK TABLES `t_damage_list` WRITE;
/*!40000 ALTER TABLE `t_damage_list` DISABLE KEYS */;
INSERT INTO `t_damage_list` VALUES (1,'2017-12-13 00:00:00','BS201712130001','cc',1),(2,'2017-12-13 00:00:00','BS201712130002','xx',1),(3,'2018-05-29 00:00:00','BS201805290001','',1);
/*!40000 ALTER TABLE `t_damage_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_damage_list_goods`
--

DROP TABLE IF EXISTS `t_damage_list_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_damage_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `damage_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbf5m8mm3gctrnuubr9xkjamj8` (`damage_list_id`) USING BTREE,
  KEY `FKdbdfmp09hlf2raktincwroe9n` (`type_id`) USING BTREE,
  CONSTRAINT `FKbf5m8mm3gctrnuubr9xkjamj8` FOREIGN KEY (`damage_list_id`) REFERENCES `t_damage_list` (`id`),
  CONSTRAINT `FKdbdfmp09hlf2raktincwroe9n` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `t_damage_list_goods_ibfk_1` FOREIGN KEY (`damage_list_id`) REFERENCES `t_damage_list` (`id`),
  CONSTRAINT `t_damage_list_goods_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_damage_list_goods`
--

LOCK TABLES `t_damage_list_goods` WRITE;
/*!40000 ALTER TABLE `t_damage_list_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_damage_list_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_goods`
--

DROP TABLE IF EXISTS `t_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `inventory_quantity` int(11) NOT NULL,
  `last_purchasing_price` float NOT NULL,
  `min_num` int(11) NOT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `producer` varchar(200) DEFAULT NULL,
  `purchasing_price` float NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `selling_price` float NOT NULL,
  `state` int(11) NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlxnna5ngumghp4f279mmbjtyo` (`type_id`) USING BTREE,
  CONSTRAINT `FKlxnna5ngumghp4f279mmbjtyo` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `t_goods_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_goods`
--

LOCK TABLES `t_goods` WRITE;
/*!40000 ALTER TABLE `t_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_goodstype`
--

DROP TABLE IF EXISTS `t_goodstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_goodstype`
--

LOCK TABLES `t_goodstype` WRITE;
/*!40000 ALTER TABLE `t_goodstype` DISABLE KEYS */;
INSERT INTO `t_goodstype` VALUES (1,'icon-folderOpen','所有类别',-1,1),(2,'icon-folder','服饰',1,1),(3,'icon-folder','食品',1,1),(4,'icon-folder','家电',1,1),(5,'icon-folder','数码',1,1),(6,'icon-folder','连衣裙',2,0),(7,'icon-folder','男士西装',2,0),(8,'icon-folder','牛仔裤',2,0),(9,'icon-folder','进口食品',3,0),(10,'icon-folder','地方特产',3,0),(11,'icon-folder','休闲食品',3,0),(12,'icon-folder','电视机',4,0),(13,'icon-folder','洗衣机',4,0),(14,'icon-folder','冰箱',4,0),(15,'icon-folder','相机',5,0),(16,'icon-folder','手机',5,1),(17,'icon-folder','音箱',5,1),(22,'icon-folder','零食',16,0),(24,'icon-folder','印象',17,0);
/*!40000 ALTER TABLE `t_goodstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_goodsunit`
--

DROP TABLE IF EXISTS `t_goodsunit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_goodsunit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_goodsunit`
--

LOCK TABLES `t_goodsunit` WRITE;
/*!40000 ALTER TABLE `t_goodsunit` DISABLE KEYS */;
INSERT INTO `t_goodsunit` VALUES (1,'个'),(2,'袋'),(3,'盒'),(4,'箱'),(5,'台'),(6,'包'),(11,'件'),(12,'条');
/*!40000 ALTER TABLE `t_goodsunit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_log`
--

DROP TABLE IF EXISTS `t_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbvn5yabu3vqwvtjoh32i9r4ip` (`user_id`) USING BTREE,
  CONSTRAINT `FKbvn5yabu3vqwvtjoh32i9r4ip` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_log_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log`
--

LOCK TABLES `t_log` WRITE;
/*!40000 ALTER TABLE `t_log` DISABLE KEYS */;
INSERT INTO `t_log` VALUES (1,'查询商品信息','2018-07-13 21:21:55','查询操作',1),(2,'查询商品库存信息','2018-07-13 21:21:57','查询操作',1),(3,'查询商品库存信息','2018-07-13 21:21:57','查询操作',1),(4,'查询商品库存信息','2018-07-13 21:21:58','查询操作',1),(5,'查询商品库存信息','2018-07-13 21:21:58','查询操作',1),(6,'查询商品信息','2018-07-13 21:21:59','查询操作',1),(7,'查询商品库存信息','2018-07-13 21:22:01','查询操作',1),(8,'查询商品库存信息','2018-07-13 21:22:01','查询操作',1),(9,'查询商品库存信息','2018-07-13 21:22:02','查询操作',1),(10,'查询商品库存信息','2018-07-13 21:22:02','查询操作',1),(11,'查询商品库存信息','2018-07-13 21:22:05','查询操作',1),(12,'查询商品库存信息','2018-07-13 21:22:05','查询操作',1),(13,'查询商品库存信息','2018-07-13 21:22:06','查询操作',1),(14,'查询商品库存信息','2018-07-13 21:22:06','查询操作',1),(15,'查询供应商信息','2018-07-13 21:22:09','查询操作',1),(16,'查询供应商信息','2018-07-13 21:22:09','查询操作',1),(17,'查询客户信息','2018-07-13 21:22:09','查询操作',1),(18,'查询客户信息','2018-07-13 21:22:09','查询操作',1),(19,'查询商品信息(无库存)','2018-07-13 21:22:10','查询操作',1),(20,'查询商品信息(无库存)','2018-07-13 21:22:10','查询操作',1),(21,'查询商品信息(有库存)','2018-07-13 21:22:10','查询操作',1),(22,'查询商品信息(有库存)','2018-07-13 21:22:10','查询操作',1),(23,'查询所有商品类别信息','2018-07-13 21:22:11','查询操作',1),(24,'查询商品单位信息','2018-07-13 21:22:11','查询操作',1),(25,'查询商品单位信息','2018-07-13 21:22:11','查询操作',1),(26,'查询商品库存信息','2018-07-13 21:22:11','查询操作',1),(27,'查询商品库存信息','2018-07-13 21:22:11','查询操作',1),(28,'查询商品库存信息','2018-07-13 21:22:13','查询操作',1),(29,'查询商品库存信息','2018-07-13 21:22:13','查询操作',1),(30,'查询商品库存信息','2018-07-13 21:22:14','查询操作',1),(31,'查询商品库存信息','2018-07-13 21:25:42','查询操作',1),(32,'查询商品库存信息','2018-07-13 21:25:42','查询操作',1),(33,'查询商品库存信息','2018-07-13 21:25:44','查询操作',1),(34,'查询商品库存信息','2018-07-13 21:25:44','查询操作',1),(35,'查询供应商信息','2018-07-13 21:26:21','查询操作',1),(36,'查询供应商信息','2018-07-13 21:26:21','查询操作',1),(37,'查询客户信息','2018-07-13 21:26:22','查询操作',1),(38,'查询客户信息','2018-07-13 21:26:22','查询操作',1),(39,'查询所有商品类别信息','2018-07-13 21:26:23','查询操作',1),(40,'查询商品单位信息','2018-07-13 21:26:23','查询操作',1),(41,'查询商品单位信息','2018-07-13 21:26:23','查询操作',1),(42,'查询商品库存信息','2018-07-13 21:26:23','查询操作',1),(43,'查询商品库存信息','2018-07-13 21:26:23','查询操作',1),(44,'查询商品库存信息','2018-07-13 21:26:24','查询操作',1),(45,'查询商品库存信息','2018-07-13 21:26:30','查询操作',1),(46,'查询商品库存信息','2018-07-13 21:26:31','查询操作',1),(47,'删除商品类别信息GoodsType [id=21, name=测试, state=0, icon=icon-folder, pId=1]','2018-07-13 21:26:33','删除操作',1),(48,'查询所有商品类别信息','2018-07-13 21:26:33','查询操作',1),(49,'查询商品库存信息','2018-07-13 21:26:36','查询操作',1),(50,'查询商品库存信息','2018-07-13 21:26:40','查询操作',1),(51,'查询商品库存信息','2018-07-13 21:26:41','查询操作',1),(52,'查询商品库存信息','2018-07-13 21:26:42','查询操作',1),(53,'查询商品库存信息','2018-07-13 21:26:42','查询操作',1),(54,'查询商品库存信息','2018-07-13 21:26:46','查询操作',1),(55,'查询商品库存信息','2018-07-13 21:26:47','查询操作',1),(56,'查询商品库存信息','2018-07-13 21:26:47','查询操作',1),(57,'查询商品库存信息','2018-07-13 21:26:58','查询操作',1),(58,'查询商品库存信息','2018-07-13 21:27:13','查询操作',1),(59,'查询商品库存信息','2018-07-13 21:27:15','查询操作',1),(60,'查询商品库存信息','2018-07-13 21:27:17','查询操作',1),(61,'查询商品库存信息','2018-07-13 21:27:19','查询操作',1);
/*!40000 ALTER TABLE `t_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6051 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` VALUES (1,'menu-plugin','系统菜单',-1,1,NULL),(10,'menu-1','进货管理',1,1,NULL),(20,'menu-2','销售管理',1,1,NULL),(30,'menu-3','库存管理',1,1,NULL),(40,'menu-4','统计报表',1,1,NULL),(50,'menu-5','基础资料',1,1,NULL),(60,'menu-6','系统管理',1,1,NULL),(1010,'menu-11','进货入库',10,0,'/purchase/purchase.html'),(1020,'menu-12','退货出库',10,0,'/purchase/return.html'),(1030,'menu-13','进货单据查询',10,0,'/purchase/purchaseSearch.html'),(1040,'menu-14','退货单据查询',10,0,'/purchase/returnSearch.html'),(1050,'menu-15','当前库存查询',10,0,'/common/stockSearch.html'),(2010,'menu-21','销售出库',20,0,'/sale/saleout.html'),(2020,'menu-22','客户退货',20,0,'/sale/salereturn.html'),(2030,'menu-23','销售单据查询',20,0,'/sale/saleSearch.html'),(2040,'menu-24','客户退货查询',20,0,'/sale/returnSearch.html'),(2050,'menu-25','当前库存查询',20,0,'/common/stockSearch.html'),(3010,'menu-31','商品报损',30,0,'/stock/damage.html'),(3020,'menu-32','商品报溢',30,0,'/stock/overflow.html'),(3030,'menu-33','库存报警',30,0,'/stock/alarm.html'),(3040,'menu-34','报损报溢查询',30,0,'/stock/damageOverflowSearch.html'),(3050,'menu-35','当前库存查询',30,0,'/common/stockSearch.html'),(4010,'menu-41','供应商统计',40,0,'/count/supplier.html'),(4020,'menu-42','客户统计',40,0,'/count/customer.html'),(4030,'menu-43','商品采购统计',40,0,'/count/purchase.html'),(4040,'menu-44','商品销售统计',40,0,'/count/sale.html'),(4050,'menu-45','按日统计分析',40,0,'/count/saleDay.html'),(4060,'menu-46','按月统计分析',40,0,'/count/saleMonth.html'),(5010,'menu-51','供应商管理',50,0,'/basicData/supplier.html'),(5020,'menu-52','客户管理',50,0,'/basicData/customer.html'),(5030,'menu-53','商品管理',50,0,'/basicData/goods.html'),(5040,'menu-54','期初库存',50,0,'/basicData/stock.html'),(6010,'menu-61','角色管理',60,0,'/power/role.html'),(6020,'menu-62','用户管理',60,0,'/power/user.html'),(6030,'menu-65','系统日志',60,0,'/power/log.html'),(6040,'menu-63','修改密码',60,0,NULL),(6050,'menu-64','安全退出',60,0,NULL);
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_overflow_list`
--

DROP TABLE IF EXISTS `t_overflow_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_overflow_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `overflow_date` datetime DEFAULT NULL,
  `overflow_number` varchar(100) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3bu8hj2xniqwbrtg6ls6b8ej2` (`user_id`) USING BTREE,
  CONSTRAINT `FK3bu8hj2xniqwbrtg6ls6b8ej2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_overflow_list_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_overflow_list`
--

LOCK TABLES `t_overflow_list` WRITE;
/*!40000 ALTER TABLE `t_overflow_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_overflow_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_overflow_list_goods`
--

DROP TABLE IF EXISTS `t_overflow_list_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_overflow_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `overflow_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd3s9761mgl456tn2xb0d164h7` (`overflow_list_id`) USING BTREE,
  KEY `FK8t46iik5kpciki8fnqtiuq5q3` (`type_id`) USING BTREE,
  CONSTRAINT `FK8t46iik5kpciki8fnqtiuq5q3` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `FKd3s9761mgl456tn2xb0d164h7` FOREIGN KEY (`overflow_list_id`) REFERENCES `t_overflow_list` (`id`),
  CONSTRAINT `t_overflow_list_goods_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `t_overflow_list_goods_ibfk_2` FOREIGN KEY (`overflow_list_id`) REFERENCES `t_overflow_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_overflow_list_goods`
--

LOCK TABLES `t_overflow_list_goods` WRITE;
/*!40000 ALTER TABLE `t_overflow_list_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_overflow_list_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_purchase_list`
--

DROP TABLE IF EXISTS `t_purchase_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_purchase_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` float NOT NULL,
  `amount_payable` float NOT NULL,
  `purchase_date` datetime DEFAULT NULL,
  `purchase_number` varchar(100) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5j2dev8b2b5d0l69nb8vtr4yb` (`supplier_id`) USING BTREE,
  KEY `FK69s6eyxr4wwvsywe9hbthef1h` (`user_id`) USING BTREE,
  CONSTRAINT `FK5j2dev8b2b5d0l69nb8vtr4yb` FOREIGN KEY (`supplier_id`) REFERENCES `t_supplier` (`id`),
  CONSTRAINT `FK69s6eyxr4wwvsywe9hbthef1h` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_purchase_list_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `t_supplier` (`id`),
  CONSTRAINT `t_purchase_list_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_purchase_list`
--

LOCK TABLES `t_purchase_list` WRITE;
/*!40000 ALTER TABLE `t_purchase_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_purchase_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_purchase_list_goods`
--

DROP TABLE IF EXISTS `t_purchase_list_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_purchase_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` float NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `purchase_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfvdvgcebqkkokyn0o00idqnpy` (`purchase_list_id`) USING BTREE,
  KEY `FK83ikbi2x3epn49fwcco8jlfwu` (`type_id`) USING BTREE,
  CONSTRAINT `FK83ikbi2x3epn49fwcco8jlfwu` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `FKfvdvgcebqkkokyn0o00idqnpy` FOREIGN KEY (`purchase_list_id`) REFERENCES `t_purchase_list` (`id`),
  CONSTRAINT `t_purchase_list_goods_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `t_purchase_list_goods_ibfk_2` FOREIGN KEY (`purchase_list_id`) REFERENCES `t_purchase_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_purchase_list_goods`
--

LOCK TABLES `t_purchase_list_goods` WRITE;
/*!40000 ALTER TABLE `t_purchase_list_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_purchase_list_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_return_list`
--

DROP TABLE IF EXISTS `t_return_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_return_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` float NOT NULL,
  `amount_payable` float NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `return_date` datetime DEFAULT NULL,
  `return_number` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4qxjj8bvj2etne243xluni0vn` (`supplier_id`) USING BTREE,
  KEY `FK904juw2v1hm2av0ig26gae9jb` (`user_id`) USING BTREE,
  CONSTRAINT `FK4qxjj8bvj2etne243xluni0vn` FOREIGN KEY (`supplier_id`) REFERENCES `t_supplier` (`id`),
  CONSTRAINT `FK904juw2v1hm2av0ig26gae9jb` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_return_list_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `t_supplier` (`id`),
  CONSTRAINT `t_return_list_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_return_list`
--

LOCK TABLES `t_return_list` WRITE;
/*!40000 ALTER TABLE `t_return_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_return_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_return_list_goods`
--

DROP TABLE IF EXISTS `t_return_list_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_return_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `return_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKemclu281vyvyk063c3foafq1w` (`return_list_id`) USING BTREE,
  KEY `FKa1prpd96fcs0x2oe0omny9vio` (`type_id`) USING BTREE,
  CONSTRAINT `FKa1prpd96fcs0x2oe0omny9vio` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `FKemclu281vyvyk063c3foafq1w` FOREIGN KEY (`return_list_id`) REFERENCES `t_return_list` (`id`),
  CONSTRAINT `t_return_list_goods_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `t_return_list_goods_ibfk_2` FOREIGN KEY (`return_list_id`) REFERENCES `t_return_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_return_list_goods`
--

LOCK TABLES `t_return_list_goods` WRITE;
/*!40000 ALTER TABLE `t_return_list_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_return_list_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'系统管理','管理员 最高权限'),(2,'主管','主管'),(4,'采购员','采购员'),(5,'销售经理','销售经理'),(7,'仓库管理员','仓库管理员'),(9,'总经理','总经理');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_menu`
--

DROP TABLE IF EXISTS `t_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhayg4ib6v7h1wyeyxhq6xlddq` (`menu_id`) USING BTREE,
  KEY `FKsonb0rbt2u99hbrqqvv3r0wse` (`role_id`) USING BTREE,
  CONSTRAINT `FKhayg4ib6v7h1wyeyxhq6xlddq` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`id`),
  CONSTRAINT `FKsonb0rbt2u99hbrqqvv3r0wse` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `t_role_menu_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`id`),
  CONSTRAINT `t_role_menu_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_menu`
--

LOCK TABLES `t_role_menu` WRITE;
/*!40000 ALTER TABLE `t_role_menu` DISABLE KEYS */;
INSERT INTO `t_role_menu` VALUES (2,1,1),(3,10,1),(4,20,1),(5,30,1),(6,40,1),(7,50,1),(8,60,1),(9,1010,1),(10,1020,1),(11,1030,1),(12,1040,1),(13,1050,1),(14,2010,1),(15,2020,1),(16,2030,1),(17,2040,1),(18,2050,1),(19,3010,1),(20,3020,1),(21,3030,1),(22,3040,1),(23,3050,1),(24,4010,1),(25,4020,1),(26,4030,1),(27,4040,1),(28,4050,1),(29,4060,1),(30,5010,1),(31,5020,1),(32,5030,1),(33,5040,1),(34,6010,1),(35,6020,1),(36,10,2),(37,1010,2),(38,1020,2),(39,1030,2),(40,1040,2),(41,1050,2),(42,1,2),(43,6030,1),(44,6040,1),(45,1,4),(46,20,4),(47,2010,4),(48,1,5),(49,30,5),(50,3010,5),(64,6050,1),(65,1,7),(66,10,7),(67,1010,7),(68,1020,7),(69,1030,7),(70,1040,7),(71,1050,7),(72,20,7),(73,2010,7),(74,2020,7),(75,2030,7),(76,40,7),(77,4010,7),(78,4020,7),(79,1,9),(80,10,9),(81,1020,9),(82,20,9),(83,2020,9),(84,30,9),(85,3040,9),(86,3050,9),(87,40,9),(88,4040,9),(89,50,9),(90,5010,9),(91,5020,9),(92,5030,9),(93,5040,9),(94,60,9),(95,6050,9);
/*!40000 ALTER TABLE `t_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sale_list`
--

DROP TABLE IF EXISTS `t_sale_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sale_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_paid` float NOT NULL,
  `amount_payable` float NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `sale_date` datetime DEFAULT NULL,
  `sale_number` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKox4qfs87eu3fvwdmrvelqhi8e` (`customer_id`) USING BTREE,
  KEY `FK34bnujemrdqimbhg133enp8k8` (`user_id`) USING BTREE,
  CONSTRAINT `FK34bnujemrdqimbhg133enp8k8` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKox4qfs87eu3fvwdmrvelqhi8e` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `t_sale_list_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_sale_list_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sale_list`
--

LOCK TABLES `t_sale_list` WRITE;
/*!40000 ALTER TABLE `t_sale_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sale_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sale_list_goods`
--

DROP TABLE IF EXISTS `t_sale_list_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sale_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `sale_list_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK20ehd6ta9geyql4hxtdsnhbox` (`sale_list_id`) USING BTREE,
  KEY `FKn9i5p1d8f0gek5x7q45cq8ibw` (`type_id`) USING BTREE,
  CONSTRAINT `FK20ehd6ta9geyql4hxtdsnhbox` FOREIGN KEY (`sale_list_id`) REFERENCES `t_sale_list` (`id`),
  CONSTRAINT `FKn9i5p1d8f0gek5x7q45cq8ibw` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`),
  CONSTRAINT `t_sale_list_goods_ibfk_1` FOREIGN KEY (`sale_list_id`) REFERENCES `t_sale_list` (`id`),
  CONSTRAINT `t_sale_list_goods_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `t_goodstype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sale_list_goods`
--

LOCK TABLES `t_sale_list_goods` WRITE;
/*!40000 ALTER TABLE `t_sale_list_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sale_list_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_supplier`
--

DROP TABLE IF EXISTS `t_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(300) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_supplier`
--

LOCK TABLES `t_supplier` WRITE;
/*!40000 ALTER TABLE `t_supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `true_name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'123','管理员','系统管理员','admin');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa9c8iiy6ut0gnx491fqx4pxam` (`role_id`) USING BTREE,
  KEY `FKq5un6x7ecoef5w1n39cop66kl` (`user_id`) USING BTREE,
  CONSTRAINT `FKa9c8iiy6ut0gnx491fqx4pxam` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKq5un6x7ecoef5w1n39cop66kl` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `t_user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES (1,1,1);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'moxi'
--

--
-- Dumping routines for database 'moxi'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-13 21:30:45
