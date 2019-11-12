/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : RY
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : RY

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2019-11-12 18:16:59
*/


-- ----------------------------
-- Table structure for TB_TASK
-- ----------------------------
DROP TABLE "RY"."TB_TASK";
CREATE TABLE "RY"."TB_TASK" (
"TASK_NUMBER" VARCHAR2(11 CHAR) NOT NULL ,
"TASK_NAME" VARCHAR2(8 CHAR) NOT NULL ,
"TASK_REGION" VARCHAR2(8 CHAR) NOT NULL ,
"TASK_STREET" VARCHAR2(11 CHAR) NOT NULL ,
"TASK_PARTITION" VARCHAR2(11 CHAR) NULL ,
"TASK_GRADE" VARCHAR2(5 CHAR) NOT NULL ,
"TASK_TYPE" VARCHAR2(10 CHAR) NOT NULL ,
"TASK_CONNECTING" VARCHAR2(500 CHAR) NOT NULL ,
"TASK_TIME" VARCHAR2(20 CHAR) NOT NULL ,
"TASK_HOUSE" VARCHAR2(11 CHAR) NULL ,
"TASK_HOUSENAME" VARCHAR2(11 CHAR) NULL ,
"TASK_HOUSEPHONE" VARCHAR2(11 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TASK
-- ----------------------------
INSERT INTO "RY"."TB_TASK" VALUES ('3', '更换任务', '福田区', '南头街道', null, '中', '餐饮污水', '排水管网更换', '2019-09-11', null, null, null);
INSERT INTO "RY"."TB_TASK" VALUES ('123456', '更换任务', '福田区', '南头街道', null, '中', '餐饮污水', '排水管网更换', '2019-09-11', null, null, null);
INSERT INTO "RY"."TB_TASK" VALUES ('4', '更换任务', '罗湖区', '南头街道', '开源饭店', '中', '餐饮污水', '排水管网更换', '2019-04-11', '1', '开源饭店', '12236954876');
INSERT INTO "RY"."TB_TASK" VALUES ('686826', '抢修任务', '盐田区', '西丽街道', '新星小区', '中', '街道污水', '管道维修，安装', '2019-09-15', '2', '新星小区', '13652648956');
INSERT INTO "RY"."TB_TASK" VALUES ('123868', '疏通任务', '福田区', '南头街道', '欣荣小区3A236', '中', '生活污水', '疏通管道', '2019-09-11', '298470', '欣荣小区', '13459686957');
INSERT INTO "RY"."TB_TASK" VALUES ('1', '任务1', '福田区', '南头街道', '喜喜小区236', '高', '雨水', '水源处理', '2018-10-11', '3', '喜喜小区', '13074699862');
INSERT INTO "RY"."TB_TASK" VALUES ('2', '任务2', '罗湖区', '沙河街道', '喜喜小学', '低', '雨水', '水源处理', '2019-09-15', '338470', '喜喜小学', '13556964865');
INSERT INTO "RY"."TB_TASK" VALUES ('140424', '任务3', '福田区', '南山街道', '新星小区', '中', '自然污水', '管道修理', '2019-09-23', '2', '新星小区', '13652648956');
INSERT INTO "RY"."TB_TASK" VALUES ('455172', '任务6', '南山区', '南山街道', '开源饭店', '中', '雨水', '检查管道', '2019-09-24', '1', '开源饭店', '12236954876');
INSERT INTO "RY"."TB_TASK" VALUES ('420069', '任务9', '南山区', '南头街道', '开源饭店', '中', '雨水', '管道检查！', '2019-09-25', '1', '开源饭店', '12236954876');
INSERT INTO "RY"."TB_TASK" VALUES ('633723', '管道任务', '福田区', '沙河街道', '欣荣小区3A236', '中', '生活污水', '排水管网检查、维修', '2019-09-11', '298470', '欣荣小区', '13459686957');
INSERT INTO "RY"."TB_TASK" VALUES ('111111', '更换任务', '福田区', '南头街道', '喜喜小区236', '中', '餐饮污水', '排水管网更换', '2019-09-11', '3', '喜喜小区', '13074699862');
INSERT INTO "RY"."TB_TASK" VALUES ('809910', 'aaaa', '福田区', '沙河街道', '撒大小区236', '高', 'aaaaa', 'aaaaa', '2019-11-12', '123456', '撒大小区', '13074699862');
INSERT INTO "RY"."TB_TASK" VALUES ('633710', '更换任务', '罗湖区', '南头街道', '开源饭店', '中', '餐饮污水', '排水管网更换', '2019-09-11', '1', '开源饭店', '12236954876');

-- ----------------------------
-- Indexes structure for table TB_TASK
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_TASK
-- ----------------------------
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_NUMBER" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_NAME" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_REGION" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_STREET" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_GRADE" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_TYPE" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_CONNECTING" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_TIME" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_NUMBER" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_NAME" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_REGION" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_STREET" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_GRADE" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_TYPE" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_CONNECTING" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_TIME" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_NAME" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_REGION" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_STREET" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_GRADE" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_TYPE" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_CONNECTING" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_TIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_TASK
-- ----------------------------
ALTER TABLE "RY"."TB_TASK" ADD PRIMARY KEY ("TASK_NUMBER");
