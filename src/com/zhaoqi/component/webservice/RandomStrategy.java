package com.zhaoqi.component.webservice;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;

/**
 * Created by zhaoqi on 2016/5/20.
 */
public class RandomStrategy implements Strategy {

    private final Random random = new Random();

    @Override
    public <T> T getServiceInstance(List<T> services) {
        if (CollectionUtils.isEmpty(services)) {
            return null;
        }
        int index =random.nextInt(services.size());
        return services.get(index);
    }
}
