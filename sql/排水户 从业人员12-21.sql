--
--修改原来的从业人员管理和排水户管理的菜单栏，原来的子菜单可以删除
--

INSERT INTO "RY"."SYS_MENU" VALUES ('6100', '从业人员管理', '2040', '5', '/employee/worker', 'menuItem', 'M', '0', null, 'fa fa-address-book', 'admin', TO_DATE('2019-09-16 13:31:48', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-10-09 00:31:14', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');
INSERT INTO "RY"."SYS_MENU" VALUES ('4214', '排水户管理', '2040', '3', '/drainage/household', 'menuItem', 'M', '0', null, 'fa fa-address-book-o', 'admin', TO_DATE('2019-09-15 12:24:48', 'YYYY-MM-DD HH24:MI:SS'), 'admin', TO_DATE('2019-09-17 15:13:14', 'YYYY-MM-DD HH24:MI:SS'), null, 'op');