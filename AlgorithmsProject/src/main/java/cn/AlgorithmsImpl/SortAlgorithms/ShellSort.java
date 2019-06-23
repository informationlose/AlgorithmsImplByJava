package cn.AlgorithmsImpl.SortAlgorithms;

import cn.Algorithms.Tools.SortTemplate;

/**
 * 希尔排序：依靠间隔不同的有序数组，不断缩小间隔，达到性能的优化。其本质还是插入排序
 * 相比于插入排序，性能提升了很多，约为60%（以10000次1000个数据排序为例）
 */
public class ShellSort extends SortTemplate {
    public void sort(Comparable[] comparables) {
        int h = 1;
        //1，4，13，40，121，364，1093...
        while (h < comparables.length / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < comparables.length; i++) {
                for (int j = i; j >= h && less(comparables[j], comparables[j - h]); j -= h) {
                    exch(comparables, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
