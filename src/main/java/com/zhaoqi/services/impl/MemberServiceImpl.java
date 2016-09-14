package com.zhaoqi.services.impl;

import com.tts.component.datasource.Slave;
import com.zhaoqi.mapper.MemberMapper;
import com.zhaoqi.model.common.Member;
import com.zhaoqi.services.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhaoqi on 2016/5/9.
 */
@Service
public class MemberServiceImpl implements IMemberService {

    @Resource
    private MemberMapper memberMapper;

    @Autowired
    private EhCacheCacheManager cacheManager;

    private final String CACHE_KEY_HEROES = "heroes";

    @Override
    @Slave()
    public Member getById(int id) {
        Member member;
        Cache cache = cacheManager.getCache(CACHE_KEY_HEROES);
        if (null == cache.get(id, Member.class)) {
            member = memberMapper.getById(id);
            cache.put(id, member);
        } else {
            member = cache.get(id, Member.class);
        }
        return member;
    }
}
