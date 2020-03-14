----
-- 修改左侧导航栏从业人员管理和排水户管理的跳转路径
-- 注意！！！！！PARENT_ID需要修改成 运营信息管理系统 的MENU_ID，2040是我数据库中测试用的
----
UPDATE "RY"."SYS_MENU" SET "MENU_ID"='6100', "MENU_NAME"='从业人员管理', "PARENT_ID"='2040', "ORDER_NUM"='5', "URL"='/employee/manage', "TARGET"='menuItem', "MENU_TYPE"='M', "VISIBLE"='0', "PERMS"=NULL, "ICON"='fa fa-address-book', "CREATE_BY"='admin', "CREATE_TIME"=TO_DATE('2019-09-16 13:31:48', 'SYYYY-MM-DD HH24:MI:SS'), "UPDATE_BY"='admin', "UPDATE_TIME"=TO_DATE('2019-10-09 00:31:14', 'SYYYY-MM-DD HH24:MI:SS'), "REMARK"=NULL, "SUBSYS_FLAG"='op', "ROWID"='AAASUiAABAAAVbqAAe' WHERE ROWID = 'AAASUiAABAAAVbqAAe';
UPDATE "RY"."SYS_MENU" SET "MENU_ID"='4214', "MENU_NAME"='排水户管理', "PARENT_ID"='2040', "ORDER_NUM"='3', "URL"='/drainage/manage', "TARGET"='menuItem', "MENU_TYPE"='M', "VISIBLE"='0', "PERMS"=NULL, "ICON"='fa fa-address-book-o', "CREATE_BY"='admin', "CREATE_TIME"=TO_DATE('2019-09-15 12:24:48', 'SYYYY-MM-DD HH24:MI:SS'), "UPDATE_BY"='admin', "UPDATE_TIME"=TO_DATE('2019-09-17 15:13:14', 'SYYYY-MM-DD HH24:MI:SS'), "REMARK"=NULL, "SUBSYS_FLAG"='op', "ROWID"='AAASUiAABAAAVbqAAz' WHERE ROWID = 'AAASUiAABAAAVbqAAz';
