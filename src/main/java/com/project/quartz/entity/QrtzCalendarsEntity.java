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
@Table(name = "qrtz_calendars", schema = "myproject", catalog = "")
@IdClass(QrtzCalendarsEntityPK.class)
public class QrtzCalendarsEntity {
    private String schedName;
    private String calendarName;
    private byte[] calendar;

    @Id
    @Column(name = "SCHED_NAME")
    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Id
    @Column(name = "CALENDAR_NAME")
    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    @Basic
    @Column(name = "CALENDAR")
    public byte[] getCalendar() {
        return calendar;
    }

    public void setCalendar(byte[] calendar) {
        this.calendar = calendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QrtzCalendarsEntity that = (QrtzCalendarsEntity) o;

        if (schedName != null ? !schedName.equals(that.schedName) : that.schedName != null) return false;
        if (calendarName != null ? !calendarName.equals(that.calendarName) : that.calendarName != null) return false;
        if (!Arrays.equals(calendar, that.calendar)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = schedName != null ? schedName.hashCode() : 0;
        result = 31 * result + (calendarName != null ? calendarName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(calendar);
        return result;
    }
}
