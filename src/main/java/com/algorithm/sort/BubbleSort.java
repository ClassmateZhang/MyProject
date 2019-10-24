package com.algorithm.sort;

/**
 * 冒泡排序算法
 * @ Author     ：zhangcx
 * @ Date       ：Created in 9:51 2018/9/12
 * @ Description： 1 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 *                 2 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 *                 3 针对所有的元素重复以上的步骤，除了最后一个；
 *                 4 重复步骤1~3，直到排序完成。
 * @ Modified By：
 * @Version: $version$
 */
public class BubbleSort {
    private void sort(int[] numbers){
        show(numbers);
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = 0; j < numbers.length-1-i; j++) {
                if(numbers[j]>numbers[j+1]){
                    int tmp=numbers[j+1]; //临时变量
                    numbers[j+1]=numbers[j];
                    numbers[j]=tmp;
                }
                System.out.print("第"+(i+1)+"-"+(j+1)+"次比较:（"+numbers[j+1]+"-"+numbers[j]+")");
                show(numbers);
            }
            System.out.print("第"+(i+1)+"次比较结果:");
            show(numbers);
        }
        show(numbers);
    }
    private void show(int[] ints){
        for (int i = 0; i <ints.length ; i++) {
            System.out.print(ints[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int number[] = {21,12,4,5,31,1,2};
        sort.sort(number);
    }
}
