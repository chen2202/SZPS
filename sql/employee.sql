DROP TABLE "RY"."T_DEPARTMENT";
CREATE TABLE "RY"."T_DEPARTMENT" (
"DEPARTMENT_ID" VARCHAR2(10 CHAR) NOT NULL ,
"DEPARTMENT_NAME" VARCHAR2(20 CHAR) NOT NULL ,
"COMPANY_ID" VARCHAR2(8 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."T_DEPARTMENT"."DEPARTMENT_ID" IS '���Ŵ���';
COMMENT ON COLUMN "RY"."T_DEPARTMENT"."DEPARTMENT_NAME" IS '������';
COMMENT ON COLUMN "RY"."T_DEPARTMENT"."COMPANY_ID" IS '��˾����';

-- ----------------------------
-- Records of T_DEPARTMENT
-- ----------------------------
INSERT INTO "RY"."T_DEPARTMENT" VALUES ('ltcpwhb', 'ά����', 'szltkjcp');
INSERT INTO "RY"."T_DEPARTMENT" VALUES ('ltcpyyb', '��Ӫ��', 'szltkjcp');
INSERT INTO "RY"."T_DEPARTMENT" VALUES ('ltcpxsb', '���۲�', 'szltkjcp');

-- ----------------------------
-- Indexes structure for table T_DEPARTMENT
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_DEPARTMENT
-- ----------------------------
ALTER TABLE "RY"."T_DEPARTMENT" ADD CHECK ("DEPARTMENT_ID" IS NOT NULL);
ALTER TABLE "RY"."T_DEPARTMENT" ADD CHECK ("DEPARTMENT_NAME" IS NOT NULL);
ALTER TABLE "RY"."T_DEPARTMENT" ADD CHECK ("COMPANY_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_DEPARTMENT
-- ----------------------------
ALTER TABLE "RY"."T_DEPARTMENT" ADD PRIMARY KEY ("DEPARTMENT_ID", "COMPANY_ID");

DROP TABLE "RY"."SYS_MENU";
CREATE TABLE "RY"."SYS_MENU" (
"MENU_ID" NUMBER(20) NOT NULL ,
"MENU_NAME" VARCHAR2(50 BYTE) NOT NULL ,
"PARENT_ID" NUMBER(20) DEFAULT 0  NULL ,
"ORDER_NUM" NUMBER(4) DEFAULT 0  NULL ,
"URL" VARCHAR2(200 BYTE) DEFAULT '#'  NULL ,
"TARGET" VARCHAR2(20 BYTE) DEFAULT ''  NULL ,
"MENU_TYPE" CHAR(1 BYTE) DEFAULT ''  NULL ,
"VISIBLE" CHAR(1 BYTE) DEFAULT 0  NULL ,
"PERMS" VARCHAR2(100 BYTE) DEFAULT NULL  NULL ,
"ICON" VARCHAR2(100 BYTE) DEFAULT '#'  NULL ,
"CREATE_BY" VARCHAR2(64 BYTE) DEFAULT ''  NULL ,
"CREATE_TIME" DATE NULL ,
"UPDATE_BY" VARCHAR2(64 BYTE) DEFAULT ''  NULL ,
"UPDATE_TIME" DATE NULL ,
"REMARK" VARCHAR2(500 BYTE) DEFAULT ''  NULL ,
"SUBSYS_FLAG" VARCHAR2(64 BYTE) DEFAULT NULL  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "RY"."SYS_MENU" IS '�˵�Ȩ�ޱ�';
COMMENT ON COLUMN "RY"."SYS_MENU"."MENU_ID" IS '�˵�����seq_sys_post.nextval';
COMMENT ON COLUMN "RY"."SYS_MENU"."MENU_NAME" IS '�˵�����';
COMMENT ON COLUMN "RY"."SYS_MENU"."PARENT_ID" IS '���˵�ID';
COMMENT ON COLUMN "RY"."SYS_MENU"."ORDER_NUM" IS '��ʾ˳��';
COMMENT ON COLUMN "RY"."SYS_MENU"."URL" IS '�����ַ';
COMMENT ON COLUMN "RY"."SYS_MENU"."TARGET" IS '�򿪷�ʽ��menuItemҳǩ menuBlank�´��ڣ�';
COMMENT ON COLUMN "RY"."SYS_MENU"."MENU_TYPE" IS '�˵����ͣ�MĿ¼ C�˵� F��ť��';
COMMENT ON COLUMN "RY"."SYS_MENU"."VISIBLE" IS '�˵�״̬��0��ʾ 1���أ�';
COMMENT ON COLUMN "RY"."SYS_MENU"."PERMS" IS 'Ȩ�ޱ�ʶ';
COMMENT ON COLUMN "RY"."SYS_MENU"."ICON" IS '�˵�ͼ��';
COMMENT ON COLUMN "RY"."SYS_MENU"."CREATE_BY" IS '������';
COMMENT ON COLUMN "RY"."SYS_MENU"."CREATE_TIME" IS '����ʱ��';
COMMENT ON COLUMN "RY"."SYS_MENU"."UPDATE_BY" IS '������';
COMMENT ON COLUMN "RY"."SYS_MENU"."UPDATE_TIME" IS '����ʱ��';
COMMENT ON COLUMN "RY"."SYS_MENU"."REMARK" IS '��ע';
COMMENT ON COLUMN "RY"."SYS_MENU"."SUBSYS_FLAG" IS '��ϵͳ��־';

-- ----------------------------
-- Records of SYS_MENU
-- ----------------------------
INSERT INTO "RY"."SYS_MENU" VALUES ('1', 'ϵͳ����', '0', '1', '#', null, 'M', '0', null, 'fa fa-gear', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ϵͳ����Ŀ¼', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2', 'ϵͳ���', '0', '2', '#', null, 'M', '0', null, 'fa fa-video-camera', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ϵͳ���Ŀ¼', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('3', 'ϵͳ����', '0', '3', '#', 'menuItem', 'M', '1', null, 'fa fa-bars', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-03 15:15:54', 'YYYY-MM-DD HH24:MI:SS'), 'ϵͳ����Ŀ¼', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('100', '�û�����', '1', '1', '/system/user', null, 'C', '0', 'system:user:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '�û�����˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('101', '��ɫ����', '1', '2', '/system/role', null, 'C', '0', 'system:role:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '��ɫ����˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('102', '�˵�����', '1', '3', '/system/menu', null, 'C', '0', 'system:menu:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '�˵�����˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('103', '���Ź���', '1', '4', '/system/dept', null, 'C', '0', 'system:dept:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '���Ź���˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('104', '��λ����', '1', '5', '/system/post', null, 'C', '0', 'system:post:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '��λ����˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('105', '�ֵ����', '1', '6', '/system/dict', null, 'C', '0', 'system:dict:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '�ֵ����˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('106', '��������', '1', '7', '/system/config', null, 'C', '0', 'system:config:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '�������ò˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('107', '֪ͨ����', '1', '8', '/system/notice', null, 'C', '0', 'system:notice:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '֪ͨ����˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('108', '��־����', '1', '9', '#', null, 'M', '0', null, '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '��־����˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('109', '�����û�', '2', '1', '/monitor/online', null, 'C', '0', 'monitor:online:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '�����û��˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('110', '��ʱ����', '2', '2', '/monitor/job', 'menuItem', 'C', '1', 'monitor:job:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-03 15:30:35', 'YYYY-MM-DD HH24:MI:SS'), '��ʱ����˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('111', '���ݼ��', '2', '3', '/monitor/data', null, 'C', '0', 'monitor:data:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '���ݼ�ز˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('112', '������', '2', '3', '/monitor/server', null, 'C', '0', 'monitor:server:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '�����ز˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('113', '������', '3', '1', '/tool/build', 'menuItem', 'C', '1', 'tool:build:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-03 15:14:37', 'YYYY-MM-DD HH24:MI:SS'), '�������˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('114', '��������', '3', '2', '/tool/gen', 'menuItem', 'C', '1', 'tool:gen:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-03 15:14:45', 'YYYY-MM-DD HH24:MI:SS'), '�������ɲ˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('115', 'ϵͳ�ӿ�', '3', '3', '/tool/swagger', null, 'C', '0', 'tool:swagger:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ϵͳ�ӿڲ˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('500', '������־', '108', '1', '/monitor/operlog', null, 'C', '0', 'monitor:operlog:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '������־�˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('501', '��¼��־', '108', '2', '/monitor/logininfor', null, 'C', '0', 'monitor:logininfor:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '��¼��־�˵�', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1000', '�û���ѯ', '100', '1', '#', null, 'F', '0', 'system:user:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1001', '�û�����', '100', '2', '#', null, 'F', '0', 'system:user:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1002', '�û��޸�', '100', '3', '#', null, 'F', '0', 'system:user:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1003', '�û�ɾ��', '100', '4', '#', null, 'F', '0', 'system:user:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1004', '�û�����', '100', '5', '#', null, 'F', '0', 'system:user:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1005', '�û�����', '100', '6', '#', null, 'F', '0', 'system:user:import', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1006', '��������', '100', '7', '#', null, 'F', '0', 'system:user:resetPwd', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1007', '��ɫ��ѯ', '101', '1', '#', null, 'F', '0', 'system:role:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1008', '��ɫ����', '101', '2', '#', null, 'F', '0', 'system:role:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1009', '��ɫ�޸�', '101', '3', '#', null, 'F', '0', 'system:role:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1010', '��ɫɾ��', '101', '4', '#', null, 'F', '0', 'system:role:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1011', '��ɫ����', '101', '5', '#', null, 'F', '0', 'system:role:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1012', '�˵���ѯ', '102', '1', '#', null, 'F', '0', 'system:menu:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1013', '�˵�����', '102', '2', '#', null, 'F', '0', 'system:menu:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1014', '�˵��޸�', '102', '3', '#', null, 'F', '0', 'system:menu:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1015', '�˵�ɾ��', '102', '4', '#', null, 'F', '0', 'system:menu:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1016', '���Ų�ѯ', '103', '1', '#', null, 'F', '0', 'system:dept:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1017', '��������', '103', '2', '#', null, 'F', '0', 'system:dept:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1018', '�����޸�', '103', '3', '#', null, 'F', '0', 'system:dept:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1019', '����ɾ��', '103', '4', '#', null, 'F', '0', 'system:dept:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1020', '��λ��ѯ', '104', '1', '#', null, 'F', '0', 'system:post:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1021', '��λ����', '104', '2', '#', null, 'F', '0', 'system:post:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1022', '��λ�޸�', '104', '3', '#', null, 'F', '0', 'system:post:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1023', '��λɾ��', '104', '4', '#', null, 'F', '0', 'system:post:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1024', '��λ����', '104', '5', '#', null, 'F', '0', 'system:post:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1025', '�ֵ��ѯ', '105', '1', '#', null, 'F', '0', 'system:dict:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1026', '�ֵ�����', '105', '2', '#', null, 'F', '0', 'system:dict:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1027', '�ֵ��޸�', '105', '3', '#', null, 'F', '0', 'system:dict:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1028', '�ֵ�ɾ��', '105', '4', '#', null, 'F', '0', 'system:dict:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1029', '�ֵ䵼��', '105', '5', '#', null, 'F', '0', 'system:dict:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1030', '������ѯ', '106', '1', '#', null, 'F', '0', 'system:config:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1031', '��������', '106', '2', '#', null, 'F', '0', 'system:config:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1032', '�����޸�', '106', '3', '#', null, 'F', '0', 'system:config:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1033', '����ɾ��', '106', '4', '#', null, 'F', '0', 'system:config:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1034', '��������', '106', '5', '#', null, 'F', '0', 'system:config:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1035', '�����ѯ', '107', '1', '#', null, 'F', '0', 'system:notice:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1036', '��������', '107', '2', '#', null, 'F', '0', 'system:notice:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1037', '�����޸�', '107', '3', '#', null, 'F', '0', 'system:notice:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1038', '����ɾ��', '107', '4', '#', null, 'F', '0', 'system:notice:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1039', '������ѯ', '500', '1', '#', null, 'F', '0', 'monitor:operlog:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1040', '����ɾ��', '500', '2', '#', null, 'F', '0', 'monitor:operlog:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1041', '��ϸ��Ϣ', '500', '3', '#', null, 'F', '0', 'monitor:operlog:detail', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1042', '��־����', '500', '4', '#', null, 'F', '0', 'monitor:operlog:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1043', '��¼��ѯ', '501', '1', '#', null, 'F', '0', 'monitor:logininfor:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1044', '��¼ɾ��', '501', '2', '#', null, 'F', '0', 'monitor:logininfor:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1045', '��־����', '501', '3', '#', null, 'F', '0', 'monitor:logininfor:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1046', '���߲�ѯ', '109', '1', '#', null, 'F', '0', 'monitor:online:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1047', '����ǿ��', '109', '2', '#', null, 'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1048', '����ǿ��', '109', '3', '#', null, 'F', '0', 'monitor:online:forceLogout', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1049', '�����ѯ', '110', '1', '#', null, 'F', '0', 'monitor:job:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1050', '��������', '110', '2', '#', null, 'F', '0', 'monitor:job:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1051', '�����޸�', '110', '3', '#', null, 'F', '0', 'monitor:job:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1052', '����ɾ��', '110', '4', '#', null, 'F', '0', 'monitor:job:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1053', '״̬�޸�', '110', '5', '#', null, 'F', '0', 'monitor:job:changeStatus', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1054', '������ϸ', '110', '6', '#', null, 'F', '0', 'monitor:job:detail', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1055', '���񵼳�', '110', '7', '#', null, 'F', '0', 'monitor:job:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1056', '���ɲ�ѯ', '114', '1', '#', null, 'F', '0', 'tool:gen:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1057', '�����޸�', '114', '2', '#', null, 'F', '0', 'tool:gen:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1058', '����ɾ��', '114', '3', '#', null, 'F', '0', 'tool:gen:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1059', 'Ԥ������', '114', '4', '#', null, 'F', '0', 'tool:gen:preview', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1060', '���ɴ���', '114', '5', '#', null, 'F', '0', 'tool:gen:code', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2000', '��ϵͳ', '0', '0', '/system/subsys', 'menuItem', 'C', '1', 'system:subsys:nav', 'fa fa-hand-pointer-o', 'admin', TO_DATE('2019-09-03 17:22:35', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-07 17:30:10', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2001', '��ˮSCADA���ϵͳ', '2000', '0', '/system/subsys/view/a', 'menuItem', 'C', '1', 'system:subsys:view:a', '#', 'admin', TO_DATE('2019-09-03 17:23:48', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-05 22:09:34', 'YYYY-MM-DD HH24:MI:SS'), null, 'SCADA');
INSERT INTO "RY"."SYS_MENU" VALUES ('2060', '�������', '2040', '0', '#', 'menuItem', 'C', '0', null, 'fa fa-file-archive-o', 'admin', TO_DATE('2019-09-06 10:05:55', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2021', '��ˮ��ʩ������Ϣϵͳ', '2000', '1', '/system/subsys/view/b', 'menuItem', 'C', '1', 'system:subsys:view:b', '#', 'admin', TO_DATE('2019-09-04 01:30:23', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-05 22:00:31', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2040', '��Ӫ��Ϣ����ϵͳ', '2000', '2', 'http://localhost:8089', 'menuItem', 'C', '1', 'system:subsys:view:c', '#', 'admin', TO_DATE('2019-09-04 09:34:57', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-08 08:18:58', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2041', '���ܷ�������ϵͳ', '2000', '3', '/system/subsys/view/d', 'menuItem', 'C', '1', 'system:subsys:view:b', '#', 'admin', TO_DATE('2019-09-04 09:38:22', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-05 22:01:04', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2042', '���ݲɼ�ϵͳ', '2000', '4', '/system/subsys/view/e', 'menuItem', 'C', '1', 'system:subsys:view:e', '#', 'admin', TO_DATE('2019-09-04 09:42:25', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-05 22:02:26', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2061', '�ձ�', '2060', '1', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:30:43', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2062', '�ܱ�', '2060', '2', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:31:07', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2063', '�±�', '2060', '3', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:34:49', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2064', '������־', '2060', '4', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:37:20', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2065', '����', '2060', '5', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:38:11', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-06 10:38:35', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2066', '�ձ���ѯ', '2061', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:46:17', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2067', '�ձ�����', '2061', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:46:38', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2068', '�ܱ���ѯ', '2062', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:46:59', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2069', '�ܱ�����', '2062', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:47:17', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2070', '�±���ѯ', '2063', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:48:25', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2071', '�±�����', '2063', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:48:41', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2072', '������־��ѯ', '2064', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:49:01', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2073', '������־����', '2064', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:49:19', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2074', '�ձ��޸�', '2061', '3', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:55:11', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2075', '�ձ�����', '2061', '4', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:55:36', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2076', '�ձ�ɾ��', '2061', '5', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:56:03', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2077', '�ܱ��޸�', '2062', '3', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 11:28:27', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2080', '�ջ��ܱ�', '2065', '1', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-07 17:09:10', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2081', '�»��ܱ�', '2065', '2', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-07 17:09:37', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2082', '��ѯ', '2080', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-07 17:10:39', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2083', '����', '2080', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-07 17:10:55', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2100', '��ҵ��Ա����', '2040', '1', '#', 'menuItem', 'C', '0', null, 'fa fa-address-book', 'admin', TO_DATE('2019-09-16 13:31:48', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-16 18:09:52', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2101', '��Ա��Ϣ', '2100', '0', '/employee', 'menuItem', 'C', '0', 'employee:view', '#', 'admin', TO_DATE('2019-09-16 13:33:22', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-16 18:10:37', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2102', '��Ա��Ϣ��ѯ', '2100', '1', '#', null, 'F', '0', 'employee:list', '#', 'admin', TO_DATE('2019-09-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-09-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2103', '��Ա��Ϣ����', '2100', '2', '#', null, 'F', '0', 'employee:add', '#', 'admin', TO_DATE('2019-09-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-09-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);

-- ----------------------------
-- Checks structure for table SYS_MENU
-- ----------------------------
ALTER TABLE "RY"."SYS_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "RY"."SYS_MENU" ADD CHECK ("MENU_NAME" IS NOT NULL);

DROP TABLE "RY"."T_WORKER";
CREATE TABLE "RY"."T_WORKER" (
"IDCARD" VARCHAR2(18 CHAR) NOT NULL ,
"NAME" VARCHAR2(20 CHAR) NOT NULL ,
"SEX" VARCHAR2(4 CHAR) NOT NULL ,
"BIRTHDAY" DATE NOT NULL ,
"TELEPHONE" NUMBER(11) NOT NULL ,
"EMAIL" VARCHAR2(30 CHAR) NOT NULL ,
"TITLE" VARCHAR2(20 CHAR) NOT NULL ,
"PROFESSION" VARCHAR2(20 CHAR) NOT NULL ,
"COMPANY_NAME" VARCHAR2(20 CHAR) NOT NULL ,
"POSITION" VARCHAR2(20 CHAR) NOT NULL ,
"DEPARTMENT_ID" VARCHAR2(8 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."T_WORKER"."IDCARD" IS '���֤��';
COMMENT ON COLUMN "RY"."T_WORKER"."NAME" IS '����';
COMMENT ON COLUMN "RY"."T_WORKER"."SEX" IS '�Ա�';
COMMENT ON COLUMN "RY"."T_WORKER"."BIRTHDAY" IS '��������';
COMMENT ON COLUMN "RY"."T_WORKER"."TELEPHONE" IS '�绰����';
COMMENT ON COLUMN "RY"."T_WORKER"."EMAIL" IS '����';
COMMENT ON COLUMN "RY"."T_WORKER"."TITLE" IS 'ְ��';
COMMENT ON COLUMN "RY"."T_WORKER"."PROFESSION" IS 'רҵ����';
COMMENT ON COLUMN "RY"."T_WORKER"."COMPANY_NAME" IS '������˾';
COMMENT ON COLUMN "RY"."T_WORKER"."POSITION" IS 'ְλ';
COMMENT ON COLUMN "RY"."T_WORKER"."DEPARTMENT_ID" IS '���Ŵ���';

-- ----------------------------
-- Records of T_WORKER
-- ----------------------------
INSERT INTO "RY"."T_WORKER" VALUES ('350181197710102918', '����', '��', TO_DATE('2019-05-06 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '18839422930', '12334234@qq.com', '����Ա��', 'һ��', '����������Ƽ��ɷ����޹�˾', '���Ա', 'ltcpwhb');
INSERT INTO "RY"."T_WORKER" VALUES ('123428955033920194', '��һ��', '��', TO_DATE('2019-09-03 17:12:05', 'YYYY-MM-DD HH24:MI:SS'), '29940399204', '2435649874@qq.com', '�߼�Ա��', '����', '����������Ƽ��ɷ����޹�˾', '���Ա', 'ltcpwhb');

-- ----------------------------
-- Indexes structure for table T_WORKER
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_WORKER
-- ----------------------------
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("IDCARD" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("SEX" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("BIRTHDAY" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("TELEPHONE" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("EMAIL" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("TITLE" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("PROFESSION" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("COMPANY_NAME" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("POSITION" IS NOT NULL);
ALTER TABLE "RY"."T_WORKER" ADD CHECK ("DEPARTMENT_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_WORKER
-- ----------------------------
ALTER TABLE "RY"."T_WORKER" ADD PRIMARY KEY ("IDCARD");

DROP TABLE "RY"."T_COMPANY";
CREATE TABLE "RY"."T_COMPANY" (
"COMPANY_ID" VARCHAR2(10 CHAR) NOT NULL ,
"COMPANY_NAME" VARCHAR2(30 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."T_COMPANY"."COMPANY_ID" IS '��˾����';
COMMENT ON COLUMN "RY"."T_COMPANY"."COMPANY_NAME" IS '��˾��';

-- ----------------------------
-- Records of T_COMPANY
-- ----------------------------
INSERT INTO "RY"."T_COMPANY" VALUES ('szltkjcp', '����������Ƽ��ɷ����޹�˾');

-- ----------------------------
-- Indexes structure for table T_COMPANY
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_COMPANY
-- ----------------------------
ALTER TABLE "RY"."T_COMPANY" ADD CHECK ("COMPANY_ID" IS NOT NULL);
ALTER TABLE "RY"."T_COMPANY" ADD CHECK ("COMPANY_NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_COMPANY
-- ----------------------------
ALTER TABLE "RY"."T_COMPANY" ADD PRIMARY KEY ("COMPANY_ID");