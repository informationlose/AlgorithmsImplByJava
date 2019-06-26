package cn.AlgorithmsImpl.SortAlgorithms;

import cn.Algorithms.Tools.SortTemplate;

/**
 * 归并排序：将排序的数据不断划分，是一个典型的递归解决问题的办法。采用原地归并后可以使得算法所需空间减少
 * 优点：实现了低时间复杂度
 * 缺点：带来了比较大的空间消耗
 * 时间复杂度：O(NlogN)
 * 空间复杂度：O(N*N)
 */
public class MergeSort extends SortTemplate {
    //辅助空间变量
    private Comparable[] aux;

    public void sort(Comparable[] comparables) {
        //普通归并，需要消耗比较大的空间
//        Comparable[] result = merge(comparables, 0, comparables.length, comparables.length);
//        System.arraycopy(result, 0, comparables, 0, result.length);
        //原地归并,适配器隐藏参数的设定
        aux = new Comparable[comparables.length];
        sort(comparables, 0, comparables.length - 1);
    }

    //普通归并所用的函数
//    private Comparable[] merge(Comparable[] comparables, int begin, int end, int length) {
//        if (length == 1) return new Comparable[]{comparables[begin]};
//        int mid = begin + length / 2;
//        Comparable[] left = merge(comparables, begin, mid, length / 2);
//        Comparable[] right = merge(comparables, mid, end, length - length / 2);
//        Comparable[] result = new Comparable[length];
//        int a = 0, b = 0;
//        for (int i = 0; i < length; i++) {
//            if (b == right.length) {
//                result[i] = left[a];
//                a++;
//            } else if (a == left.length) {
//                result[i] = right[b];
//                b++;
//            } else if (less(left[a], right[b])) {
//                result[i] = left[a];
//                a++;
//            } else {
//                result[i] = right[b];
//                b++;
//            }
//        }
//        return result;
//    }

    //递归用函数，分组
    private void sort(Comparable[] comparables, int begin, int end) {
        if (begin >= end) return;
        int mid = begin + (end - begin) / 2;
        sort(comparables, begin, mid);
        sort(comparables, mid + 1, end);
        merge(comparables, begin, mid, end);
    }

    //    原地归并,单次使用
    private void merge(Comparable[] comparables, int begin, int mid, int end) {
        int i = begin;
        int j = mid + 1;
        if (end - begin >= 0) System.arraycopy(comparables, begin, aux, begin, end - begin + 1);
        for (int k = begin; k <= end; k++) {
            if (i > mid) comparables[k] = aux[j++];
            else if (j > end) comparables[k] = aux[i++];
            else if (less(aux[i], aux[j])) comparables[k] = aux[i++];
            else comparables[k] = aux[j++];
        }
    }
}