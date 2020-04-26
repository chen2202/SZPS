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

Date: 2020-04-26 12:26:04
*/


-- ----------------------------
-- Table structure for DRAINAGE_T_HOUSEHOLD
-- ----------------------------
DROP TABLE "RY"."DRAINAGE_T_HOUSEHOLD";
CREATE TABLE "RY"."DRAINAGE_T_HOUSEHOLD" (
"HOUSEHOLD_ID" NUMBER NOT NULL ,
"HOUSEHOLD_NAME" VARCHAR2(225 CHAR) NOT NULL ,
"RECORD_STATE" VARCHAR2(50 CHAR) NOT NULL ,
"DOORPLATE_DETAIL_ADDRESS" VARCHAR2(255 CHAR) NOT NULL ,
"LONGITUDE" NUMBER NOT NULL ,
"LATITUDE" NUMBER NOT NULL ,
"ADMINISTRATIVE_NAME" VARCHAR2(8 CHAR) NOT NULL ,
"STREET_NAME" VARCHAR2(10 CHAR) NOT NULL ,
"COMMITTEES" VARCHAR2(15 CHAR) NOT NULL ,
"LANE_NAME" VARCHAR2(8 CHAR) NOT NULL ,
"DOORPLATE_NUMBER" VARCHAR2(8 CHAR) NOT NULL ,
"HOUSEHOLD_LEVEL" VARCHAR2(20 CHAR) NOT NULL ,
"PARENT_HOUSEHOLD_NAME" VARCHAR2(225 CHAR) NULL ,
"LINKMAN" VARCHAR2(50 CHAR) NOT NULL ,
"TELEPHONE" NUMBER(11) NOT NULL ,
"COVER_AREA" NUMBER(4) NOT NULL ,
"WATER_METER_ID" VARCHAR2(255 CHAR) NOT NULL ,
"SEWAGE_CATEGORY" VARCHAR2(10 CHAR) NOT NULL ,
"UNIT_TYPE" VARCHAR2(50 CHAR) NOT NULL ,
"OTHER_UNIT_TYPE" VARCHAR2(50 CHAR) NULL ,
"CFLIST" VARCHAR2(255 CHAR) NULL ,
"OTHER_COMPOSITION" VARCHAR2(50 CHAR) NULL ,
"WATER_DIVERSION" VARCHAR2(2 CHAR) NULL ,
"BUSINESS_LICENSE" VARCHAR2(10 CHAR) NOT NULL ,
"SOCIAL_CREDIT_ID" VARCHAR2(18 CHAR) NULL ,
"DRAINAGE_LICENSE" VARCHAR2(10 CHAR) NOT NULL ,
"DRAINAGE_LICENSE_NUMBER" VARCHAR2(50 CHAR) NULL ,
"DRAINAGE_LICENSE_BEGIN_TIME" DATE NULL ,
"DRAINAGE_LICENSE_END_TIME" DATE NULL ,
"SEWAGE_LICENSE" VARCHAR2(10 CHAR) NOT NULL ,
"SEWAGE_LICENSE_NUMBER" VARCHAR2(50 CHAR) NULL ,
"SEWAGE_LICENSE_BEGIN_TIME" DATE NULL ,
"SEWAGE_LICENSE_END_TIME" DATE NULL ,
"NOTE" VARCHAR2(500 CHAR) NOT NULL ,
"REGISTRATION_TIME" DATE NOT NULL ,
"REGISTRATION_PERSON" NUMBER DEFAULT NULL  NULL ,
"UPDATE_TIME" DATE NOT NULL ,
"UPDATE_PERSON" VARCHAR2(4 CHAR) NOT NULL ,
"PARENT_HOUSEHOLD_ID" NUMBER NULL ,
"ADDRESSBZ" VARCHAR2(255 CHAR) NULL ,
"MAINTYPEIDX" NUMBER NULL ,
"HASCYCERT" VARCHAR2(10 CHAR) NULL ,
"CYCERTNO" VARCHAR2(50 CHAR) NULL ,
"CYDATE1" DATE NULL ,
"CYDATE2" DATE NULL ,
"PSKNUM" NUMBER NULL ,
"YSPSKNUM" NUMBER NULL ,
"WSPSKNUM" NUMBER NULL ,
"HHPSKNUM" NUMBER NULL ,
"RECORDER" VARCHAR2(20 CHAR) NULL ,
"LEVELCHAR" VARCHAR2(2 BYTE) NULL ,
"HASSH" NUMBER NULL ,
"NEEDZZ" VARCHAR2(10 CHAR) NULL ,
"NEEDPSCERT" VARCHAR2(10 CHAR) NULL ,
"NEEDPWCERT" VARCHAR2(10 CHAR) NULL ,
"NEEDCYCERT" VARCHAR2(10 CHAR) NULL ,
"IMPORTBZ" VARCHAR2(100 CHAR) NULL ,
"BUILDING" VARCHAR2(200 CHAR) NULL ,
"HASDEVICE" VARCHAR2(1 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."HOUSEHOLD_ID" IS '排水户编号';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."HOUSEHOLD_NAME" IS '排水户名称';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."RECORD_STATE" IS '记录状态';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."DOORPLATE_DETAIL_ADDRESS" IS '门牌详细地址';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."LONGITUDE" IS '经度';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."LATITUDE" IS '纬度';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."ADMINISTRATIVE_NAME" IS '行政区名';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."STREET_NAME" IS '街道名';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."COMMITTEES" IS '居委会';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."LANE_NAME" IS '街路巷名';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."DOORPLATE_NUMBER" IS '门牌号码';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."HOUSEHOLD_LEVEL" IS '排水户级别';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."PARENT_HOUSEHOLD_NAME" IS '上级排水户';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."LINKMAN" IS '联系人';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."TELEPHONE" IS '联系电话';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."COVER_AREA" IS '占地面积 /㎡';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."WATER_METER_ID" IS '水表编号';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."SEWAGE_CATEGORY" IS '污水类别';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."UNIT_TYPE" IS '单位类型（排水户类型）';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."OTHER_UNIT_TYPE" IS '其他单位类型(排水户类型)';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."CFLIST" IS '成分列表';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."OTHER_COMPOSITION" IS '其他成分';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."WATER_DIVERSION" IS '内部废、污、雨是否分流';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."BUSINESS_LICENSE" IS '是否取得营业执照';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."SOCIAL_CREDIT_ID" IS '统一社会信用代码';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."DRAINAGE_LICENSE" IS '是否取得排水许可证';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."DRAINAGE_LICENSE_NUMBER" IS '排水许可证号';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."DRAINAGE_LICENSE_BEGIN_TIME" IS '排水许可证开始日期';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."DRAINAGE_LICENSE_END_TIME" IS '排水许可证结束日期';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."SEWAGE_LICENSE" IS '是否取得排污许可证';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."SEWAGE_LICENSE_NUMBER" IS '排污许可证号';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."SEWAGE_LICENSE_BEGIN_TIME" IS '排污许可证开始日期';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."SEWAGE_LICENSE_END_TIME" IS '排污许可证结束日期';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."NOTE" IS '备注';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."REGISTRATION_TIME" IS '登记时间';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."REGISTRATION_PERSON" IS '登记人id';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."UPDATE_TIME" IS '最新更新时间';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."UPDATE_PERSON" IS '上一修改人';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."PARENT_HOUSEHOLD_ID" IS '二级排水户对应的一级排水户ID（上级排水户ID）';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."ADDRESSBZ" IS '地址补充信息';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."MAINTYPEIDX" IS '大类分类ID';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."HASCYCERT" IS '是否取得餐饮许可证';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."CYCERTNO" IS '餐饮许可证号';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."CYDATE1" IS '餐饮许可证开始日期';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."CYDATE2" IS '餐饮许可证结束日期';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."PSKNUM" IS '排水口数量';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."YSPSKNUM" IS '雨水排放口数量';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."WSPSKNUM" IS '污水排放口数量';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."HHPSKNUM" IS '混合排水口数量';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."RECORDER" IS '初始登记人姓名';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."LEVELCHAR" IS '一级排水户F，二级排水户S';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."HASSH" IS '是否曾经审核通过';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."NEEDZZ" IS '是否需办营业执照';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."NEEDPSCERT" IS '是否需办排水许可证';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."NEEDPWCERT" IS '是否需办排污许可证';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."NEEDCYCERT" IS '是否需办餐饮许可证';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."IMPORTBZ" IS '如果批量导入记录临时表的名称';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."BUILDING" IS '小区或附近建筑物';
COMMENT ON COLUMN "RY"."DRAINAGE_T_HOUSEHOLD"."HASDEVICE" IS '是否有管网设施';

-- ----------------------------
-- Records of DRAINAGE_T_HOUSEHOLD
-- ----------------------------
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('1', '光明社区排水户', '已审核', '光明区光明街道办事处光明社区工作站', '234.214675', '-122.123454', '光明区', '光明街道办事处', '光明社区工作站', '光明巷', '1号', '一级排水户', null, 'xxx', '999999999', '2', 'gmsq1|gmsq2', '生活排污类', '生活', null, null, null, '是', '是', 'xxxxxxxx234', '是', '23534534545', TO_DATE('2019-10-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-10-07 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '否', null, null, null, '光明社区的全部生活污水排出口', TO_DATE('2019-10-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2019-10-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'xxx', null, null, null, null, null, null, null, '3', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('2', 'aaaa', '待修改', 'aaaaaaaaaaaaaaaaaaaaaa', '-123.222778', '-12.334456', '光明区', '凤凰街道办事处', '塘尾社区工作站', 'aa', '2a', '二级排水户', 'b', 'a', '12234234', '1', 'a1', '生活排污类', '其他', '雨水', '水s', '水', '是', '否', 'asdf', '是', '123455334434', TO_DATE('2019-10-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '是', 'sdf', TO_DATE('2019-10-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-10-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'sdf', TO_DATE('2019-10-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '2', TO_DATE('2019-10-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'df12', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('3', 'bt', '待审核', 'w', '234', '43', '龙岗区', '坂田街道办事处', '大发埔社区里石排居委会', '12', '3', '二级排水户', null, 'sdf', '23451', '1', 'sd', '有毒有害排污类', '其他', null, null, null, '否', '是', null, '否', null, TO_DATE('2019-10-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-10-06 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '否', '34', null, null, 'erw', TO_DATE('2019-10-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '3', TO_DATE('2019-10-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '归海一二', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('4', '234', '待审核', '34', '3', '4', '南山区', '南山街道办事处', '南光社区工作站', '3', '3', '三级排水户', null, '3', '3', '1', '3', '有毒有害排污类', '工业', null, null, null, '否', '是', null, '否', null, TO_DATE('2019-07-02 08:27:53', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-07-28 08:27:59', 'YYYY-MM-DD HH24:MI:SS'), '否', null, null, null, 'we', TO_DATE('2019-10-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4', TO_DATE('2019-10-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '3', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('5', '34', '待审核', '3', '23', '3', '福田区', '华富街道办事处', '田面社区工作站', '23', '4', '一级排水户', null, 'er', '466', '1', '3', '沉淀物排污类', '工业', null, null, null, '是', '是', null, '是', null, null, null, '否', null, null, null, '3', TO_DATE('2019-10-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '5', TO_DATE('2019-10-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('6', 'aaa120', '待修改', 'sdf', '405', '5', '深汕合作区', '赤石镇', '园林社区居民委员会', '23', '2', '一级排水户', null, '24', '24', '24', '24', '沉淀物排污类', '工业', null, null, null, '否', '是', null, '否', null, null, null, '是', null, null, null, '2', TO_DATE('2019-10-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '6', TO_DATE('2019-10-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'we', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('7', '前海开发区某排水户', '已审核', '前海开发区某处', '234234.41', '-343134.21', '前海开发区', '前海合作区', '前海合作区虚拟社区', '1', '1', '二级排水户', null, 'zxc', '234455645', '1', '1', '生活排污类', '居民住宅', null, null, null, '是', '否', null, '是', '123123', TO_DATE('2020-04-11 14:59:03', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-05-31 14:59:06', 'YYYY-MM-DD HH24:MI:SS'), '是', '排污许可234', TO_DATE('2020-04-11 14:59:35', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-05-28 14:59:37', 'YYYY-MM-DD HH24:MI:SS'), 'a', TO_DATE('2020-04-11 14:59:45', 'YYYY-MM-DD HH24:MI:SS'), '7', TO_DATE('2020-04-11 14:59:50', 'YYYY-MM-DD HH24:MI:SS'), 'zz', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('8', '甲子塘社区排水户', '已审核', '光明区凤凰街道办事处甲子塘社区工作站', '23.675576', '234.333567', '光明区', '凤凰街道办事处', '甲子塘社区工作站', '甲子塘巷', '3号', '一级排水户', null, '郑某', '2343454556', '3', 'jztsq1|jztsq2', '有毒有害排污类', '其他', '污染物', '铜，铬，铅，镍，砷，其他', '重铬酸钾', '是', '否', null, '否', null, null, null, '否', null, null, null, '无', TO_DATE('2019-10-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '8', TO_DATE('2019-10-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '张xx', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('9', '龙华民治排水户', '待审核', '龙华区民治街道办事处丰润社区居委会', '12.331234', '-234.344563', '龙华区', '民治街道办事处', '丰润社区居委会', '无', '1号', '二级排水户', 'xxx', 'zxc', '1230495', '1', 'lhmz1|lhmz2|lhmz3', '生活排污类', '生活', null, null, null, '是', '是', '3423523436', '否', null, null, null, '是', '345345145', TO_DATE('2019-10-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-10-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '无', TO_DATE('2019-10-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '9', TO_DATE('2019-10-16 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'zxc', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('10', 'xx', '已审核', 'xxxxxxxx', '342.3330', '44.3220', '前海开发区', '前海合作区', '前海合作区虚拟社区', 'a', 'aa', '一级排水户', null, 'zxc', '234345', '1', 'ad', '有毒有害排污类', '工业', null, null, null, '是', '否', null, '否', null, null, null, '否', null, null, null, 'w', TO_DATE('2019-10-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '10', TO_DATE('2019-10-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'w', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('11', 'asdf', '已审核', 'sdf', '234', '234', '南山区', '南头街道办事处', '南头城社区工作站', '1', '1', '二级排水户', null, '23', '4324', '1', '345', '有毒有害排污类', '工业', null, null, null, '是', '是', null, '是', null, null, null, '否', null, null, null, 'wer', TO_DATE('2019-10-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '11', TO_DATE('2019-10-06 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'er', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('12', 'wewe', '待审核', 're', '23', '43', '罗湖区', '东晓街道办事处', '木棉岭社区工作站', '23', '434', '二级排水户', '234', '324', '423', '1', '234', '沉淀物排污类', '工业', '23', '43', '34', '是', '是', 'werwet', '是', '34234', TO_DATE('2019-10-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-10-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '是', '234234', TO_DATE('2019-10-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-10-14 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'wer', TO_DATE('2019-10-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '12', TO_DATE('2019-10-06 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'iuio', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('13', 'sdf', '待审核', 'aaaaaasss', '234', '543', '宝安区', '新桥街道办事处', '万丰社区', '1', '23', '一级排水户', null, '34', '234', '1', '234', '沉淀物排污类', '工业', '23', '5', '34', '是', '否', null, '否', null, null, null, '否', null, null, null, '23', TO_DATE('2019-10-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '13', TO_DATE('2019-10-07 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '34', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('14', '2', '待修改', '2', '2', '2', '深汕合作区', '赤石镇', '园林社区居民委员会', '2', '2', '二级排水户', null, '2', '2', '2', '2', '沉淀物排污类', '生活', null, null, null, '是', '是', null, '否', null, TO_DATE('2019-10-06 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-10-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '否', null, null, null, '23', TO_DATE('2019-10-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '14', TO_DATE('2019-10-14 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '2', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('15', 'wer', '待审核', 'er', '23', '4', '坪山区', '坪山街道办事处', '六联社区居委会', '0', '9', '一级排水户', null, '9', '9', '9', '9', '沉淀物排污类', '工业', null, null, null, '是', '否', null, '是', null, null, null, '否', null, null, null, '9', TO_DATE('2019-10-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '15', TO_DATE('2019-10-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '9', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('16', 'q', '待修改', '4', '23', '43', '宝安区', '松岗街道办事处', '潭头社区', '23', '5', '一级排水户', null, '2', '2', '6', 'er', '沉淀物排污类', '其他', null, null, null, '是', '否', null, '是', null, TO_DATE('2019-10-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '否', null, null, null, 'er', TO_DATE('2019-10-13 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '16', TO_DATE('2019-10-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'wer', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('17', 'df', '待修改', '234', '23', '4', '盐田区', '梅沙街道办事处', '东海岸居委会', '3', '3', '三级排水户', null, '2', '32', '1', '3', '沉淀物排污类', '工业', null, null, null, '否', '否', null, '是', null, null, null, '否', null, null, null, '234', TO_DATE('2019-10-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '17', TO_DATE('2019-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'wer', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('18', '23', '待修改', '23', '242', '24', '坪山区', '坪山街道办事处', '六联社区居委会', '3', '234', '一级排水户', null, '12', '343', '1', '123', '有毒有害排污类', '工业', null, null, null, '是', '是', null, '是', null, null, null, '是', null, null, null, '1111', TO_DATE('2019-10-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '18', TO_DATE('2019-10-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '324', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('19', 'w', '待修改', 'w', '4', '4', '大鹏新区', '大鹏办事处', '王母社区居委会', '3', '3', '一级排水户', '3', '3', '3', '3', '3', '沉淀物排污类', '工业', null, null, null, '是', '是', null, '否', null, null, null, '是', null, null, null, '3', TO_DATE('2019-10-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '19', TO_DATE('2019-10-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'f', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('20', 'r', '待修改', 'er', '77', '8', '宝安区', '新安街道办事处', '安乐社区', 'u', 'o', '一级排水户', null, 'u', '789', '8', '9', '沉淀物排污类', '生活', null, null, null, '否', '是', null, '否', null, null, null, '是', null, null, null, '90', TO_DATE('2019-10-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2019-10-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '90', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('25', '前海开发区排水户5', '已审核', 'xxxxxxxxxxx', '83.223345', '-23.444440', '前海开发区', '前海合作区', '前海合作区虚拟社区', '啊', '2号', '三级排水户', null, 'czx', '23', '1', 'aa|2a|23a|3', '生活排污类', '居民住宅', null, null, null, '是', '是', '23234a啊啊', '是', '排水A23452343', TO_DATE('2020-04-01 09:57:14', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-06-01 09:57:31', 'YYYY-MM-DD HH24:MI:SS'), '是', '排污B234452', TO_DATE('2020-04-20 09:57:55', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-06-18 09:57:59', 'YYYY-MM-DD HH24:MI:SS'), '无', TO_DATE('2020-04-20 09:58:13', 'YYYY-MM-DD HH24:MI:SS'), '190', TO_DATE('2020-04-20 09:58:22', 'YYYY-MM-DD HH24:MI:SS'), '我', '7', '无', '1234', '是', '餐饮C23306-3', TO_DATE('2020-04-20 09:59:13', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-05-30 09:59:14', 'YYYY-MM-DD HH24:MI:SS'), '4', '1', '1', '2', '小郑', 'S', '4', '是', '是', '是', '是', 'T_A', '那家饭店', '无');
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('21', '光明区白花社区排水户', '待修改', 'aaaaaa', '-23.334578', '495.409567', '光明区', '光明街道办事处', '白花社区工作站', '无', '1号', '一级排水户', null, '啊哈', '12309567', '2', 'gmbh1|gmbh2|gmbh3', '餐饮排污类', '其他', '餐饮排污类', null, null, '是', '否', null, '否', null, null, null, '否', null, null, null, '无', TO_DATE('2019-10-31 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2019-10-31 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'zxc', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('22', '光明区某个排水户2', '已审核', '光明区哪里哪里哪里', '342345.45', '345345.32', '光明区', '公明街道办事处', '上村社区工作站', '东周巷', 'a', '三级排水户', '无', 'cxz', '23434234', '2', 'a|b', '生活排污类', '生活', null, null, null, '是', '是', '2343525', '是', '23445342', TO_DATE('2020-04-10 19:05:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-04-25 19:06:04', 'YYYY-MM-DD HH24:MI:SS'), '是', '234234', TO_DATE('2020-04-10 19:06:15', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-04-10 19:06:17', 'YYYY-MM-DD HH24:MI:SS'), '无', TO_DATE('2020-04-10 19:06:25', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2020-04-10 19:06:32', 'YYYY-MM-DD HH24:MI:SS'), '无', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('23', '东周社区排水户', '待提交', '光明区光明街道办事处东周社区工作站', '123.124456', '212.112223', '光明区', '光明街道办事处', '东周社区工作站', '东周巷', '22号', '一级排水户', null, '郑某', '18833345924', '5', 'dzsq1|dzsq2|dzsq3', '生活排污类', '其他', null, '铜, 铬, 铅, 镍, 砷', null, '是', '是', '1234562374', '是', '1243235343', TO_DATE('2019-10-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-10-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '是', '646234646465', TO_DATE('2019-10-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-10-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '无', TO_DATE('2019-10-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2019-10-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '赵xx', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO "RY"."DRAINAGE_T_HOUSEHOLD" VALUES ('24', '光明区某个排水户', '待审核', 'aaaaaa', '243', '23', '光明区', '公明街道办事处', '上村社区工作站', 'aaaaa', 'a', '二级排水户', '无', 'zxc', '183444444', '2', 'a1|a2', '餐饮排污类', '生活', null, null, null, '是', '是', '2342ssddfs', '否', null, null, null, '否', null, null, null, '啊', TO_DATE('2020-02-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1', TO_DATE('2020-02-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '无', null, null, null, null, null, null, null, '0', null, null, null, null, null, '0', null, null, null, null, null, null, null);

-- ----------------------------
-- Indexes structure for table DRAINAGE_T_HOUSEHOLD
-- ----------------------------

-- ----------------------------
-- Checks structure for table DRAINAGE_T_HOUSEHOLD
-- ----------------------------
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("HOUSEHOLD_NAME" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("RECORD_STATE" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("DOORPLATE_DETAIL_ADDRESS" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("LONGITUDE" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("LATITUDE" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("ADMINISTRATIVE_NAME" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("STREET_NAME" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("COMMITTEES" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("LANE_NAME" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("DOORPLATE_NUMBER" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("HOUSEHOLD_LEVEL" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("LINKMAN" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("TELEPHONE" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("COVER_AREA" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("WATER_METER_ID" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("SEWAGE_CATEGORY" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("UNIT_TYPE" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("BUSINESS_LICENSE" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("DRAINAGE_LICENSE" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("SEWAGE_LICENSE" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("NOTE" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("REGISTRATION_TIME" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("UPDATE_TIME" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("UPDATE_PERSON" IS NOT NULL);
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD CHECK ("HOUSEHOLD_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DRAINAGE_T_HOUSEHOLD
-- ----------------------------
ALTER TABLE "RY"."DRAINAGE_T_HOUSEHOLD" ADD PRIMARY KEY ("HOUSEHOLD_ID");
