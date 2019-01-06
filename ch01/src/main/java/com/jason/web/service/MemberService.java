package com.jason.web.service;

import com.jason.web.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.PostConstruct;

@Slf4j
@Service
public class MemberService {

    private MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @PostConstruct
    public void test() {
        log.info("Service created..");
    }

    public String getTime() {
        return memberMapper.getTime();
    }

    public String getTime2() {
        return memberMapper.getTime2();
    }

    public int removeAll() {
        return memberMapper.removeAll();
    }

    @Transactional
    public int insertUsers() {

        int result = 0;

        log.info("memberMapper.insertUser(2)");
        result += memberMapper.insertUser(2, 25, "koh");

        log.info("memberMapper.insertUser(3)");
        result += memberMapper.insertUser(3, 25, "jason");

        log.info("memberMapper.insertUser(1)");
        result += memberMapper.insertUser(1, 25, "1234567890123");

        return result;
    }
}
