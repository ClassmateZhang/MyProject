package com.example.research;

import com.project.quartz.dao.JobAndTriggerDao;
import com.project.quartz.entity.QrtzJobDetailsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(basePackages = {"com.project"})
public class QuartzApplicationTests {
    @Autowired
    private JobAndTriggerDao jobAndTriggerDao;
    @Test
    public void test() throws Exception {
        QrtzJobDetailsEntity q = new QrtzJobDetailsEntity();
        q.setJobClassName("com.project.quartz.job.HelloJob");
        q.setJobGroup("group1");
        q.setDescription("0 0 2 * * ?");
        jobAndTriggerDao.save(q);
        System.out.println("存储完成");
    }
}
