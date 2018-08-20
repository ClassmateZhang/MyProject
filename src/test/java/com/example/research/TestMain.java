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
    //红包总数
    static int counts= 2000;
    static {
        keyChanceMap.put("aaa8.88", 1700);
        keyChanceMap.put("bbb18.88", 300);
    }

    public static void main(String[] args) {
        for (int i = 1; i <=10000 ; i++) {
            if(counts==0 || ((Integer)keyChanceMap.get("aaa8.88")==0 && (Integer)keyChanceMap.get("bbb18.88")==0)){
                System.out.println("所有红包发放完成！！！");
                break;
            }
            System.out.println("第"+i+"次发奖--》aaa8.88="+keyChanceMap.get("aaa8.88")+"--bbb18.88="+keyChanceMap.get("bbb18.88"));
            redPacket();
        }
    }
    public static void redPacket(){
        Long time = System.currentTimeMillis();
        Map<String, Integer> count = new HashMap<String, Integer>();
        List<String> list = new ArrayList<>();
        String item = null;
        for (int i = 0; i < counts; i++) {
            item = chanceSelect(keyChanceMap);
            //System.out.println("第"+(i+1)+"次选取为："+item);
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
        int num = rand.nextInt(counts);
        //数目-1
        Integer ladder = keyChanceMap.get(list.get(num));
        keyChanceMap.put(list.get(num),ladder--);
        counts--;
        System.out.println(num+"最终选择的随机数为："+list.get(num)+" 耗时："+(System.currentTimeMillis()-time));
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
            //System.out.println("rand="+rand+"--value="+entry.getValue()+"-->rand -= entry.getValue()="+(rand-entry.getValue()));
            rand -= entry.getValue();
            // 选中
            if (rand <= 0) {
                //System.out.println(entry.getValue()+"被选中"+rand);
                String item = entry.getKey();
                return item;
            }
        }
        return null;
    }
}
