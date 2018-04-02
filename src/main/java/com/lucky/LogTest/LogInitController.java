package com.lucky.LogTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LogInitController {

    @RequestMapping(value = "/")
    public void LogPrint(){
        Integer integer = Integer.valueOf(3);




    }


}
