import cn.Algorithms.Tools.AlgorithmsException;
import cn.Algorithms.Tools.SortTemplate;
import cn.AlgorithmsImpl.Max_Heapify.MaxHeapify;
import cn.AlgorithmsImpl.Queue.ArrayQueue;
import cn.AlgorithmsImpl.SortAlgorithms.InsertSort;
import cn.AlgorithmsImpl.SortAlgorithms.QuickSort;
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

    @Test
    public void testSort() {
        SortTemplate sortTemplate = new InsertSort();
//        String[] data = {"b","d","d","a","c"};
        Integer[] data = {23, 2, 1, 3, 5, 1, 2, 5};
        sortTemplate.sort(data);
        sortTemplate.show(data);
    }
}

