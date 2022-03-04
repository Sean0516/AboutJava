package com.duplicall.sort;

import com.duplicall.sort.common.SortUtils;

import java.util.Arrays;

/**
 * @Description BubbleSort
 * @Author Sean
 * @Date 2022/3/4 11:05
 * @Version 1.0
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
            System.out.println("-----------------------");
        }

    }

    public static void bubbleSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 33, 14, 2, 5, 6};
        BubbleSort.bubbleSort2(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
