package com.algorithm.sort;

/**
 * 选择排序
 * @ Author     ：zhangcx
 * @ Date       ：Created in 11:38 2018/9/12
 * @ Description：1 初始状态：无序区为R[1..n]，有序区为空；
                  2 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
                  3 n-1趟结束，数组有序化了。
 * @ Modified By：
 * @Version: $version$
 */
public class SelectionSort {
    private void show(int[] ints){
        for (int i = 0; i <ints.length ; i++) {
            System.out.print(ints[i]+" ");
        }
        System.out.println();
    }
    private void sort(int[] ints){
        show(ints);
        for (int i = 0; i <ints.length-1 ; i++) {
            int min = i; //存储最小值索引位置
            for (int j = i+1; j <ints.length ; j++) {
                if (ints[min]>ints[j]){ //寻找最小值
                    min = j;
                }
            }
            int tmp = ints[i];
            ints[i]=ints[min];
            ints[min]=tmp;
        }
        show(ints);
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int number[] = {21,12,4,5,31,1,2};
        sort.sort(number);
    }
}
