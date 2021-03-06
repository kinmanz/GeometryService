package com.db.geometry.services;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.Date;
import java.util.List;
import java.util.Random;

public enum Services {
    DISCOVERY("discovery"),
    MAPLOGIN("maplogin"),
    MAP("maplogin"),
    LOGIN("maplogin"),
    MATH("mathservice"),
    GEOMETRY("geometry"),
    TELEGRAM("telegram");

    public final String id;

    Services(String id) {
        this.id = id;
    }

    private static final Random random = new Random(new Date().getTime());

    private static ServiceInstance pickRandomInstanceFromList(List<ServiceInstance> instances) {
        return instances.get(Math.abs(random.nextInt()) % instances.size());
    }

    public ServiceInstance pickRandomInstance(DiscoveryClient discoveryClient) {
        return pickRandomInstanceFromList(discoveryClient.getInstances(id));
    }
}