package com.szps.web.controller.wechat;


import com.szps.web.domain.event.EventSubmit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "eventUpload")
public class EventUploadController {

    @PostMapping(value = "/event/list")
    @ResponseBody
    public List<EventSubmit> getEventList(){

        return null;
    }

}
