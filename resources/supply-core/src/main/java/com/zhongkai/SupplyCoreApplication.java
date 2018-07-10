package com.zhongkai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: SupplyCoreApplication
 * @Description:
 * @date 2018/1/26
 * @Copyright © 2017北京数人科技有限公司
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.zhongkai")
@MapperScan("com.zhongkai.core.dao")
public class SupplyCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupplyCoreApplication.class, args);
    }

}
