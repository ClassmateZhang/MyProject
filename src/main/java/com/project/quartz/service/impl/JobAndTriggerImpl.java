package com.project.quartz.service.impl;

import com.project.quartz.dao.JobAndTriggerDao;
import com.github.pagehelper.PageInfo;
import com.project.quartz.entity.JobAndTrigger;
import com.project.quartz.service.IJobAndTriggerService;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:43 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Service
public class JobAndTriggerImpl implements IJobAndTriggerService {
    /*@Autowired
    private JobAndTriggerDao jobAndTriggerDao;*/
    @Autowired
    private EntityManager entityManager;

    @Override
    public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize) {
        //PageHelper.startPage(pageNum, pageSize);
         List<JobAndTrigger> list = new ArrayList<>();
        String sql = "select qrtz_job_details.JOB_NAME," +
                "  qrtz_job_details.JOB_GROUP," +
                "  qrtz_job_details.JOB_CLASS_NAME," +
                "  qrtz_triggers.TRIGGER_NAME," +
                "  qrtz_triggers.TRIGGER_GROUP," +
                "  qrtz_cron_triggers.CRON_EXPRESSION," +
                "  qrtz_cron_triggers.TIME_ZONE_ID from qrtz_job_details" +
                "  JOIN qrtz_triggers" +
                "  JOIN qrtz_cron_triggers ON qrtz_job_details.JOB_NAME = qrtz_triggers.JOB_NAME" +
                "  AND qrtz_triggers.TRIGGER_NAME = qrtz_cron_triggers.TRIGGER_NAME" +
                "  AND qrtz_triggers.TRIGGER_GROUP = qrtz_cron_triggers.TRIGGER_GROUP";
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List rows = query.getResultList();
        for (Object obj : rows) {
            Map row = (Map) obj;
            JobAndTrigger jobAndTrigger = new JobAndTrigger();
            jobAndTrigger.setCRON_EXPRESSION(row.get("CRON_EXPRESSION")+"");
            jobAndTrigger.setJOB_CLASS_NAME(row.get("JOB_CLASS_NAME")+"");
            jobAndTrigger.setJOB_GROUP(row.get("JOB_GROUP")+"");
            jobAndTrigger.setJOB_NAME(row.get("JOB_NAME")+"");
            jobAndTrigger.setTIME_ZONE_ID(row.get("TIME_ZONE_ID")+"");
            jobAndTrigger.setTRIGGER_GROUP(row.get("TRIGGER_GROUP")+"");
            jobAndTrigger.setTRIGGER_NAME(row.get("TRIGGER_NAME")+"");
            list.add(jobAndTrigger);
        }
        PageInfo<JobAndTrigger> page = new PageInfo<JobAndTrigger>(list);
        return page;
    }
}
