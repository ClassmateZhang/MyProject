package com.project.quartz.dao;

import com.example.research.pojo.User;
import com.project.quartz.entity.JobAndTrigger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:47 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public interface JobAndTriggerDao{
    @Query(value = "select tqrtz_job_details.JOB_NAME," +
            "tqrtz_job_details.JOB_GROUP," +
            "tqrtz_job_details.JOB_CLASS_NAME," +
            "tqrtz_triggers.TRIGGER_NAME," +
            "tqrtz_triggers.TRIGGER_GROUP," +
            "tqrtz_cron_triggers.CRON_EXPRESSION," +
            "tqrtz_cron_triggers.TIME_ZONE_ID from tqrtz_job_details" +
            " JOIN qrtz_triggers" +
            " JOIN qrtz_cron_triggers ON qrtz_job_details.JOB_NAME = qrtz_triggers.JOB_NAME" +
            " AND qrtz_triggers.TRIGGER_NAME = qrtz_cron_triggers.TRIGGER_NAME" +
            " AND qrtz_triggers.TRIGGER_GROUP = qrtz_cron_triggers.TRIGGER_GROUP",nativeQuery = true)
    public List<Object> getAllJobAndTrigger();
}
