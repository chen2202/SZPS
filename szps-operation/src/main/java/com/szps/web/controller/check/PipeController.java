package com.szps.web.controller.check;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/check/pipe")
public class PipeController {

    @RequestMapping(value = "/pipe")
    public  String getPipe(){
        return "check/pipe/pipe";
    }
}
