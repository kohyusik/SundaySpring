package com.jason.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;


@Slf4j
public class JdbcTest {

    @Test
    public void logTest() {
        String test = "test";
        log.debug(test);

        assertEquals("test", test);

    }

    @Test
    public void jdbcConnectTest() {
        try {

            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }

        try (Connection con = DriverManager.getConnection(

                "jdbc:mariadb://ec2-13-125-38-65.ap-northeast-2.compute.amazonaws.com:3306/web",
                "jason", "qwe123")) {

            log.info(con.toString());

            PreparedStatement pstmt = con.prepareStatement("show tables");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                log.debug(rs.getString(1));
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
