package com.zhaoqi.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaoqi.component.webservice.ServiceCaller;
import com.zhaoqi.controller.common.model.ResponseVo;
import com.zhaoqi.restapi.HelloRequest;

/**
 * Created by zhaoqi on 2016/5/26.
 */
@Controller
@RequestMapping("/common")
public class ZeuServiceTestController {
    @Resource
    private ServiceCaller serviceCaller;

    @RequestMapping("/serviceCaller/test")
    @ResponseBody
    public ResponseVo sayHiByServiceCaller(){
        ResponseVo response= new ResponseVo();
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setHello("ship of love");
        try {
            response = serviceCaller.futureGet("CommonController.getFeedback", helloRequest,ResponseVo.class).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
