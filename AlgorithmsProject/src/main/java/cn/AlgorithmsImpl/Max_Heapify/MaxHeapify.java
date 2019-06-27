package cn.AlgorithmsImpl.Max_Heapify;

/**
 * 最大堆的实现：使用数组作为实现的载体
 * 注意，最大堆的性质只是父结点大于子节点而已！！在数组中不一定是从大到小的排列的！！！！
 * 如果想要从大到小或从小到大排序，只能不断的抽取首个元素，直到数组消失
 */
public class MaxHeapify<Key extends Comparable<Key>> {
    private Key[] data;
    private int N = 0;

    public MaxHeapify(int Max) {
        data = (Key[]) new Comparable[Max + 1];
    }

    public void showData() {
        for (int i = 0; i < N; i++) {
            System.out.print(data[i + 1] + " ");
        }
    }

    //比较
    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    //交换
    private void exch(int i, int j) {
        Key temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //上浮
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    //下沉
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (less(j, k)) break;
            exch(j, k);
            k = j;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        data[++N] = v;
        swim(N);
    }

    public Key deleteMax() {
        Key result = data[1];
        data[1] = data[N--];
        data[N + 1] = null;
        sink(1);
        return result;
    }
}
