package com.ztest.sc.cloud.gateway;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.alibaba.nacos.discovery.NacosDiscoveryClientAutoConfiguration;
import org.springframework.cloud.gateway.discovery.GatewayDiscoveryClientAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 强制NacosDiscover在Gateway前装配，确保gateway能通过注册中心中获取路由
 * gateway集成eureka时，通过对Ribbon的装配顺序强制Discover在GateWay前装配
 * gateway集成nacos时，无法控制装配顺序，导致Gateway装配时未发现Discover，因此无法从discover获取路由
 *
 * @author Administrator
 * @version 1.0
 * @data 2019/3/8 0008 16
 */
@Configuration
@AutoConfigureAfter({NacosDiscoveryClientAutoConfiguration.class})
@AutoConfigureBefore({GatewayDiscoveryClientAutoConfiguration.class})
public class NacosBeforeGatewayConfiguration {

}
