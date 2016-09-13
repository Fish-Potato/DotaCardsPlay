package com.zhaoqi.test;

import com.tts.component.message.TTSMessageConsumer;
import com.tts.util.JsonUtil;
import org.springframework.stereotype.Service;

/**
 * Created by zhaoqi on 2016/9/1 0001.
 */
@Service
public class TestConsumer implements TTSMessageConsumer {

    @Override
    public String getMessageName() {
        return "hehe";
    }

    @Override
    public void handleMessage(Object message) {
        System.out.println("receive amq message : "+ JsonUtil.toString(message));
    }
}
