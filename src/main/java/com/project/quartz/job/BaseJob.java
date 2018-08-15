package com.project.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:27 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public interface BaseJob extends Job{
    public void execute(JobExecutionContext context) throws JobExecutionException;
}
