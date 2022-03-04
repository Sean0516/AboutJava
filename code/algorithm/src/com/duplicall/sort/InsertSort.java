package com.duplicall.sort;

import com.duplicall.sort.common.SortUtils;

import java.util.Arrays;

/**
 * @Description InsertSort
 * @Author Sean
 * @Date 2022/3/4 11:16
 * @Version 1.0
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 - 1 做到有序
        // 0 - 2 位置有序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                SortUtils.swap(arr, j, j + 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, 33, 14, 2, 5, 6};
        InsertSort.insertSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
