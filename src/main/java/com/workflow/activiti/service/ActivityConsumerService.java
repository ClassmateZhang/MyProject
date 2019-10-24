package com.workflow.activiti.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:13 2018/9/29
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
/*@RestController
@RequestMapping("/test123")*/
public interface ActivityConsumerService {
    /**      * 流程demo      * @return      */
    //@RequestMapping(value="/activitiDemo",method= RequestMethod.GET)
    public boolean startActivityDemo();
}
