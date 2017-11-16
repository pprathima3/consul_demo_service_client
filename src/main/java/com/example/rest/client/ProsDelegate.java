/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author praveena
 */
@Service
public class ProsDelegate {
     @Autowired
    RestTemplate restTemplate;
     
      @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    public String invokePros(String id){
        if(restTemplate == null){
            System.out.println("restTempalte is null");
        } else {
            System.out.println("restTemplate is not null");
        }
        String response = restTemplate.exchange("http://pros/pros/hello/{id}",HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},id).getBody();
       return response;
    }
}
