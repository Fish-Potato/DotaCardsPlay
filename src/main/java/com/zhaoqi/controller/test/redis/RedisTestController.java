package com.zhaoqi.controller.test.redis;

import com.tts.component.annotation.Json;
import com.tts.component.cache.TTSCache;
import com.tts.component.cache.TTSCacheClean;
import com.zhaoqi.controller.common.model.ResponseVo;
import com.zhaoqi.controller.test.redis.model.RedisTestRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaoqi on 2016/8/15 0015.
 */
@Controller()
public class RedisTestController {

    @RequestMapping("/tts")
    @ResponseBody
    @TTSCache(keyExpression = "#{a}#{b}#{helloRequest}")
    public ResponseVo getCacheTest(@Json RedisTestRequest request){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setMsg("success");
        return responseVo;
    }


    @RequestMapping("/tts/clean")
    @ResponseBody
    @TTSCacheClean(keyExpression = "#{a}#{b}#{helloRequest}",methodName ="getCacheTest" )
    public ResponseVo cleanCacheTest(@Json RedisTestRequest request){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setMsg("success");
        return responseVo;
    }
}
