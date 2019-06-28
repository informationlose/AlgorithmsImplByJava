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
    //实现具有Min方法的栈
//    Stack stack1 = new Stack();
//    Stack stack2 = new Stack();
//
//    public void push(int node) {
//        stack1.push(node);
//        if (stack2.isEmpty()) {
//            stack2.push(node);
//        } else {
//            if ((int) stack2.peek() <= node) {
//                stack2.push((int) stack2.peek());
//            } else stack2.push(node);
//        }
//    }
//
//    public void pop() {
//        stack1.pop();
//        stack2.pop();
//    }
//
//    public int min() {
//        int min = (int) stack2.peek();
//        return min;
//    }
    //反转链表
//    public static class ListNode {
//        int val;
//        ListNode next = null;
//
//        ListNode(int val) {
//            this.val = val;
//        }
//    }
//    ListNode result;
//    public ListNode ReverseList(ListNode head){
//        if(head.next == null){
//            result = head;
//            return head;
//        }
//        ReverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return result;
//    }
    //斐波那契数列
//    public int Fibonacci(int n){
//        int result;
//        if(n == 0)return 0;
//        if(n == 1)return 1;
//        if(n == 2)return 1;
//        result = Fibonacci(n - 1) + Fibonacci(n - 2);
//        return result;
//    }
    //跳台阶
//    public int JumpFloor(int target){
//        if(target == 1)return 1;
//        if(target == 2)return 2;
//        return JumpFloor(target - 1) + JumpFloor(target - 2);
//    }
    //跳台阶II
//    public int JumpFloorII(int target){
//        if(target == 0)return 0;
//        if(target == 1)return 1;
//        if(target == 2)return 2;
//        int result = 0;
//        while(target != 0){
//            result += JumpFloorII(--target);
//        }
//        return result + 1;
//    }
    public static void main(String[] args) {
        NewCodeProgram newCodeProgram = new NewCodeProgram();
    }
}
