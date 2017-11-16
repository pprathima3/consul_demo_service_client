/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.rest.client;

import com.example.dto.HelloDto;
import javax.websocket.server.PathParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author praveena
 */
@FeignClient(name="pros")
public interface ProsClient {
    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    HelloDto get(@PathParam("id") String id);
}
