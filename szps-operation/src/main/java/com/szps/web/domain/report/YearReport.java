package com.szps.web.domain.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.szps.common.annotation.Excel;
import com.szps.common.utils.DateUtils;

public class YearReport {
	Long id;
	@Excel(name = "流域")
	String basin;// 所属流域
	@Excel(name = "水质净化厂")
	String deptname;// 名称
	
	@Excel(name = "辖区")
	String darea;// 辖区
	@Excel(name = "设计规模(万吨/日)")
	String dscale;// 设计规模
	@Excel(name = "1月处理水量(万吨)")
	String tcapacity1;// 处理量
	@Excel(name = "2月处理水量(万吨)")
	String tcapacity2;// 处理量
	@Excel(name = "3月处理水量(万吨)")
	String tcapacity3;// 处理量
	@Excel(name = "4月处理水量(万吨)")
	String tcapacity4;// 处理量
	@Excel(name = "5月处理水量(万吨)")
	String tcapacity5;// 处理量
	@Excel(name = "6月处理水量(万吨)")
	String tcapacity6;// 处理量
	@Excel(name = "7月处理水量(万吨)")
	String tcapacity7;// 处理量
	@Excel(name = "8月处理水量(万吨)")
	String tcapacity8;// 处理量
	@Excel(name = "9月处理水量(万吨)")
	String tcapacity9;// 处理量
	@Excel(name = "10月处理水量(万吨)")
	String tcapacity10;// 处理量
	@Excel(name = "11月处理水量(万吨)")
	String tcapacity11;// 处理量
	@Excel(name = "12月处理水量(万吨)")
	String tcapacity12;// 处理量

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDarea() {
		return darea;
	}

	public void setDarea(String darea) {
		this.darea = darea;
	}

	public String getDscale() {
		return dscale;
	}

	public void setDscale(String dscale) {
		this.dscale = dscale;
	}

	public String getTcapacity1() {
		return tcapacity1;
	}

	public void setTcapacity1(String tcapacity1) {
		this.tcapacity1 = tcapacity1;
	}

	public String getTcapacity2() {
		return tcapacity2;
	}

	public void setTcapacity2(String tcapacity2) {
		this.tcapacity2 = tcapacity2;
	}

	public String getTcapacity3() {
		return tcapacity3;
	}

	public void setTcapacity3(String tcapacity3) {
		this.tcapacity3 = tcapacity3;
	}

	public String getTcapacity4() {
		return tcapacity4;
	}

	public void setTcapacity4(String tcapacity4) {
		this.tcapacity4 = tcapacity4;
	}

	public String getTcapacity5() {
		return tcapacity5;
	}

	public void setTcapacity5(String tcapacity5) {
		this.tcapacity5 = tcapacity5;
	}

	public String getTcapacity6() {
		return tcapacity6;
	}

	public void setTcapacity6(String tcapacity6) {
		this.tcapacity6 = tcapacity6;
	}

	public String getTcapacity7() {
		return tcapacity7;
	}

	public void setTcapacity7(String tcapacity7) {
		this.tcapacity7 = tcapacity7;
	}

	public String getTcapacity8() {
		return tcapacity8;
	}

	public void setTcapacity8(String tcapacity8) {
		this.tcapacity8 = tcapacity8;
	}

	public String getTcapacity9() {
		return tcapacity9;
	}

	public void setTcapacity9(String tcapacity9) {
		this.tcapacity9 = tcapacity9;
	}

	public String getTcapacity10() {
		return tcapacity10;
	}

	public void setTcapacity10(String tcapacity10) {
		this.tcapacity10 = tcapacity10;
	}

	public String getTcapacity11() {
		return tcapacity11;
	}

	public void setTcapacity11(String tcapacity11) {
		this.tcapacity11 = tcapacity11;
	}

	public String getTcapacity12() {
		return tcapacity12;
	}

	public void setTcapacity12(String tcapacity12) {
		this.tcapacity12 = tcapacity12;
	}
	

    public List<YearReport> calYearReport(List<DayReportW> list ){
    	List<YearReport> yList = new ArrayList<YearReport>();
    	if (null == list || list.size()<=0) {
			return yList;
		}
        	Map<String, List<DayReportW>> map = new HashMap<>();
        	int k = 0;
        	int k1 = 0;
        	int lastIndex = k;
        	Long id = 1L;
        	Long id2 = 1L;
        	for (DayReportW dayReportW : list) {
        		List<DayReportW> tmpList = map.get(dayReportW.getBasin());
        		if (tmpList == null) {
        			if (k > 0) {
        				DayReportW lt =list.get(k-1);
        				//DayReportW w = dayReportW.calReport(list, lastIndex, k);
        				//String.valueOf(/t1)
        				List<DayReportW> tList = map.get(lt.getBasin());
        				//-----
        				Map<String, List<DayReportW>> map2 = new HashMap<>();
        				for (DayReportW dayReportW2 : tList) {
        					List<DayReportW> tmpList2 = map2.get(dayReportW2.getDeptname());
        					if (tmpList2 ==null ) {
								/*
								 * if (k1>0) { System.out.println(k1); }
								 */
        						tmpList2 = new ArrayList<>();
        						dayReportW2.setId(id);
        	        			tmpList2.add(dayReportW2);
        	        			map2.put(dayReportW2.getDeptname(), tmpList2);
							}else {
			        			id++;
			        			dayReportW2.setId(id);
			        			tmpList2.add(dayReportW2);
			        		}
        					k1++;
						}
        				if (map2.size()>0) {
        					YearReport yearReportBasin = new YearReport();
    					    Double tcapacityBasin1 = 0d;//处理量
    					    Double tcapacityBasin2 = 0d;//处理量
    					    Double tcapacityBasin3 = 0d;//处理量
    					    Double tcapacityBasin4 = 0d;//处理量
    					    Double tcapacityBasin5 = 0d;//处理量
    					    Double tcapacityBasin6 = 0d;//处理量
    					    Double tcapacityBasin7 = 0d;//处理量
    					    Double tcapacityBasin8 = 0d;//处理量
    					    Double tcapacityBasin9 = 0d;//处理量
    					    Double tcapacityBasin10 = 0d;//处理量
    					    Double tcapacityBasin11 = 0d;//处理量
    					    Double tcapacityBasin12 = 0d;//处理量
    					    Double dscale = 0d;//处理量
    					    
        					for(Entry<String, List<DayReportW>> entry : map2.entrySet()){
        					    String mapKey = entry.getKey();
        					    List<DayReportW> mvList = entry.getValue();
        					    YearReport yearReport = new YearReport();
        					    Double tcapacity1 = 0d;//处理量
        					    Double tcapacity2 = 0d;//处理量
        					    Double tcapacity3 = 0d;//处理量
        					    Double tcapacity4 = 0d;//处理量
        					    Double tcapacity5 = 0d;//处理量
        					    Double tcapacity6 = 0d;//处理量
        					    Double tcapacity7 = 0d;//处理量
        					    Double tcapacity8 = 0d;//处理量
        					    Double tcapacity9 = 0d;//处理量
        					    Double tcapacity10 = 0d;//处理量
        					    Double tcapacity11 = 0d;//处理量
        					    Double tcapacity12 = 0d;//处理量
        					    for (DayReportW dayReportW2 : mvList) {
									try {
										int month = DateUtils.getMonth(dayReportW2.getReportdate(), DateUtils.YYYY_MM_DD);
										yearReport.setBasin(dayReportW2.getBasin());
										yearReport.setDarea(dayReportW2.getDarea());
										yearReport.setDscale(dayReportW2.getDscale());
										yearReport.setDeptname(dayReportW2.getDeptname());
										String t = dayReportW2.getTcapacity();
										if (null == t || t.equals("")) {
											t="0";
										}
										switch (month) {
											case 1:
												tcapacity1 =tcapacity1+Double.valueOf(t);
												break;
											case 2:
												tcapacity2 =tcapacity2+Double.valueOf(t);
												break;
											case 3:
												tcapacity3 =tcapacity3+Double.valueOf(t);
												break;
											case 4:
												tcapacity4 =tcapacity4+Double.valueOf(t);
												break;
											case 5:
												tcapacity5 =tcapacity5+Double.valueOf(t);
												break;
											case 6:
												tcapacity6 =tcapacity6+Double.valueOf(t);
												break;
											case 7:
												tcapacity7 =tcapacity7+Double.valueOf(t);
												break;
											case 8:
												tcapacity8 =tcapacity8+Double.valueOf(t);
												break;
											case 9:
												tcapacity9 =tcapacity9+Double.valueOf(t);
												break;
											case 10:
												tcapacity10 =tcapacity10+Double.valueOf(t);
												break;
											case 11:
												tcapacity11 =tcapacity11+Double.valueOf(t);
												break;
											case 12:
												tcapacity12 =tcapacity12+Double.valueOf(t);
												break;
												
											default:
												break;
										}
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
        					    yearReport.setTcapacity1(String.format("%.2f", tcapacity1));
        					    yearReport.setTcapacity2(String.format("%.2f", tcapacity2));
        					    yearReport.setTcapacity3(String.format("%.2f", tcapacity3));
        					    yearReport.setTcapacity4(String.format("%.2f", tcapacity4));
        					    yearReport.setTcapacity5(String.format("%.2f", tcapacity5));
        					    yearReport.setTcapacity6(String.format("%.2f", tcapacity6));
        					    yearReport.setTcapacity7(String.format("%.2f", tcapacity7));
        					    yearReport.setTcapacity8(String.format("%.2f", tcapacity8));
        					    yearReport.setTcapacity9(String.format("%.2f", tcapacity9));
        					    yearReport.setTcapacity10(String.format("%.2f", tcapacity10));
        					    yearReport.setTcapacity11(String.format("%.2f", tcapacity11));
        					    yearReport.setTcapacity12(String.format("%.2f", tcapacity12));
        					    yearReport.setId(id2);
        					    id2++;
        					    yList.add(yearReport);
        					    
        					    dscale = dscale + Double.valueOf(yearReport.getDscale());
        					    tcapacityBasin1  = tcapacityBasin1  + tcapacity1 ;
        					    tcapacityBasin2  = tcapacityBasin2  + tcapacity2 ;
        					    tcapacityBasin3  = tcapacityBasin3  + tcapacity3 ;
        					    tcapacityBasin4  = tcapacityBasin4  + tcapacity4 ;
        					    tcapacityBasin5  = tcapacityBasin5  + tcapacity5 ;
        					    tcapacityBasin6  = tcapacityBasin6  + tcapacity6 ;
        					    tcapacityBasin7  = tcapacityBasin7  + tcapacity7 ;
        					    tcapacityBasin8  = tcapacityBasin8  + tcapacity8 ;
        					    tcapacityBasin9  = tcapacityBasin9  + tcapacity9 ;
        					    tcapacityBasin10 = tcapacityBasin10 + tcapacity10;
        					    tcapacityBasin11 = tcapacityBasin11 + tcapacity11;
        					    tcapacityBasin12 = tcapacityBasin12 + tcapacity12;
        					}
        					yearReportBasin.setDeptname("合计");
    					    yearReportBasin.setDscale(String.format("%.2f", dscale));
    					    yearReportBasin.setTcapacity1 (String.format("%.2f", tcapacityBasin1 ));
    					    yearReportBasin.setTcapacity2 (String.format("%.2f", tcapacityBasin2 ));
    					    yearReportBasin.setTcapacity3 (String.format("%.2f", tcapacityBasin3 ));
    					    yearReportBasin.setTcapacity4 (String.format("%.2f", tcapacityBasin4 ));
    					    yearReportBasin.setTcapacity5 (String.format("%.2f", tcapacityBasin5 ));
    					    yearReportBasin.setTcapacity6 (String.format("%.2f", tcapacityBasin6 ));
    					    yearReportBasin.setTcapacity7 (String.format("%.2f", tcapacityBasin7 ));
    					    yearReportBasin.setTcapacity8 (String.format("%.2f", tcapacityBasin8 ));
    					    yearReportBasin.setTcapacity9 (String.format("%.2f", tcapacityBasin9 ));
    					    yearReportBasin.setTcapacity10(String.format("%.2f", tcapacityBasin10));
    					    yearReportBasin.setTcapacity11(String.format("%.2f", tcapacityBasin11));
    					    yearReportBasin.setTcapacity12(String.format("%.2f", tcapacityBasin12));
    					    yList.add(yearReportBasin);
						}
        				//----        				
        				//tList.add(w);
        				//nlist.addAll(tList);
        				lastIndex = k;
        				id=1L;
        				
        				

 					}
        			tmpList = new ArrayList<>();
        			dayReportW.setId(id);
        			tmpList.add(dayReportW);
        			map.put(dayReportW.getBasin(), tmpList);
        		} else {
        			id++;
        			dayReportW.setId(id);
        			tmpList.add(dayReportW);
        		}
        		k++;
 			}
        	if (k>lastIndex) {
        		DayReportW lt =list.get(k-1);
 				//DayReportW w = lt.calReport(list, lastIndex, k);
 				//String.valueOf(/t1)
 				List<DayReportW> tList = map.get(lt.getBasin());
 				
 				//-----
				Map<String, List<DayReportW>> map2 = new HashMap<>();
				for (DayReportW dayReportW2 : tList) {
					List<DayReportW> tmpList2 = map2.get(dayReportW2.getDeptname());
					if (tmpList2 ==null ) {
						/*
						 * if (k1>0) { System.out.println(k1); }
						 */
						tmpList2 = new ArrayList<>();
						dayReportW2.setId(id);
	        			tmpList2.add(dayReportW2);
	        			map2.put(dayReportW2.getDeptname(), tmpList2);
					}else {
	        			id++;
	        			dayReportW2.setId(id);
	        			tmpList2.add(dayReportW2);
	        		}
					k1++;
				}
				if (map2.size()>0) {
					YearReport yearReportBasin = new YearReport();
				    Double tcapacityBasin1 = 0d;//处理量
				    Double tcapacityBasin2 = 0d;//处理量
				    Double tcapacityBasin3 = 0d;//处理量
				    Double tcapacityBasin4 = 0d;//处理量
				    Double tcapacityBasin5 = 0d;//处理量
				    Double tcapacityBasin6 = 0d;//处理量
				    Double tcapacityBasin7 = 0d;//处理量
				    Double tcapacityBasin8 = 0d;//处理量
				    Double tcapacityBasin9 = 0d;//处理量
				    Double tcapacityBasin10 = 0d;//处理量
				    Double tcapacityBasin11 = 0d;//处理量
				    Double tcapacityBasin12 = 0d;//处理量
				    Double dscale = 0d;//处理量
					for(Entry<String, List<DayReportW>> entry : map2.entrySet()){
					    String mapKey = entry.getKey();
					    List<DayReportW> mvList = entry.getValue();
					    YearReport yearReport = new YearReport();
					    Double tcapacity1 = 0d;//处理量
					    Double tcapacity2 = 0d;//处理量
					    Double tcapacity3 = 0d;//处理量
					    Double tcapacity4 = 0d;//处理量
					    Double tcapacity5 = 0d;//处理量
					    Double tcapacity6 = 0d;//处理量
					    Double tcapacity7 = 0d;//处理量
					    Double tcapacity8 = 0d;//处理量
					    Double tcapacity9 = 0d;//处理量
					    Double tcapacity10 = 0d;//处理量
					    Double tcapacity11 = 0d;//处理量
					    Double tcapacity12 = 0d;//处理量
					    for (DayReportW dayReportW2 : mvList) {
							try {
								int month = DateUtils.getMonth(dayReportW2.getReportdate(), DateUtils.YYYY_MM_DD);
								yearReport.setBasin(dayReportW2.getBasin());
								yearReport.setDarea(dayReportW2.getDarea());
								double a = 0;
								double b = 0;
								try {
									 a = Double.valueOf(yearReport.getDscale());
								} catch (Exception e) {
									// TODO: handle exception
								}
								try {
									b = Double.valueOf(dayReportW2.getDscale());
								} catch (Exception e) {
									// TODO: handle exception
								}
								 
								yearReport.setDscale( String.valueOf(a+b) );
								yearReport.setDeptname(dayReportW2.getDeptname());
								String t = dayReportW2.getTcapacity();
								if (null == t || t.equals("")) {
									t="0";
								}
								switch (month) {
									case 1:
										tcapacity1 =tcapacity1+Double.valueOf(t);
										break;
									case 2:
										tcapacity2 =tcapacity2+Double.valueOf(t);
										break;
									case 3:
										tcapacity3 =tcapacity3+Double.valueOf(t);
										break;
									case 4:
										tcapacity4 =tcapacity4+Double.valueOf(t);
										break;
									case 5:
										tcapacity5 =tcapacity5+Double.valueOf(t);
										break;
									case 6:
										tcapacity6 =tcapacity6+Double.valueOf(t);
										break;
									case 7:
										tcapacity7 =tcapacity7+Double.valueOf(t);
										break;
									case 8:
										tcapacity8 =tcapacity8+Double.valueOf(t);
										break;
									case 9:
										tcapacity9 =tcapacity9+Double.valueOf(t);
										break;
									case 10:
										tcapacity10 =tcapacity10+Double.valueOf(t);
										break;
									case 11:
										tcapacity11 =tcapacity11+Double.valueOf(t);
										break;
									case 12:
										tcapacity12 =tcapacity12+Double.valueOf(t);
										break;
										
									default:
										break;
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					    yearReport.setTcapacity1(String.format("%.2f", tcapacity1));
					    yearReport.setTcapacity2(String.format("%.2f", tcapacity2));
					    yearReport.setTcapacity3(String.format("%.2f", tcapacity3));
					    yearReport.setTcapacity4(String.format("%.2f", tcapacity4));
					    yearReport.setTcapacity5(String.format("%.2f", tcapacity5));
					    yearReport.setTcapacity6(String.format("%.2f", tcapacity6));
					    yearReport.setTcapacity7(String.format("%.2f", tcapacity7));
					    yearReport.setTcapacity8(String.format("%.2f", tcapacity8));
					    yearReport.setTcapacity9(String.format("%.2f", tcapacity9));
					    yearReport.setTcapacity10(String.format("%.2f", tcapacity10));
					    yearReport.setTcapacity11(String.format("%.2f", tcapacity11));
					    yearReport.setTcapacity12(String.format("%.2f", tcapacity12));
					    yearReport.setId(id2);
					    id2++;
					    yList.add(yearReport);
					    String ds = yearReport.getDscale();
					    if (null ==  ds) {
							ds="0";
						}
					    dscale = dscale + Double.valueOf(ds);
					    tcapacityBasin1  = tcapacityBasin1  + tcapacity1 ;
					    tcapacityBasin2  = tcapacityBasin2  + tcapacity2 ;
					    tcapacityBasin3  = tcapacityBasin3  + tcapacity3 ;
					    tcapacityBasin4  = tcapacityBasin4  + tcapacity4 ;
					    tcapacityBasin5  = tcapacityBasin5  + tcapacity5 ;
					    tcapacityBasin6  = tcapacityBasin6  + tcapacity6 ;
					    tcapacityBasin7  = tcapacityBasin7  + tcapacity7 ;
					    tcapacityBasin8  = tcapacityBasin8  + tcapacity8 ;
					    tcapacityBasin9  = tcapacityBasin9  + tcapacity9 ;
					    tcapacityBasin10 = tcapacityBasin10 + tcapacity10;
					    tcapacityBasin11 = tcapacityBasin11 + tcapacity11;
					    tcapacityBasin12 = tcapacityBasin12 + tcapacity12;
					}
					yearReportBasin.setDeptname("合计");
				    yearReportBasin.setDscale(String.format("%.2f", dscale));
				    yearReportBasin.setTcapacity1 (String.format("%.2f", tcapacityBasin1 ));
				    yearReportBasin.setTcapacity2 (String.format("%.2f", tcapacityBasin2 ));
				    yearReportBasin.setTcapacity3 (String.format("%.2f", tcapacityBasin3 ));
				    yearReportBasin.setTcapacity4 (String.format("%.2f", tcapacityBasin4 ));
				    yearReportBasin.setTcapacity5 (String.format("%.2f", tcapacityBasin5 ));
				    yearReportBasin.setTcapacity6 (String.format("%.2f", tcapacityBasin6 ));
				    yearReportBasin.setTcapacity7 (String.format("%.2f", tcapacityBasin7 ));
				    yearReportBasin.setTcapacity8 (String.format("%.2f", tcapacityBasin8 ));
				    yearReportBasin.setTcapacity9 (String.format("%.2f", tcapacityBasin9 ));
				    yearReportBasin.setTcapacity10(String.format("%.2f", tcapacityBasin10));
				    yearReportBasin.setTcapacity11(String.format("%.2f", tcapacityBasin11));
				    yearReportBasin.setTcapacity12(String.format("%.2f", tcapacityBasin12));
				    yList.add(yearReportBasin);
				}
				
				//----
 				
 				//tList.add(w);
 				//nlist.addAll(tList);
 				
 				

 			}
        	return yList;
    }

}
