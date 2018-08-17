package com.example.research;

import java.util.*;

/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 9:27 2018/8/1
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class TestMain {
    // String 可以为任意类型 也可以自定义类型
    static Map<String, Integer> keyChanceMap = new HashMap<String, Integer>();
    static {
        keyChanceMap.put("aaa", 500);
        keyChanceMap.put("bbb", 1500);
        keyChanceMap.put("ccc", 2000);
        keyChanceMap.put("ddd", 3000);
        keyChanceMap.put("eee", 3000);
    }

    public static void main(String[] args) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        List<String> list = new ArrayList<>();
        String item = null;
        for (int i = 0; i < 10000; i++) {
            item = chanceSelect(keyChanceMap);
            System.out.println("第"+(i+1)+"次选取为："+item);
            list.add(item);

            if (count.containsKey(item)) {
                count.put(item, count.get(item) + 1);
            } else {
                count.put(item, 1);
            }
        }
        for (String id : count.keySet()) {
            System.out.println(id + "\t出现了 " + count.get(id) + " 次");
        }
        Random rand = new Random();
        int num = rand.nextInt(10000);
        System.out.print(num+"最终选择的随机数为："+list.get(num));
    }
    public static String chanceSelect(Map<String, Integer> keyChanceMap) {
        if (keyChanceMap == null || keyChanceMap.size() == 0)
            return null;
        //总数量
        Integer sum = 0;
        for (Integer value : keyChanceMap.values()) {
            sum += value;
        }
        // 从1开始
        Integer rand = new Random().nextInt(sum) + 1;
        for (Map.Entry<String, Integer> entry : keyChanceMap.entrySet()) {
            System.out.println("rand="+rand+"--value="+entry.getValue()+"-->rand -= entry.getValue()="+(rand-entry.getValue()));
            rand -= entry.getValue();
            // 选中
            if (rand <= 0) {
                System.out.println(entry.getValue()+"被选中"+rand);
                String item = entry.getKey();
                return item;
            }
        }
        return null;
    }
}
