package com.example.research;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 */
@SpringBootApplication
//设置扫描包的位置
//@ComponentScan(basePackages = {"com.*","*"})
public class ResearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResearchApplication.class, args);
	}
}
