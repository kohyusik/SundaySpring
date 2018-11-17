package com.jason.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;

@Slf4j
public class DataSourceTest {

    @Test
    public void logTest() {
        String test = "test";
        log.debug(test);

        assertEquals("test", test);

    }
}
