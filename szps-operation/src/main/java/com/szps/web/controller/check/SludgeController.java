package com.szps.web.controller.check;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "check/sludge")
public class SludgeController {

    @RequestMapping(value = "/sludge")
    public String getsludge(){
        return "check/sludge/sludge";
    }
}
