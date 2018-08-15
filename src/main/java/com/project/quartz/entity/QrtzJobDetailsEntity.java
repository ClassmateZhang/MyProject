package com.project.quartz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 15:04 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Entity
@Table(name = "qrtz_job_details", schema = "myproject", catalog = "")
@IdClass(QrtzJobDetailsEntityPK.class)
public class QrtzJobDetailsEntity implements Serializable{
    private String schedName;
    private String jobName;
    private String jobGroup;
    private String description;
    private String jobClassName;
    private String isDurable;
    private String isNonconcurrent;
    private String isUpdateData;
    private String requestsRecovery;
    private byte[] jobData;
    private long id;

    @Id
    @Column(name = "SCHED_NAME")
    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Id
    @Column(name = "JOB_NAME")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Id
    @Column(name = "JOB_GROUP")
    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "JOB_CLASS_NAME")
    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    @Basic
    @Column(name = "IS_DURABLE")
    public String getIsDurable() {
        return isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
    }

    @Basic
    @Column(name = "IS_NONCONCURRENT")
    public String getIsNonconcurrent() {
        return isNonconcurrent;
    }

    public void setIsNonconcurrent(String isNonconcurrent) {
        this.isNonconcurrent = isNonconcurrent;
    }

    @Basic
    @Column(name = "IS_UPDATE_DATA")
    public String getIsUpdateData() {
        return isUpdateData;
    }

    public void setIsUpdateData(String isUpdateData) {
        this.isUpdateData = isUpdateData;
    }

    @Basic
    @Column(name = "REQUESTS_RECOVERY")
    public String getRequestsRecovery() {
        return requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }

    @Basic
    @Column(name = "JOB_DATA")
    public byte[] getJobData() {
        return jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }

    @Basic
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzJobDetailsEntity that = (QrtzJobDetailsEntity) o;

        if (id != that.id) return false;
        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (jobName != null ? !jobName.equals(that.jobName) : that.jobName != null) return false;
        if (jobGroup != null ? !jobGroup.equals(that.jobGroup) : that.jobGroup != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (jobClassName != null ? !jobClassName.equals(that.jobClassName) : that.jobClassName != null) return false;
        if (isDurable != null ? !isDurable.equals(that.isDurable) : that.isDurable != null) return false;
        if (isNonconcurrent != null ? !isNonconcurrent.equals(that.isNonconcurrent) : that.isNonconcurrent != null)
            return false;
        if (isUpdateData != null ? !isUpdateData.equals(that.isUpdateData) : that.isUpdateData != null) return false;
        if (requestsRecovery != null ? !requestsRecovery.equals(that.requestsRecovery) : that.requestsRecovery != null)
            return false;
        if (!Arrays.equals(jobData, that.jobData)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        result = 31 * result + (jobGroup != null ? jobGroup.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (jobClassName != null ? jobClassName.hashCode() : 0);
        result = 31 * result + (isDurable != null ? isDurable.hashCode() : 0);
        result = 31 * result + (isNonconcurrent != null ? isNonconcurrent.hashCode() : 0);
        result = 31 * result + (isUpdateData != null ? isUpdateData.hashCode() : 0);
        result = 31 * result + (requestsRecovery != null ? requestsRecovery.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(jobData);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
