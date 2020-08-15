package com.szps.web.domain.psxksp;
import com.szps.common.annotation.Excel;

import java.sql.Date;

public class EX_GDBS_SB {

    @Excel(name = "省级申办流水号", prompt = "省级申办流水号")
    private String SBLSH;

    @Excel(name = "市级统一申办流水号", prompt = "市级统一申办流水号")
    private String SBLSH_SHORT;

    @Excel(name = "事项编号", prompt = "事项编号")
    private String SXBM;

    @Excel(name = "事项名称", prompt = "事项名称")
    private String SXMC;

    @Excel(name = "项目地址", prompt = "项目地址")
    private String SXQXBM;

    @Excel(name = "父事项编码", prompt = "父事项编码")
    private String FSXBM;

    @Excel(name = "父事项名称", prompt = "父事项名称")
    private String FSXMC;

    @Excel(name = "雨水量", prompt = "雨水量")
    private String SQRLX;

    @Excel(name = "单位名称", prompt = "单位名称")
    private String SQRMC;

    @Excel(name = "申请人证件类型", prompt = "申请人证件类型")
    private String SQRZJLX;

    @Excel(name = "申请人证件号码", prompt = "申请人证件号码")
    private String SQRZJHM;

    @Excel(name = "联系人姓名", prompt = "联系人姓名")
    private String LXRXM;

    @Excel(name = "联系人证件类型", prompt = "联系人证件类型")
    private String LXRZJLX;

    @Excel(name = "联系人身份证件号码", prompt = "联系人身份证件号码")
    private String LXRSFZJHM;

    @Excel(name = "联系人手机", prompt = "联系人手机")
    private String LXRSJ;

    @Excel(name = "联系人邮箱", prompt = "联系人邮箱")
    private String LXRYX;

    @Excel(name = "项目名称", prompt = "项目名称")
    private String SBXMMC;

    @Excel(name = "申报材料清单", prompt = "申报材料清单")
    private String SBCLQD;

    @Excel(name = "提交方式", prompt = "提交方式")
    private String TJFS;

    @Excel(name = "申办回执号", prompt = "申办回执号")
    private String SBHZH;

    @Excel(name = "申办时间", prompt = "申办时间")
    private Date SBSJ;

    @Excel(name = "申办具体网点", prompt = "申办具体网点")
    private String SBJTWD;

    @Excel(name = "业务发生所在地区编号", prompt = "业务发生所在地区编号")
    private String XZQHDM;

    @Excel(name = "原申办流水号", prompt = "原申办流水号")
    private String YSBLSH;

    @Excel(name = "备注", prompt = "备注")
    private String BZ;

    @Excel(name = "分发至下级部门的行政区划代码", prompt = "分发至下级部门的行政区划代码")
    private String F_XZQHDM;

    @Excel(name = "网厅统一身份认证平台账号", prompt = "网厅统一身份认证平台账号")
    private String USERIDCODE;

    @Excel(name = "投资项目统一编码", prompt = "投资项目统一编码")
    private String PROJECT_CODE;

    @Excel(name = "网上申办渠道", prompt = "网上申办渠道")
    private String WSSBQD;

    @Excel(name = "取证方式", prompt = "取证方式")
    private String OBTAIN_PAPER_WAY;

    @Excel(name = "材料递交方式", prompt = "材料递交方式")
    private String OBTAIN_DELIVER_WAY;

    @Excel(name = "数据版本号", prompt = "数据版本号")
    private String VERSION;

    @Excel(name = "接收标识", prompt = "接收标识")
    private Short REC_FLAG;

    @Excel(name = "业务信息", prompt = "业务信息")
    private String XML_DATA;

    @Excel(name = "数据提供部门组织机构代码/社会信用代码", prompt = "数据提供部门组织机构代码/社会信用代码")
    private String D_ZZJGDM;

    @Excel(name = "权责清单事项编码", prompt = "权责清单事项编码")
    private String SXBM_SHORT;

    @Excel(name = "入库时间", prompt = "入库时间")
    private Date INSERTTIME;

    @Excel(name = "接口调用成功返回时间", prompt = "接口调用成功返回时间")
    private Date RESPONSETIME;

    @Excel(name = "FLAG", prompt = "FLAG")
    private int FLAG;

    @Excel(name = "SYNC", prompt = "SYNC")
    private int SYNC;

    @Excel(name = "单位代码", prompt = "单位代码")
    private String DWDM;
    @Excel(name = "证件有效期", prompt = "证件有效期")
    private String BYZD1;
    @Excel(name = "事项名称", prompt = "事项名称")
    private String BYZD2;
    @Excel(name = "审批状态", prompt = "审批状态")
    private String BYZD4;
    @Excel(name = "接驳口1信息", prompt = "接驳口1信息")
    private String BYZD3;
    @Excel(name = "接驳口2信息", prompt = "接驳口2信息")
    private String BMMC;
    @Excel(name = "9位部门组织机构代码", prompt = "9位部门组织机构代码")
    private String BMZZJGDM;

    @Excel(name = "备用字段，用于扩展使用", prompt = "备用字段，用于扩展使用")
    private String BYZD;
    @Excel(name = "是否实现单点登录代码", prompt = "是否实现单点登录代码")
    private String SFSXDDDL;
    @Excel(name = "实现单点登录的网办用户 ID ", prompt = "实现单点登录的网办用户 ID ")
    private String DDDLYHID;
    @Excel(name = "不填写（初始值是 N， 系统默认）", prompt = "不填写（初始值是 N， 系统默认）")
    private String CLZT;
    @Excel(name = "不填写（系统交换的处理时间）", prompt = "不填写（系统交换的处理时间）")
    private Date CLSJ;
    @Excel(name = "ID", prompt = "ID")
    private Integer ID;
    @Excel(name = "ISTOSPJC", prompt = "ISTOSPJC")
    private Integer ISTOSPJC;
    @Excel(name = "污废水量", prompt = "污废水量")
    private String SXBBH;
    @Excel(name = "前置库同步时间", prompt = "前置库同步时间")
    private Date SYNCTIME;
    @Excel(name = "事项版本编码", prompt = "事项版本编码")
    private String SXBBBM;
    @Excel(name = "事项表单编码", prompt = "事项表单编码")
    private String SXBDBM;
    @Excel(name = "省级事项编码", prompt = "省级事项编码")
    private String SJSXBM;
    @Excel(name = "省级事项版本号", prompt = "省级事项版本号")
    private String SJSXBBH;
    @Excel(name = "接驳口1纬度", prompt = "接驳口1纬度")
    private double WD1;
    @Excel(name = "接驳口1经度", prompt = "接驳口1经度")
    private double JD1;
    @Excel(name = "接驳口2纬度", prompt = "接驳口2纬度")
    private double WD2;
    @Excel(name = "接驳口2经度", prompt = "接驳口2经度")
    private double JD2;
    @Excel(name = "审批正文下载路径", prompt = "审批正文下载路径")
    private String filePath;


    private String beginTime;
    private String endTime;

    private String okTime;

    public String getSBLSH() {
        return SBLSH;
    }

    public void setSBLSH(String SBLSH) {
        this.SBLSH = SBLSH;
    }

    public String getSBLSH_SHORT() {
        return SBLSH_SHORT;
    }

    public void setSBLSH_SHORT(String SBLSH_SHORT) {
        this.SBLSH_SHORT = SBLSH_SHORT;
    }

    public String getSXBM() {
        return SXBM;
    }

    public void setSXBM(String SXBM) {
        this.SXBM = SXBM;
    }

    public String getSXMC() {
        return SXMC;
    }

    public void setSXMC(String SXMC) {
        this.SXMC = SXMC;
    }

    public String getSXQXBM() {
        return SXQXBM;
    }

    public void setSXQXBM(String SXQXBM) {
        this.SXQXBM = SXQXBM;
    }

    public String getFSXBM() {
        return FSXBM;
    }

    public void setFSXBM(String FSXBM) {
        this.FSXBM = FSXBM;
    }

    public String getFSXMC() {
        return FSXMC;
    }

    public void setFSXMC(String FSXMC) {
        this.FSXMC = FSXMC;
    }

    public String getSQRLX() {
        return SQRLX;
    }

    public void setSQRLX(String SQRLX) {
        this.SQRLX = SQRLX;
    }

    public String getSQRMC() {
        return SQRMC;
    }

    public void setSQRMC(String SQRMC) {
        this.SQRMC = SQRMC;
    }

    public String getSQRZJLX() {
        return SQRZJLX;
    }

    public void setSQRZJLX(String SQRZJLX) {
        this.SQRZJLX = SQRZJLX;
    }

    public String getSQRZJHM() {
        return SQRZJHM;
    }

    public void setSQRZJHM(String SQRZJHM) {
        this.SQRZJHM = SQRZJHM;
    }

    public String getLXRXM() {
        return LXRXM;
    }

    public void setLXRXM(String LXRXM) {
        this.LXRXM = LXRXM;
    }

    public String getLXRZJLX() {
        return LXRZJLX;
    }

    public void setLXRZJLX(String LXRZJLX) {
        this.LXRZJLX = LXRZJLX;
    }

    public String getLXRSFZJHM() {
        return LXRSFZJHM;
    }

    public void setLXRSFZJHM(String LXRSFZJHM) {
        this.LXRSFZJHM = LXRSFZJHM;
    }

    public String getLXRSJ() {
        return LXRSJ;
    }

    public void setLXRSJ(String LXRSJ) {
        this.LXRSJ = LXRSJ;
    }

    public String getLXRYX() {
        return LXRYX;
    }

    public void setLXRYX(String LXRYX) {
        this.LXRYX = LXRYX;
    }

    public String getSBXMMC() {
        return SBXMMC;
    }

    public void setSBXMMC(String SBXMMC) {
        this.SBXMMC = SBXMMC;
    }

    public String getSBCLQD() {
        return SBCLQD;
    }

    public void setSBCLQD(String SBCLQD) {
        this.SBCLQD = SBCLQD;
    }

    public String getTJFS() {
        return TJFS;
    }

    public void setTJFS(String TJFS) {
        this.TJFS = TJFS;
    }

    public String getSBHZH() {
        return SBHZH;
    }

    public void setSBHZH(String SBHZH) {
        this.SBHZH = SBHZH;
    }

    public Date getSBSJ() {
        return SBSJ;
    }

    public void setSBSJ(Date SBSJ) {
        this.SBSJ = SBSJ;
    }

    public String getSBJTWD() {
        return SBJTWD;
    }

    public void setSBJTWD(String SBJTWD) {
        this.SBJTWD = SBJTWD;
    }

    public String getXZQHDM() {
        return XZQHDM;
    }

    public void setXZQHDM(String XZQHDM) {
        this.XZQHDM = XZQHDM;
    }

    public String getYSBLSH() {
        return YSBLSH;
    }

    public void setYSBLSH(String YSBLSH) {
        this.YSBLSH = YSBLSH;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }

    public String getF_XZQHDM() {
        return F_XZQHDM;
    }

    public void setF_XZQHDM(String f_XZQHDM) {
        F_XZQHDM = f_XZQHDM;
    }

    public String getUSERIDCODE() {
        return USERIDCODE;
    }

    public void setUSERIDCODE(String USERIDCODE) {
        this.USERIDCODE = USERIDCODE;
    }

    public String getPROJECT_CODE() {
        return PROJECT_CODE;
    }

    public void setPROJECT_CODE(String PROJECT_CODE) {
        this.PROJECT_CODE = PROJECT_CODE;
    }

    public String getWSSBQD() {
        return WSSBQD;
    }

    public void setWSSBQD(String WSSBQD) {
        this.WSSBQD = WSSBQD;
    }

    public String getOBTAIN_PAPER_WAY() {
        return OBTAIN_PAPER_WAY;
    }

    public void setOBTAIN_PAPER_WAY(String OBTAIN_PAPER_WAY) {
        this.OBTAIN_PAPER_WAY = OBTAIN_PAPER_WAY;
    }

    public String getOBTAIN_DELIVER_WAY() {
        return OBTAIN_DELIVER_WAY;
    }

    public void setOBTAIN_DELIVER_WAY(String OBTAIN_DELIVER_WAY) {
        this.OBTAIN_DELIVER_WAY = OBTAIN_DELIVER_WAY;
    }

    public String getVERSION() {
        return VERSION;
    }

    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }

    public Short getREC_FLAG() {
        return REC_FLAG;
    }

    public void setREC_FLAG(Short REC_FLAG) {
        this.REC_FLAG = REC_FLAG;
    }

    public String getXML_DATA() {
        return XML_DATA;
    }

    public void setXML_DATA(String XML_DATA) {
        this.XML_DATA = XML_DATA;
    }

    public String getD_ZZJGDM() {
        return D_ZZJGDM;
    }

    public void setD_ZZJGDM(String d_ZZJGDM) {
        D_ZZJGDM = d_ZZJGDM;
    }

    public String getSXBM_SHORT() {
        return SXBM_SHORT;
    }

    public void setSXBM_SHORT(String SXBM_SHORT) {
        this.SXBM_SHORT = SXBM_SHORT;
    }

    public Date getINSERTTIME() {
        return INSERTTIME;
    }

    public void setINSERTTIME(Date INSERTTIME) {
        this.INSERTTIME = INSERTTIME;
    }

    public Date getRESPONSETIME() {
        return RESPONSETIME;
    }

    public void setRESPONSETIME(Date RESPONSETIME) {
        this.RESPONSETIME = RESPONSETIME;
    }

    public int getFLAG() {
        return FLAG;
    }

    public void setFLAG(int FLAG) {
        this.FLAG = FLAG;
    }

    public int getSYNC() {
        return SYNC;
    }

    public void setSYNC(int SYNC) {
        this.SYNC = SYNC;
    }

    public String getDWDM() {
        return DWDM;
    }

    public void setDWDM(String DWDM) {
        this.DWDM = DWDM;
    }

    public String getBYZD1() {
        return BYZD1;
    }

    public void setBYZD1(String BYZD1) {
        this.BYZD1 = BYZD1;
    }

    public String getBYZD2() {
        return BYZD2;
    }

    public void setBYZD2(String BYZD2) {
        this.BYZD2 = BYZD2;
    }

    public String getBYZD4() {
        return BYZD4;
    }

    public void setBYZD4(String BYZD4) {
        this.BYZD4 = BYZD4;
    }

    public String getBYZD3() {
        return BYZD3;
    }

    public void setBYZD3(String BYZD3) {
        this.BYZD3 = BYZD3;
    }

    public String getBMMC() {
        return BMMC;
    }

    public void setBMMC(String BMMC) {
        this.BMMC = BMMC;
    }

    public String getBMZZJGDM() {
        return BMZZJGDM;
    }

    public void setBMZZJGDM(String BMZZJGDM) {
        this.BMZZJGDM = BMZZJGDM;
    }

    public String getBYZD() {
        return BYZD;
    }

    public void setBYZD(String BYZD) {
        this.BYZD = BYZD;
    }

    public String getSFSXDDDL() {
        return SFSXDDDL;
    }

    public void setSFSXDDDL(String SFSXDDDL) {
        this.SFSXDDDL = SFSXDDDL;
    }

    public String getDDDLYHID() {
        return DDDLYHID;
    }

    public void setDDDLYHID(String DDDLYHID) {
        this.DDDLYHID = DDDLYHID;
    }

    public String getCLZT() {
        return CLZT;
    }

    public void setCLZT(String CLZT) {
        this.CLZT = CLZT;
    }

    public Date getCLSJ() {
        return CLSJ;
    }

    public void setCLSJ(Date CLSJ) {
        this.CLSJ = CLSJ;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getISTOSPJC() {
        return ISTOSPJC;
    }

    public void setISTOSPJC(Integer ISTOSPJC) {
        this.ISTOSPJC = ISTOSPJC;
    }

    public String getSXBBH() {
        return SXBBH;
    }

    public void setSXBBH(String SXBBH) {
        this.SXBBH = SXBBH;
    }

    public Date getSYNCTIME() {
        return SYNCTIME;
    }

    public void setSYNCTIME(Date SYNCTIME) {
        this.SYNCTIME = SYNCTIME;
    }

    public String getSXBBBM() {
        return SXBBBM;
    }

    public void setSXBBBM(String SXBBBM) {
        this.SXBBBM = SXBBBM;
    }

    public String getSXBDBM() {
        return SXBDBM;
    }

    public void setSXBDBM(String SXBDBM) {
        this.SXBDBM = SXBDBM;
    }

    public String getSJSXBM() {
        return SJSXBM;
    }

    public void setSJSXBM(String SJSXBM) {
        this.SJSXBM = SJSXBM;
    }

    public String getSJSXBBH() {
        return SJSXBBH;
    }

    public void setSJSXBBH(String SJSXBBH) {
        this.SJSXBBH = SJSXBBH;
    }

    public double getWD1() {
        return WD1;
    }

    public void setWD1(double WD1) {
        this.WD1 = WD1;
    }

    public double getJD1() {
        return JD1;
    }

    public void setJD1(double JD1) {
        this.JD1 = JD1;
    }

    public double getWD2() {
        return WD2;
    }

    public void setWD2(double WD2) {
        this.WD2 = WD2;
    }

    public double getJD2() {
        return JD2;
    }

    public void setJD2(double JD2) {
        this.JD2 = JD2;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getOkTime() {
        return okTime;
    }

    public void setOkTime(String okTime) {
        this.okTime = okTime;
    }
}
