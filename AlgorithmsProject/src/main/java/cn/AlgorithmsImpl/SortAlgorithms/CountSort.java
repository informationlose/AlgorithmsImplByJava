package cn.AlgorithmsImpl.SortAlgorithms;

/**
 * 计数排序
 * 本实现只针对数组形式进行排序
 * 原理：
 * 计算好每一个元素在数组中应该在的位置，直接定位好后排序
 * 优点：
 * 移动数据的次数较少
 * 最终排序可以实现一次移动就到最终位置
 * 缺点：
 * 排序所需要的空间较大
 * 需要自己确定最大数且只支持正数
 * 对于数据较大的排序较麻烦
 * 输入：
 * 待排序数组A[]，数组内最大数
 * 输出：
 * 排序好的数组B[]
 */

public class CountSort {
    private static int[] inArray;
    private static int[] tempArray;
    private static int[] outArray;

    public static int[] querySort(int[] inputArray, int max) {
        inArray = inputArray;
        tempArray = new int[max];
        outArray = inputArray;
        for (int i = 0; i < inArray.length; i++) {
            tempArray[inArray[i]]++;
        }
        for (int i = 1; i < tempArray.length; i++) {
            tempArray[i] = tempArray[i - 1] + tempArray[i];
        }
        for (int i = outArray.length - 1; i > 0; i--) {
            outArray[tempArray[inArray[i]]] = inArray[i];
            tempArray[inputArray[i]]--;
        }
        return outArray;
    }
}
