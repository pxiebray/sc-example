package com.ztest.sc.business.product.test;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/8/15 0015 52
 */
public class RibbonTest {
    private static final List<Server> serverList = new ArrayList<>();
    static {
        serverList.add(new Server("peer1", 8081));
        serverList.add(new Server("peer2", 8082));
        serverList.add(new Server("peer3", 8083));
    }

    public static void main(String[] args) {
        LoadBalancerBuilder builder = LoadBalancerBuilder.newBuilder();
        ILoadBalancer loadBalancer = builder.buildFixedServerListLoadBalancer(serverList);
        for (int i = 0; i < 10; i++ ){
            Server server = loadBalancer.chooseServer(null);
            System.out.println(server.toString());
        }


    }
}
