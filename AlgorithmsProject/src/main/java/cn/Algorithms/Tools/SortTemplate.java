package cn.Algorithms.Tools;

/**
 * 此类是排序所用到的模板类，排序的实现基于Comparable接口
 * 排序均为从小到大的顺序，如果需要从大到小的顺序，可以更改less的实现
 */
public abstract class SortTemplate {
    public abstract void sort(Comparable[] comparables);

    //比较a是否小于b，需要实现Comparable接口
    protected boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    //交换数据
    protected void exch(Comparable[] comparables, int a, int b) {
        Comparable t = comparables[a];
        comparables[a] = comparables[b];
        comparables[b] = t;
    }

    //单行打印出数据
    public void show(Comparable[] comparables) {
        for (int i = 0; i < comparables.length; i++) {
            if (i == comparables.length - 1) System.out.println(comparables[i] + " ");
            else System.out.print(comparables[i] + " -> ");
        }
        System.out.println();
    }

    //查看数据是否按从小到大的顺序排列好
    public boolean isSorted(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            if (less(comparables[i], comparables[i - 1])) return false;
        }
        return true;
    }

}
