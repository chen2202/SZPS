--
--
--EMPLOYEE_T_COMPANY表结构发生变化，拆分成EMPLOYEE_T_COMPANY和EMPLOYEE_T_CP_PROJECT两个数据表
--需要删除原来的EMPLOYEE_T_COMPANY表，重新导入上面两个表
--
--SYS——MENU表有添加一些缺失的数据，可以直接导入
--

-- ----------------------------
-- Table structure for EMPLOYEE_T_COMPANY
-- ----------------------------
DROP TABLE "RY"."EMPLOYEE_T_COMPANY";
CREATE TABLE "RY"."EMPLOYEE_T_COMPANY" (
"COMPANY_ID" VARCHAR2(10 CHAR) NOT NULL ,
"COMPANY_NAME" VARCHAR2(30 CHAR) NOT NULL ,
"ADDRESS" VARCHAR2(25 CHAR) NOT NULL ,
"REPRESENTATIVE" VARCHAR2(4 CHAR) NOT NULL ,
"BUSINESS_SCOPE" VARCHAR2(25 CHAR) NOT NULL ,
"REGISTERED_CAPITAL" NUMBER NOT NULL ,
"QUALIFICATION" VARCHAR2(15 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."EMPLOYEE_T_COMPANY"."COMPANY_ID" IS '公司代码';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_COMPANY"."COMPANY_NAME" IS '公司名';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_COMPANY"."ADDRESS" IS '运营单位地址';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_COMPANY"."REPRESENTATIVE" IS '法定代表人';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_COMPANY"."BUSINESS_SCOPE" IS '经营范围';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_COMPANY"."REGISTERED_CAPITAL" IS '注册资本 万元';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_COMPANY"."QUALIFICATION" IS '企业资质';

-- ----------------------------
-- Records of EMPLOYEE_T_COMPANY
-- ----------------------------
INSERT INTO "RY"."EMPLOYEE_T_COMPANY" VALUES ('szltkjcp', '深圳市蓝天科技股份有限公司', '深圳市xx区', '张某', '科技', '1000', '合格');
INSERT INTO "RY"."EMPLOYEE_T_COMPANY" VALUES ('szrjgccp', '深圳市软件工程有限公司', '深圳市xx区', '赵某', '科技、软件', '500', '合格');
INSERT INTO "RY"."EMPLOYEE_T_COMPANY" VALUES ('szddsgcp', '深圳市大地施工公司', '深圳市xxx区', '陈xx', '排水、施工、电力', '200', '优秀');
INSERT INTO "RY"."EMPLOYEE_T_COMPANY" VALUES ('szdspscp', '深圳市地鼠排水公司', '深圳市xx区', '李某', '水质检查', '100', '合格');

-- ----------------------------
-- Indexes structure for table EMPLOYEE_T_COMPANY
-- ----------------------------

-- ----------------------------
-- Checks structure for table EMPLOYEE_T_COMPANY
-- ----------------------------
ALTER TABLE "RY"."EMPLOYEE_T_COMPANY" ADD CHECK ("COMPANY_ID" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_COMPANY" ADD CHECK ("COMPANY_NAME" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_COMPANY" ADD CHECK ("ADDRESS" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_COMPANY" ADD CHECK ("REPRESENTATIVE" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_COMPANY" ADD CHECK ("BUSINESS_SCOPE" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_COMPANY" ADD CHECK ("REGISTERED_CAPITAL" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_COMPANY" ADD CHECK ("QUALIFICATION" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table EMPLOYEE_T_COMPANY
-- ----------------------------
ALTER TABLE "RY"."EMPLOYEE_T_COMPANY" ADD PRIMARY KEY ("COMPANY_ID");



-- ----------------------------
-- Table structure for EMPLOYEE_T_CP_PROJECT
-- ----------------------------
CREATE TABLE "RY"."EMPLOYEE_T_CP_PROJECT" (
"COMPANY_ID" VARCHAR2(10 CHAR) NOT NULL ,
"PIPE_PROJECT" VARCHAR2(15 CHAR) NOT NULL ,
"PROJECT_SCOPE" VARCHAR2(15 CHAR) NOT NULL ,
"PIPE_STOP_TIME" DATE NOT NULL ,
"PROJECT_COMPANY_NAME" VARCHAR2(30 CHAR) NOT NULL ,
"PROJECT_COMPANY_ADDRESS" VARCHAR2(25 CHAR) NOT NULL ,
"PROJECT_PEOPLE" NUMBER(5) NOT NULL ,
"PROJECT_HEADER" VARCHAR2(4 CHAR) NOT NULL ,
"TELEPHONE" NUMBER(11) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."EMPLOYEE_T_CP_PROJECT"."COMPANY_ID" IS '公司代码';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_CP_PROJECT"."PIPE_PROJECT" IS '运营项目';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_CP_PROJECT"."PIPE_STOP_TIME" IS '运营截止时间';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_CP_PROJECT"."PROJECT_COMPANY_NAME" IS '项目公司名称';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_CP_PROJECT"."PROJECT_COMPANY_ADDRESS" IS '项目公司地址';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_CP_PROJECT"."PROJECT_PEOPLE" IS '项目人数';
COMMENT ON COLUMN "RY"."EMPLOYEE_T_CP_PROJECT"."TELEPHONE" IS '联系电话';

-- ----------------------------
-- Records of EMPLOYEE_T_CP_PROJECT
-- ----------------------------
INSERT INTO "RY"."EMPLOYEE_T_CP_PROJECT" VALUES ('szltkjcp', 'xx网运营', '软件', TO_DATE('2020-02-28 08:58:54', 'YYYY-MM-DD HH24:MI:SS'), 'xx公司', '深圳市xx区', '20', '郑某', '8019283');
INSERT INTO "RY"."EMPLOYEE_T_CP_PROJECT" VALUES ('szrjgccp', 'xxx网运营', '软件', TO_DATE('2019-10-27 08:59:05', 'YYYY-MM-DD HH24:MI:SS'), 'xx公司', '深圳市xx区', '25', '钱某', '8099994');
INSERT INTO "RY"."EMPLOYEE_T_CP_PROJECT" VALUES ('szdspscp', 'x区下水道清理', '工程', TO_DATE('2030-10-01 08:59:11', 'YYYY-MM-DD HH24:MI:SS'), 'xx公司', '深圳市xx区', '15', '郭某', '8012834');
INSERT INTO "RY"."EMPLOYEE_T_CP_PROJECT" VALUES ('szdspscp', 'xxx区xxx路绿化', '工程', TO_DATE('2020-03-14 15:05:55', 'YYYY-MM-DD HH24:MI:SS'), 'xxx公司', '深圳市xxx区', '30', '赵某', '8098334');

-- ----------------------------
-- Checks structure for table EMPLOYEE_T_CP_PROJECT
-- ----------------------------
ALTER TABLE "RY"."EMPLOYEE_T_CP_PROJECT" ADD CHECK ("COMPANY_ID" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_CP_PROJECT" ADD CHECK ("PIPE_PROJECT" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_CP_PROJECT" ADD CHECK ("PROJECT_SCOPE" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_CP_PROJECT" ADD CHECK ("PIPE_STOP_TIME" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_CP_PROJECT" ADD CHECK ("PROJECT_COMPANY_NAME" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_CP_PROJECT" ADD CHECK ("PROJECT_COMPANY_ADDRESS" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_CP_PROJECT" ADD CHECK ("PROJECT_PEOPLE" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_CP_PROJECT" ADD CHECK ("PROJECT_HEADER" IS NOT NULL);
ALTER TABLE "RY"."EMPLOYEE_T_CP_PROJECT" ADD CHECK ("TELEPHONE" IS NOT NULL);




-- 导入SYS_MENU表的缺失数据
INSERT INTO "RY"."SYS_MENU" VALUES ('6110', '人员信息编辑', '6100', '9', '#', null, 'F', '0', 'employee:worker:edit', '#', 'admin', TO_DATE('2019-10-08 15:19:11', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-08 15:19:16', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6111', '水厂信息详情', '6100', '10', '#', null, 'F', '0', 'employee:factory:detail', '#', 'admin', TO_DATE('2019-10-02 17:20:56', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-02 17:21:11', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6112', '水厂信息新增', '6100', '11', '#', null, 'F', '0', 'employee:factory:add', '#', 'admin', TO_DATE('2019-10-23 08:53:50', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-23 08:54:07', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6113', '水厂信息删除', '6100', '12', '#', null, 'F', '0', 'employee:factory:remove', '#', 'admin', TO_DATE('2019-10-23 08:55:12', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-23 08:55:15', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6114', '水厂信息编辑', '6100', '13', '#', null, 'F', '0', 'employee:factory:edit', '#', 'admin', TO_DATE('2019-10-23 08:56:46', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-23 08:56:50', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6115', '公司信息新增', '6100', '14', '#', null, 'F', '0', 'employee:company:add', '#', 'admin', TO_DATE('2019-10-23 09:02:23', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-23 09:02:29', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6116', '公司信息删除', '6100', '15', '#', null, 'F', '0', 'employee:company:remove', '#', 'admin', TO_DATE('2019-10-23 09:04:00', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-23 09:04:03', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6117', '公司信息编辑', '6100', '16', '#', null, 'F', '0', 'employee:company:edit', '#', 'admin', TO_DATE('2019-10-23 09:05:31', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-23 09:05:35', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6118', '部门信息', '6100', '17', '/employee/department', 'menuItem', 'C', '0', 'employee:department:view', '#', 'admin', TO_DATE('2019-10-03 15:14:48', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-10-03 15:14:50', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('6119', '部门信息查询', '6100', '18', '#', null, 'F', '0', 'employee:department:list', '#', 'admin', TO_DATE('2019-10-08 15:26:01', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-08 15:26:04', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6120', '部门信息删除', '6100', '19', '#', null, 'F', '0', 'employee:department:remove', '#', 'admin', TO_DATE('2019-10-08 15:27:09', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-08 15:27:12', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6121', '部门信息新增', '6100', '20', '#', null, 'F', '0', 'employee:department:add', '#', 'admin', TO_DATE('2019-10-08 15:28:00', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-08 15:28:02', 'YYYY-MM-DD HH24:MI:SS'), null, null);