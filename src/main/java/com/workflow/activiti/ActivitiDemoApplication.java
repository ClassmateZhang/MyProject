package com.workflow.activiti;

import com.project.quartz.QuartzApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:12 2018/9/29
 * @ Description：activiti6工作流活动启动类
 * @ Modified By：
 * @Version: 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.workflow.*"})
public class ActivitiDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class,args);
    }
}
