package com.zhaoqi.controller;

import javax.annotation.Resource;

import com.tts.component.cache.TTSCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tts.component.annotation.Json;
import com.zhaoqi.controller.common.model.ResponseVo;
import com.zhaoqi.restapi.HelloRequest;
import com.zhaoqi.services.IMemberService;

/**
 * Created by zhaoqi on 2016/5/5.
 */
@RequestMapping("/common")
@Controller
public class CommonController {

    @Resource
    private IMemberService memberService;

    @RequestMapping("/sayHi")
    @ResponseBody
    @TTSCache
    public ResponseVo getFeedback(@Json HelloRequest hello){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setMsg("success");
        responseVo.setData(hello.getHello());
        return responseVo;
    }

    @RequestMapping("/member/getById")
    @ResponseBody
    public ResponseVo getMemberById(@Json Integer id) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(memberService.getById(id));
        return  responseVo;
    }

}
