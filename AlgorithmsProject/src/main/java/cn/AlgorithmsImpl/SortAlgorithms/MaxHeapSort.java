package cn.AlgorithmsImpl.SortAlgorithms;

import cn.Algorithms.Tools.SortTemplate;

public class MaxHeapSort extends SortTemplate {
    //采用最大堆结构进行排序
//    MaxHeapify maxHeapify;
//    @Override
//    public void sort(Comparable[] comparables) {
//        maxHeapify = new MaxHeapify(comparables.length);
//        for (Comparable comparable : comparables) {
//            maxHeapify.insert(comparable);
//        }
//        for (int i = 0; i < comparables.length ; i++) {
//            comparables[i] = maxHeapify.deleteMax();
//        }
//    }
    public void sort(Comparable[] comparables) {
        //取巧，设置一个哨兵以帮助解决第一个元素不参与排序的问题
        int min = 0;
        int N = comparables.length - 1;
        for (int i = 1; i <= N; i++) {
            if (less(comparables[i], comparables[min])) exch(comparables, min, i);
        }
        for (int i = N / 2; i >= 1; i--) {
            sink(comparables, i, N);
        }
        while (N > 1) {
            exch(comparables, 1, N--);
            sink(comparables, 1, N);
        }
    }

    private void sink(Comparable[] comparables, int i, int n) {
        while (i <= n / 2) {
            int maxNode = 2 * i;
            if (maxNode < n) maxNode = less(comparables[i * 2], comparables[i * 2 + 1]) ? i * 2 + 1 : i * 2;
            if (less(comparables[i], comparables[maxNode])) {
                exch(comparables, i, maxNode);
            }
            i = maxNode;
        }
    }
}
