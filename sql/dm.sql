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

Date: 2019-09-15 23:36:25
*/


-- ----------------------------
-- Table structure for DM_PERMISSION   权限表
-- ----------------------------
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
-- Indexes structure for table DM_PERMISSION
-- ----------------------------

-- ----------------------------
-- Checks structure for table DM_PERMISSION
-- ----------------------------
ALTER TABLE "RY"."DM_PERMISSION" ADD CHECK ("PER_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DM_PERMISSION
-- ----------------------------
ALTER TABLE "RY"."DM_PERMISSION" ADD PRIMARY KEY ("PER_ID");


-- ----------------------------
-- 权限表序列
-- ----------------------------
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

Date: 2019-09-15 23:36:35
*/


-- ----------------------------
-- Table structure for DM_AUDIT    审批表
-- ----------------------------
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
-- Indexes structure for table DM_AUDIT
-- ----------------------------

-- ----------------------------
-- Checks structure for table DM_AUDIT
-- ----------------------------
ALTER TABLE "RY"."DM_AUDIT" ADD CHECK ("AUDIT_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DM_AUDIT
-- ----------------------------
ALTER TABLE "RY"."DM_AUDIT" ADD PRIMARY KEY ("AUDIT_ID");


-- ----------------------------
-- 审批表序列
-- ----------------------------
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

Date: 2019-09-15 23:14:31
*/


-- ----------------------------
-- Table structure for DM_DATA    资料表
-- ----------------------------
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
"DATA_URL" VARCHAR2(100 BYTE) DEFAULT ''  NULL ,
"DATA_FLAG" CHAR(1 BYTE) DEFAULT '0'  NULL 
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
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_URL" IS '附件文件路径';
COMMENT ON COLUMN "RY"."DM_DATA"."DATA_FLAG" IS '删除标志 (0存在 2删除)';

-- ----------------------------
-- Indexes structure for table DM_DATA
-- ----------------------------

-- ----------------------------
-- Checks structure for table DM_DATA
-- ----------------------------
ALTER TABLE "RY"."DM_DATA" ADD CHECK ("DATA_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DM_DATA
-- ----------------------------
ALTER TABLE "RY"."DM_DATA" ADD PRIMARY KEY ("DATA_ID");


-- ----------------------------
-- 资料表序列
-- ----------------------------
CREATE SEQUENCE SEQ_DM_DATA
increment by 1    -- 每次递增1  
start with 1       -- 从1开始  
nomaxvalue      -- 没有最大值  
minvalue 1       -- 最小值=1  
NOCYCLE;      -- 不循环  





-- ----------------------------
-- 菜单栏数据
-- ----------------------------
INSERT INTO "RY"."SYS_MENU" VALUES ('7', '规划任务审批', '5', '1', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-08 19:36:38', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-11 11:30:41', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('5', '规划资料管理', '2040', '1', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-08 19:34:10', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('6', '规划资料展示', '5', '0', '/dm/data', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-08 19:36:16', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-08 19:43:58', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('14', '资料新增', '6', '0', '#', 'menuItem', 'F', '0', 'dm:data:add', '#', 'admin', TO_DATE('2019-09-12 08:47:33', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-12 08:52:10', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('9', '资料权限审批', '5', '2', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-10 14:57:19', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-13 13:22:29', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('10', '通过记录', '7', '1', '/dm/audit/pass', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-11 11:25:02', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-12 19:58:35', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('11', '驳回记录', '7', '2', '/dm/audit/reject', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-11 11:25:36', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-12 19:58:51', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('12', '待审核', '7', '0', '/dm/audit', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-11 11:31:16', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('13', '操作日志', '5', '3', '/dm/log', 'menuItem', 'C', '1', null, '#', 'admin', TO_DATE('2019-09-11 20:34:03', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-11 20:34:27', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('15', '资料修改', '6', '1', '#', 'menuItem', 'F', '0', 'dm:data:edit', '#', 'admin', TO_DATE('2019-09-12 08:52:33', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('16', '资料删除', '6', '2', '#', 'menuItem', 'F', '0', 'dm:data:remove', '#', 'admin', TO_DATE('2019-09-12 08:53:40', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('17', '资料导出', '6', '3', '#', 'menuItem', 'F', '0', 'dm:data:export', '#', 'admin', TO_DATE('2019-09-12 08:54:15', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('18', '待审批', '9', '0', '/dm/permission', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-13 13:22:55', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('19', '通过记录', '9', '1', '/dm/permission/pass', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-13 13:23:21', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('20', '驳回记录', '9', '2', '/dm/permission/reject', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-13 13:24:04', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('21', '回收站', '5', '4', '/dm/recycle', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-13 13:26:30', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-13 23:28:17', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('22', '我的资料库', '5', '3', '/dm/my', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-13 23:27:56', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('23', '资料查看', '6', '4', '#', 'menuItem', 'F', '0', 'dm:data:view', '#', 'admin', TO_DATE('2019-09-16 00:02:08', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('24', '资料访问权限申请', '6', '5', '#', 'menuItem', 'F', '0', 'dm:data:permission', '#', 'admin', TO_DATE('2019-09-16 00:03:30', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');









-- ----------------------------
-- 下面角色可根据需要定义和分配
-- ----------------------------




-- ----------------------------
-- 用户角色数据
-- ----------------------------
INSERT INTO "RY"."SYS_ROLE" VALUES ('3', '资料管理员', 'data', '4', '2', '0', '0', 'admin', TO_DATE('2019-09-12 08:11:04', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-15 23:50:33', 'YYYY-MM-DD HH24:MI:SS'), null);
INSERT INTO "RY"."SYS_ROLE" VALUES ('4', '资料审核员', 'audit', '5', '2', '0', '0', 'admin', TO_DATE('2019-09-12 08:15:54', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-15 23:51:05', 'YYYY-MM-DD HH24:MI:SS'), null);




-- ----------------------------
-- 角色对应菜单权限
-- ----------------------------
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '5');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '6');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '9');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '14');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '15');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '16');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '17');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '18');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '19');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '20');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '21');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '2000');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('3', '2040');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('4', '5');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('4', '7');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('4', '10');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('4', '11');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('4', '12');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('4', '2000');
INSERT INTO "RY"."SYS_ROLE_MENU" VALUES ('4', '2040');




-- ----------------------------
-- 附加操作   普通用户权限设置需在  角色管理-->编辑-->菜单权限(勾选规划资料展示底下的资料查看、资料访问权限申请),根据需要设置
-- ----------------------------







