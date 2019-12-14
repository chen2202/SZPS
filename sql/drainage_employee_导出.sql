--2019-12-14
--排水户模块 从业人员管理模块 导出excel表权限
--插入到SYS_MENU

INSERT INTO "RY"."SYS_MENU" VALUES ('6122', '人员信息导出', '6100', '21', '#', null, 'F', '0', 'employee:worker:export', '#', 'admin', TO_DATE('2019-12-11 14:47:51', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-12-11 14:47:54', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('4225', '排水户信息查询', '4214', '7', '#', null, 'F', '0', 'drainage:household:list', '#', 'admin', TO_DATE('2019-10-27 10:54:26', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-10-27 10:54:29', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6123', '水厂信息导出', '6100', '22', '#', null, 'F', '0', 'employee:factory:export', '#', 'admin', TO_DATE('2019-12-11 15:31:02', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-12-11 15:31:04', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6124', '公司信息导出', '6100', '23', '#', null, 'F', '0', 'employee:company:export', '#', 'admin', TO_DATE('2019-12-11 15:57:18', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-12-11 15:57:20', 'YYYY-MM-DD HH24:MI:SS'), null, null);
INSERT INTO "RY"."SYS_MENU" VALUES ('6125', '排水户信息导出', '6100', '24', '#', null, 'F', '0', 'drainage:household:export', '#', 'admin', TO_DATE('2019-12-11 18:11:01', 'YYYY-MM-DD HH24:MI:SS'), null, TO_DATE('2019-12-11 18:11:04', 'YYYY-MM-DD HH24:MI:SS'), null, null);