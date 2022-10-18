package com.study.test;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

public class SpringJdbcTest04 extends BaseTest{

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testQueryCount(){
        //定义sql语句
        String sql="select count(1) from tb_jdbc";
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("总记录数："+total);
    }
}
