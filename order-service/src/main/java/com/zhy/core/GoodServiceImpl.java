package com.zhy.core;

import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {

    /**
     * 熔断用
     * @return
     */
    @Override
    public String getGoodStr() {
        return "服务调取失败";
    }
}
