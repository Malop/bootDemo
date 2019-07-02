package com.mwp.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

//等价于使用@Configuration @EnableAutoConfiguration @ComponentScan三者
@SpringBootApplication(scanBasePackages = "com.mwp.demo")
@ImportResource("classpath:applicationContext.xml")
@MapperScan("com.mwp.demo.mapper")
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class,args);
    }
}
