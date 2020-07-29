package com.szps.web.domain.report;

import java.util.List;

import com.szps.common.core.domain.BaseEntity;

public class DayReportW extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12653304690408370L;
	Long id;
	Long deptid;
	String deptname;// 名称
	String basin;//所属流域
	String reportdate;//日期
	String dscale;//设计规模
	String tcapacity;//处理量
	String loadrate;//负荷率
	String incod;//进水COD
	String inan;//进水氨氮
	String darea;//辖区
	String inp;//进水总磷
	String inss;//进水SS
	String inbod;//进水BOD
	String outcod;//出水COD
	String outan;//出水氨氮
	String outp;//出水总磷
	String outdo;//出水DO
	String dlevel;//提升泵坑 设计液位
	String aleave;//提升泵坑 实际液位
	String sludec;//污泥浓度
	String lanfilll;//垃圾渗滤液
	String sol;//渗滤液来源
	String operation;//运营单位
	String dtype;//类型
	Long dept_id;//CREATE_BY 部门ID
	String startTime1;
	String endTime1;
	
	
	public String getStartTime1() {
		return startTime1;
	}
	public void setStartTime1(String startTime1) {
		this.startTime1 = startTime1;
	}
	public String getEndTime1() {
		return endTime1;
	}
	public void setEndTime1(String endTime1) {
		this.endTime1 = endTime1;
	}
	public Long getDept_id() {
		return dept_id;
	}
	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDeptid() {
		return deptid;
	}
	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getBasin() {
		return basin;
	}
	public void setBasin(String basin) {
		this.basin = basin;
	}
	public String getReportdate() {
		return reportdate;
	}
	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}
	public String getDscale() {
		return dscale;
	}
	public void setDscale(String dscale) {
		this.dscale = dscale;
	}
	public String getTcapacity() {
		return tcapacity;
	}
	public void setTcapacity(String tcapacity) {
		this.tcapacity = tcapacity;
	}
	public String getLoadrate() {
		return loadrate;
	}
	public void setLoadrate(String loadrate) {
		this.loadrate = loadrate;
	}
	public String getIncod() {
		return incod;
	}
	public void setIncod(String incod) {
		this.incod = incod;
	}
	public String getInan() {
		return inan;
	}
	public void setInan(String inan) {
		this.inan = inan;
	}
	public String getDarea() {
		return darea;
	}
	public void setDarea(String darea) {
		this.darea = darea;
	}
	public String getInp() {
		return inp;
	}
	public void setInp(String inp) {
		this.inp = inp;
	}
	public String getInss() {
		return inss;
	}
	public void setInss(String inss) {
		this.inss = inss;
	}
	public String getInbod() {
		return inbod;
	}
	public void setInbod(String inbod) {
		this.inbod = inbod;
	}
	public String getOutcod() {
		return outcod;
	}
	public void setOutcod(String outcod) {
		this.outcod = outcod;
	}
	public String getOutan() {
		return outan;
	}
	public void setOutan(String outan) {
		this.outan = outan;
	}
	public String getOutp() {
		return outp;
	}
	public void setOutp(String outp) {
		this.outp = outp;
	}
	public String getOutdo() {
		return outdo;
	}
	public void setOutdo(String outdo) {
		this.outdo = outdo;
	}
	public String getDlevel() {
		return dlevel;
	}
	public void setDlevel(String dlevel) {
		this.dlevel = dlevel;
	}
	public String getAleave() {
		return aleave;
	}
	public void setAleave(String aleave) {
		this.aleave = aleave;
	}
	public String getSludec() {
		return sludec;
	}
	public void setSludec(String sludec) {
		this.sludec = sludec;
	}
	public String getLanfilll() {
		return lanfilll;
	}
	public void setLanfilll(String lanfilll) {
		this.lanfilll = lanfilll;
	}
	public String getSol() {
		return sol;
	}
	public void setSol(String sol) {
		this.sol = sol;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

    
    
    public DayReportW calReport(List<DayReportW> list,int lastIndex,int k) {
    	Double dscale = 0d;//设计规模
		Double tcapacity  = 0d;//处理量
		Double loadrate = 0d;//负荷率
		Double incod = 0d;//进水COD
		Double inan = 0d;//进水氨氮
		Double inp = 0d;//进水总磷
		Double inss = 0d;//进水SS
		Double inbod = 0d;//进水BOD
		Double outcod = 0d;//出水COD
		Double outan = 0d;//出水氨氮
		Double outp = 0d;//出水总磷
		Double outdo = 0d;//出水DO
		Double dlevel = 0d;//提升泵坑 设计液位
		Double aleave = 0d;//提升泵坑 实际液位
		Double sludec = 0d;//污泥浓度
		Double lanfilll = 0d;//垃圾渗滤液
		for(int i = lastIndex ;i<k;i++) {
			DayReportW t =list.get(i);
			try {
				dscale = dscale + Double.valueOf(t.getDscale());
			} catch (Exception e) {
			}
			try {
				tcapacity = tcapacity + Double.valueOf(t.getTcapacity());
			} catch (Exception e) {
			}
			try {
				loadrate = loadrate +Double.valueOf(t.getLoadrate());
			} catch (Exception e) {
			}
			try {
				incod = incod + Double.valueOf(t.getIncod());
			} catch (Exception e) {
			}
			try {
				inan = inan + Double.valueOf(t.getInan());
			} catch (Exception e) {
			}
			try {
				inp = inp + Double.valueOf(t.getInp());
			} catch (Exception e) {
			}
			try {
				inss = inss+ Double.valueOf(t.getInss());
			} catch (Exception e) {
			}
			try {
				inbod = inbod+ Double.valueOf(t.getInbod());
			} catch (Exception e) {
			}
			try {
				outcod = outcod + Double.valueOf(t.getOutcod());
			} catch (Exception e) {
			}
			try {
				outan = outan + Double.valueOf(t.getOutan());
			} catch (Exception e) {
			}
			try {
				outp = outp + Double.valueOf(t.getOutp());
			} catch (Exception e) {
			}
			try {
				outdo = outdo+ Double.valueOf(t.getOutdo());
			} catch (Exception e) {
			}
			try {
				dlevel = dlevel + Double.valueOf(t.getDlevel());
			} catch (Exception e) {
			}
			try {
				aleave = aleave + Double.valueOf(t.getAleave());
			} catch (Exception e) {
			}
			try {
				sludec = sludec+ Double.valueOf(t.getSludec());
			} catch (Exception e) {
			}
			try {
				lanfilll = lanfilll + Double.valueOf(t.getLanfilll());
			} catch (Exception e) {
			}
		}
		int t1 = k-lastIndex;
		DayReportW w = new DayReportW();
		//w.setBasin(lt.getBasin());
		w.setDarea("-");
		w.setDeptname("合计");
		w.setDscale(String.format("%.2f", dscale));
		w.setTcapacity(String.format("%.2f", tcapacity));
		w.setLoadrate(String.format("%.2f", loadrate/t1));
		w.setIncod(String.format("%.2f", incod/t1));
		w.setInan(String.format("%.2f", inan/t1));
		w.setInp(String.format("%.2f", inp/t1));
		//w.setInss(String.format("%.2f", inss/t1));
		w.setInbod(String.format("%.2f", inbod/t1));
		w.setOutcod(String.format("%.2f", outcod/t1));
		w.setOutan(String.format("%.2f", outan/t1));
		w.setOutp(String.format("%.2f", outp/t1));
		w.setOutdo(String.format("%.2f", outdo/t1));
		w.setDlevel(String.format("%.2f", dlevel/t1));
		w.setAleave(String.format("%.2f", aleave/t1));
		w.setSludec(String.format("%.2f", sludec/t1));
		w.setLanfilll(String.format("%.2f", lanfilll/t1));
		return w;
    }
    
}