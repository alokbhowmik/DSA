import java.util.Arrays;

/**
 * MinimumQuery
 */
public class MinimumQuery {
    int bs(int arr[], int t){
        int idx = -1;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + (r - l) / 2);
            if (arr[mid] <= t) {
                idx = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return idx; 
    }
    int[] minimumQuery(int[] querys, int[] nums) {
        int m = querys.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        int[] ps = new int[m];
        ps[0] = nums[0];
        for (int i = 1; i < m; i++) {
            ps[i] = ps[i - 1] + nums[i];
            // System.out.println("+++++++++++" + ps[i]);
        }
        for (int i = 0; i < m; i++) {
            int q = querys[i];
            int idx = bs(nums, q);
            // System.out.println("---------" + idx );
            if (idx + 1 >= m) {
                ans[i] = q * m - ps[m - 1];
                // System.out.println(ans[i]);
            } else if (idx < 0) {
                ans[i] = ps[m - 1] - m * q;
            } else {
                ans[i] = q * (idx + 1) - 2 * ps[idx] + ps[m - 1]  - (m - 1 - idx)*q;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int q[] = {8,4 ,3};
        int nums[] = { 2, 5, 1 };
        MinimumQuery minimumQuery = new MinimumQuery();
        
        int ans[] = minimumQuery.minimumQuery(q, nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
}