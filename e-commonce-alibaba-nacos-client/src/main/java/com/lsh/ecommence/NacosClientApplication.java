package com.lsh.ecommence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author lishaohui
 * @Date 2023/5/25 17:26
 */
@SpringBootApplication
@EnableDiscoveryClient
//@RefreshScope
public class NacosClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class, args);
    }

}
