package com.study.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJdbcTest01 {

    @Test
    public void testJdbc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        // crud 操作
        // 定义sql语句
        String sql = "select count(1) from tb_jdbc";
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("总记录数：" + total);
        // 执行查询操作 （无参数）
    }

    @Test
    public void testJdbc02() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql = "select count(1) from tb_jdbc where user_id=?";
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class, 2);
        System.out.println("总记录数：" + total);

    }
}
