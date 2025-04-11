package dsa.hashmap;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();

    }

    public boolean insert(int val) {

        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;

    }

    public boolean remove(int val) {

        if(!map.containsKey(val)){
            return false;
        }
        int index=map.get(val);
        list.set(index, list.getLast());
        map.put(list.getLast(), index);
        map.remove(val);
        list.removeLast();
        return true;

    }

    public int getRandom() {

        Random random=new Random();
        return list.get(random.nextInt(list.size()));

    }
}
