package com.yc.springbootkhaomyblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yc.springbootkhaomyblog.mapper")
public class SpringbootKhaoMyblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKhaoMyblogApplication.class, args);
    }

}
