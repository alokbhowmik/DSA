import java.util.*;

public class TreeSet1 {
    /**
     * Pair
     */
    public class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair pair) {
            return pair.first == this.first ? 0 : -1;
        }

        @Override
        public String toString() {
            return first + " : " + second;
        }

    }

    TreeSet<Pair> ts;

    TreeSet1() {
        ts = new TreeSet<>();
    }

    boolean add(int start, int end) {
        ts.add(new Pair(start, end));
        return true;
    }

    @Override
    public String toString() {
        return "" + ts.toString();
    }
}
