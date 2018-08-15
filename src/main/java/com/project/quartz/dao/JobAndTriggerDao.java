package com.project.quartz.dao;

import com.project.quartz.entity.QrtzJobDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:47 2018/8/15
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public interface JobAndTriggerDao extends JpaRepository<QrtzJobDetailsEntity,Long> {
}
