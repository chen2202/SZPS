/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : ZXC2
Source Server Version : 110200
Source Host           : 127.0.0.1:1522
Source Schema         : RY

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2020-04-26 12:25:46
*/


-- ----------------------------
-- Table structure for DRAINAGE_T_DRAIN
-- ----------------------------
DROP TABLE "RY"."DRAINAGE_T_DRAIN";
CREATE TABLE "RY"."DRAINAGE_T_DRAIN" (
"DRAIN_ID" NUMBER NOT NULL ,
"HOUSEHOLD_ID" NUMBER NOT NULL ,
"DRAIN_TYPE" VARCHAR2(5 CHAR) NULL ,
"PSKWZ" VARCHAR2(255 CHAR) NULL ,
"PRSZPSGW" VARCHAR2(10 CHAR) NULL ,
"PRXQGW" VARCHAR2(10 BYTE) NULL ,
"HASONELINEDEVICE" VARCHAR2(10 CHAR) NULL ,
"WATER_TO" VARCHAR2(255 CHAR) NULL ,
"WATER_NAME" VARCHAR2(255 CHAR) NULL ,
"PRETREATMENT_FACILITY" VARCHAR2(255 CHAR) NULL ,
"PRETREATMENT_FACILITY_NUMBER" VARCHAR2(255 CHAR) NULL ,
"PRETREATMENT_FACILITY_NOTE" VARCHAR2(500 CHAR) NULL ,
"OTHERACTION" VARCHAR2(255 CHAR) NULL ,
"OTHER_NOTE" VARCHAR2(255 CHAR) NULL ,
"IMPORTBZ" VARCHAR2(100 CHAR) NULL ,
"PACTIONNUM" NUMBER NULL ,
"PIDX1" NUMBER NULL ,
"PIDX2" NUMBER NULL ,
"PIDX3" NUMBER NULL ,
"PIDX4" NUMBER NULL ,
"PIDX5" NUMBER NULL ,
"PIDX6" NUMBER NULL ,
"PIDX7" NUMBER NULL ,
"NIDX1" NUMBER NULL ,
"NIDX2" NUMBER NULL ,
"NIDX3" NUMBER NULL ,
"NIDX4" NUMBER NULL ,
"NIDX5" NUMBER NULL ,
"NIDX6" NUMBER NULL ,
"NIDX7" NUMBER NULL ,
"PAS" VARCHAR2(255 CHAR) NULL ,
"NS" VARCHAR2(255 BYTE) NULL ,
"RIVERNAME" VARCHAR2(50 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."DRAIN_ID" IS '排水口ID';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."HOUSEHOLD_ID" IS '对应的排水户ID';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."DRAIN_TYPE" IS '排水口类型';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."PSKWZ" IS '排水口位置或排水井编码';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."PRSZPSGW" IS '是否排入市政排水管网';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."PRXQGW" IS '排入新区管网';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."HASONELINEDEVICE" IS '有一个线路设备';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."WATER_TO" IS '排水去向';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."WATER_NAME" IS '对应的水体名称';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."PRETREATMENT_FACILITY" IS '预处理设施列表';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."PRETREATMENT_FACILITY_NUMBER" IS '对应的数量列表';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."PRETREATMENT_FACILITY_NOTE" IS '备注列表，逗号分隔';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."OTHERACTION" IS '其他处理方式';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."OTHER_NOTE" IS '其他备注说明';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."IMPORTBZ" IS '如果批量导入记录临时表的名称';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."PACTIONNUM" IS '预处理设施数量';
COMMENT ON COLUMN "RY"."DRAINAGE_T_DRAIN"."RIVERNAME" IS '排水口对应的流域名称';

-- ----------------------------
-- Records of DRAINAGE_T_DRAIN
-- ----------------------------
INSERT INTO "RY"."DRAINAGE_T_DRAIN" VALUES ('1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_DRAIN" VALUES ('2', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_DRAIN" VALUES ('3', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_DRAIN" VALUES ('4', '25', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_DRAIN" VALUES ('5', '25', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_DRAIN" VALUES ('6', '25', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_DRAIN" VALUES ('7', '25', '雨水排放口', '啊啊啊', '是', '否', '无', '河流', '雨水', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Indexes structure for table DRAINAGE_T_DRAIN
-- ----------------------------

-- ----------------------------
-- Checks structure for table DRAINAGE_T_DRAIN
-- ----------------------------
ALTER TABLE "RY"."DRAINAGE_T_DRAIN" ADD CHECK ("DRAIN_ID" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_DRAIN" ADD CHECK ("HOUSEHOLD_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DRAINAGE_T_DRAIN
-- ----------------------------
ALTER TABLE "RY"."DRAINAGE_T_DRAIN" ADD PRIMARY KEY ("DRAIN_ID");
