package com.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sys.*.mapper")
public class CreditCardManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditCardManagementSystemApplication.class, args);
    }

}
