package cn.AlgorithmsImpl.SortAlgorithms;

import cn.Algorithms.Tools.SortTemplate;

/**
 * 插入排序：把排序集合分成两组，一组存放排序好的，另一组是原始的，每次排序把原始的一张放在排序好的中。
 */
public class InsertSort extends SortTemplate {
    public void sort(Comparable[] comparables) {
        //三重循环，有点吓人
//        for (int i = 0; i < comparables.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if(less(comparables[i], comparables[j])){
//                    for (int k = j; k < i; k++) {
//                        exch(comparables, k, i);
//                    }
//                }
//            }
//        }
    }
}
