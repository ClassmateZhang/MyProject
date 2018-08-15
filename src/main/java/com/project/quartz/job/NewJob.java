package com.project.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:29 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class NewJob implements BaseJob{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("New Job开始："+new Date());
    }
}
