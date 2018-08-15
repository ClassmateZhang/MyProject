package com.project.quartz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.quartz.dao.JobAndTriggerDao;
import com.project.quartz.entity.JobAndTrigger;
import com.project.quartz.entity.QrtzJobDetails;
import com.project.quartz.service.IJobAndTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:43 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Service
public class JobAndTriggerImpl implements IJobAndTriggerService {
    @Autowired
    private JobAndTriggerDao jobAndTriggerDao;
    @Override
    public PageInfo<QrtzJobDetails> getJobAndTriggerDetails(int pageNum, int pageSize) {
        //PageHelper.startPage(pageNum, pageSize);
        List<QrtzJobDetails> list = jobAndTriggerDao.findAll();
        PageInfo<QrtzJobDetails> page = new PageInfo<QrtzJobDetails>(list);
        return page;
    }
}
