package com.jason.sample.service;

import com.jason.sample.aop.ConvertTarget;
import com.jason.sample.domain.SampleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : yusik
 * @date : 24/11/2018
 */

@Slf4j
@Service
public class SampleService {

    @ConvertTarget
    public Integer doAdd(String str1, String str2) {
        log.info("+++++++++++++++++ SampleService.doAdd : {} + {}", str1, str2);
        return Integer.parseInt(str1) + Integer.parseInt(str2);
    }

    public SampleDTO findAll() {

        SampleDTO dto = new SampleDTO();
        dto.setName("my name");
        dto.setAge(22);

        return dto;
    }
}
