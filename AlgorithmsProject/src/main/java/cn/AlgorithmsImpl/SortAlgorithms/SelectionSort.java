package cn.AlgorithmsImpl.SortAlgorithms;

import cn.Algorithms.Tools.SortTemplate;

/**
 * 选择排序：每次把数据中最小的元素排在前端，每次排序缩小最小元素的搜寻集合
 * 优点：每次交换都是有效且最终的
 * 缺点：当排序的数据较多时，所需要的复杂度会平方增大，不适合大量数据的排序
 * 时间复杂度：O(N*N)
 * 空间需求：N
 */
public class SelectionSort extends SortTemplate {
    public void sort(Comparable[] comparables) {
        for (int i = 0; i < comparables.length; i++) {
            //第一次尝试递归，发现没什么用，也没用上递归
//            selection(comparables, i, comparables.length - 1);
            //这种类似于冒泡了，发生交换的次数太多了
//            for (int j = i; j < comparables.length - 1; j++) {
//                if(less(comparables[j], comparables[i]))exch(comparables, i, j);
//            }
            //这种是书上的排序方法，交换的次数比较少，且每次都是有效的最终交换
            int min = i;
            for (int j = i; j < comparables.length; j++) {
                if (less(comparables[j], comparables[min])) min = j;
            }
            exch(comparables, min, i);
        }
    }

//    private void selection(Comparable[] comparables, int begin, int end) {
//        Comparable min = comparables[begin];
//        for (int i = begin; i < end; i++) {
//            if (less(comparables[i], min)) {
//                exch(comparables, begin, i);
//            }
//        }
//    }
}
