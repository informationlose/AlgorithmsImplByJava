package cn.AlgorithmsImpl.SearchAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class ForkTreeSearch<Key extends Comparable<Key>, Value> {
//    private Node root;
//
//    private class Node {
//        private Key key;
//        private Value value;
//        private Node left;
//        private Node right;
//        private int N;
//
//        public Node(Key key, Value value, int N) {
//            this.key = key;
//            this.value = value;
//            this.N = N;
//        }
//    }
//
//    public void put(Key key, Value value) {
//        root = put(key, value, root);
//    }
//
//    private Node put(Key key, Value value, Node node) {
//        if (node == null) {
//            return new Node(key, value, 1);
//        }
//        int cmp = key.compareTo(node.key);
//        if (cmp > 0) node.right = put(key, value, node.right);
//        else if (cmp < 0) node.left = put(key, value, node.left);
//        else node.value = value;
//        node.N = size(node.left) + size(node.right) + 1;
//        return node;
//    }
//
//    public Value get(Key key) {
//        Node n = get(key, root);
//        if (n == null) return null;
//        else return n.value;
//    }
//
//    private Node get(Key key, Node node) {
//        if (node == null) return null;
//        int cmp = key.compareTo(node.key);
//        if (cmp > 0) return get(key, node.right);
//        else if (cmp < 0) return get(key, node.left);
//        else return node;
//    }
//
//    public int size() {
//        return size(root);
//    }
//
//    private int size(Node node) {
//        if (node == null) return 0;
//        return node.N;
//    }
//
//    public Key min() {
//        return min(root).key;
//    }
//
//    private Node min(Node node) {
//        if (node.left == null) return node;
//        else return min(node.left);
//    }
//
//    public Key max() {
//        return max(root).key;
//    }
//
//    private Node max(Node node) {
//        if (node.right == null) return node;
//        else return max(node.right);
//    }
//
//    public Key floor(Key key) {
//        Node node = floor(key, root);
//        if (node == null) return null;
//        else return node.key;
//    }
//
//    //先定位一个小于key的node，然后直接查其右子树中有没有小于这个node的存在，如果有就递归再看看，直到出现了null为止（不论这个null在哪里）
//    private Node floor(Key key, Node node) {
//        if (node == null) return null;
//        int cmp = key.compareTo(node.key);
//        if (cmp == 0) return node;
//        if (cmp < 0) return floor(key, node.left);
//        Node n = floor(key, node.right);
//        if (n != null) return n;
//        else return node;
//    }
//
//    public Key ceiling(Key key) {
//        Node node = ceiling(key, root);
//        if (node == null) return null;
//        else return node.key;
//    }
//
//    private Node ceiling(Key key, Node node) {
//        if (node == null) return null;
//        int cmp = key.compareTo(node.key);
//        if (cmp == 0) return node;
//        if (cmp > 0) return ceiling(key, node.right);
//        Node n = ceiling(key, node.left);
//        if (n != null) return n;
//        else return node;
//    }
//
//    public Key select(int k) {
//        if (k > size()) return null;
//        Node n = select(k - 1, root);
//        if (n == null) return null;
//        return n.key;
//    }
//
//    private Node select(int k, Node node) {
//        if (k < 0) return null;
//        int i = size(node.left);
//        if (k > i) {
//            return select(k - 1 - i, node.right);
//        } else if (k < i) {
//            return select(k, node.left);
//        } else return node;
//    }
//
//    public int rank(Key key) {
//        return rank(key, root);
//    }
//
//    private int rank(Key key, Node node) {
//        if (node == null) return 0;
//        int cmp = key.compareTo(node.key);
//        if (cmp == 0) return size(node.left) + 1;
//        else if (cmp > 0) return rank(key, node.right) + 1 + size(node.left);
//        else return rank(key, node.left);
//    }
//
//    public void deleteMin() {
//        root = deleteMin(root);
//    }
//
//    private Node deleteMin(Node node) {
//        if (node.left == null) {
//            return node.right;
//        }
//        node.left = deleteMin(node.left);
//        node.N = size(node.left) + size(node.right) + 1;
//        return node;
//    }
//
//    public void deleteMax() {
//        deleteMax(root);
//    }
//
//    private Node deleteMax(Node node) {
//        if (node.right == null) return node.left;
//        else {
//            node.right = deleteMax(node.right);
//            node.N = size(node.right) + size(node.left) + 1;
//            return node;
//        }
//    }
//
//    public void delete(Key key) {
//        delete(root, key);
//    }
//
//    private Node delete(Node node, Key key) {
//        if (node == null) return null;
//        int cmp = key.compareTo(node.key);
//        if (cmp > 0) node.right = delete(node.right, key);
//        else if (cmp < 0) node.left = delete(node.left, key);
//        else {
//            if (node.right == null) return node.left;
//            if (node.left == null) return node.right;
//            Node n = node;
//            node = min(n.right);
//            node.right = deleteMin(n.right);
//            node.left = n.left;
//        }
//        node.N = size(node.left) + size(node.right) + 1;
//        return node;
//    }
//
//    public void printM() {
//        printM(root);
//    }
//
//    private void printM(Node node) {
//        if (node == null) return;
//        printM(node.left);
//        System.out.print(node.key + " ");
//        printM(node.right);
//    }
//
//    public Iterable<Key> keys() {
//        return keys(min(), max());
//    }
//
//    public Iterable<Key> keys(Key begin, Key end) {
//        Queue<Key> queue = new LinkedList<>();
//        keys(begin, end, root, queue);
//        return queue;
//    }
//
//    private void keys(Key begin, Key end, Node node, Queue<Key> queue) {
//        if (node == null) return;
//        int cmpBegin = begin.compareTo(node.key);
//        int cmpEnd = end.compareTo(node.key);
//        if (cmpBegin < 0) keys(begin, end, node.left, queue);
//        if (cmpBegin <= 0 && cmpEnd >= 0) queue.add(node.key);
//        if (cmpEnd > 0) keys(begin, end, node.right, queue);
//    }

//    public void show() {
//        Node node;
//        Queue queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            node = (Node) queue.poll();
//            System.out.print("key: " + node.key + " value: " + node.value + " ");
//            System.out.println();
//            if (node.left != null)
//                queue.add(node.left);
//            if (node.right != null)
//                queue.add(node.right);
//
//        }
//    }

    private Node root;

    public static void main(String[] args) {
        ForkTreeSearch f = new ForkTreeSearch();
        f.put("d", 1);
        f.put("s", 2);
        f.put("a", 3);
        f.put("e", 4);
        f.put("c", 5);
        Iterable keys = f.keys();
        for (Object a :
                keys) {
            System.out.println(a);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    public Key max() {
        Node node = max(root);
        if (node != null) return node.key;
        else return null;
    }

    private Node max(Node node) {
        if (node == null) return null;
        while (node.right != null) node = node.right;
        return node;
    }

    public Key min() {
        Node node = min(root);
        if (node != null) return node.key;
        else return null;
    }

    private Node min(Node node) {
        if (node == null) return null;
        while (node.left != null) node = node.left;
        return node;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp > 0) node.right = put(node.right, key, value);
        else if (cmp < 0) node.left = put(node.left, key, value);
        else node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value get(Key key) {
        Node node = get(root, key);
        if (node != null) return node.value;
        else return null;
    }

    private Node get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) return get(node.right, key);
        else if (cmp < 0) return get(node.left, key);
        else return node;
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node != null) return node.key;
        else return null;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) return floor(node.left, key);
        else if (cmp > 0) {
            Node n = floor(node.right, key);
            if (n == null) return node;
            else return n;
        } else return node;
    }

    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) return null;
        else return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) return ceiling(node.right, key);
        else if (cmp < 0) {
            Node n = ceiling(node.left, key);
            if (n == null) return node;
            else return n;
        } else return node;
    }

    public Key select(int k) {
        Node n = select(root, k);
        if (n == null) return null;
        else return n.key;
    }

    private Node select(Node node, int k) {
        if (node == null) return null;
        if (size(node) + 1 == k) return node;
        else if (k < size(node) + 1) return select(node.left, k);
        else return select(node.right, k - size(node.left) - 1);
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return size(node.left) + 1;
        else if (cmp > 0) return rank(key, node.right) + 1 + size(node.left);
        else return rank(key, node.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node == null) return null;
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node == null) return null;
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) node.right = delete(node.right, key);
        else if (cmp < 0) node.left = delete(node.left, key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node n = node;
            node = min(n.right);
            //下面的赋值顺序不能颠倒，不然会出现引用类型的错误，可能导致无限循环出现
            node.right = deleteMin(n.right);
            node.left = n.left;
        }
        node.N = size(node.right) + size(node.left) + 1;
        return node;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key begin, Key end) {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, begin, end);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key begin, Key end) {
        if (node == null) return;
        if (begin.compareTo(end) > 0) return;
        int cmpBegin = begin.compareTo(node.key);
        int cmpEnd = end.compareTo(node.key);
        if (cmpBegin < 0) keys(node.left, queue, begin, end);
        if (cmpBegin <= 0 && cmpEnd >= 0) queue.add(node.key);
        if (cmpEnd > 0) keys(node.right, queue, begin, end);
    }

    public void printM() {
        printM(root);
    }

    private void printM(Node node) {
        if (node == null) return;
        printM(node.left);
        System.out.println(node.key);
        printM(node.right);
    }

    private class Node {
        Key key;
        Value value;
        int N;
        Node left;
        Node right;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
}
