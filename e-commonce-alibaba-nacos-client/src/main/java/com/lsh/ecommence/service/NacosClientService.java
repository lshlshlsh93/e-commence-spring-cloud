package com.lsh.ecommence.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author lishaohui
 * @Date 2023/5/25 18:52
 */
@Service
@Slf4j
public class NacosClientService {

    private final DiscoveryClient discoveryClient;


    public NacosClientService(
            DiscoveryClient discoveryClient
    ) {
        this.discoveryClient = discoveryClient;
    }

    public List<ServiceInstance> getNacosClientInfo(String serviceId) {
        log.info("request nacos client to get service instance info: [{}]", serviceId);
        return discoveryClient.getInstances(serviceId);
    }

}
