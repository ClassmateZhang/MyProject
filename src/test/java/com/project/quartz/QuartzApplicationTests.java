package com.project.quartz;

import com.project.quartz.service.IJobAndTriggerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 17:15 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@ComponentScan(basePackages = {"com.project"})
public class QuartzApplicationTests {
    @Autowired
    private IJobAndTriggerService iJobAndTriggerService;
    @Test
    public void test() throws Exception {
        iJobAndTriggerService.getJobAndTriggerDetails(1,5);
        System.out.println("运行完成");
    }
}
