package com.project.quartz.service;

import com.github.pagehelper.PageInfo;
import com.project.quartz.entity.QrtzJobDetailsEntity;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:42 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public interface IJobAndTriggerService {
    public PageInfo<QrtzJobDetailsEntity> getJobAndTriggerDetails(int pageNum, int pageSize);
}
