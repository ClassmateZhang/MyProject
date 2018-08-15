package com.project.quartz.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 15:04 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class QrtzCalendarsEntityPK implements Serializable {
    private String schedName;
    private String calendarName;

    @Column(name = "SCHED_NAME")
    @Id
    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Column(name = "CALENDAR_NAME")
    @Id
    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzCalendarsEntityPK that = (QrtzCalendarsEntityPK) o;

        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (calendarName != null ? !calendarName.equals(that.calendarName) : that.calendarName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (calendarName != null ? calendarName.hashCode() : 0);
        return result;
    }
}
