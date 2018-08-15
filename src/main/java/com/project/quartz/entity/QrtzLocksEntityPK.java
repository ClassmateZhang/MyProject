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
public class QrtzLocksEntityPK implements Serializable {
    private String schedName;
    private String lockName;

    @Column(name = "SCHED_NAME")
    @Id
    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Column(name = "LOCK_NAME")
    @Id
    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzLocksEntityPK that = (QrtzLocksEntityPK) o;

        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (lockName != null ? !lockName.equals(that.lockName) : that.lockName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (lockName != null ? lockName.hashCode() : 0);
        return result;
    }
}
