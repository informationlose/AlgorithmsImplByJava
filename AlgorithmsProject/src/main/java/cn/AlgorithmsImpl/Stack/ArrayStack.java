package cn.AlgorithmsImpl.Stack;

import cn.Algorithms.Tools.AlgorithmsException;

/**
 * 此数组栈初始限定大小为16个元素，
 */
public class ArrayStack<T> {
    private Class<T>[] data = new Class[16];
    private int stackTop = -1;

    public boolean isEmpty() {
        if (stackTop == -1) return true;
        else return false;
    }

    public void push(Class<T> x) throws AlgorithmsException {
        if (stackTop == 15) throw new AlgorithmsException("堆数据上溢");
        stackTop += 1;
        data[stackTop] = x;
    }

    public Class<T> pop() throws AlgorithmsException {
        if (stackTop == -1) throw new AlgorithmsException("堆数据下溢");
        Class<T> popData = data[stackTop];
        stackTop -= 1;
        return popData;
    }
}
