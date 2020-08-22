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

Date: 2020-08-22 15:49:52
*/


-- ----------------------------
-- Table structure for TB_TASK
-- ----------------------------
DROP TABLE "RY"."TB_TASK";
CREATE TABLE "RY"."TB_TASK" (
"TASK_NUMBER" VARCHAR2(11 CHAR) NOT NULL ,
"TASK_TIME" VARCHAR2(20 CHAR) NOT NULL ,
"TASK_HOUSE" VARCHAR2(11 CHAR) NULL ,
"TASK_RESULT" VARCHAR2(300 CHAR) NULL ,
"TASK_HANDLE" VARCHAR2(300 CHAR) NULL ,
"TASK_FLAG" VARCHAR2(5 CHAR) NULL ,
"TASK_CHECKTIME" VARCHAR2(20 CHAR) NULL ,
"TASK_FILE" VARCHAR2(200 CHAR) NULL ,
"TASK_BC" VARCHAR2(200 CHAR) NULL ,
"UPDATE_TIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TASK
-- ----------------------------
INSERT INTO "RY"."TB_TASK" VALUES ('3', '2019-09-11', '1', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('123456', '2019-09-11', '3', '基本符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('4', '2019-04-11', '1', '不符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('144764', '2020-06-13', '2', null, null, '未完成', null, null, '大大撒旦', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('372153', '2020-06-13', '6', null, null, '未完成', null, null, '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('964123', '2020-07-22', '338470', null, null, '未完成', null, null, '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('91163', '2020-05-12', '123455', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('296381', '2020-05-28', '55986', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('825316', '2020-06-13', '2984755', null, null, '未完成', null, null, '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('193535', '2020-06-13', '2635', null, null, '未完成', null, null, '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('686826', '2019-09-15', '2', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('123868', '2019-09-11', '298470', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('1', '2018-10-11', '2', 'as', '整改', '完成', '2019-09-13', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', null, TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('2', '2019-09-15', '338470', '不符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('140424', '2019-09-23', '2', '不符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('455172', '2019-09-24', '1', '符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('420069', '2019-09-25', '1', '不符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('633723', '2019-09-11', '298470', 'dddddd', 'asdad', '完成', '2020-08-22', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', null, TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('111111', '2019-09-11', '123457', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', null, TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('736026', '2020-05-12', '123457', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('809910', '2019-11-12', '123456', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO "RY"."TB_TASK" VALUES ('633710', '2019-09-11', '1', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '无', TO_DATE('2020-08-22 13:47:14', 'YYYY-MM-DD HH24:MI:SS'));

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
