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
@Table(name = "qrtz_locks", schema = "myproject", catalog = "")
@IdClass(QrtzLocksEntityPK.class)
public class QrtzLocksEntity {
    private String schedName;
    private String lockName;

    @Id
    @Column(name = "SCHED_NAME")
    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Id
    @Column(name = "LOCK_NAME")
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

        QrtzLocksEntity that = (QrtzLocksEntity) o;

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
