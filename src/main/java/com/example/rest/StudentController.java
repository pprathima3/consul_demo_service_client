/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest;

import com.example.dto.HelloDto;
import com.example.rest.client.HystrixWrappedProsClient;
import com.example.rest.client.ProsDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



/**
 *
 * @author praveena
 */
@RestController
@RequestMapping("/")
@EnableAutoConfiguration
public class StudentController {
    
    @Autowired
    private HystrixWrappedProsClient prosClient;
    @Autowired
    DiscoveryClient discoveryClient;
    
    @Autowired
    ProsDelegate prosDelegate;
    
    @RequestMapping(value = "/getDetails/{id}", method = GET)
    public String get(@PathVariable String id) {
       //HelloDto dto = prosClient.get(id);
       return prosDelegate.invokePros(id);
    }
    
   
    
}
