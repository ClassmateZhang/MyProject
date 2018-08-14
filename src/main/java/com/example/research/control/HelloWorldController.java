package com.example.research.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 14:46 2018/8/14
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World and SpringBoot";
    }
}
