package cn.AlgorithmsImpl.SortAlgorithms;

import cn.Algorithms.Tools.SortTemplate;

/**
 * 插入排序：把排序集合分成两组，一组存放排序好的，另一组是原始的，每次排序把原始的一张放在排序好的中。
 *      优点：语句少，可以自动识别出已经排序好了的数组，降低无效输出。对于部分有序数组十分合适，也很适合小规模数组
 *      缺点：每次插入都需要移动多个元素才能成功。
 *      时间复杂度：O(N*N)
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
//        for (int i = 1; i < comparables.length; i++) {
//            for (int j = i; j > 0 && less(comparables[j], comparables[j - 1]); j--) {
//                exch(comparables, j - 1, j);
//            }
//        }
        //改进交换的方法，使得大元素向后移动，而不是交换
        for (int i = 1; i < comparables.length; i++) {
            Comparable temp = comparables[i];
            int index = 0;
            for (int j = i; j > 0; j--) {
                if (less(temp, comparables[j - 1])) {
                    comparables[j] = comparables[j - 1];
                    if ((j - 1) == 0) comparables[0] = temp;
                } else {
                    comparables[j] = temp;
                    break;
                }
            }
        }
    }
}
