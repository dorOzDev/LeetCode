package topinterview150.medium.insertdeletegetrandom;

import java.util.*;

public class RandomizedSet {

    private final HashMap<Integer, Integer> map;
    private final ArrayList<Integer> arr;
    private final Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
        arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        Integer index = map.getOrDefault(val, -1);
        boolean isPresent = index > -1;
        if(!isPresent) {
            arr.add(val);
            map.put(val, arr.size() - 1);
        }

        return !isPresent;
    }

    public boolean remove(int val) {
        Integer index = map.getOrDefault(val, -1);
        boolean isPresent = index > -1;
        if(isPresent) {
            Integer last = arr.getLast();
            Collections.swap(arr, index, arr.size() - 1);
            map.put(last, index);
            arr.removeLast();
            map.remove(val);
        }

        return isPresent;
    }

    public int getRandom() {
        int randomIndex = random.ints(0, arr.size()).findFirst().getAsInt();

        return arr.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(3);
        set.insert(3);
        set.getRandom();
        set.getRandom();
        set.insert(1);

        set.getRandom();
    }
}
