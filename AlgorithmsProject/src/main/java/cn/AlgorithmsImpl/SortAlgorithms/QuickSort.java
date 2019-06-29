package cn.AlgorithmsImpl.SortAlgorithms;

import cn.Algorithms.Tools.SortTemplate;

import java.util.Random;

/**
 * 快速排序：使用数组实现，始终把最后一位放在数组中使得前面比他小，后面比他大。
 * 使用一个循环不断扩大大于他的区域，
 * 在循环中，如果出现了比他小的，则扩大一下比他小的区域并和当前的区域（比他大的区域的最外层）交换
 * 1.39NlogN
 * 三项切分的快速排序可以针对有大量的重复值出现的数组排序：
 * 三项切分直接把递归的选项跨过了相同的数据，减少了不必要的交换
 */
public class QuickSort extends SortTemplate {
    @Override
    public void sort(Comparable[] comparables) {
        Random random = new Random();
        int i = random.nextInt(comparables.length - 1);
        exch(comparables, 0, i);
        sort(comparables, 0, comparables.length - 1);
    }

    private void sort(Comparable[] comparables, int begin, int end) {
        if (begin >= end) return;
        int j = partition(comparables, begin, end);
        sort(comparables, begin, j - 1);
        sort(comparables, j + 1, end);
    }

    //此处是双向交换，找出一个小于和一个大于第一个数的相交换
    private int partition(Comparable[] comparables, int begin, int end) {
        int i = begin, j = end + 1;
        while (true) {
            while (less(comparables[++i], comparables[begin])) if (i == end) break;
            while (less(comparables[begin], comparables[--j])) if (j == begin) break;
            if (i >= j) break;
            exch(comparables, i, j);
        }
        exch(comparables, begin, j);
        return j;
    }

    //以前的实现
//    private static int[] array;
//    private static int last;
//    private static int before;
//    private static int after;
//
//    private static int partition(int[] Array, int begin, int end) {
//        array = Array;
//        before = begin - 1;
//        after = begin;
//        last = end;
////        出现错误的地方：在预定的前一个地方停止了循环，导致错误的交换
//        for (; after <= last - 1; after++) {
//            if (array[after] <= array[last]) {
//                before++;
//                int temp = array[before];
//                array[before] = array[after];
//                array[after] = temp;
//            }
//        }
//        int temp = array[last];
//        array[last] = array[before + 1];
//        array[before + 1] = temp;
//        return before + 1;
//    }
//
//    public static void sort(int[] Array, int begin, int end) {
//        if (end > begin) {
//            int temp = partition(Array, begin, end);
//            sort(Array, begin, temp - 1);
//            sort(Array, temp + 1, end);
//        }
//    }
    //找出数据中排序好的第K个元素
    public Comparable select(Comparable[] comparables, int k) {
        Random random = new Random();
        int i = random.nextInt(comparables.length - 1);
        exch(comparables, 0, i);
        int begin = 0, end = comparables.length - 1, j;
        while (begin <= end) {
            j = partition(comparables, begin, end);
            if (j == k) return comparables[k];
            else if (j > k) end = j - 1;
            else begin = j + 1;
        }
        return comparables[k];
    }
}
