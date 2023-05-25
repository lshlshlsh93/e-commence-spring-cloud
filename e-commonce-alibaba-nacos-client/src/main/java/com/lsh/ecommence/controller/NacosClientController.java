package com.lsh.ecommence.controller;

import com.lsh.ecommence.service.NacosClientService;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author lishaohui
 * @Date 2023/5/25 18:55
 * @Decription <h1>nacos client controller</h1>
 */
@Slf4j
@RestController
@RequestMapping("/nacos-client")
public class NacosClientController {

    private final NacosClientService nacosClientService;

    public NacosClientController(NacosClientService nacosClientService) {
        this.nacosClientService = nacosClientService;
    }

    /**
     * <h2>根据service id获取服务的所有实例信息</h2>
     */
    @GetMapping("/service-instance")
    public List<ServiceInstance> logNacosClientInfo(
            @RequestParam(defaultValue = "e-commence-nacos-client") String serviceId
    ) {
        log.info("coming in nacos client info: [{}]", serviceId);
        return nacosClientService.getNacosClientInfo(serviceId);
    }


}
