package cn.AlgorithmsImpl.SearchAlgorithms;

import java.util.Objects;

public class LinearProbingHashST<Key, Value> {
    private int M = 16;//初始大小
    private int N;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST() {
        keys = (Key[]) new Objects[M];
        values = (Value[]) new Objects[M];
    }

    private LinearProbingHashST(int m) {
        this.M = m;
        keys = (Key[]) new Objects[M];
        values = (Value[]) new Objects[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int m) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(m);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) t.put(keys[i], values[i]);
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    public void put(Key key, Value value) {
        if (N > M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        int hash = hash(key);
        for (int i = hash; keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) return values[i];
        }
        return null;
    }

    private boolean contains(Key key) {
        for (Key value : keys) {
            if (key.equals(value)) return true;
        }
        return false;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        values[i] = null;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N <= M / 8) resize(M / 2);
    }
}
