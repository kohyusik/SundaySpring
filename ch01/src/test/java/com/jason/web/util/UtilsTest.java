package com.jason.web.util;

import org.junit.Test;

/**
 * @author : yusik
 * @date : 24/11/2018
 */
public class UtilsTest {

    private SampleUtils utils = new SampleUtils();

    @Test
    public void test1() {
        utils.util1();
    }
    @Test
    public void test2() {
        utils.util1();
        utils.util2();
    }
}
