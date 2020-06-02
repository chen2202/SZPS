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

Date: 2020-06-02 09:40:41
*/


-- ----------------------------
-- Table structure for EX_GDBS_SB
-- ----------------------------
DROP TABLE "RY"."EX_GDBS_SB";
CREATE TABLE "RY"."EX_GDBS_SB" (
"SBLSH" VARCHAR2(50 BYTE) NOT NULL ,
"SBLSH_SHORT" VARCHAR2(50 BYTE) NOT NULL ,
"SXBM" VARCHAR2(50 BYTE) NOT NULL ,
"SXMC" VARCHAR2(1000 BYTE) NOT NULL ,
"SXQXBM" VARCHAR2(50 BYTE) NOT NULL ,
"FSXBM" VARCHAR2(50 BYTE) NULL ,
"FSXMC" VARCHAR2(1000 BYTE) NULL ,
"SQRLX" VARCHAR2(2 BYTE) NOT NULL ,
"SQRMC" VARCHAR2(400 BYTE) NOT NULL ,
"SQRZJLX" VARCHAR2(10 BYTE) NULL ,
"SQRZJHM" VARCHAR2(50 BYTE) NOT NULL ,
"LXRXM" VARCHAR2(200 BYTE) NOT NULL ,
"LXRZJLX" VARCHAR2(2 BYTE) NULL ,
"LXRSFZJHM" VARCHAR2(50 BYTE) NULL ,
"LXRSJ" VARCHAR2(400 BYTE) NOT NULL ,
"LXRYX" VARCHAR2(400 BYTE) NULL ,
"SBXMMC" VARCHAR2(2000 BYTE) NOT NULL ,
"SBCLQD" VARCHAR2(2000 BYTE) NULL ,
"TJFS" VARCHAR2(2 BYTE) NOT NULL ,
"SBHZH" VARCHAR2(50 BYTE) NOT NULL ,
"SBSJ" DATE NOT NULL ,
"SBJTWD" VARCHAR2(400 BYTE) NULL ,
"XZQHDM" VARCHAR2(12 BYTE) NOT NULL ,
"YSBLSH" VARCHAR2(50 BYTE) NOT NULL ,
"BZ" VARCHAR2(2000 BYTE) NULL ,
"F_XZQHDM" VARCHAR2(12 BYTE) NULL ,
"USERIDCODE" VARCHAR2(2000 BYTE) NULL ,
"PROJECT_CODE" VARCHAR2(32 BYTE) NULL ,
"WSSBQD" VARCHAR2(2 BYTE) NULL ,
"OBTAIN_PAPER_WAY" VARCHAR2(2 BYTE) NULL ,
"OBTAIN_DELIVER_WAY" VARCHAR2(2 BYTE) NULL ,
"VERSION" VARCHAR2(50 BYTE) NULL ,
"REC_FLAG" NUMBER(2) DEFAULT 1  NOT NULL ,
"XML_DATA" CLOB NULL ,
"D_ZZJGDM" VARCHAR2(18 BYTE) NOT NULL ,
"SXBM_SHORT" VARCHAR2(50 BYTE) NOT NULL ,
"INSERTTIME" DATE NULL ,
"RESPONSETIME" DATE NULL ,
"FLAG" NUMBER(10) DEFAULT 0  NULL ,
"SYNC" NUMBER(10) DEFAULT 0  NULL ,
"DWDM" VARCHAR2(50 BYTE) NOT NULL ,
"BYZD1" VARCHAR2(400 BYTE) NULL ,
"BYZD2" VARCHAR2(400 BYTE) NULL ,
"BYZD4" VARCHAR2(4000 BYTE) NULL ,
"BYZD3" VARCHAR2(400 BYTE) NULL ,
"BMMC" VARCHAR2(500 BYTE) NULL ,
"BMZZJGDM" VARCHAR2(9 BYTE) NULL ,
"BYZD" VARCHAR2(2000 BYTE) NULL ,
"SFSXDDDL" VARCHAR2(3 BYTE) NULL ,
"DDDLYHID" VARCHAR2(50 BYTE) NULL ,
"CLZT" VARCHAR2(2 BYTE) NULL ,
"CLSJ" DATE NULL ,
"ID" NUMBER NULL ,
"ISTOSPJC" NUMBER(10) NULL ,
"SXBBH" VARCHAR2(10 BYTE) NULL ,
"SYNCTIME" DATE NULL ,
"SXBBBM" VARCHAR2(50 BYTE) NULL ,
"SXBDBM" VARCHAR2(50 BYTE) NULL ,
"SJSXBM" VARCHAR2(50 BYTE) NULL ,
"SJSXBBH" VARCHAR2(50 BYTE) NULL ,
"WD1" NUMBER NULL ,
"JD1" NUMBER NULL ,
"FILE_PATH" VARCHAR2(200 CHAR) NULL ,
"WD2" NUMBER NULL ,
"JD2" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of EX_GDBS_SB
-- ----------------------------
INSERT INTO "RY"."EX_GDBS_SB" VALUES ('S18000021811120001', '00754151201003820011811120001', '00000100200754151216440300', '污水排入排水管网许可证核发', '20171109102156078536', '深圳市城市轨道交通13号', '龙岗区', '3', '深圳市同胜美地实业有限公司', '49', '91440300MA5DJ3T98Q', '魏元山', '10', '360782199506013817', '18588223346', '深圳市龙岗区龙平西路', '深圳市龙岗区龙平西路项目', '排水总平面图;预处理设施材料;施工期限证明;法定授权委托证明书;经办人身份证复印件;组织机构信用代码证或企业营业执照（系统共享）;水质检测报告;法人代表证明书;法人身份证复印件;法人证书（系统共享）;法定代表人身份证（系统共享）;法定代表人证明书（系统共享）;法人授权委托书（系统共享）;代理人身份证（系统共享）;基坑及桩基础阶段施工许可或项目主体施工许可;深圳市水务局排水行政许可业务申请表;', '0', 'S18000021811120001', TO_DATE('1-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '市行政服务大厅西厅,9号综合受理（基建）', '440300', 'S18000021811120001', '居住', null, null, '2018-440326-70-03-716501', '0', '0', '0', '1', '1', null, '007541512', 'S1800002', TO_DATE('1-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0', '0', '7541512', '2019-12-22~2020-06-22', '建设项目排水审批', '已审批', '设一座7000*3000*2000三级沉淀池、一座Z11-50S化粪池、2座ZG-3隔油池', 'DN300污水管下游连接现状海德二道、DN400市政污水管的预留检查并(连接管管径DN300)', null, '0', null, '市排水管理处', null, null, '4742', null, '38', null, 'b47a92515e2c4310a5640171eed9655e', 'qz201809141530084274', '00754151201003820013440300', '10个工作日', '111321.7770', '31685.13', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '129893.94', '30374.71');
INSERT INTO "RY"."EX_GDBS_SB" VALUES ('S18000021811160006', '00754151201003820011811160006', '00000100200754151216440300', '污水排入排水管网许可证核发', '20171109102156078536', '深圳市城市轨道交通15号', '龙岗区', '3', '深圳市鸿腾投资管理有限公司', '49', '91440300788326902U', '侯洪林', '10', '370683199410010956', '18553526991', '深圳市龙岗区龙平西路', '帝豪酒店项目', '排水总平面图;预处理设施材料;水质检测报告;施工期限证明;法定授权委托证明书;经办人身份证复印件;组织机构信用代码证或企业营业执照（系统共享）;法人代表证明书;法人身份证复印件;深圳市水务局排水行政许可业务申请表;法人证书（系统共享）;法定代表人身份证（系统共享）;法定代表人证明书（系统共享）;法人授权委托书（系统共享）;代理人身份证（系统共享）;基坑及桩基础阶段施工许可或项目主体施工许可;', '0', 'S18000021811160006', TO_DATE('1-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '市行政服务大厅西厅,9号综合受理（基建）', '440300', 'S18000021811160006', '居住', null, null, '2015-440300-70-03-067193', '0', '0', '0', '1', '1', null, '007541512', 'S1800002', TO_DATE('1-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0', '0', '7541512', '2020-05-22~2020-06-22', '城市排水许可', '已审批', '设一座7000*3000*2000三级沉淀池、一座Z11-50S化粪池、2座ZG-3隔油池', 'DN300污水管下游连接现状海德二道、DN400市政污水管的预留检查并(连接管管径DN300)', null, '0', null, '市排水管理处', null, null, '4744', null, '39', null, '323814470f404228acdbe0b3c858006b', 'qz201809141530084274', '00754151201003820013440300', '10个工作日', '111321.7770', '31685.13', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '129893.94', '30374.71');
INSERT INTO "RY"."EX_GDBS_SB" VALUES ('S18000021811160007', '00754151201003820011811160007', '00000100200754151216440300', '污水排入排水管网许可证核发', '20171109102156078536', '深圳市城市轨道交通14号', '龙岗区', '3', '深圳市交通公用设施建设中心', '80', '10', '柯昊东', '10', '440883199107091131', '13798499084', '深圳市龙岗区龙平西路', '夜课山庄项目', '法人代表证明书;排水总平面图;预处理设施材料;法人身份证复印件;水质检测报告;施工期限证明;法定授权委托证明书;组织机构信用代码证或企业营业执照（系统共享）;经办人身份证复印件;深圳市水务局排水行政许可业务申请表;基坑及桩基础阶段施工许可或项目主体施工许可;法人证书（系统共享）;法定代表人身份证（系统共享）;法定代表人证明书（系统共享）;法人授权委托书（系统共享）;代理人身份证（系统共享）;', '0', 'S18000021811160007', TO_DATE('1-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '市行政服务大厅西厅,10号综合受理（基建）', '440300', 'S18000021811160007', '居住', null, null, '2016-440300-48-01-102588', '0', '0', '0', '1', '1', null, '007541512', 'S1800002', TO_DATE('1-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0', '0', '7541512', '2019-12-25~2020-07-22', '建设项目排水审批', '已审批', '设一座7000*3000*2000三级沉淀池、一座Z11-50S化粪池、2座ZG-3隔油池', 'DN300污水管下游连接现状海德二道、DN400市政污水管的预留检查并(连接管管径DN300)', null, '0', null, '市排水管理处', null, null, '4745', null, '39', null, '323814470f404228acdbe0b3c858006b', 'qz201809141530084274', '00754151201003820013440300', '10个工作日', '111321.7770', '31685.13', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '129893.94', '30374.71');
INSERT INTO "RY"."EX_GDBS_SB" VALUES ('S18000021811160001', '00754151201003820011811160001', '00000100200754151216440300', '污水排入排水管网许可证核发', '20171109102156078536', '深圳市城市轨道交通16号', '龙岗区', '3', '深圳市住宅工程管理站', '52', '12440300G347792238', '李奋斌', '10', '440582198909226635', '18666299502', '深圳市龙岗区龙平西路', 'xxxx项目', '深圳市水务局排水行政许可业务申请表;法人证书（系统共享）;法定代表人身份证（系统共享）;法定代表人证明书（系统共享）;法人授权委托书（系统共享）;代理人身份证（系统共享）;法人代表证明书;组织机构信用代码证或企业营业执照（系统共享）;预处理设施材料;排水总平面图;施工期限证明;经办人身份证复印件;法定授权委托证明书;法人身份证复印件;基坑及桩基础阶段施工许可或项目主体施工许可;水质检测报告;', '0', 'S18000021811160001', TO_DATE('1-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '市行政服务大厅西厅,11号综合受理（基建）', '440300', 'S18000021811160001', '居住', null, null, '2017-440300-81-01-103214', '0', '0', '0', '1', '1', null, '007541512', 'S1800002', TO_DATE('1-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0', '0', '7541512', '2021-11-22~2022-07-22', '城市排水许可', '已审批', '设一座7000*3000*2000三级沉淀池、一座Z11-50S化粪池、2座ZG-3隔油池1', 'DN300污水管下游连接现状海德二道、DN400市政污水管的预留检查并(连接管管径DN3001)', null, '0', null, '市排水管理处', null, null, '4753', null, '39', null, '323814470f404228acdbe0b3c858006b', 'qz201809141530084274', '00754151201003820013440300', '10个工作日', '111321.7770', '31685.13', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '129893.94', '30374.71');

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
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('269754', '/profile\upload\2019/11/11\e253363125affe2f147c61aaba39d062.doc', '299413', '维修记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('744683', '/profile/upload/2019/10/24/adf83940effaf1e3dd4bbe4362fc8e30.doc', '558764', '管道记录表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('799117', '/profile\upload/2019/11/11/d3f310e03c038a9e143c97b9e1ef866b.doc', '726643', '登记检查表.doc');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('341791', '/profile/upload/2019/09/23/641ed4d6a7551c274e9790a00e368aee.docx', '979258', '排水监督检查子模块设计文件.docx');
INSERT INTO "RY"."TB_ENCLOSURE" VALUES ('947279', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc', '539253', '维修记录表.doc');

-- ----------------------------
-- Table structure for TB_FEEDBACK
-- ----------------------------
DROP TABLE "RY"."TB_FEEDBACK";
CREATE TABLE "RY"."TB_FEEDBACK" (
"FEEDBACK_ID" VARCHAR2(11 CHAR) NOT NULL ,
"TASK_NUMBER" VARCHAR2(11 CHAR) NOT NULL ,
"FEEDBACK_INFORMATION" VARCHAR2(500 CHAR) NOT NULL ,
"FEEDBACK_TIME" VARCHAR2(10 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_FEEDBACK
-- ----------------------------
INSERT INTO "RY"."TB_FEEDBACK" VALUES ('979258', '123868', '处理得很好！！', '2019-09-11');
INSERT INTO "RY"."TB_FEEDBACK" VALUES ('513543', '1', '检查得很到位！！', '2019-09-11');
INSERT INTO "RY"."TB_FEEDBACK" VALUES ('306743', '633710', '成功疏通', '2019-09-11');
INSERT INTO "RY"."TB_FEEDBACK" VALUES ('18986', '633723', '很好', '2019-09-25');
INSERT INTO "RY"."TB_FEEDBACK" VALUES ('202985', '4', 'uu与他', '2019-11-11');
INSERT INTO "RY"."TB_FEEDBACK" VALUES ('299413', '2', '555', '2019-11-11');
INSERT INTO "RY"."TB_FEEDBACK" VALUES ('539253', '809910', '1111', '2019-11-18');
INSERT INTO "RY"."TB_FEEDBACK" VALUES ('726643', '420069', '111', '2019-11-11');

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
INSERT INTO "RY"."TB_HOUSE" VALUES ('123457', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '秦宓', '13074699862', '否', '2008-09-11', '2019-09-11', '建设项目排水审批', '2008-09-11~2019-09-11', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('1', 'XXXX科技有限公司', '深圳市盐田区xx街道xxxx餐馆', '陈明发', '12236954876', '是', '2019-09-11', '2020-09-11', '建设项目排水审批', '2019-09-11~2020-09-11', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('298470', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王七十', '13459686957', '否', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('338470', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '孙大叔', '13556964865', '是', '2019-09-11', '2023-09-11', '城市排水许可', '2019-09-11~2023-09-11', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('2', 'XXXX科技有限公司', '深圳市盐田区xx街道xxxx餐馆', '李商店', '13652648988', '是', '2019-09-12', '2022-09-14', '城市排水许可', '2019-09-12~2022-09-14', 'adasdasda');
INSERT INTO "RY"."TB_HOUSE" VALUES ('3', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '秦宓', '13074699833', '是', '2019-09-09', '2019-10-11', '城市排水许可', '2019-09-09~2019-10-11', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('6', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王大苏打', '13459686957', '否', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('6666', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王七', '13459686957', '否', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('2984755', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王十', '13459686957', '否', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('2635', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王啊啊', '13459686957', '否', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('55986', 'XXXX科技有限公司', '深圳市福田区xx街道xxxx餐馆', '王破', '13459686957', '是', '2013-09-11', '2020-05-10', '城市排水许可', '2013-09-11~2020-05-10', 'XXXX项目');
INSERT INTO "RY"."TB_HOUSE" VALUES ('123455', 'HHHH科技有限公司', '深圳市福田区xx街道xxxx餐馆', '秦噢', '13074699862', '是', '2008-09-11', '2019-09-11', '建设项目排水审批', '2008-09-11~2019-09-11', 'HHHH项目');

-- ----------------------------
-- Table structure for TB_PICTURE
-- ----------------------------
DROP TABLE "RY"."TB_PICTURE";
CREATE TABLE "RY"."TB_PICTURE" (
"PICTURE_ID" VARCHAR2(11 CHAR) NOT NULL ,
"PICTURE_LOCATION" VARCHAR2(200 CHAR) NOT NULL ,
"FEEDBACK_ID" VARCHAR2(11 CHAR) NOT NULL ,
"PICTURE_NAME" VARCHAR2(200 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_PICTURE
-- ----------------------------
INSERT INTO "RY"."TB_PICTURE" VALUES ('402481', '/profile/upload/2019/09/23/871030e55930dea9c29ca133ece34b49.jpg', '513543', 'dasd.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('806935', '/profile/upload/2019/09/23/6d3a5a0c87a5272a26a9a159bb4a13ae.jpg', '513543', 'aaa.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('799703', '/profile/upload/2019/09/23/7fcb6ed6b1d5ba473d4b34a4956a5b04.jpg', '513543', 'fff.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('318171', '/profile/upload/2019/09/23/a882b40a011d3a654b480234d9e697eb.jpg', '173970', 'qqq.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('639710', '/profile/upload/2019/09/23/62c476b83178389611c36882cd57efec.jpg', '173970', 'fff.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('175943', '/profile/upload/2019/09/23/31c22c4de21f3f103505beffbf3b86f9.jpg', '306743', 'dasd.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('344042', '/profile/upload/2019/09/25/2223b82754ef327aab1a73bede552a92.jpg', '386628', 'dasd.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('368333', '/profile/upload/2019/09/25/732ba13d26d7bb7eae8d83f82a01b4e4.jpg', '1', 'qqq.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('965050', '/profile\upload\2019/11/29\cfb76b323d91116a7f48e7bf37ff7e44.jpg', '346993', 'dasd.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('343657', '/profile\upload\2019/11/18\7529b53f278066e98305a8d69fe7e284.jpg', '539253', 'fff.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('142627', '/profile\upload\2019/11/11\95e5b8f1f17159698f80b222b21988fc.jpg', '202985', 'qqq.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('449047', '/profile/upload/2019/09/25/d40cff80c4d054dbe1046f5bb62ea229.jpg', '386628', 'aaa.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('358260', '/profile\upload\2019/11/11\10bec5b51a031fe1ca1e4d1c2a2190e6.jpg', '299413', 'dasd.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('996597', '/profile/upload/2019/09/23/fc47ca39d9c3886b603fc13d44daf04c.jpg', '979258', '20160616170850200.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('368332', '/profile/upload/2019/09/25/732ba13d26d7bb7eae8d83f82a01b4e4.jpg', '18986', 'qqq.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('817690', '/profile\upload\2019/11/09\64456048f350d44effe46db4263fb5a7.jpg', '607927', 'fff.jpg');
INSERT INTO "RY"."TB_PICTURE" VALUES ('634863', '/profile\upload\2019/11/11\99022c50b3cf9c6e1a2e80b686322458.jpg', '726643', 'fff.jpg');

-- ----------------------------
-- Table structure for TB_RULE
-- ----------------------------
DROP TABLE "RY"."TB_RULE";
CREATE TABLE "RY"."TB_RULE" (
"RULE_NUMBER" VARCHAR2(11 CHAR) NOT NULL ,
"RULE_CONTENT" VARCHAR2(100 CHAR) NULL ,
"RULE_TYPE" VARCHAR2(20 CHAR) NULL ,
"RULE_NAME" VARCHAR2(20 CHAR) NULL ,
"RULE_BASIS" VARCHAR2(50 CHAR) NULL ,
"RULE_SCALE" VARCHAR2(10 CHAR) NULL ,
"RULE_MAIN" VARCHAR2(20 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_RULE
-- ----------------------------
INSERT INTO "RY"."TB_RULE" VALUES ('390336', '外观检查', '排水行政许可', '建设项目排水审批', '文件指导', '15%', '排水管理处');
INSERT INTO "RY"."TB_RULE" VALUES ('1', '外观检查', '排水行政许可', '城市排水许可', '文件指导', '20%', '排水管理处');

-- ----------------------------
-- Table structure for TB_STAFF
-- ----------------------------
DROP TABLE "RY"."TB_STAFF";
CREATE TABLE "RY"."TB_STAFF" (
"STAFF_NUMBER" VARCHAR2(11 CHAR) NOT NULL ,
"STAFF_NAME" VARCHAR2(10 CHAR) NOT NULL ,
"STAFF_POST" VARCHAR2(11 CHAR) NOT NULL ,
"STAFF_DEPT" VARCHAR2(20 CHAR) NOT NULL ,
"STAFF_W" VARCHAR2(5 CHAR) NULL ,
"STAFF_AREA" VARCHAR2(20 CHAR) NULL ,
"STAFF_CART" VARCHAR2(30 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_STAFF
-- ----------------------------
INSERT INTO "RY"."TB_STAFF" VALUES ('123', '李欧克', '一类', 'XXXX科技有限公司', '备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('1233', '李破败', '一类', 'XXXX科技有限公司', '备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('12366', '李给', '一类', 'XXXX科技有限公司', '备选', null, 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('123669', '李普', '一类', 'XXXX科技有限公司', '非备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('2369', '罗德', '二类', 'XXXX科技有限公司', '非备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('254', '罗岛', '二类', 'XXXX科技有限公司', '备选', null, 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('2987', '德岛', '二类', 'XXXX科技有限公司', '非备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('21111', '恐岛', '二类', 'XXXX科技有限公司', '非备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('338470', '张天志', '一类', 'XXXX科技有限公司', '非备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('1', '王小明', '一类', 'XXXX科技有限公司', '备选', null, 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('298470', '李四发', '一类', 'XXXX科技有限公司', '备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('218470', '李得到', '一类', 'XXXX科技有限公司', '备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('298471', '李血谨', '二类', 'XXXX科技有限公司', '备选', null, 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('198470', '王的的', '二类', 'XXXX科技有限公司', '非备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('2', '罗德岛', '二类', 'XXXX科技有限公司', '备选', null, 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('3', '秦都', '二类', 'XXXX科技有限公司', '非备选', '排水行政许可', 'BM1965346532');
INSERT INTO "RY"."TB_STAFF" VALUES ('501455', '范帅', '二类', '啊大苏打有限公司', '非备选', '排水行政许可', '1126555422');

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
"TASK_FILE" VARCHAR2(200 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TASK
-- ----------------------------
INSERT INTO "RY"."TB_TASK" VALUES ('3', '2019-09-11', '1', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('123456', '2019-09-11', '3', '基本符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('4', '2019-04-11', '1', '不符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('91163', '2020-05-12', '123455', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('296381', '2020-05-28', '55986', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('686826', '2019-09-15', '2', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('123868', '2019-09-11', '298470', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('1', '2018-10-11', '3', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('2', '2019-09-15', '338470', '不符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('140424', '2019-09-23', '2', '不符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('455172', '2019-09-24', '1', '符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('420069', '2019-09-25', '1', '不符合', '责令处罚', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('633723', '2019-09-11', '298470', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('111111', '2019-09-11', '3', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('736026', '2020-05-12', '123457', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('809910', '2019-11-12', '123456', '符合', '责令整改', '完成', '2019-09-11', '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');
INSERT INTO "RY"."TB_TASK" VALUES ('633710', '2019-09-11', '1', null, null, '未完成', null, '/profile\upload\2019/11/18\9b1beb23cc3c3cbaff7b4e962946f8a9.doc');

-- ----------------------------
-- Table structure for TB_TASKSTAFF
-- ----------------------------
DROP TABLE "RY"."TB_TASKSTAFF";
CREATE TABLE "RY"."TB_TASKSTAFF" (
"TASK_NUMBER" VARCHAR2(11 CHAR) NOT NULL ,
"STAFF_NUMBER" VARCHAR2(11 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of TB_TASKSTAFF
-- ----------------------------
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('633710', '1');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('633710', '298470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('455172', '298470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('455172', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('140424', '1');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('140424', '298470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('140424', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('123868', '1');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('1', '1');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('2', '1');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('1', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('633723', '198470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('633723', '218470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('633723', '2');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('686826', '1');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('686826', '298470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('686826', '298471');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('4', '1');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('809910', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('809910', '298471');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('809910', '218470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('809910', '3');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('123456', '218470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('123456', '198470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('606791', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('606791', '123');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('606791', '12366');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('3', '3');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('3', '1');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('3', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('3', '298471');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('3', '218470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('3', '2');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('829844', '2987');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('829844', '2');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('829844', '2369');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('829844', '198470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('829844', '254');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('829844', '12366');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('91163', '123669');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('91163', '123');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('91163', '2');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('296381', '12366');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('296381', '2987');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('12345', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('12345', '3');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('111111', '3');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('111111', '218470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('34', '218470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('34', '298471');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('43903', '123669');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('420069', '298470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('420069', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('43903', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('43903', '123');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('749315', '123669');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('749315', '1233');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('749315', '218470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('154900', '123');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('154900', '123669');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('154900', '218470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('154900', '123');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('154900', '12366');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('154900', '338470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('736026', '12366');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('736026', '2987');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('736026', '123669');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('28778', '218470');
INSERT INTO "RY"."TB_TASKSTAFF" VALUES ('28778', '254');

-- ----------------------------
-- Checks structure for table EX_GDBS_SB
-- ----------------------------
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SBLSH" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SBLSH_SHORT" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SXBM" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SXMC" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SXQXBM" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SQRLX" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SQRMC" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SQRZJHM" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("LXRXM" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("LXRSJ" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SBXMMC" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("TJFS" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SBHZH" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SBSJ" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("XZQHDM" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("YSBLSH" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("REC_FLAG" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("D_ZZJGDM" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("SXBM_SHORT" IS NOT NULL);
ALTER TABLE "RY"."EX_GDBS_SB" ADD CHECK ("DWDM" IS NOT NULL);

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

-- ----------------------------
-- Indexes structure for table TB_FEEDBACK
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_FEEDBACK
-- ----------------------------
ALTER TABLE "RY"."TB_FEEDBACK" ADD CHECK ("FEEDBACK_ID" IS NOT NULL);
ALTER TABLE "RY"."TB_FEEDBACK" ADD CHECK ("TASK_NUMBER" IS NOT NULL);
ALTER TABLE "RY"."TB_FEEDBACK" ADD CHECK ("FEEDBACK_INFORMATION" IS NOT NULL);
ALTER TABLE "RY"."TB_FEEDBACK" ADD CHECK ("FEEDBACK_TIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_FEEDBACK
-- ----------------------------
ALTER TABLE "RY"."TB_FEEDBACK" ADD PRIMARY KEY ("FEEDBACK_ID");

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
-- Indexes structure for table TB_PICTURE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_PICTURE
-- ----------------------------
ALTER TABLE "RY"."TB_PICTURE" ADD CHECK ("PICTURE_ID" IS NOT NULL);
ALTER TABLE "RY"."TB_PICTURE" ADD CHECK ("PICTURE_LOCATION" IS NOT NULL);
ALTER TABLE "RY"."TB_PICTURE" ADD CHECK ("FEEDBACK_ID" IS NOT NULL);
ALTER TABLE "RY"."TB_PICTURE" ADD CHECK ("PICTURE_NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_PICTURE
-- ----------------------------
ALTER TABLE "RY"."TB_PICTURE" ADD PRIMARY KEY ("PICTURE_ID");

-- ----------------------------
-- Indexes structure for table TB_RULE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_RULE
-- ----------------------------
ALTER TABLE "RY"."TB_RULE" ADD CHECK ("RULE_NUMBER" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_RULE
-- ----------------------------
ALTER TABLE "RY"."TB_RULE" ADD PRIMARY KEY ("RULE_NUMBER");

-- ----------------------------
-- Indexes structure for table TB_STAFF
-- ----------------------------

-- ----------------------------
-- Checks structure for table TB_STAFF
-- ----------------------------
ALTER TABLE "RY"."TB_STAFF" ADD CHECK ("STAFF_NUMBER" IS NOT NULL);
ALTER TABLE "RY"."TB_STAFF" ADD CHECK ("STAFF_NAME" IS NOT NULL);
ALTER TABLE "RY"."TB_STAFF" ADD CHECK ("STAFF_POST" IS NOT NULL);
ALTER TABLE "RY"."TB_STAFF" ADD CHECK ("STAFF_DEPT" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TB_STAFF
-- ----------------------------
ALTER TABLE "RY"."TB_STAFF" ADD PRIMARY KEY ("STAFF_NUMBER");

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

-- ----------------------------
-- Checks structure for table TB_TASKSTAFF
-- ----------------------------
ALTER TABLE "RY"."TB_TASKSTAFF" ADD CHECK ("TASK_NUMBER" IS NOT NULL);
ALTER TABLE "RY"."TB_TASKSTAFF" ADD CHECK ("STAFF_NUMBER" IS NOT NULL);
