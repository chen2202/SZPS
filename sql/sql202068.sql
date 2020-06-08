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

Date: 2020-06-08 14:30:32
*/


-- ----------------------------
-- Table structure for TB_HOUSE
-- ----------------------------
DROP TABLE "RY"."TB_HOUSE";
CREATE TABLE "RY"."TB_HOUSE" (
"HOUSE_NUMBER" VARCHAR2(11 CHAR) NOT NULL ,
"HOUSE_NAME" VARCHAR2(11 CHAR) NOT NULL ,
"HOUSE_REGION" VARCHAR2(30 CHAR) NOT NULL ,
"HOUSE_ROLE" VARCHAR2(5 CHAR) NOT NULL ,
"HOUSE_PHONE" VARCHAR2(11 BYTE) NOT NULL ,
"HOUSE_FLAG" VARCHAR2(2 CHAR) DEFAULT 0  NOT NULL ,
"HOUSE_BEGIN" VARCHAR2(30 CHAR) NULL ,
"HOUSE_END" VARCHAR2(30 CHAR) NULL ,
"HOUSE_RULE" VARCHAR2(20 CHAR) NULL ,
"HOUSE_TIME" VARCHAR2(30 CHAR) NULL ,
"HOUSE_ITEM" VARCHAR2(30 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_HOUSE
-- ----------------------------
INSERT INTO "RY"."TB_HOUSE" VALUES ('123456', 'XXXX科技有限公司', '深圳市龙华区清湖街道xxxx餐馆', '秦宓', '13074699862', '否', '2019-09-11', '2021-09-11', '建设项目排水审批', '2019-09-11~2021-09-11', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('123457', '深圳市盐田科技有限公司', '深圳市福田区xx街道xxxx餐馆', '秦宓', '13074699862', '否', '2008-09-11', '2019-09-11', '建设项目排水审批', '2008-09-11~2019-09-11', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('1', 'XXXX科技有限公司', '深圳市盐田区xx街道xxxx餐馆', '陈明发', '12236954876', '是', '2019-09-11', '2020-09-11', '建设项目排水审批', '2019-09-11~2020-09-11', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('298470', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王七十', '13459686957', '否', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('338470', 'sadas科技有限公司', '深圳市福田区xx街道xxxx餐馆', '孙大叔', '13556964865', '是', '2019-09-11', '2023-09-11', '城市排水许可', '2019-09-11~2023-09-11', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('2', '阿大撒科技有限公司', '深圳市盐田区xx街道xxxx餐馆', '李商店', '13652648988', '是', '2019-09-12', '2022-09-14', '城市排水许可', '2019-09-12~2022-09-14', 'adasdasda');
INSERT INTO "RY"."TB_HOUSE" VALUES ('3', '大大科技有限公司', '深圳市福田区xx街道xxxx餐馆', '秦宓', '13074699833', '是', '2019-09-09', '2019-10-11', '城市排水许可', '2019-09-09~2019-10-11', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('6', '人人人科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王大苏打', '13459686957', '否', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('6666', '法塔赫科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王七', '13459686957', '是', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('2984755', '哦哦哦科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王十', '13459686957', '否', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('2635', '钱钱钱科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王啊啊', '13459686957', '否', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('55986', 'aaa科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王破', '13459686957', '是', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('123455', 'HHHH科技有限公司', '深圳市福田区xx街道xxxx餐馆', '秦噢', '13074699862', '是', '2008-09-11', '2019-09-11', '建设项目排水审批', '2008-09-11~2019-09-11', 'HHHH项目');

-- ----------------------------
-- Table structure for TB_TASK
-- ----------------------------
DROP TABLE "RY"."TB_TASK";
CREATE TABLE "RY"."TB_TASK" (
"TASK_NUMBER" VARCHAR2(11 CHAR) NOT NULL ,
"TASK_TIME" VARCHAR2(10 CHAR) NOT NULL ,
"TASK_HOUSE" VARCHAR2(11 CHAR) NULL ,
"TASK_RESULT" VARCHAR2(10 CHAR) NULL ,
"TASK_HANDLE" VARCHAR2(10 CHAR) NULL ,
"TASK_FLAG" VARCHAR2(5 CHAR) NULL ,
"TASK_CHECKTIME" VARCHAR2(20 CHAR) NULL ,
"TASK_FILE" VARCHAR2(200 CHAR) NULL ,
"TASK_BC" VARCHAR2(200 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TASK
-- ----------------------------
INSERT INTO "RY"."TB_TASK" VALUES ('3', '2019-09-11', '1', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('123456', '2019-09-11', '3', '基本符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('4', '2019-04-11', '1', '不符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('91163', '2020-05-12', '123455', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('296381', '2020-05-28', '55986', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('686826', '2019-09-15', '2', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('123868', '2019-09-11', '298470', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('1', '2018-10-11', '3', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('2', '2019-09-15', '338470', '不符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('140424', '2019-09-23', '2', '不符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('455172', '2019-09-24', '1', '符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('420069', '2019-09-25', '1', '不符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('633723', '2019-09-11', '298470', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('111111', '2019-09-11', '123457', null, null, null, null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', 'ok');
INSERT INTO "RY"."TB_TASK" VALUES ('736026', '2020-05-12', '123457', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('809910', '2019-11-12', '123456', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');
INSERT INTO "RY"."TB_TASK" VALUES ('633710', '2019-09-11', '1', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无');

-- ----------------------------
-- Indexes structure for table TB_HOUSE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_HOUSE
-- ----------------------------
ALTER TABLE "RY"."TB_HOUSE" ADD CHECK ("HOUSE_NUMBER" IS NOT NULL);
ALTER TABLE "RY"."TB_HOUSE" ADD CHECK ("HOUSE_NAME" IS NOT NULL);
ALTER TABLE "RY"."TB_HOUSE" ADD CHECK ("HOUSE_REGION" IS NOT NULL);
ALTER TABLE "RY"."TB_HOUSE" ADD CHECK ("HOUSE_ROLE" IS NOT NULL);
ALTER TABLE "RY"."TB_HOUSE" ADD CHECK ("HOUSE_PHONE" IS NOT NULL);
ALTER TABLE "RY"."TB_HOUSE" ADD CHECK ("HOUSE_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_HOUSE
-- ----------------------------
ALTER TABLE "RY"."TB_HOUSE" ADD PRIMARY KEY ("HOUSE_NUMBER");

-- ----------------------------
-- Indexes structure for table TB_TASK
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_TASK
-- ----------------------------
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_NUMBER" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_TIME" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_NUMBER" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_TIME" IS NOT NULL);
ALTER TABLE "RY"."TB_TASK" ADD CHECK ("TASK_TIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_TASK
-- ----------------------------
ALTER TABLE "RY"."TB_TASK" ADD PRIMARY KEY ("TASK_NUMBER");


UPDATE "RY"."SYS_MENU" SET "MENU_NAME"='已审批', "PARENT_ID"='4213', "ORDER_NUM"='2', "URL"='op/permit/waiting', "TARGET"='menuItem', "MENU_TYPE"='C', "VISIBLE"='1', "PERMS"='op:permit:waiting', "ICON"='#', "CREATE_BY"='admin', "CREATE_TIME"=TO_DATE('2019-09-15 12:55:21', 'SYYYY-MM-DD HH24:MI:SS'), "UPDATE_BY"='admin', "UPDATE_TIME"=TO_DATE('2019-09-17 15:05:29', 'SYYYY-MM-DD HH24:MI:SS'), "REMARK"=NULL, "SUBSYS_FLAG"='op'  WHERE "MENU_ID"='4216';
UPDATE "RY"."SYS_MENU" SET  "MENU_NAME"='数据统计', "PARENT_ID"='4213', "ORDER_NUM"='5', "URL"='op/permit/statistic', "TARGET"='menuItem', "MENU_TYPE"='C', "VISIBLE"='1', "PERMS"='op:permit:statistic', "ICON"='#', "CREATE_BY"='admin', "CREATE_TIME"=TO_DATE('2019-09-15 12:56:54', 'SYYYY-MM-DD HH24:MI:SS'), "UPDATE_BY"='admin', "UPDATE_TIME"=TO_DATE('2019-09-17 15:07:25', 'SYYYY-MM-DD HH24:MI:SS'), "REMARK"=NULL, "SUBSYS_FLAG"='op' WHERE "MENU_ID"='4219';
UPDATE "RY"."SYS_MENU" SET  "MENU_NAME"='抽查管理', "PARENT_ID"='7088', "ORDER_NUM"='0', "URL"='/supervise/datas/datas', "TARGET"='menuItem', "MENU_TYPE"='C', "VISIBLE"='0', "PERMS"='supervise:datas:list', "ICON"='#', "CREATE_BY"='admin', "CREATE_TIME"=TO_DATE('2019-09-08 16:54:55', 'SYYYY-MM-DD HH24:MI:SS'), "UPDATE_BY"=NULL, "UPDATE_TIME"=NULL, "REMARK"=NULL, "SUBSYS_FLAG"='op'  WHERE "MENU_ID"='7085';
UPDATE "RY"."SYS_MENU" SET  "MENU_NAME"='抽查历史', "PARENT_ID"='7088', "ORDER_NUM"='0', "URL"='/supervise/complete/complete', "TARGET"='menuItem', "MENU_TYPE"='C', "VISIBLE"='0', "PERMS"='supervise:complete:list', "ICON"='#', "CREATE_BY"='admin', "CREATE_TIME"=TO_DATE('2019-09-08 16:55:51', 'SYYYY-MM-DD HH24:MI:SS'), "UPDATE_BY"=NULL, "UPDATE_TIME"=NULL, "REMARK"=NULL, "SUBSYS_FLAG"='op'  WHERE "MENU_ID"='7086';
UPDATE "RY"."SYS_MENU" SET  "MENU_NAME"='数据管理', "PARENT_ID"='7088', "ORDER_NUM"='0', "URL"='/supervise/data/main', "TARGET"='menuItem', "MENU_TYPE"='C', "VISIBLE"='0', "PERMS"='supervise:datas:list', "ICON"='#', "CREATE_BY"='admin', "CREATE_TIME"=TO_DATE('2019-09-08 16:56:39', 'SYYYY-MM-DD HH24:MI:SS'), "UPDATE_BY"=NULL, "UPDATE_TIME"=NULL, "REMARK"=NULL, "SUBSYS_FLAG"='op'  WHERE "MENU_ID"='7087';
INSERT INTO "RY"."SYS_MENU" ("MENU_ID", "MENU_NAME", "PARENT_ID", "ORDER_NUM", "URL", "TARGET", "MENU_TYPE", "VISIBLE", "PERMS", "ICON", "CREATE_BY", "CREATE_TIME", "UPDATE_BY", "UPDATE_TIME", "REMARK", "SUBSYS_FLAG", "ROWID") VALUES ('330030', '检查对象管理', '7087', '0', '/supervise/data/list', 'menuItem', 'C', '1', 'supervise:data:list', '#', 'admin', TO_DATE('2019-09-10 14:57:19', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-03-05 10:03:43', 'SYYYY-MM-DD HH24:MI:SS'), NULL, 'op');
INSERT INTO "RY"."SYS_MENU" ("MENU_ID", "MENU_NAME", "PARENT_ID", "ORDER_NUM", "URL", "TARGET", "MENU_TYPE", "VISIBLE", "PERMS", "ICON", "CREATE_BY", "CREATE_TIME", "UPDATE_BY", "UPDATE_TIME", "REMARK", "SUBSYS_FLAG", "ROWID") VALUES ('330031', '执法人员管理', '7087', '1', '/supervise/data1/list', 'menuItem', 'C', '1', 'supervise:data1:list', '#', 'admin', TO_DATE('2019-09-10 14:57:19', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-03-05 10:03:43', 'SYYYY-MM-DD HH24:MI:SS'), NULL, 'op');
INSERT INTO "RY"."SYS_MENU" ("MENU_ID", "MENU_NAME", "PARENT_ID", "ORDER_NUM", "URL", "TARGET", "MENU_TYPE", "VISIBLE", "PERMS", "ICON", "CREATE_BY", "CREATE_TIME", "UPDATE_BY", "UPDATE_TIME", "REMARK", "SUBSYS_FLAG", "ROWID") VALUES ('330032', '事项管理', '7087', '2', '/supervise/data2/list', 'menuItem', 'C', '1', 'supervise:data2:list', '#', 'admin', TO_DATE('2019-09-10 14:57:19', 'SYYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2020-03-05 10:03:43', 'SYYYY-MM-DD HH24:MI:SS'), NULL, 'op');

