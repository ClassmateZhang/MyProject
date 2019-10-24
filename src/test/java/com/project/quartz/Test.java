package com.project.quartz;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 17:25 2018/9/26
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Test {
    public static void main(String[] args) {
        String phone = "15110218001";
        String phoneNumber = phone.replaceAll("(\\d{3})\\d{5}(\\d{3})","$1*****$2");
        System.out.println(phoneNumber+"----"+phone.substring(phone.length()-3));
        Map map = new HashMap();
        System.out.println(map.size());
        map.put("123","123");
        System.out.println(map.size());
        System.out.println(map.get("23"));
        System.out.println(map.get("123"));
    }
}
