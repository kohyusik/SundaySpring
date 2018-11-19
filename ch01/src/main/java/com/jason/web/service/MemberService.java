package com.jason.web.service;

import com.jason.web.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public String getTime() {
        return memberMapper.getTime();
    }

    public String getTime2() {
        return memberMapper.getTime2();
    }
}
