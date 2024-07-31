import java.util.Arrays;
import java.util.Comparator;

public class PrintLeargest {
    String printLargest(int n, String[] arr) {
        // code here
        Arrays.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return yx.compareTo(xy);
                // TODO Auto-generated method stub
                // throw new UnsupportedOperationException("Unimplemented method 'compare'");
            }
            
        });
        // Arrays.sort(arr, new Comparator<String>() {
        //     @Override
        //     int compare(String x, String y) {
        //         String xy = x + y;
        //         String yx = y + x;
        //         return xy.compareTo(yx) > 0 ? -1 : 1;
        //     }
        // });

        String ans = "";
        for (int i = 0; i < n; i++) {
            ans += arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        PrintLeargest pLeargest = new PrintLeargest();
        String[] arr = {"3", "30", "34", "5", "9"};
        String ans = pLeargest.printLargest(5, arr);
        System.out.println(ans);
    }
}
