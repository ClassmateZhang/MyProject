package com.project.quartz.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 15:04 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Entity
@Table(name = "qrtz_blob_triggers", schema = "myproject", catalog = "")
@IdClass(QrtzBlobTriggersEntityPK.class)
public class QrtzBlobTriggersEntity {
    private String schedName;
    private String triggerName;
    private String triggerGroup;
    private byte[] blobData;

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
    @Column(name = "BLOB_DATA")
    public byte[] getBlobData() {
        return blobData;
    }

    public void setBlobData(byte[] blobData) {
        this.blobData = blobData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzBlobTriggersEntity that = (QrtzBlobTriggersEntity) o;

        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (triggerName != null ? !triggerName.equals(that.triggerName) : that.triggerName != null) return false;
        if (triggerGroup != null ? !triggerGroup.equals(that.triggerGroup) : that.triggerGroup != null) return false;
        if (!Arrays.equals(blobData, that.blobData)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (triggerName != null ? triggerName.hashCode() : 0);
        result = 31 * result + (triggerGroup != null ? triggerGroup.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(blobData);
        return result;
    }
}
