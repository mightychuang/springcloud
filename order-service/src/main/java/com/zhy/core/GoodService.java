package com.zhy.core;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("good-service")
public interface GoodService {

    @GetMapping("/str")
    String getGoodStr();
}
