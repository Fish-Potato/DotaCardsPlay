package com;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import net.sf.ehcache.util.NamedThreadFactory;

/**
 * Created by zhaoqi on 2016/6/28.
 */
public class ScheduledTest {
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(1,new NamedThreadFactory("PraiseAdd-Task"));

    public static void main(String[] args) {
        ScheduledTest scheduledTest = new ScheduledTest();
        for (int i=0;i<20;i++) {
            scheduledTest.execute("我是task"+i);
        }
    }

    public void execute(String msg) {
        service.scheduleAtFixedRate(() -> System.out.println(msg),0,30, TimeUnit.SECONDS);
    }
}
