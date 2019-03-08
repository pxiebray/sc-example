package com.ztest.sc.business.product.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Administrator
 * @version 1.0
 * @data 2019/3/8 0008 26
 */
@FeignClient(name = "user")
public interface UserApi {

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    String getUser(@PathVariable Long id);
}
