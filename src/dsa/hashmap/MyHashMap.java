package dsa.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyHashMap {

    List<Node>[] map;

    public MyHashMap() {
        map = new List[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new ArrayList<Node>();
        }
    }

    public void put(int key, int value) {

        remove(key);

        int hashValue = hash(key);
        Node newNode = new Node(key, value);
        map[hashValue].add(newNode);

    }

    public int get(int key) {
        int hashValue = hash(key);
        List<Node> list = map[hashValue];
        Optional<Node> result = list.stream().filter(n -> n.key == key).findFirst();
        return result.map(n -> n.value).orElse(-1);
    }

    public void remove(int key) {
        int hashValue = hash(key);
        List<Node> list = map[hashValue];
        Optional<Node> result = list.stream().filter(n -> n.key == key).findFirst();
        if (result.isPresent()) {
            list.remove(result.get());
        }

    }

    private int hash(int key) {
        return key % 1000;
    }
}

class Node {
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */