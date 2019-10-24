package com.example.research;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 14:39 2018/8/31
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Test extends A {
    Test(){
        System.out.println("counstructor B");
    }
    static {
        System.out.println("static block B");
    }
    {
        System.out.println("non static block B");
    }
    public static void main(String[] args) {
        /*Test t1 = new Test();
        System.out.println("main");
        Test t2 = new Test();*/
        //String s = "{\"exchange\":\"HKEX\",\"code\":\"06855\",\"name\":\"\",\"orderdate\":20191017,\"matchdate\":20191025,\"jkamt\":3454.46,\"hitqty\":0,\"qty\":100,\"cashqty\":100,\"financialqty\":0,\"apply_fee\":5,\"tradefee\":0,\"orderstatus\":\"2\",\"status\":\"1\",\"order_seq\":\"0000049947\",\"order_type\":0,\"exec_type\":1,\"loan_rate\":0,\"refund_amt\":0}"
        System.out.println(String.valueOf(System.currentTimeMillis()));

    }
}
class A{
    A(){
        System.out.println("counstructor A");
    }
    static {
        System.out.println("static block A");
    }
    {
        System.out.println("non static block A");
    }
}