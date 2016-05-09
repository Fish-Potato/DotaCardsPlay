package com.zhaoqi.services.impl;

import com.zhaoqi.mapper.MemberMapper;
import com.zhaoqi.model.common.Member;
import com.zhaoqi.services.IMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhaoqi on 2016/5/9.
 */
@Service
public class MemberServiceImpl implements IMemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public Member getById(int id) {
        return memberMapper.getById(id);
    }
}
