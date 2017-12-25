package com.zhy.core;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GoodService goodService;

    @RequestMapping("/getOrder")
    @HystrixCommand(fallbackMethod = "findOrderFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String getOrderInof(){
//        try{
//            Thread.sleep(5000);
//        }catch (Exception e){
//
//        }
       String result =  restTemplate.getForObject("http://good-service/good/info",String.class);
        return "good info: " + result ;
    }



    public String findOrderFallback() {
        return "订单查找失败！";
    }
    @RequestMapping("/info")
    public  String getSystemInfo(){
        return  System.currentTimeMillis() + "";
    }

    @RequestMapping("/goods")
    public String getGoodsStr(){
        return goodService.getGoodStr();
    }
}
