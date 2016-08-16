package com.zhaoqi.controller.test.config;

import com.tts.component.annotation.Json;
import com.tts.component.config.ConfigReader;
import com.zhaoqi.controller.common.model.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoqi on 2016/8/16 0016.
 */
@Controller
@RequestMapping("/global/config")
public class DynamicConfigTestController {

    @Resource
    private ConfigReader configReader;

    @RequestMapping("/get")
    @ResponseBody
    public ResponseVo getConfig (@Json List<String> keys) {
        Map<String,String> configs = new HashMap<>();
        for (String key: keys) {
            configs.put(key,configReader.getString(key,null));
        }
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(configs);
        return responseVo;
    }
}
