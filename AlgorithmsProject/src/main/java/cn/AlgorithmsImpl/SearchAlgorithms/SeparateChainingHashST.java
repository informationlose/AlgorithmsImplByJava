package cn.AlgorithmsImpl.SearchAlgorithms;

import java.util.LinkedList;

public class SeparateChainingHashST<Key extends Comparable, Value> {
    private int M;
    private int N;
    private SequentialSearch<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int i) {
        this.M = i;
        st = (SequentialSearch<Key, Value>[]) new SequentialSearch[M];
        for (int j = 0; j < M; j++) {
            st[j] = new SequentialSearch<Key, Value>();
        }
    }

    public void put(Key key, Value value) {
        SequentialSearch search = st[hash(key)];
        search.put(key, value);
        N++;
    }

    public Value get(Key key) {
        SequentialSearch search = st[hash(key)];
        return (Value) search.get(key);
    }

    public void delete(Key key) {
        SequentialSearch search = st[hash(key)];
        search.delete(key);
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Iterable keys() {
        LinkedList<Key> result = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            SequentialSearch searches = st[i];
            LinkedList<Key> iterable = (LinkedList<Key>) searches.keys();
            while (!iterable.isEmpty()) {
                result.add(iterable.pop());
            }
        }
        return result;
    }
}
