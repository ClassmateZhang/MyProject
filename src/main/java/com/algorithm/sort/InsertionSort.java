package com.algorithm.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * 插入排序
 * @ Author     ：zhangcx
 * @ Date       ：Created in 14:30 2018/9/12
 * @ Description：
 * 1、从第一个元素开始，该元素可以认为已经被排序；
   2、取出下一个元素，在已经排序的元素序列中从后向前扫描；
   3、如果该元素（已排序）大于新元素，将该元素移到下一位置；
   4、重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
   5、将新元素插入到该位置后；
   6、重复步骤2~5。
 * @ Modified By：
 * @Version: $version$
 */
public class InsertionSort {
    private void sort(int[] ints){
        ToolUtil.show(ints);
        for (int i = 1; i <ints.length ; i++) {
            int number = ints[i+1]; //抽出的元素
            for (int j = i; j >=0; j--) {
                if(number>ints[j]){
                    ints[j]=ints[i];
                }
            }
        }
        ToolUtil.show(ints);
    }
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int number[] = {21,12,4,5,31,1,2};
        sort.sort(number);
        Map map = new HashMap();
    }
}
