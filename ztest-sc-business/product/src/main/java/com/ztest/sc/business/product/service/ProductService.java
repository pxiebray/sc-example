package com.ztest.sc.business.product.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/8/15 0015 07
 */
@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String getProduct(Long id) {
        return restTemplate.getForObject("http://USER/users/1", String.class);
    }

    public String fallback(Long id) {
        return "hello hystrix " + id;
    }
}
