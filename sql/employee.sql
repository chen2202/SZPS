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
COMMENT ON COLUMN "RY"."T_DEPARTMENT"."DEPARTMENT_ID" IS '部门代码';
COMMENT ON COLUMN "RY"."T_DEPARTMENT"."DEPARTMENT_NAME" IS '部门名';
COMMENT ON COLUMN "RY"."T_DEPARTMENT"."COMPANY_ID" IS '公司代码';

-- ----------------------------
-- Records of T_DEPARTMENT
-- ----------------------------
INSERT INTO "RY"."T_DEPARTMENT" VALUES ('ltcpwhb', '维护部', 'szltkjcp');
INSERT INTO "RY"."T_DEPARTMENT" VALUES ('ltcpyyb', '运营部', 'szltkjcp');
INSERT INTO "RY"."T_DEPARTMENT" VALUES ('ltcpxsb', '销售部', 'szltkjcp');

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
COMMENT ON TABLE "RY"."SYS_MENU" IS '菜单权限表';
COMMENT ON COLUMN "RY"."SYS_MENU"."MENU_ID" IS '菜单主键seq_sys_post.nextval';
COMMENT ON COLUMN "RY"."SYS_MENU"."MENU_NAME" IS '菜单名称';
COMMENT ON COLUMN "RY"."SYS_MENU"."PARENT_ID" IS '父菜单ID';
COMMENT ON COLUMN "RY"."SYS_MENU"."ORDER_NUM" IS '显示顺序';
COMMENT ON COLUMN "RY"."SYS_MENU"."URL" IS '请求地址';
COMMENT ON COLUMN "RY"."SYS_MENU"."TARGET" IS '打开方式（menuItem页签 menuBlank新窗口）';
COMMENT ON COLUMN "RY"."SYS_MENU"."MENU_TYPE" IS '菜单类型（M目录 C菜单 F按钮）';
COMMENT ON COLUMN "RY"."SYS_MENU"."VISIBLE" IS '菜单状态（0显示 1隐藏）';
COMMENT ON COLUMN "RY"."SYS_MENU"."PERMS" IS '权限标识';
COMMENT ON COLUMN "RY"."SYS_MENU"."ICON" IS '菜单图标';
COMMENT ON COLUMN "RY"."SYS_MENU"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "RY"."SYS_MENU"."CREATE_TIME" IS '创建时间';
COMMENT ON COLUMN "RY"."SYS_MENU"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "RY"."SYS_MENU"."UPDATE_TIME" IS '更新时间';
COMMENT ON COLUMN "RY"."SYS_MENU"."REMARK" IS '备注';
COMMENT ON COLUMN "RY"."SYS_MENU"."SUBSYS_FLAG" IS '子系统标志';

-- ----------------------------
-- Records of SYS_MENU
-- ----------------------------
INSERT INTO "RY"."SYS_MENU" VALUES ('1', '系统管理', '0', '1', '#', null, 'M', '0', null, 'fa fa-gear', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '系统管理目录', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2', '系统监控', '0', '2', '#', null, 'M', '0', null, 'fa fa-video-camera', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '系统监控目录', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('3', '系统工具', '0', '3', '#', 'menuItem', 'M', '1', null, 'fa fa-bars', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-03 15:15:54', 'YYYY-MM-DD HH24:MI:SS'), '系统工具目录', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('100', '用户管理', '1', '1', '/system/user', null, 'C', '0', 'system:user:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '用户管理菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('101', '角色管理', '1', '2', '/system/role', null, 'C', '0', 'system:role:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '角色管理菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('102', '菜单管理', '1', '3', '/system/menu', null, 'C', '0', 'system:menu:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '菜单管理菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('103', '部门管理', '1', '4', '/system/dept', null, 'C', '0', 'system:dept:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '部门管理菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('104', '岗位管理', '1', '5', '/system/post', null, 'C', '0', 'system:post:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '岗位管理菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('105', '字典管理', '1', '6', '/system/dict', null, 'C', '0', 'system:dict:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '字典管理菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('106', '参数设置', '1', '7', '/system/config', null, 'C', '0', 'system:config:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '参数设置菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('107', '通知公告', '1', '8', '/system/notice', null, 'C', '0', 'system:notice:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '通知公告菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('108', '日志管理', '1', '9', '#', null, 'M', '0', null, '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '日志管理菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('109', '在线用户', '2', '1', '/monitor/online', null, 'C', '0', 'monitor:online:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '在线用户菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('110', '定时任务', '2', '2', '/monitor/job', 'menuItem', 'C', '1', 'monitor:job:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-03 15:30:35', 'YYYY-MM-DD HH24:MI:SS'), '定时任务菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('111', '数据监控', '2', '3', '/monitor/data', null, 'C', '0', 'monitor:data:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '数据监控菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('112', '服务监控', '2', '3', '/monitor/server', null, 'C', '0', 'monitor:server:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '服务监控菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('113', '表单构建', '3', '1', '/tool/build', 'menuItem', 'C', '1', 'tool:build:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-03 15:14:37', 'YYYY-MM-DD HH24:MI:SS'), '表单构建菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('114', '代码生成', '3', '2', '/tool/gen', 'menuItem', 'C', '1', 'tool:gen:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-03 15:14:45', 'YYYY-MM-DD HH24:MI:SS'), '代码生成菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('115', '系统接口', '3', '3', '/tool/swagger', null, 'C', '0', 'tool:swagger:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '系统接口菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('500', '操作日志', '108', '1', '/monitor/operlog', null, 'C', '0', 'monitor:operlog:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '操作日志菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('501', '登录日志', '108', '2', '/monitor/logininfor', null, 'C', '0', 'monitor:logininfor:view', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), '登录日志菜单', null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1000', '用户查询', '100', '1', '#', null, 'F', '0', 'system:user:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1001', '用户新增', '100', '2', '#', null, 'F', '0', 'system:user:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1002', '用户修改', '100', '3', '#', null, 'F', '0', 'system:user:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1003', '用户删除', '100', '4', '#', null, 'F', '0', 'system:user:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1004', '用户导出', '100', '5', '#', null, 'F', '0', 'system:user:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1005', '用户导入', '100', '6', '#', null, 'F', '0', 'system:user:import', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1006', '重置密码', '100', '7', '#', null, 'F', '0', 'system:user:resetPwd', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1007', '角色查询', '101', '1', '#', null, 'F', '0', 'system:role:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1008', '角色新增', '101', '2', '#', null, 'F', '0', 'system:role:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1009', '角色修改', '101', '3', '#', null, 'F', '0', 'system:role:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1010', '角色删除', '101', '4', '#', null, 'F', '0', 'system:role:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1011', '角色导出', '101', '5', '#', null, 'F', '0', 'system:role:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1012', '菜单查询', '102', '1', '#', null, 'F', '0', 'system:menu:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1013', '菜单新增', '102', '2', '#', null, 'F', '0', 'system:menu:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1014', '菜单修改', '102', '3', '#', null, 'F', '0', 'system:menu:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1015', '菜单删除', '102', '4', '#', null, 'F', '0', 'system:menu:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1016', '部门查询', '103', '1', '#', null, 'F', '0', 'system:dept:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1017', '部门新增', '103', '2', '#', null, 'F', '0', 'system:dept:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1018', '部门修改', '103', '3', '#', null, 'F', '0', 'system:dept:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1019', '部门删除', '103', '4', '#', null, 'F', '0', 'system:dept:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1020', '岗位查询', '104', '1', '#', null, 'F', '0', 'system:post:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1021', '岗位新增', '104', '2', '#', null, 'F', '0', 'system:post:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1022', '岗位修改', '104', '3', '#', null, 'F', '0', 'system:post:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1023', '岗位删除', '104', '4', '#', null, 'F', '0', 'system:post:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1024', '岗位导出', '104', '5', '#', null, 'F', '0', 'system:post:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1025', '字典查询', '105', '1', '#', null, 'F', '0', 'system:dict:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1026', '字典新增', '105', '2', '#', null, 'F', '0', 'system:dict:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1027', '字典修改', '105', '3', '#', null, 'F', '0', 'system:dict:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1028', '字典删除', '105', '4', '#', null, 'F', '0', 'system:dict:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1029', '字典导出', '105', '5', '#', null, 'F', '0', 'system:dict:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1030', '参数查询', '106', '1', '#', null, 'F', '0', 'system:config:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1031', '参数新增', '106', '2', '#', null, 'F', '0', 'system:config:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1032', '参数修改', '106', '3', '#', null, 'F', '0', 'system:config:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1033', '参数删除', '106', '4', '#', null, 'F', '0', 'system:config:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1034', '参数导出', '106', '5', '#', null, 'F', '0', 'system:config:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1035', '公告查询', '107', '1', '#', null, 'F', '0', 'system:notice:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1036', '公告新增', '107', '2', '#', null, 'F', '0', 'system:notice:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1037', '公告修改', '107', '3', '#', null, 'F', '0', 'system:notice:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1038', '公告删除', '107', '4', '#', null, 'F', '0', 'system:notice:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1039', '操作查询', '500', '1', '#', null, 'F', '0', 'monitor:operlog:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1040', '操作删除', '500', '2', '#', null, 'F', '0', 'monitor:operlog:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1041', '详细信息', '500', '3', '#', null, 'F', '0', 'monitor:operlog:detail', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1042', '日志导出', '500', '4', '#', null, 'F', '0', 'monitor:operlog:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1043', '登录查询', '501', '1', '#', null, 'F', '0', 'monitor:logininfor:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1044', '登录删除', '501', '2', '#', null, 'F', '0', 'monitor:logininfor:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1045', '日志导出', '501', '3', '#', null, 'F', '0', 'monitor:logininfor:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1046', '在线查询', '109', '1', '#', null, 'F', '0', 'monitor:online:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1047', '批量强退', '109', '2', '#', null, 'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1048', '单条强退', '109', '3', '#', null, 'F', '0', 'monitor:online:forceLogout', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1049', '任务查询', '110', '1', '#', null, 'F', '0', 'monitor:job:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1050', '任务新增', '110', '2', '#', null, 'F', '0', 'monitor:job:add', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1051', '任务修改', '110', '3', '#', null, 'F', '0', 'monitor:job:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1052', '任务删除', '110', '4', '#', null, 'F', '0', 'monitor:job:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1053', '状态修改', '110', '5', '#', null, 'F', '0', 'monitor:job:changeStatus', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1054', '任务详细', '110', '6', '#', null, 'F', '0', 'monitor:job:detail', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1055', '任务导出', '110', '7', '#', null, 'F', '0', 'monitor:job:export', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1056', '生成查询', '114', '1', '#', null, 'F', '0', 'tool:gen:list', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1057', '生成修改', '114', '2', '#', null, 'F', '0', 'tool:gen:edit', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1058', '生成删除', '114', '3', '#', null, 'F', '0', 'tool:gen:remove', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1059', '预览代码', '114', '4', '#', null, 'F', '0', 'tool:gen:preview', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('1060', '生成代码', '114', '5', '#', null, 'F', '0', 'tool:gen:code', '#', 'admin', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), 'ry', TO_DATE('2018-03-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2000', '子系统', '0', '0', '/system/subsys', 'menuItem', 'C', '1', 'system:subsys:nav', 'fa fa-hand-pointer-o', 'admin', TO_DATE('2019-09-03 17:22:35', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-07 17:30:10', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2001', '排水SCADA监管系统', '2000', '0', '/system/subsys/view/a', 'menuItem', 'C', '1', 'system:subsys:view:a', '#', 'admin', TO_DATE('2019-09-03 17:23:48', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-05 22:09:34', 'YYYY-MM-DD HH24:MI:SS'), null, 'SCADA');
INSERT INTO "RY"."SYS_MENU" VALUES ('2060', '报表管理', '2040', '0', '#', 'menuItem', 'C', '0', null, 'fa fa-file-archive-o', 'admin', TO_DATE('2019-09-06 10:05:55', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2021', '排水设施地理信息系统', '2000', '1', '/system/subsys/view/b', 'menuItem', 'C', '1', 'system:subsys:view:b', '#', 'admin', TO_DATE('2019-09-04 01:30:23', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-05 22:00:31', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2040', '运营信息管理系统', '2000', '2', 'http://localhost:8089', 'menuItem', 'C', '1', 'system:subsys:view:c', '#', 'admin', TO_DATE('2019-09-04 09:34:57', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-08 08:18:58', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2041', '智能分析决策系统', '2000', '3', '/system/subsys/view/d', 'menuItem', 'C', '1', 'system:subsys:view:b', '#', 'admin', TO_DATE('2019-09-04 09:38:22', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-05 22:01:04', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2042', '数据采集系统', '2000', '4', '/system/subsys/view/e', 'menuItem', 'C', '1', 'system:subsys:view:e', '#', 'admin', TO_DATE('2019-09-04 09:42:25', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-05 22:02:26', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2061', '日报', '2060', '1', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:30:43', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2062', '周报', '2060', '2', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:31:07', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2063', '月报', '2060', '3', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:34:49', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2064', '运行日志', '2060', '4', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:37:20', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2065', '汇总', '2060', '5', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:38:11', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-06 10:38:35', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2066', '日报查询', '2061', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:46:17', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2067', '日报新增', '2061', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:46:38', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2068', '周报查询', '2062', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:46:59', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2069', '周报新增', '2062', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:47:17', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2070', '月报查询', '2063', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:48:25', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2071', '月报新增', '2063', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:48:41', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2072', '运行日志查询', '2064', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:49:01', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2073', '运行日志新增', '2064', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:49:19', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2074', '日报修改', '2061', '3', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:55:11', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2075', '日报导出', '2061', '4', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:55:36', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2076', '日报删除', '2061', '5', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 10:56:03', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2077', '周报修改', '2062', '3', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-06 11:28:27', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2080', '日汇总表', '2065', '1', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-07 17:09:10', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2081', '月汇总表', '2065', '2', '#', 'menuItem', 'C', '0', null, '#', 'admin', TO_DATE('2019-09-07 17:09:37', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2082', '查询', '2080', '1', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-07 17:10:39', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2083', '导出', '2080', '2', '#', 'menuItem', 'F', '0', null, '#', 'admin', TO_DATE('2019-09-07 17:10:55', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2100', '从业人员管理', '2040', '1', '#', 'menuItem', 'C', '0', null, 'fa fa-address-book', 'admin', TO_DATE('2019-09-16 13:31:48', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-16 18:09:52', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2101', '人员信息', '2100', '0', '/employee', 'menuItem', 'C', '0', 'employee:view', '#', 'admin', TO_DATE('2019-09-16 13:33:22', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-16 18:10:37', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('2102', '人员信息查询', '2100', '1', '#', null, 'F', '0', 'employee:list', '#', 'admin', TO_DATE('2019-09-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-09-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('2103', '人员信息新增', '2100', '2', '#', null, 'F', '0', 'employee:add', '#', 'admin', TO_DATE('2019-09-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-09-16 11:33:00', 'YYYY-MM-DD HH24:MI:SS'), null, null);

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
COMMENT ON COLUMN "RY"."T_WORKER"."IDCARD" IS '身份证号';
COMMENT ON COLUMN "RY"."T_WORKER"."NAME" IS '名字';
COMMENT ON COLUMN "RY"."T_WORKER"."SEX" IS '性别';
COMMENT ON COLUMN "RY"."T_WORKER"."BIRTHDAY" IS '出生日期';
COMMENT ON COLUMN "RY"."T_WORKER"."TELEPHONE" IS '电话号码';
COMMENT ON COLUMN "RY"."T_WORKER"."EMAIL" IS '邮箱';
COMMENT ON COLUMN "RY"."T_WORKER"."TITLE" IS '职称';
COMMENT ON COLUMN "RY"."T_WORKER"."PROFESSION" IS '专业资质';
COMMENT ON COLUMN "RY"."T_WORKER"."COMPANY_NAME" IS '所属公司';
COMMENT ON COLUMN "RY"."T_WORKER"."POSITION" IS '职位';
COMMENT ON COLUMN "RY"."T_WORKER"."DEPARTMENT_ID" IS '部门代码';

-- ----------------------------
-- Records of T_WORKER
-- ----------------------------
INSERT INTO "RY"."T_WORKER" VALUES ('350181197710102918', '张三', '男', TO_DATE('2019-05-06 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '18839422930', '12334234@qq.com', '初级员工', '一级', '深圳市蓝天科技股份有限公司', '检查员', 'ltcpwhb');
INSERT INTO "RY"."T_WORKER" VALUES ('123428955033920194', '丁一二', '男', TO_DATE('2019-09-03 17:12:05', 'YYYY-MM-DD HH24:MI:SS'), '29940399204', '2435649874@qq.com', '高级员工', '二级', '深圳市蓝天科技股份有限公司', '检查员', 'ltcpwhb');

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
COMMENT ON COLUMN "RY"."T_COMPANY"."COMPANY_ID" IS '公司代码';
COMMENT ON COLUMN "RY"."T_COMPANY"."COMPANY_NAME" IS '公司名';

-- ----------------------------
-- Records of T_COMPANY
-- ----------------------------
INSERT INTO "RY"."T_COMPANY" VALUES ('szltkjcp', '深圳市蓝天科技股份有限公司');

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