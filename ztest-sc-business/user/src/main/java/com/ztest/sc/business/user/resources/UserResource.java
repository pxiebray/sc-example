package com.ztest.sc.business.user.resources;

import com.ztest.sc.business.user.vo.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/8/14 0014 59
 */
@RestController
public class UserResource {

    @Value("${hello}")
    private String helloValue;

    @Value("${server.port}")
    private String instancePort;

    @GetMapping
    public String home(@PathVariable Long id) {
        return "hello " + helloValue;
    }

    @GetMapping("/users/{id}")
    public UserInfo getUser(@PathVariable Long id) {
        return new UserInfo(id, instancePort, "", "");
    }
}
