package com.ztest.sc.business.product.resources;

import com.ztest.sc.business.product.feign.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/8/14 0014 57
 */
@RestController
public class ProductResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserApi userApi;

    @GetMapping("/products/rest/{id}")
    public String getProductByRest(@PathVariable Long id) {
        return restTemplate.getForObject("http://user/users/1", String.class);
    }

    @GetMapping("/products/feign/{id}")
    public String getProductByFeign(@PathVariable Long id) {
        return userApi.getUser(id);
    }


}
