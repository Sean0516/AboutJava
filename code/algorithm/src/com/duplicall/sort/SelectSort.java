package com.duplicall.sort;

import com.duplicall.sort.common.SortUtils;

import java.util.Arrays;

/**
 * @Description SelectSort
 * @Author Sean
 * @Date 2022/3/4 10:51
 * @Version 1.0
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ N-1
        // 1 ~ N-1
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 最小值在 i ~ N-1 的那个位置
            for (int j = i + 1; j < arr.length; j++) {
                // 在i ~ N-1 上找到最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (i == minIndex) {
                return;
            }
            SortUtils.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 6};

        SelectSort.selectSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
