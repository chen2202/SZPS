package com.szps.web.controller.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.core.controller.BaseController;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.utils.DateUtils;
import com.szps.web.domain.report.DayReportW;
import com.szps.web.domain.report.YearReport;
import com.szps.web.service.report.IDayReportWService;

@Controller
@RequestMapping("/op/report/collect/year")
public class CollectYearReportController extends BaseController {
	 @Autowired
	private IDayReportWService reportService;
	
	private String prefix = "/report/collect";

    
    @GetMapping("")
    public String collect( ModelMap mmap)
    {
        return prefix + "/yearcollect";
    }
    
    @GetMapping("/stat")
    public String stat(ModelMap mmap)
    {
        return prefix + "/stat";
    }
    
    @RequiresPermissions("report:daycollect:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DayReportW dayReport,ModelMap mmap)
    {
        startPage();
        if (null == dayReport) {
        	dayReport = new DayReportW();
 		}
        dayReport.setDtype("b");
        String startTime1 = dayReport.getStartTime1();
        String endTime1 = "9999-12-31" ;
        if (null == startTime1 || startTime1.equals("")) {
			try {
				startTime1 = String.valueOf(DateUtils.getYear(DateUtils.getDate(), DateUtils.YYYY_MM_DD))+"-00-00";
				endTime1 =  String.valueOf(DateUtils.getYear(DateUtils.getDate(), DateUtils.YYYY_MM_DD))+"-12-32";
			} catch (Exception e) {
				
			}
		}else {
			startTime1 = startTime1+"-00-00";
			endTime1 = startTime1+"-12-32";
		}
        List<DayReportW> list = reportService.selectListForYear(dayReport.getDtype(), startTime1, endTime1);
        List<YearReport> yList = new ArrayList<YearReport>();
        List<DayReportW> nlist = new ArrayList<DayReportW>();
        if (null != list && list.size()>0) {
        	Map<String, List<DayReportW>> map = new HashMap<>();
        	int k = 0;
        	int k1 = 0;
        	int lastIndex = k;
        	int lastIndex2 = k1;
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
										switch (month) {
											case 1:
												tcapacity1 =tcapacity1+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 2:
												tcapacity2 =tcapacity2+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 3:
												tcapacity3 =tcapacity3+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 4:
												tcapacity4 =tcapacity4+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 5:
												tcapacity5 =tcapacity5+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 6:
												tcapacity6 =tcapacity6+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 7:
												tcapacity7 =tcapacity7+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 8:
												tcapacity8 =tcapacity8+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 9:
												tcapacity9 =tcapacity9+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 10:
												tcapacity10 =tcapacity10+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 11:
												tcapacity11 =tcapacity11+Double.valueOf(dayReportW2.getTcapacity());
												break;
											case 12:
												tcapacity12 =tcapacity12+Double.valueOf(dayReportW2.getTcapacity());
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
								yearReport.setDscale(dayReportW2.getDscale());
								switch (month) {
									case 1:
										tcapacity1 =tcapacity1+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 2:
										tcapacity2 =tcapacity2+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 3:
										tcapacity3 =tcapacity3+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 4:
										tcapacity4 =tcapacity4+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 5:
										tcapacity5 =tcapacity5+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 6:
										tcapacity6 =tcapacity6+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 7:
										tcapacity7 =tcapacity7+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 8:
										tcapacity8 =tcapacity8+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 9:
										tcapacity9 =tcapacity9+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 10:
										tcapacity10 =tcapacity10+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 11:
										tcapacity11 =tcapacity11+Double.valueOf(dayReportW2.getTcapacity());
										break;
									case 12:
										tcapacity12 =tcapacity12+Double.valueOf(dayReportW2.getTcapacity());
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
 				
 				

 			}
        	
 		}
        return getDataTable(yList);
    }
}
