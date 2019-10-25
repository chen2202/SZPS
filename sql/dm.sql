/*

2019/10/25修改

*/


/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : RY
Source Server Version : 110200
Source Host           : 192.168.71.1:1521
Source Schema         : RY

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2019-10-25 17:28:06
*/


-- ----------------------------
-- Table structure for DM_PERMISSION
-- ----------------------------
DROP TABLE "RY"."DM_PERMISSION";
CREATE TABLE "RY"."DM_PERMISSION" (
"PER_ID" NUMBER(20) NOT NULL ,
"DATA_ID" NUMBER(20) NULL ,
"USER_ID" NUMBER(20) NULL ,
"PER_DATE" DATE NULL ,
"PER_STATUS" CHAR(1 BYTE) DEFAULT '0'  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."DM_PERMISSION"."PER_ID" IS '权限ID';
COMMENT ON COLUMN "RY"."DM_PERMISSION"."DATA_ID" IS '资料ID';
COMMENT ON COLUMN "RY"."DM_PERMISSION"."USER_ID" IS '用户ID';
COMMENT ON COLUMN "RY"."DM_PERMISSION"."PER_DATE" IS '申请时间';
COMMENT ON COLUMN "RY"."DM_PERMISSION"."PER_STATUS" IS '审批状态(0待审批 1通过 2驳回)';

-- ----------------------------
-- Checks structure for table DM_PERMISSION
-- ----------------------------
ALTER TABLE "RY"."DM_PERMISSION" ADD CHECK ("PER_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_PERMISSION" ADD CHECK ("PER_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_PERMISSION" ADD CHECK ("PER_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_PERMISSION" ADD CHECK ("PER_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_PERMISSION" ADD CHECK ("PER_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_PERMISSION" ADD CHECK ("PER_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_PERMISSION" ADD CHECK ("PER_ID" IS NOT NULL);


/*
	序列
*/
drop sequence SEQ_DM_PERMISSION;
CREATE SEQUENCE SEQ_DM_PERMISSION  
increment by 1    -- 每次递增1  
start with 1       -- 从1开始  
nomaxvalue      -- 没有最大值  
minvalue 1       -- 最小值=1  
NOCYCLE;      -- 不循环






/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : RY
Source Server Version : 110200
Source Host           : 192.168.71.1:1521
Source Schema         : RY

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2019-10-25 17:27:14
*/


-- ----------------------------
-- Table structure for DM_AUDIT
-- ----------------------------
DROP TABLE "RY"."DM_AUDIT";
CREATE TABLE "RY"."DM_AUDIT" (
"AUDIT_ID" NUMBER(20) NOT NULL ,
"DATA_ID" NUMBER(20) NULL ,
"USER_ID" NUMBER(20) NULL ,
"USER_NAME" VARCHAR2(30 BYTE) DEFAULT ''  NULL ,
"AUDIT_STATUS" CHAR(1 BYTE) DEFAULT '0'  NULL ,
"AUDIT_RESULT" VARCHAR2(600 BYTE) DEFAULT ''  NULL ,
"AUDIT_DATE" DATE NULL ,
"AUDIT_CREATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."DM_AUDIT"."AUDIT_ID" IS '审批ID';
COMMENT ON COLUMN "RY"."DM_AUDIT"."DATA_ID" IS '资料ID';
COMMENT ON COLUMN "RY"."DM_AUDIT"."USER_ID" IS '用户ID';
COMMENT ON COLUMN "RY"."DM_AUDIT"."USER_NAME" IS '用户昵称';
COMMENT ON COLUMN "RY"."DM_AUDIT"."AUDIT_STATUS" IS '审批状态(0待审批 1通过 2驳回)';
COMMENT ON COLUMN "RY"."DM_AUDIT"."AUDIT_RESULT" IS '审批结果';
COMMENT ON COLUMN "RY"."DM_AUDIT"."AUDIT_DATE" IS '审批日期';
COMMENT ON COLUMN "RY"."DM_AUDIT"."AUDIT_CREATE" IS '创建日期';

-- ----------------------------
-- Checks structure for table DM_AUDIT
-- ----------------------------
ALTER TABLE "RY"."DM_AUDIT" ADD CHECK ("AUDIT_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_AUDIT" ADD CHECK ("AUDIT_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_AUDIT" ADD CHECK ("AUDIT_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_AUDIT" ADD CHECK ("AUDIT_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_AUDIT" ADD CHECK ("AUDIT_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_AUDIT" ADD CHECK ("AUDIT_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_AUDIT" ADD CHECK ("AUDIT_ID" IS NOT NULL);


/*
	序列
*/
drop sequence SEQ_DM_AUDIT;
CREATE SEQUENCE SEQ_DM_AUDIT  
increment by 1    -- 每次递增1  
start with 1       -- 从1开始  
nomaxvalue      -- 没有最大值  
minvalue 1       -- 最小值=1  
NOCYCLE;      -- 不循环




/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : RY
Source Server Version : 110200
Source Host           : 192.168.71.1:1521
Source Schema         : RY

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2019-10-25 17:27:55
*/


-- ----------------------------
-- Table structure for DM_FILE
-- ----------------------------
DROP TABLE "RY"."DM_FILE";
CREATE TABLE "RY"."DM_FILE" (
"FILE_ID" NUMBER(20) NOT NULL ,
"DATA_ID" NUMBER(20) NULL ,
"FILE_NAME" VARCHAR2(100 BYTE) NULL ,
"FILE_PATH" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Triggers structure for table DM_FILE
-- ----------------------------
CREATE OR REPLACE TRIGGER "RY"."BEFOREDMFILEINSERT" BEFORE INSERT ON "RY"."DM_FILE" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN  
SELECT SEQ_DM_FILE.nextval INTO :new.FILE_ID  FROM dual;  
END;
-- ----------------------------
-- Checks structure for table DM_FILE
-- ----------------------------
ALTER TABLE "RY"."DM_FILE" ADD CHECK ("FILE_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_FILE" ADD CHECK ("FILE_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_FILE" ADD CHECK ("FILE_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_FILE" ADD CHECK ("FILE_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_FILE" ADD CHECK ("FILE_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_FILE" ADD CHECK ("FILE_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_FILE" ADD CHECK ("FILE_ID" IS NOT NULL);


/*
	序列
*/
drop sequence SEQ_DM_FILE;
CREATE SEQUENCE SEQ_DM_FILE  
increment by 1    -- 每次递增1  
start with 1       -- 从1开始  
nomaxvalue      -- 没有最大值  
minvalue 1       -- 最小值=1  
NOCYCLE;      -- 不循环





/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : RY
Source Server Version : 110200
Source Host           : 192.168.71.1:1521
Source Schema         : RY

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2019-10-25 17:27:39
*/


-- ----------------------------
-- Table structure for DM_DATA
-- ----------------------------
DROP TABLE "RY"."DM_DATA";
CREATE TABLE "RY"."DM_DATA" (
"DATA_ID" NUMBER(20) NOT NULL ,
"DATA_UUID" VARCHAR2(50 BYTE) DEFAULT ''  NULL ,
"DATA_DATE" DATE NULL ,
"DATA_APPLICANT" VARCHAR2(30 BYTE) DEFAULT ''  NULL ,
"DATA_COMPANY" VARCHAR2(100 BYTE) DEFAULT ''  NULL ,
"DATA_BOROUGH" VARCHAR2(100 BYTE) DEFAULT ''  NULL ,
"DATA_STREET" VARCHAR2(100 BYTE) DEFAULT ''  NULL ,
"DATA_TYPE" VARCHAR2(30 BYTE) DEFAULT ''  NULL ,
"DATA_LEVEL" VARCHAR2(30 BYTE) DEFAULT ''  NULL ,
"DATA_THEME" VARCHAR2(100 BYTE) DEFAULT ''  NULL ,
"DATA_DESC" VARCHAR2(900 BYTE) DEFAULT ''  NULL ,
"DATA_FLAG" CHAR(1 BYTE) DEFAULT '0'  NULL ,
"DATA_RIVER" VARCHAR2(100 BYTE) DEFAULT ''  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_ID" IS '资料表主键';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_UUID" IS '申请编号';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_DATE" IS '申请日期';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_APPLICANT" IS '申请人';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_COMPANY" IS '规划单位';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_BOROUGH" IS '行政区';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_STREET" IS '街道';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_TYPE" IS '所属类别';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_LEVEL" IS '密级';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_THEME" IS '主题';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_DESC" IS '简介';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_FLAG" IS '删除标志 (0存在 2删除)';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_RIVER" IS '流域';

-- ----------------------------
-- Checks structure for table DM_DATA
-- ----------------------------
ALTER TABLE "RY"."DM_DATA" ADD CHECK ("DATA_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_DATA" ADD CHECK ("DATA_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_DATA" ADD CHECK ("DATA_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_DATA" ADD CHECK ("DATA_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_DATA" ADD CHECK ("DATA_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_DATA" ADD CHECK ("DATA_ID" IS NOT NULL);
ALTER TABLE "RY"."DM_DATA" ADD CHECK ("DATA_ID" IS NOT NULL);


/*
	序列
*/
drop sequence SEQ_DM_DATA;
CREATE SEQUENCE SEQ_DM_DATA  
increment by 1    -- 每次递增1  
start with 1       -- 从1开始  
nomaxvalue      -- 没有最大值  
minvalue 1       -- 最小值=1  
NOCYCLE;      -- 不循环




