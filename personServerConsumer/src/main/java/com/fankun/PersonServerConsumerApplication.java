package com.fankun;

import com.fankun.api.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient//@EnableEurekaClient EnableDiscoveryClient发现服务，包括eureka
@EnableFeignClients(basePackageClasses={PersonService.class})
public class PersonServerConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonServerConsumerApplication.class,args);
    }
}
