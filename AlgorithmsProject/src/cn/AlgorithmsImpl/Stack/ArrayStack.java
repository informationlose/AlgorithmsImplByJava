package cn.AlgorithmsImpl.Stack;

import cn.Algorithms.Tools.AlgorithmsException;

/**
 * 此数组栈限定大小为16个int元素，
 * */
public class ArrayStack {
    private int data[] = new int[16];
    private int stackTop = -1;

    public boolean isEmpty() {
        if (stackTop == -1) return true;
        else return false;
    }

    public void push(int x) throws AlgorithmsException {
        if (stackTop == 15) throw new AlgorithmsException("堆数据上溢");
        stackTop += 1;
        data[stackTop] = x;
    }

    public int pop() throws AlgorithmsException {
        if (stackTop == -1) throw new AlgorithmsException("堆数据下溢");
        int popData = data[stackTop];
        stackTop -= 1;
        return popData;
    }
}
