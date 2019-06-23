package cn.AlgorithmsImpl.Max_Heapify;

/**
 * 最大堆的实现：使用数组作为实现的载体
 * 注意，最大堆的性质只是父结点大于子节点而已！！在数组中不一定是从大到小的排列的！！！！
 * 如果想要从大到小或从小到大排序，只能不断的抽取首个元素，直到数组消失
 */
public class MaxHeapify {
    private static int[] space;
    private static int length;

    private static int left(int i) {
        return 2 * (i + 1) - 1;
    }

    private static int right(int i) {
        return 2 * (i + 1);
    }

    private static void checkMaxHeapify(int i) {
        int max = i;
        int l = left(i);
        int r = right(i);
        if (l < length && space[l] > space[i]) max = l;
        if (r < length && space[r] > space[max]) max = r;
        if (max != i) {
            int temp = space[max];
            space[max] = space[i];
            space[i] = temp;
            checkMaxHeapify(max);
        }
    }

    private static void buildMaxHeap(int[] array, int arrayLength) {
        space = array;
        length = arrayLength;
        for (int i = (int) Math.floor(length / 2); i >= 0; i--) {
            checkMaxHeapify(i);
        }
    }

    public static void heapSort(int[] maxHeapifyArray) {
        for (int i = maxHeapifyArray.length; i > 0; i--) {
            buildMaxHeap(maxHeapifyArray, i);
            int temp = maxHeapifyArray[0];
            maxHeapifyArray[0] = maxHeapifyArray[i - 1];
            maxHeapifyArray[i - 1] = temp;
        }
    }

    private int parent(int i) {
        return (int) Math.floor(i / 2);
    }
}
