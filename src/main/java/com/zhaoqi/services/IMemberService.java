package com.zhaoqi.services;

import com.tts.component.datasource.Slave;
import com.zhaoqi.model.common.Member;

/**
 * Created by zhaoqi on 2016/5/9.
 */
public interface IMemberService {
    @Slave()
    public Member getById(int id);
}
