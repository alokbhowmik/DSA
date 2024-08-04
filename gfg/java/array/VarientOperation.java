package gfg.java.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VarientOperation {
     public int countUniques(int[] arr, int k, int l, int r) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> set = new ArrayList<>();
        Set<Integer> newSet = new HashSet<>();
        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
            newSet.add(num);
        }
        for(int i = l; i<=r && k > 0; i++){
            if(map.get(i) == null){
                set.add(i);
                k--;
            }
        }
        for(int key: map.keySet()){
            while(map.get(key) > 1 && !set.isEmpty()){
                map.put(key, map.get(key) - 1);
                newSet.add(set.get(0));
                set.remove(set.get(0));
            }
        }
        return newSet.size();
    }
}
