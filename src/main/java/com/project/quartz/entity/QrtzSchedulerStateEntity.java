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
@Table(name = "qrtz_scheduler_state", schema = "myproject", catalog = "")
@IdClass(QrtzSchedulerStateEntityPK.class)
public class QrtzSchedulerStateEntity {
    private String schedName;
    private String instanceName;
    private long lastCheckinTime;
    private long checkinInterval;

    @Id
    @Column(name = "SCHED_NAME")
    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Id
    @Column(name = "INSTANCE_NAME")
    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @Basic
    @Column(name = "LAST_CHECKIN_TIME")
    public long getLastCheckinTime() {
        return lastCheckinTime;
    }

    public void setLastCheckinTime(long lastCheckinTime) {
        this.lastCheckinTime = lastCheckinTime;
    }

    @Basic
    @Column(name = "CHECKIN_INTERVAL")
    public long getCheckinInterval() {
        return checkinInterval;
    }

    public void setCheckinInterval(long checkinInterval) {
        this.checkinInterval = checkinInterval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzSchedulerStateEntity that = (QrtzSchedulerStateEntity) o;

        if (lastCheckinTime != that.lastCheckinTime) return false;
        if (checkinInterval != that.checkinInterval) return false;
        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (instanceName != null ? !instanceName.equals(that.instanceName) : that.instanceName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (instanceName != null ? instanceName.hashCode() : 0);
        result = 31 * result + (int) (lastCheckinTime ^ (lastCheckinTime >>> 32));
        result = 31 * result + (int) (checkinInterval ^ (checkinInterval >>> 32));
        return result;
    }
}
