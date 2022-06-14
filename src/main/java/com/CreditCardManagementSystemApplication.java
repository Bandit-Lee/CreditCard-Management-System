package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bandit
 */
@SpringBootApplication
@MapperScan("com.sys.*.mapper")
public class CreditCardManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditCardManagementSystemApplication.class, args);
    }

}
