package com.zhy;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//请用服务熔断
@RefreshScope//启用配置中心自动刷新
@EnableFeignClients //开启FeignClient
public class OrderApp {

    @Bean
    @LoadBalanced//启用服务负载
    public RestTemplate createRestTemplate(){
        return  new RestTemplate();
    }

    /**
     * 随机策略
     *
     * 配置文件application.yml加入
         NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
         stores:
            ribbon:
                listOfServers: www.baidu.com,www.jalja.org,www.163.org
     */
    @Bean
    public IRule createRandomRule(){
        return new RandomRule();
    }

    /**
     * 择一个最小的并发请求的server 逐个考察Server，如果Server被tripped了，
        则忽略，在选择其中ActiveRequestsCount最小的server
     在配置文件application.yml加入
        NFLoadBalancerRuleClassName: com.netflix.loadbalancer.BestAvailableRule
     */
//    @Bean
//    public IRule createBestAvailableRule(){
//        return  new BestAvailableRule();
//    }
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class);
    }
}
