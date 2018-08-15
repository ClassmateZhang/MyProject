package com.project.quartz.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 15:05 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class QrtzSchedulerStateEntityPK implements Serializable {
    private String schedName;
    private String instanceName;

    @Column(name = "SCHED_NAME")
    @Id
    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Column(name = "INSTANCE_NAME")
    @Id
    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzSchedulerStateEntityPK that = (QrtzSchedulerStateEntityPK) o;

        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (instanceName != null ? !instanceName.equals(that.instanceName) : that.instanceName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (instanceName != null ? instanceName.hashCode() : 0);
        return result;
    }
}
