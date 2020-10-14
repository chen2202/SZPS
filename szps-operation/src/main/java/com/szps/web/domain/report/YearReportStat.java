package com.szps.web.domain.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.szps.common.annotation.Excel;
import com.szps.common.utils.DateUtils;

public class YearReportStat {
	Long id;
	String deptname;// 名称
	Integer whichYear;
	// 总规模
	double totalScale;
	// 计算规模
	double calCapacity;
	// 实际处理量
	double realCapacity;
	// 日均处理量
	String avgDayCapacity;
	// 负荷率
	String loadrate;
	// COD削减量
	double cod;
	// AD削减量
	double ad;
	// 平均COD进水浓度
	double avgCod;
	// 平均AD进水浓度
	double avgAD;
	
	int days;

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getWhichYear() {
		return whichYear;
	}

	public void setWhichYear(Integer whichYear) {
		this.whichYear = whichYear;
	}

	public double getTotalScale() {
		return totalScale;
	}

	public void setTotalScale(double totalScale) {
		this.totalScale = totalScale;
	}

	public double getCalCapacity() {
		return calCapacity;
	}

	public void setCalCapacity(double calCapacity) {
		this.calCapacity = calCapacity;
	}

	public double getRealCapacity() {
		return realCapacity;
	}

	public void setRealCapacity(double realCapacity) {
		this.realCapacity = realCapacity;
	}

	public String getAvgDayCapacity() {
		return avgDayCapacity;
	}

	public void setAvgDayCapacity(String avgDayCapacity) {
		this.avgDayCapacity = avgDayCapacity;
	}

	public String getLoadrate() {
		return loadrate;
	}

	public void setLoadrate(String loadrate) {
		this.loadrate = loadrate;
	}

	public double getCod() {
		return cod;
	}

	public void setCod(double cod) {
		this.cod = cod;
	}

	public double getAd() {
		return ad;
	}

	public void setAd(double ad) {
		this.ad = ad;
	}

	public double getAvgCod() {
		return avgCod;
	}

	public void setAvgCod(double avgCod) {
		this.avgCod = avgCod;
	}

	public double getAvgAD() {
		return avgAD;
	}

	public void setAvgAD(double avgAD) {
		this.avgAD = avgAD;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<YearReportStat> calYearReport(List<DayReportW> list) {
		
		Map<Integer, YearReportStat > map = new HashMap<>();
		int k = 0;
		int k1 = 0;
		int lastIndex = k;
		Long id = 1L;
		Long id2 = 1L;
		for (DayReportW dayReportW : list) {
			String reportDate = dayReportW.getReportdate();
			Integer year = 0;
			try {
				year = DateUtils.getYear(reportDate, DateUtils.YYYY_MM_DD);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			YearReportStat tmp = map.get(year);
			if (tmp == null) {
				if (k > 0) {
					lastIndex = k;
					id = 1L;
				}
				tmp = new YearReportStat();
				tmp.setId(id);
				//tmp.setDeptname(dayReportW.getDeptname());
				tmp.setWhichYear(year);
				try {
					double totalScale = 0;
					try {
						totalScale = Double.valueOf(dayReportW.getDscale());
					} catch (Exception e) {
						// TODO: handle exception
					}
					tmp.setTotalScale(totalScale);
					tmp.setCalCapacity(totalScale);
				} catch (Exception e) {
				}
				try {
					double a = Double.valueOf(dayReportW.getTcapacity());
					tmp.setRealCapacity(a);
				} catch (Exception e) {
				}
				
				//tmp.setAvgDayCapacity(avgDayCapacity);
				//tmp.setLoadrate(loadrate);
				//削减量COD：（进水COD*实际处理量）—（出水COD*实际处理量）
				try {
					double a = Double.valueOf(dayReportW.getIncod()); 
					double b = Double.valueOf(dayReportW.getOutan()); 				
					tmp.setCod((a-b)*tmp.getRealCapacity());
				} catch (Exception e) {
				}
				//	削减量氨氮：（进水氨氮*实际处理量）—（出水氨氮*实际处理量）
				try {
					double a = Double.valueOf(dayReportW.getInan()); 
					double b = Double.valueOf(dayReportW.getOutan()); 				
					tmp.setAd((a-b)*tmp.getRealCapacity());
				} catch (Exception e) {
				}
				//?	进水COD：时段内各日进水COD浓度与日处理量乘积累加之和与日处理量累加之和的比值；
				try {
					double a = Double.valueOf(dayReportW.getIncod()); 				
					tmp.setAvgCod(a*tmp.getRealCapacity());
				} catch (Exception e) {
				}
				//?
				try {
					double a = Double.valueOf(dayReportW.getInan()); 				
					tmp.setAvgAD(a*tmp.getRealCapacity());
				} catch (Exception e) {
				}
				tmp.setDays(1);
				map.put(year, tmp);
			} else {
				id++;
				try {
					double totalScale = 0;
					double b = 0;
					try {
						totalScale = Double.valueOf(dayReportW.getDscale());
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						b = Double.valueOf(dayReportW.getTcapacity());
					} catch (Exception e) {
						// TODO: handle exception
					}
					tmp.setTotalScale(totalScale+tmp.getTotalScale());
					tmp.setCalCapacity(b+tmp.getCalCapacity());
				} catch (Exception e) {
				}
				try {
					double a = Double.valueOf(dayReportW.getTcapacity());
					tmp.setRealCapacity(a+tmp.getRealCapacity());
				} catch (Exception e) {
				}
				
				try {
					double a = Double.valueOf(dayReportW.getIncod()); 
					double b = Double.valueOf(dayReportW.getOutan()); 				
					tmp.setCod((a-b)*tmp.getRealCapacity()+tmp.getCod());
				} catch (Exception e) {
				}
				//	削减量氨氮：（进水氨氮*实际处理量）—（出水氨氮*实际处理量）
				try {
					double a = Double.valueOf(dayReportW.getInan()); 
					double b = Double.valueOf(dayReportW.getOutan()); 				
					tmp.setAd((a-b)*tmp.getRealCapacity()+tmp.getAd());
				} catch (Exception e) {
				}
				//?	进水COD：时段内各日进水COD浓度与日处理量乘积累加之和与日处理量累加之和的比值；
				try {
					double a = Double.valueOf(dayReportW.getIncod()); 				
					tmp.setAvgCod(a+tmp.getAvgAD());
				} catch (Exception e) {
				}
				//?
				try {
					double a = Double.valueOf(dayReportW.getInan()); 				
					tmp.setAvgAD(a+tmp.getAvgAD());
				} catch (Exception e) {
				}
				tmp.setDays(tmp.getDays()+1);
			}
			k++;
		

		}
		List<YearReportStat> list2 = new ArrayList<YearReportStat>();
		if (map.size()>0) {
			for(Integer key:map.keySet()){
				YearReportStat stat = map.get(key);
				double a = 0;
				try {
					a = stat.getRealCapacity();
				} catch (Exception e) {
				}
				
				stat.setAvgDayCapacity(String.format("%.2f", a/stat.getDays()));
				stat.setLoadrate(String.format("%.2f", stat.getRealCapacity()/stat.getCalCapacity()*100)+"%");
				list2.add(stat);
            }
		}
		
		return list2;
	}

}
