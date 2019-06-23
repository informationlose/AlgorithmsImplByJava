package cn.AlgorithmsImpl.SortAlgorithms;

/**
 * 快速排序：使用数组实现，始终把最后一位放在数组中使得前面比他小，后面比他大。
 * 使用一个循环不断扩大大于他的区域，
 * 在循环中，如果出现了比他小的，则扩大一下比他小的区域并和当前的区域（比他大的区域的最外层）交换
 */
public class QuickSort {
    private static int[] array;
    private static int last;
    private static int before;
    private static int after;

    private static int partition(int[] Array, int begin, int end) {
        array = Array;
        before = begin - 1;
        after = begin;
        last = end;
//        出现错误的地方：在预定的前一个地方停止了循环，导致错误的交换
        for (; after <= last - 1; after++) {
            if (array[after] <= array[last]) {
                before++;
                int temp = array[before];
                array[before] = array[after];
                array[after] = temp;
            }
        }
        int temp = array[last];
        array[last] = array[before + 1];
        array[before + 1] = temp;
        return before + 1;
    }

    public static void sort(int[] Array, int begin, int end) {
        if (end > begin) {
            int temp = partition(Array, begin, end);
            sort(Array, begin, temp - 1);
            sort(Array, temp + 1, end);
        }
    }
}
