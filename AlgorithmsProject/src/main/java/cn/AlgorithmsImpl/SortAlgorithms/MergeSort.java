package cn.AlgorithmsImpl.SortAlgorithms;

import cn.Algorithms.Tools.SortTemplate;

/**
 * 归并排序：将排序的数据不断划分，是一个典型的递归解决问题的办法。
 * 优点：实现了低时间复杂度
 * 缺点：带来了比较大的空间消耗
 * 时间复杂度：O(NlogN)
 * 空间复杂度：O(N*N)
 */
public class MergeSort extends SortTemplate {
    public void sort(Comparable[] comparables) {
        //普通归并，需要消耗比较大的空间
        Comparable[] result = merge(comparables, 0, comparables.length, comparables.length);
        System.arraycopy(result, 0, comparables, 0, result.length);
    }

    private Comparable[] merge(Comparable[] comparables, int begin, int end, int length) {
        if (length == 1) return new Comparable[]{comparables[begin]};
        int mid = begin + length / 2;
        Comparable[] left = merge(comparables, begin, mid, length / 2);
        Comparable[] right = merge(comparables, mid, end, length - length / 2);
        Comparable[] result = new Comparable[length];
        int a = 0, b = 0;
        for (int i = 0; i < length; i++) {
            if (b == right.length) {
                result[i] = left[a];
                a++;
            } else if (a == left.length) {
                result[i] = right[b];
                b++;
            } else if (less(left[a], right[b])) {
                result[i] = left[a];
                a++;
            } else {
                result[i] = right[b];
                b++;
            }
        }
        return result;
    }
}