package com.ztest.sc.cloud.eureka;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiepeng
 * @version 1.0
 * @data 2018/7/6 0006 33
 */
@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
@EnableAdminServer
@RestController
public class EurekaApplication {


    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/test")
    public void getTest() {
        Applications applications = eurekaClient.getApplications();
        Application application = applications.getRegisteredApplications("EUREKA");

        if (application != null) {
            System.out.println(application.toString());

            List<InstanceInfo> instanceInfos = application.getInstances();
            if (instanceInfos != null) {
                instanceInfos.forEach(instanceInfo -> {
                    instanceInfo.getMetadata();
                });
            }
        }
        System.out.println(applications.size());
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
