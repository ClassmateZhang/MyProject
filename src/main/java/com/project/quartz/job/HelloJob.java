package com.project.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:28 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class HelloJob implements BaseJob{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello Job执行时间: " + new Date());
    }
}
