package cn.AlgorithmsImpl.SortAlgorithms;

import cn.Algorithms.Tools.SortTemplate;

/**
 * 插入排序：把排序集合分成两组，一组存放排序好的，另一组是原始的，每次排序把原始的一张放在排序好的中。
 *      优点：语句少
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
        //书上的写法，少了一个循环。第二个循环是递减的，使得语句更为精简。
        for (int i = 1; i < comparables.length; i++) {
            for (int j = i; j > 0 && less(comparables[j], comparables[j - 1]); j--) {
                exch(comparables, j - 1, j);
            }
        }
    }
}
