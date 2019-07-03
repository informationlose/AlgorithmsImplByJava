package cn.AlgorithmsImpl.SearchAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

//红黑树实现，前身原理是2-3树，只需要将所有的红链接合并，即得到一颗2-3树
public class RedAndBlackTree<Key extends Comparable<Key>, Value> {
    private static boolean RED = true;
    private static boolean BLACK = false;
    private Node root;

    private boolean isRED(Node node) {
        if (node != null) return node.color;
        else return false;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    private boolean isEmpty() {
        if (root == null) return true;
        else return false;
    }

    private Node rotateLeft(Node left) {
        Node right = left.right;
        left.right = right.left;
        right.left = left;
        right.N = left.N;
        left.N = 1 + size(left.right) + size(left.left);
        right.color = left.color;
        left.color = RED;
        return right;
    }

    private Node rotateRight(Node right) {
        Node left = right.left;
        right.left = left.right;
        left.right = right;
        left.N = right.N;
        right.N = 1 + size(right.left) + size(right.right);
        left.color = right.color;
        right.color = RED;
        return left;
    }

    private void filpColor(Node node) {
        node.color = RED;
        if (node.left != null)
            node.left.color = BLACK;
        if (node.right != null)
            node.right.color = BLACK;
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
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1, RED);
        int cmp = key.compareTo(node.key);
        if (cmp > 0) node.right = put(node.right, key, value);
        else if (cmp < 0) node.left = put(node.left, key, value);
        else node.value = value;
        if (isRED(node.right) && !isRED(node.left)) node = rotateLeft(node);
        if (isRED(node.left) && isRED(node.left.left)) node = rotateRight(node);
        if (isRED(node.right) && isRED(node.left)) filpColor(node);

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

    private Node MoveRedLeft(Node node) {
        filpColor(node);//注意，在删除中这个操作应该是和以前的相反
        if (node.right != null && isRED(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }
        return node;
    }

    private Node MoveRedRight(Node node) {
        filpColor(node);//注意，在删除中这个操作应该是和以前的相反
        if (!isRED(node.left.left)) {
            node = rotateRight(node);
        }
        return node;
    }

    private Node balance(Node node) {
        if (isRED(node.right)) node = rotateLeft(node);
        if (isRED(node.right) && !isRED(node.left)) node = rotateLeft(node.left);
        if (isRED(node.right) && isRED(node.left)) filpColor(node);
        if (isRED(node.left) && isRED(node.left.left)) node = rotateRight(node);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMin() {
        if (!isRED(root.left) && !isRED(root.right)) root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMin(Node node) {
        if (node == null || node.left == null) return null;
        if (!isRED(node.left) && !isRED(node.left.left)) node = MoveRedLeft(node);
        node.left = deleteMin(node.left);
        return balance(node);
    }

    public void deleteMax() {
        if (!isRED(root.left) && !isRED(root.right)) root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node node) {
        if (isRED(node.left)) node = rotateRight(node);
        if (node.right == null) return null;
        if (!isRED(node.right) && !isRED(node.right.left)) node = MoveRedRight(node);
        node.right = deleteMax(node.right);
        return balance(node);
    }

    public void delete(Key key) {
        if (!isRED(root.left) && !isRED(root.right)) root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node node, Key key) {
        if (key.compareTo(node.key) < 0) {
            if (!isRED(node.left) && !isRED(node.left.left)) node = MoveRedLeft(node);
            node.left = delete(node.left, key);
        } else {
            if (isRED(node.left)) node = rotateRight(node);
            if (key.compareTo(node.key) == 0 && (node.right == null)) return null;
            if (!isRED(node.right) && !isRED(node.right.left)) node = rotateRight(node);
            if (key.compareTo(node.key) == 0) {
                node.value = get(node.right, min(node.right).key).value;
                node.key = min(node.right).key;
                node.right = deleteMin(node.right);
            } else node.right = delete(node.right, key);
        }
        return balance(node);
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
        Node left, right;
        boolean color;
        int N;

        private Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }
}
