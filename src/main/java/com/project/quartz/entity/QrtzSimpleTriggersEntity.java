package com.project.quartz.entity;

import javax.persistence.*;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 15:05 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Entity
@Table(name = "qrtz_simple_triggers", schema = "myproject", catalog = "")
@IdClass(QrtzSimpleTriggersEntityPK.class)
public class QrtzSimpleTriggersEntity {
    private String schedName;
    private String triggerName;
    private String triggerGroup;
    private long repeatCount;
    private long repeatInterval;
    private long timesTriggered;

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
    @Column(name = "REPEAT_COUNT")
    public long getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(long repeatCount) {
        this.repeatCount = repeatCount;
    }

    @Basic
    @Column(name = "REPEAT_INTERVAL")
    public long getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    @Basic
    @Column(name = "TIMES_TRIGGERED")
    public long getTimesTriggered() {
        return timesTriggered;
    }

    public void setTimesTriggered(long timesTriggered) {
        this.timesTriggered = timesTriggered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzSimpleTriggersEntity that = (QrtzSimpleTriggersEntity) o;

        if (repeatCount != that.repeatCount) return false;
        if (repeatInterval != that.repeatInterval) return false;
        if (timesTriggered != that.timesTriggered) return false;
        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (triggerName != null ? !triggerName.equals(that.triggerName) : that.triggerName != null) return false;
        if (triggerGroup != null ? !triggerGroup.equals(that.triggerGroup) : that.triggerGroup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (triggerName != null ? triggerName.hashCode() : 0);
        result = 31 * result + (triggerGroup != null ? triggerGroup.hashCode() : 0);
        result = 31 * result + (int) (repeatCount ^ (repeatCount >>> 32));
        result = 31 * result + (int) (repeatInterval ^ (repeatInterval >>> 32));
        result = 31 * result + (int) (timesTriggered ^ (timesTriggered >>> 32));
        return result;
    }
}
