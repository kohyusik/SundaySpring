package com.jason.sample.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({"foo", "bar"})
public class SampleDTO {

    private String name;
    private int age;

    private String foo;
    private String bar;
}
