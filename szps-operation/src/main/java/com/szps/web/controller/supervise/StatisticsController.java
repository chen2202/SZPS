package com.szps.web.controller.supervise;


import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.web.service.supervise.FeedbackService;
import com.szps.web.service.supervise.TaskService;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/supervise/statistics")
public class StatisticsController extends BaseController {

    private String prefix = "supervise/statistics";

    @Autowired
    TaskService taskService;

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/statistics")
    public String dataview()
    {

        return prefix+"/Statistics";
    }

    @RequiresPermissions("supervise:statistics:list")
    @PostMapping("/list")
    public String list(HttpServletRequest request, Model model)
    {
        String taskRegion=request.getParameter("taskRegion");
        String taskStreet=request.getParameter("taskStreet");
        String report=request.getParameter("report");
        String taskTime=request.getParameter("taskTime");
        if(report.equals("月报"))
        {
            //完成的
            List a=new ArrayList();
            //总的
            List b=new ArrayList();
            String s;

            for (int i=1;i<=31;i+=2)
            {

                if(i<10)
                {
                   s=taskTime+"-0"+String.valueOf(i);
                }
                else
                {
                    s=taskTime+"-"+String.valueOf(i);
                }
               b.add(taskService.selectTaskCount(taskRegion,taskStreet,s));
               a.add(feedbackService.countTbFeedback(taskRegion,taskStreet,s));
            }
            model.addAttribute("complete",a);
            model.addAttribute("all",b);
            model.addAttribute("taskTime",taskTime);
            System.out.println(model);
            return prefix+"/monthStatistics";
        }
        else if(report.equals("季报"))
        {
           String s=taskTime.substring(0,4);
           String ss;
            //完成的
            int []a=new int[20];
            List complete=new ArrayList();
            //总的
            int []b=new int[20];
            List all=new ArrayList();
           for (int i=1;i<=12;i++)
           {
              if (i<10)
              {
                  ss=s+"-0"+String.valueOf(i);
              }
              else
              {
                  ss=s+"-"+String.valueOf(i);
              }
               b[i]=taskService.selectMonthTaskCount(taskRegion,taskStreet,ss);

               a[i]=feedbackService.countMonthTbFeedback(taskRegion,taskStreet,ss);

           }
            int one=a[2]+a[3]+a[4];
            int two=a[5]+a[6]+a[7];
            int three=a[8]+a[9]+a[10];
            int four=a[0]+a[1]+a[11];

            int oneall=b[2]+b[3]+b[4];
            int twoall=b[5]+b[6]+b[7];
            int threeall=b[8]+b[9]+b[10];
            int fourall=b[0]+b[1]+b[11];

            complete.add(one);
            complete.add(two);
            complete.add(three);
            complete.add(four);
            all.add(oneall);
            all.add(twoall);
            all.add(threeall);
            all.add(fourall);
            model.addAttribute("complete",complete);
            model.addAttribute("all",all);
            model.addAttribute("taskTime",s);

            return prefix+"/seasonStatistics";
        }
        else if(report.equals("年报"))
        {
            String s=taskTime.substring(0,4);
            String ss;

            //完成的
            List a=new ArrayList();
            //总的
            List b=new ArrayList();
            for (int i=1;i<=12;i++)
            {
                if (i<10)
                {
                    ss=s+"-0"+String.valueOf(i);

                }
                else
                {
                    ss=s+"-"+String.valueOf(i);

                }
                b.add(taskService.selectMonthTaskCount(taskRegion,taskStreet,ss));

                a.add(feedbackService.countMonthTbFeedback(taskRegion,taskStreet,ss));

            }
            model.addAttribute("complete",a);
            model.addAttribute("all",b);
            model.addAttribute("taskTime",s);

            return prefix+"/yearStatistics";
        }
        else
             return prefix+"/Statistics";
    }





}
