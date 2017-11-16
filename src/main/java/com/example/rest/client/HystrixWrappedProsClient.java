/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest.client;

import com.example.dto.HelloDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author praveena
 */
@Service
public class HystrixWrappedProsClient implements ProsClient {
    
    @Autowired 
    ProsClient prosClient;
    
    @Override
    @HystrixCommand(groupKey = "helloGroup", fallbackMethod = "fallBackCall")
    public HelloDto get(String id) {
        return prosClient.get(id);
    }

    public String fallBackCall() {
        return "FAILED PROS CALL! - FALLING BACK";
}

    
}
