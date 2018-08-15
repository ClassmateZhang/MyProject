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
@Table(name = "qrtz_paused_trigger_grps", schema = "myproject", catalog = "")
@IdClass(QrtzPausedTriggerGrpsEntityPK.class)
public class QrtzPausedTriggerGrpsEntity {
    private String schedName;
    private String triggerGroup;

    @Id
    @Column(name = "SCHED_NAME")
    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Id
    @Column(name = "TRIGGER_GROUP")
    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzPausedTriggerGrpsEntity that = (QrtzPausedTriggerGrpsEntity) o;

        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (triggerGroup != null ? !triggerGroup.equals(that.triggerGroup) : that.triggerGroup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (triggerGroup != null ? triggerGroup.hashCode() : 0);
        return result;
    }
}
