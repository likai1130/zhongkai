package com.zhongkai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: SupplyManageApplication
 * @Description: 项目启动类
 * @date 2018/1/9
 * @Copyright © 2017北京数人科技有限公司
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.zhongkai")
public class SupplyManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupplyManageApplication.class, args);
    }
}
