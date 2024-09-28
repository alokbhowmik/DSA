import java.util.*;
import java.util.Map.Entry;

public class TreeMap1 {
   public static void main(String[] args) {
       TreeMap<Integer, Integer> map = new TreeMap<>();
       map.put(10, 20);
       map.put(11, 21);
       map.put(12, 25);
       map.put(7, 88);
       System.err.println(map);
    //    Entry<Integer, Integer> ent = map.lowerEntry(12);
    //    System.out.println(ent);
    Entry<Integer, Integer> ent = map.ceilingEntry(10);//map.floorEntry(11);
    System.out.println(ent);
   } 
}
