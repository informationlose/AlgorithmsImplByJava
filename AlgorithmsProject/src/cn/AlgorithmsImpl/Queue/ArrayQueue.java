package cn.AlgorithmsImpl.Queue;
/**
 *以牺牲了一个空间作为代价，换取可以辨别是否溢出的标志
 * */
public class ArrayQueue {
    private int data[] = new int[16];
    private int head;
    private int tail;
    public void enqueue(int x){
        if(head == tail + 1 || (tail == 15 && head == 0)){
            throw new ArithmeticException("队列数据上溢");
        }
        data[tail] = x;
        if(tail == 15)tail = 0;
        else tail++;
    }
    public int dequeue(){
        if(head == tail || (head == 15 && head == 0)){
            throw new ArithmeticException("队列数据下溢");
        }
        int DequeueData = data[head];
        if(head == 15)head = 0;
        else head++;
        return DequeueData;
    }
}
