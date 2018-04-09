package com.lucky.LogTest;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/Log")
public class LogInitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogInitController.class);

    @RequestMapping(value = "/initLog")
    @ResponseBody
    public String LogPrint(){
        LOGGER.info("日志请求  {}","begin");

        return "log end";

    }



}
