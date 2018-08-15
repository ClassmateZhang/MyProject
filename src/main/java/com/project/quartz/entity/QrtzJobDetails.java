package com.project.quartz.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 13:44 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Entity
@Table(name = "qrtz_job_details",schema = "myproject")
public class QrtzJobDetails {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "SCHED_NAME",nullable = false, unique = true)
    private String schedName;
    @Column(name = "JOB_NAME",nullable = false)
    private String jobName;
    @Column(name = "JOB_GROUP",nullable = false, unique = true)
    private String jobGroup;
    @Column(name = "DESCRIPTION",nullable = true, unique = true)
    private String description;
    @Column(name = "JOB_CLASS_NAME",nullable = false)
    private String jobClassName;
    @Column(name = "IS_DURABLE",nullable = false)
    private String isDurable;
    @Column(name = "IS_NONCONCURRENT",nullable = false)
    private String isNonconcurrent;
    @Column(name = "IS_UPDATE_DATA",nullable = false)
    private String isUpdateData;
    @Column(name = "REQUESTS_RECOVERY",nullable = false)
    private String requestsRecovery;
    @Column(name = "JOB_DATA",nullable = false)
    private Date jobData;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getIsDurable() {
        return isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
    }

    public String getIsNonconcurrent() {
        return isNonconcurrent;
    }

    public void setIsNonconcurrent(String isNonconcurrent) {
        this.isNonconcurrent = isNonconcurrent;
    }

    public String getIsUpdateData() {
        return isUpdateData;
    }

    public void setIsUpdateData(String isUpdateData) {
        this.isUpdateData = isUpdateData;
    }

    public String getRequestsRecovery() {
        return requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }

    public Date getJobData() {
        return jobData;
    }

    public void setJobData(Date jobData) {
        this.jobData = jobData;
    }

    public QrtzJobDetails(String schedName, String jobName, String jobGroup, String description, String jobClassName, String isDurable, String isNonconcurrent, String isUpdateData, String requestsRecovery, Date jobData) {
        this.schedName = schedName;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.description = description;
        this.jobClassName = jobClassName;
        this.isDurable = isDurable;
        this.isNonconcurrent = isNonconcurrent;
        this.isUpdateData = isUpdateData;
        this.requestsRecovery = requestsRecovery;
        this.jobData = jobData;
    }
}
