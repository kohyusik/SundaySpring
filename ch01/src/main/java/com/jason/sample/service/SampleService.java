package com.jason.sample.service;

import com.jason.sample.domain.SampleDTO;
import org.springframework.stereotype.Service;

/**
 * @author : yusik
 * @date : 24/11/2018
 */

@Service
public class SampleService {

    public SampleDTO findAll() {
        SampleDTO dto = new SampleDTO();
        dto.setName("my name");
        dto.setAge(22);

//        String testNull = null;
//        testNull.hashCode();

        return dto;
    }
}
