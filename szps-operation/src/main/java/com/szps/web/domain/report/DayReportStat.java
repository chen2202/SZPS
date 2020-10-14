package com.szps.web.domain.report;

import java.util.List;

public class DayReportStat {
	String basin;//所属流域
	String tcapacity;//处理量
	String loadrate;//负荷率
	String incod;//进水COD
	String inbod;//进水BOD
	String inan;//进水氨氮
	String inp;//进水总磷
	String remark;//进水总磷
	public String getBasin() {
		return basin;
	}
	public void setBasin(String basin) {
		this.basin = basin;
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
	public String getInbod() {
		return inbod;
	}
	public void setInbod(String inbod) {
		this.inbod = inbod;
	}
	public String getInan() {
		return inan;
	}
	public void setInan(String inan) {
		this.inan = inan;
	}
	public String getInp() {
		return inp;
	}
	public void setInp(String inp) {
		this.inp = inp;
	}
	
	   
    public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public DayReportStat statReport(List<DayReportW> list,int lastIndex,int k) {
		Double tcapacity  = 0d;//处理量
		Double loadrate = 0d;//负荷率
		Double incod = 0d;//进水COD
		Double inan = 0d;//进水氨氮
		Double inp = 0d;//进水总磷
		Double inbod = 0d;//进水BOD
		String basin = "";
		for(int i = lastIndex ;i<k;i++) {
			DayReportW t =list.get(i);
			basin = t.getBasin();
			try {
				tcapacity = tcapacity + Double.valueOf(t.getTcapacity());
			} catch (Exception e) {
			}
			try {
				String s = t.getLoadrate();
				if (s!=null && s.contains("%")) {
					s=s.replace("%", "");
				}
				loadrate = loadrate +Double.valueOf(s);
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
		}
		DayReportStat w = new DayReportStat();
		//w.setBasin(lt.getBasin());
		w.setBasin(basin);
		w.setTcapacity(String.format("%.2f", tcapacity));
		w.setLoadrate(String.format("%.2f", loadrate)+"%");
		w.setIncod(String.format("%.2f", incod));
		w.setInan(String.format("%.2f", inan));
		w.setInp(String.format("%.2f", inp));
		//w.setInss(String.format("%.2f", inss/t1));
		w.setInbod(String.format("%.2f", inbod));
		return w;
    }
}
