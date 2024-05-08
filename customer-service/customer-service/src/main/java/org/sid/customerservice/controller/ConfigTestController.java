package org.sid.customerservice.controller;

import org.sid.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
    @Autowired
    GlobalConfig globalConfig;
    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
     @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")
    private int p2;

    @GetMapping("/testConfig")
    public Map<String,Integer> ConfigTest(){
        return Map.of("p1",p1,"p2",p2);
    }
}
