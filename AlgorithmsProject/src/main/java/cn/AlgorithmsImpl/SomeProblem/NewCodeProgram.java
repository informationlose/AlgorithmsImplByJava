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
    //旋转数组中的最小值
//    public int minNumberInRotateArray(int [] array){
//        if(array.length == 0)return 0;
//        int min = 0;
//        for (int i = 1; i < array.length; i++) {
//            if(array[i - 1]>array[i])min = array[i];
//        }
//        return min;
//    }
    //栈的压入和弹出是否对应
//    public boolean IsPopOrder(int[] push ,int[] pop){
//        if(push.length == 0)return true;
//        if(pop.length == 1)return pop[0] == push[0];
//        int N = pop.length;
//        for (int i = 0; i < N; i++) {
//            int j = 0;
//            for (int k = 0; k < N; k++) {
//                if(push[k] == pop[i]){
//                    j = i;
//                    break;
//                }
//                if(k == N - 1)return false;
//            }
//            int count = 0;
//            for (int k = i + 1; k < N; k++) {
//                for (int l = 0; l < j; l++) {
//                    if(pop[k] == push[l]){
//                        for (int m = k + 1; m < N; m++) {
//                            for (int n = l + 1; n < j; n++) {
//                                if(pop[m] == push[n])return false;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }
    //输出链表倒数第k个节点
//    public class ListNode {
//        int val;
//        ListNode next = null;
//
//        ListNode(int val) {
//            this.val = val;
//        }
//    }
//    public ListNode FindKthToTail(ListNode head, int k){
//        ListNode result = head;
//        int length = 0;
//        while(head != null){
//            length++;
//            head = head.next;
//        }
//        if(k>length)return null;
//        for (int i = 0; i < length - k; i++) {
//            result = result.next;
//        }
//        return result;
//    }
    //调整奇偶数的位置
//    public void reOrderArray(int[] array) {
//        for (int i = 1; i < array.length; i++) {
//            for (int j = i; j > 0 && array[j] % 2 == 1; j--) {
//                if (array[j - 1] % 2 == 1) break;
//                int temp = array[j];
//                array[j] = array[j - 1];
//                array[j - 1] = temp;
//            }
//        }
//    }
    //顺序打印矩阵
//    public ArrayList<Integer> printMatrix(int[][] matrix) {
//        if (matrix.length == 0) return null;
//        ArrayList<Integer> result = new ArrayList<>();
//        int x1 = 0, x2 = matrix[0].length - 1, y1 = 0, y2 = matrix.length - 1;
//        while (x1 <= x2 && y1 <= y2) {
//            for (int i = x1; i <= x2; i++) {
//                result.add(matrix[y1][i]);
//            }
//            y1++;
//            for (int i = y1; i <= y2; i++) {
//                result.add(matrix[i][x2]);
//            }
//            x2--;
//            if (y1 - 1 != y2)
//                for (int i = x2; i >= x1; i--) {
//                    result.add(matrix[y2][i]);
//                }
//            y2--;
//            if (x1 != x2 + 1)
//                for (int i = y2; i >= y1; i--) {
//                    result.add(matrix[i][x1]);
//                }
//            x1++;
//        }
//        return result;
//    }

    public static void main(String[] args) {
    }
}
