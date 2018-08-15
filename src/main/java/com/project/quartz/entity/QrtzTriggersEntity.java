package com.project.quartz.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 15:05 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Entity
@Table(name = "qrtz_triggers", schema = "myproject", catalog = "")
@IdClass(QrtzTriggersEntityPK.class)
public class QrtzTriggersEntity {
    private String schedName;
    private String triggerName;
    private String triggerGroup;
    private String description;
    private Long nextFireTime;
    private Long prevFireTime;
    private Integer priority;
    private String triggerState;
    private String triggerType;
    private long startTime;
    private Long endTime;
    private String calendarName;
    private Short misfireInstr;
    private byte[] jobData;

    @Id
    @Column(name = "SCHED_NAME")
    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Id
    @Column(name = "TRIGGER_NAME")
    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    @Id
    @Column(name = "TRIGGER_GROUP")
    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
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
    @Column(name = "NEXT_FIRE_TIME")
    public Long getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Long nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    @Basic
    @Column(name = "PREV_FIRE_TIME")
    public Long getPrevFireTime() {
        return prevFireTime;
    }

    public void setPrevFireTime(Long prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    @Basic
    @Column(name = "PRIORITY")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "TRIGGER_STATE")
    public String getTriggerState() {
        return triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    @Basic
    @Column(name = "TRIGGER_TYPE")
    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    @Basic
    @Column(name = "START_TIME")
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "END_TIME")
    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "CALENDAR_NAME")
    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    @Basic
    @Column(name = "MISFIRE_INSTR")
    public Short getMisfireInstr() {
        return misfireInstr;
    }

    public void setMisfireInstr(Short misfireInstr) {
        this.misfireInstr = misfireInstr;
    }

    @Basic
    @Column(name = "JOB_DATA")
    public byte[] getJobData() {
        return jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzTriggersEntity that = (QrtzTriggersEntity) o;

        if (startTime != that.startTime) return false;
        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (triggerName != null ? !triggerName.equals(that.triggerName) : that.triggerName != null) return false;
        if (triggerGroup != null ? !triggerGroup.equals(that.triggerGroup) : that.triggerGroup != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (nextFireTime != null ? !nextFireTime.equals(that.nextFireTime) : that.nextFireTime != null) return false;
        if (prevFireTime != null ? !prevFireTime.equals(that.prevFireTime) : that.prevFireTime != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        if (triggerState != null ? !triggerState.equals(that.triggerState) : that.triggerState != null) return false;
        if (triggerType != null ? !triggerType.equals(that.triggerType) : that.triggerType != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (calendarName != null ? !calendarName.equals(that.calendarName) : that.calendarName != null) return false;
        if (misfireInstr != null ? !misfireInstr.equals(that.misfireInstr) : that.misfireInstr != null) return false;
        if (!Arrays.equals(jobData, that.jobData)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (triggerName != null ? triggerName.hashCode() : 0);
        result = 31 * result + (triggerGroup != null ? triggerGroup.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (nextFireTime != null ? nextFireTime.hashCode() : 0);
        result = 31 * result + (prevFireTime != null ? prevFireTime.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (triggerState != null ? triggerState.hashCode() : 0);
        result = 31 * result + (triggerType != null ? triggerType.hashCode() : 0);
        result = 31 * result + (int) (startTime ^ (startTime >>> 32));
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (calendarName != null ? calendarName.hashCode() : 0);
        result = 31 * result + (misfireInstr != null ? misfireInstr.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(jobData);
        return result;
    }
}
