package com.szps.web.controller.event;


import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.framework.web.domain.server.Sys;
import com.szps.web.domain.event.EventAll;
import com.szps.web.domain.event.EventSend;
import com.szps.web.domain.event.EventSubmit;
import com.szps.web.service.event.IEventEmailService;
import com.szps.web.service.event.IEventSubmitService;
import com.szps.web.service.event.impl.EventEmailServiceImpl;
import com.szps.web.service.event.impl.EventSubmitServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping(value = "event/send")
public class EvnetSendController extends BaseController {

    private String prefix = "event/send";

    @Autowired
    private IEventSubmitService eventSubmitService;

    @Autowired
    private IEventEmailService eventEmailService;

    @RequiresPermissions("event:send:view")
    @GetMapping()
    public String submit() {
        return prefix + "/send";
    }

    /**
     * 查询污水厂事件列表
     */
    @RequiresPermissions("event:submit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EventSubmit eventSubmit) {
        startPage();
        List<EventAll> list = new ArrayList<EventAll>();

        return getDataTable(list);
    }


    @GetMapping("/sendmail/{eventSid}")
    public String sendEmail(@PathVariable("eventSid") Integer eventSid, ModelMap mmap, Model model) {
        EventAll eventAll = new EventAll();
        EventSubmit eventSubmit = eventSubmitService.selectEventSubmitById(eventSid);
        List<EventSend> eventSend = eventSubmitService.getEventSendEmail();
        model.addAttribute("emails", eventSend);
        for (int i = 0; i < eventSend.size(); i++) {
            if (eventSend.get(i).getEventAttribute().equals(eventSubmit.getEventAttribute())) {
                eventAll.setEventEmail(eventSend.get(i).getEventEmail());
            }
        }
        eventAll.setEventSid(eventSubmit.getEventSid());
        eventAll.setEventName(eventSubmit.getEventName());
        eventAll.setEventPlace(eventSubmit.getEventPlace());
        eventAll.setEventTime(eventSubmit.getEventTime());
        eventAll.setEventContent(eventSubmit.getEventContent());
        eventAll.setEventAttribute(eventSubmit.getEventAttribute());
        eventAll.setEventCreateuser(eventSubmit.getEventCreateuser());
        eventAll.setCreateTime(eventSubmit.getCreateTime());
        mmap.put("eventAll", eventAll);

        return prefix + "/sendmail";
    }

    @GetMapping(value = "sendmail")
    public String sendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sendUser = request.getParameter("eventCreateuser");
        String eventName = request.getParameter("eventName");
        String eventContent = request.getParameter("eventContent");
        String emails = request.getParameter("channelsList");
        String[] strs = emails.split(",");

        for(int i=0;i<strs.length;i++){
            sendEmail(sendUser, eventName, eventContent, strs[i]);
        }

        EventSubmit eventSubmit=new EventSubmit();
        eventSubmit.setEventName(eventName);
        eventSubmit.setEventStatus("已发送");

        eventEmailService.updateEventStatus(eventSubmit);

        return "event/submit/submit";
    }

    // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    public static String myEmailAccount = "2942362392@qq.com";
    public static String myEmailPassword = "enuiqgstccandgjb";

    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.qq.com";

//    // 收件人邮箱（替换为自己知道的有效邮箱）
//    public static String receiveMailAccount = "3309329172@qq.com";

    public static void sendEmail(String sendUser, String eventName, String eventContent, String email) throws Exception {
// 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     打开下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        /*
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        */

//        for (int i = 0; i < email.length; i++) {


            // 2. 根据配置创建会话对象, 用于和邮件服务器交互
            Session session = Session.getInstance(props);
//           session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

            // 3. 创建一封邮件
            MimeMessage message = createMimeMessage(session, myEmailAccount, email, sendUser, eventName, eventContent);

            // 4. 根据 Session 获取邮件传输对象
            Transport transport = session.getTransport();

            // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
            //
            //    PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
            //           仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
            //           类型到对应邮件服务器的帮助网站上查看具体失败原因。
            //
            //    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
            //           (1) 邮箱没有开启 SMTP 服务;
            //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
            //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
            //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
            //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
            //
            //    PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
            transport.connect(myEmailAccount, myEmailPassword);

            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());

            // 7. 关闭连接
            transport.close();
//        }
    }


    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session     和服务器交互的会话
     * @param sendMail    发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String sendUser, String eventName, String eventContent) throws Exception {


        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, sendUser, "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "", "UTF-8"));

        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject(eventName, "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent(eventContent, "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
}
