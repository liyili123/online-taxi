package com.mashibing.cloudeureka;

import com.netflix.appinfo.DataCenterInfo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.eureka.lease.Lease;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

    @Test
    public void concurrent(){
        ConcurrentHashMap<String, Map<String, Lease<InstanceInfo>>> registry = new ConcurrentHashMap();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            InstanceInfo ii = new InstanceInfo("instanceId", "appname", "groupname", "111.11.11", "sid", new InstanceInfo.PortWrapper(true, 9988),
                    new InstanceInfo.PortWrapper(false, 9877), "ssss", "ssss", "ssssss", "12121", "safasdas", "adss", 1, new DataCenterInfo() {
                @Override
                public Name getName() {
                    return null;
                }
            },"localhost",InstanceInfo.InstanceStatus.DOWN,null,null,null,false,null,System.currentTimeMillis(),System.currentTimeMillis(),InstanceInfo.ActionType.ADDED,"asgName");
            ii.setLastDirtyTimestamp(System.currentTimeMillis());
            Lease<InstanceInfo> lease = new Lease<>(ii,1);
            Map<String ,Lease<InstanceInfo>> map = new HashMap<String,Lease<InstanceInfo>>();
            registry.putIfAbsent("applicationName",map);
            registry.get("applicationName");


        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
