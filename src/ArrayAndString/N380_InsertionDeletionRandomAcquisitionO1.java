package ArrayAndString;

import java.lang.reflect.Array;
import java.util.*;

public class N380_InsertionDeletionRandomAcquisitionO1 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
    }

}

class RandomizedSet {

    private ArrayList<Integer> arrayList = null;
    private HashMap<Integer,Integer> hashMap = null;
    private Random random = null;

    public RandomizedSet() {
        arrayList = new ArrayList<>();
        hashMap = new HashMap<Integer,Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (hashMap.containsKey(val)){
            return false;
        }else {
            arrayList.add(val);
            hashMap.put(val,arrayList.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (hashMap.containsKey(val)){
            Integer index = hashMap.get(val);
            arrayList.set(index,arrayList.getLast());
            hashMap.remove(val);
            arrayList.remove(arrayList.size()-1);
            if (index<arrayList.size()){
                hashMap.put(arrayList.get(index),index);
            }
            return true;
        }else {
            return false;
        }
    }

    public int getRandom() {
        return arrayList.get(random.nextInt(arrayList.size()));
    }
}