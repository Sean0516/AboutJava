package com.duplicall.sort.common;

import java.util.Arrays;

/**
 * @Description SortUtils
 * @Author Sean
 * @Date 2022/3/4 10:51
 * @Version 1.0
 */
public class SortUtils {
    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println("数据交换" + i + " to " + j);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((int) ((maxValue + 1) * Math.random()) - maxValue * Math.random());
        }
        return arr;
    }
}
