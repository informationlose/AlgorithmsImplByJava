package cn.AlgorithmsImpl.FindAlgorithms;

public class SequentialSearch<Key extends Comparable, Value> {
    private Node first;
    private int size = 0;

    public int size() {
        return size;
    }

    public void put(Key key, Value value) {
//        在后方插入
//        Node i;
//        for (i = first; i != null; i = i.next) {
//            if (i.key.equals(key)) {
//                i.value = value;
//                return;
//            }
//        }
//        i.next = new Node(key, value, null);
        //在前方插入
        for (Node i = first; i != null; i = i.next) {
            if (i.key.equals(key)) {
                i.value = value;
                size++;
                return;
            }
        }
        size++;
        first = new Node(key, value, first);
    }

    public Value get(Key key) {
        Node i;
        for (i = first; i != null; i = i.next) {
            if (key.equals(i.key)) return i.value;
        }
        return null;
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
