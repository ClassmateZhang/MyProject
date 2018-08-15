package com.project.quartz.entity;

import javax.persistence.*;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 15:04 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Entity
@Table(name = "qrtz_cron_triggers", schema = "myproject", catalog = "")
@IdClass(QrtzCronTriggersEntityPK.class)
public class QrtzCronTriggersEntity {
    private String schedName;
    private String triggerName;
    private String triggerGroup;
    private String cronExpression;
    private String timeZoneId;

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
    @Column(name = "CRON_EXPRESSION")
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Basic
    @Column(name = "TIME_ZONE_ID")
    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzCronTriggersEntity that = (QrtzCronTriggersEntity) o;

        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (triggerName != null ? !triggerName.equals(that.triggerName) : that.triggerName != null) return false;
        if (triggerGroup != null ? !triggerGroup.equals(that.triggerGroup) : that.triggerGroup != null) return false;
        if (cronExpression != null ? !cronExpression.equals(that.cronExpression) : that.cronExpression != null)
            return false;
        if (timeZoneId != null ? !timeZoneId.equals(that.timeZoneId) : that.timeZoneId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (triggerName != null ? triggerName.hashCode() : 0);
        result = 31 * result + (triggerGroup != null ? triggerGroup.hashCode() : 0);
        result = 31 * result + (cronExpression != null ? cronExpression.hashCode() : 0);
        result = 31 * result + (timeZoneId != null ? timeZoneId.hashCode() : 0);
        return result;
    }
}
