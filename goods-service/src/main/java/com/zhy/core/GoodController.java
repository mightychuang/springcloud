package com.zhy.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Value("${eureka.instance.hostname}")
    private  String hostName;


    @RequestMapping("/info")
    public  String getGoodInfo(String name){
        System.out.println(hostName + " "  +System.currentTimeMillis() + " == " + name);
        return  hostName + " "  +System.currentTimeMillis() + " == " + name;
    }

    @RequestMapping("/str")
    public  String getTime(){
        return "aaaa";
    }

}
