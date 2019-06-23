import cn.Algorithms.Tools.AlgorithmsException;
import cn.Algorithms.Tools.SortTemplate;
import cn.AlgorithmsImpl.Max_Heapify.MaxHeapify;
import cn.AlgorithmsImpl.Queue.ArrayQueue;
import cn.AlgorithmsImpl.SortAlgorithms.QuickSort;
import cn.AlgorithmsImpl.SortAlgorithms.ShellSort;
import cn.AlgorithmsImpl.Stack.ArrayStack;
import org.junit.jupiter.api.Test;

public class AlgorithmsTest {
    @Test
    public void ArrayStackTest() throws AlgorithmsException {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push(3);
        arrayStack.push(6);
        arrayStack.push(9);
        System.out.println(arrayStack.isEmpty());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.isEmpty());
    }

    @Test
    public void ArrayQueueTest() throws AlgorithmsException {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 0; i < 15; ++i) {
            arrayQueue.enqueue(i);
        }
        for (int i = 0; i < 15; i++) {
            System.out.println(arrayQueue.dequeue());
        }
    }

    @Test
    public void MaxHeapifyTest() {
        int[] heapTest = new int[16];
        for (int i = 0; i < 16; i++) {
            heapTest[i] = i;
        }
        MaxHeapify.heapSort(heapTest);
        for (int i = 0; i < 16; i++) {
            System.out.println(heapTest[i]);
        }
    }

    @Test
    public void QuickSortTest() {
        int[] testArray = new int[12];
        for (int i = 0; i < 12; i++) {
            testArray[i] = (int) (Math.random() * 100);
            System.out.print(testArray[i] + "  ");
        }
        System.out.println();
        QuickSort.sort(testArray, 0, testArray.length - 1);
        for (int i = 0; i < 12; i++) {
            System.out.print(testArray[i] + "  ");
        }
    }

    /**
     * 排序算法
     * 可用性测试
     */
    @Test
    public void testSortUserful() {
        SortTemplate sortTemplate = new ShellSort();
        Integer[] data = new Integer[40];
        for (int i = 0; i < 40; i++) {
            data[i] = (int) (Math.random() * 1000);
        }
        System.out.println("待排序数据：");
        sortTemplate.show(data);
        sortTemplate.sort(data);
        System.out.println("排序完成数据：" + sortTemplate.isSorted(data));
        sortTemplate.show(data);
    }

    /**
     * 排序算法
     * 性能测试
     */
    @Test
    public void testSortTime() {
        SortTemplate sortTemplate = new ShellSort();
        Integer[] data = new Integer[10000];
        long times = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                data[j] = (int) (Math.random() * 100000);
            }
            long begin = System.currentTimeMillis();
            sortTemplate.sort(data);
            long end = System.currentTimeMillis();
            times = times + (end - begin);
        }
        String[] name = sortTemplate.getClass().getName().split("\\.");
        System.out.println(name[3] + "算法执行10000次所用时间：" + times);
    }
}

