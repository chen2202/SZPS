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

Date: 2019-11-11 17:02:05
*/


-- ----------------------------
-- Table structure for TB_ENCLOSURE
-- ----------------------------
DROP TABLE "RY"."TB_ENCLOSURE";
CREATE TABLE "RY"."TB_ENCLOSURE" (
"ENCLOSURE_ID" VARCHAR2(11 CHAR) NOT NULL ,
"ENCLOSURE_LOCATION" VARCHAR2(200 CHAR) NOT NULL ,
"FEEDBACK_ID" VARCHAR2(11 CHAR) NOT NULL ,
"ENCLOSURE_NAME" VARCHAR2(200 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_ENCLOSURE
-- ----------------------------
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('181399', '/profile/upload/2019/09/23/aff891b3289e6ed0b3a695cb52c6f465.doc', '173970', '维修记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('581218', '/profile/upload/2019/09/23/96ba993475afad848f07d7212cedd5a0.doc', '513543', '登记检查表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('227014', '/profile/upload/2019/09/23/70bbc9ee7e10c018a3315c7ec306706c.doc', '513543', '管道记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('976340', '/profile/upload/2019/09/23/59e54c795b5aec4cdf597ea885a1e96a.doc', '306743', '管道记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('325258', '/profile/upload/2019/09/23/eb6322f3c1adda61f81ed243efe7d4c1.doc', '306743', '维修记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('375841', '/profile/upload/2019/09/23/dde3a744242cf8fe1b5b24ce0737531c.doc', '306743', '登记检查表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('527753', '/profile/upload/2019/09/25/7468ebc0c92bd088530e3e1780079716.doc', '386628', '登记检查表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('38756', '/profile\upload\2019/11/11\850d949322cdc0eed17f4a438dd49af8.doc', '202985', '管道记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('417732', '/profile\upload\2019/11/11\f0814fac25c166889e2efff891b7d629.doc', '202985', '维修记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('719143', '/profile/upload/2019/09/25/aa90c09261139aec4059ae23e3ae9394.doc', '18986', '维修记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('7743', '/profile/upload/2019/09/25/402330b9c8d63713653352548544e93f.doc', '18986', '管道记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('821336', '/profile\upload/2019/11/11/00ce1918f60d12c015c76ffee2c4176e.doc', '726643', '管道记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('744683', '/profile/upload/2019/10/24/adf83940effaf1e3dd4bbe4362fc8e30.doc', '558764', '管道记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('799117', '/profile\upload/2019/11/11/d3f310e03c038a9e143c97b9e1ef866b.doc', '726643', '登记检查表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('341791', '/profile/upload/2019/09/23/641ed4d6a7551c274e9790a00e368aee.docx', '979258', '排水监督检查子模块设计文件.docx');

-- ----------------------------
-- Indexes structure for table TB_ENCLOSURE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_ENCLOSURE
-- ----------------------------
ALTER TABLE "RY"."TB_ENCLOSURE" ADD CHECK ("ENCLOSURE_LOCATION" IS NOT NULL);
ALTER TABLE "RY"."TB_ENCLOSURE" ADD CHECK ("FEEDBACK_ID" IS NOT NULL);
ALTER TABLE "RY"."TB_ENCLOSURE" ADD CHECK ("ENCLOSURE_NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_ENCLOSURE
-- ----------------------------
ALTER TABLE "RY"."TB_ENCLOSURE" ADD PRIMARY KEY ("ENCLOSURE_ID");
