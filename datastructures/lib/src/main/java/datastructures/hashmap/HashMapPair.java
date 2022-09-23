package datastructures.hashmap;

import java.util.AbstractMap;

public class HashMapPair<K, V> extends AbstractMap.SimpleEntry {

    public HashMapPair(K key, V value) {
        super(key, value);
    }
}
