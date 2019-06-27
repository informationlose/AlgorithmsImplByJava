package cn.AlgorithmsImpl.SomeProblem;

public class NewCodeProgram {
    //面试题目：用两个栈实现队列
//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//
//    public void push(int node) {
//        stack1.push(node);
//    }
//
//    public int pop() {
//        if(stack2.empty()) {
//            while (!stack1.empty()) stack2.push(stack1.pop());
//        }
//        return stack2.pop();
//    }
    //滑动窗口最大值
//    public ArrayList<Integer> maxInWindows(int[] num, int size) {
//        ArrayList<Integer> result = new ArrayList();
//        if (num.length == 0 || size == 0) return result;
//        LinkedList<Integer> linkedList = new LinkedList<Integer>();
//        for (int i = 0; i < num.length; i++) {
//            while (!linkedList.isEmpty() && num[linkedList.peekLast()] <= num[i]) {
//                linkedList.pollLast();
//            }
//            linkedList.addLast(i);
//            if (i - linkedList.peekFirst() >= size) {
//                linkedList.pollFirst();
//            }
//            if (i >= size - 1) {
//                result.add(num[linkedList.peekFirst()]);
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {

    }
}
