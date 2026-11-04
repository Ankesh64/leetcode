import java.util.*;

class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    long sumLeft = 0, sumRight = 0;
    int sizeLeft = 0, sizeRight = 0;

    void addToMap(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void removeFromMap(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) map.remove(val);
        else map.put(val, count - 1);
    }

    void add(int val) {
        if (sizeLeft == 0 || val <= left.lastKey()) {
            addToMap(left, val);
            sumLeft += val;
            sizeLeft++;
        } else {
            addToMap(right, val);
            sumRight += val;
            sizeRight++;
        }
        balance();
    }

    void remove(int val) {
        if (left.containsKey(val)) {
            removeFromMap(left, val);
            sumLeft -= val;
            sizeLeft--;
        } else {
            removeFromMap(right, val);
            sumRight -= val;
            sizeRight--;
        }
        balance();
    }

    void balance() {
        while (sizeLeft > sizeRight + 1) {
            int val = left.lastKey();
            removeFromMap(left, val);
            sumLeft -= val;
            sizeLeft--;

            addToMap(right, val);
            sumRight += val;
            sizeRight++;
        }

        while (sizeLeft < sizeRight) {
            int val = right.firstKey();
            removeFromMap(right, val);
            sumRight -= val;
            sizeRight--;

            addToMap(left, val);
            sumLeft += val;
            sizeLeft++;
        }
    }

    long getCost() {
        long median = left.lastKey();

        return median * sizeLeft - sumLeft
             + sumRight - median * sizeRight;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < n; i++) {
            add(nums[i]);

            if (i >= x) {
                remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }

        long INF = Long.MAX_VALUE / 2;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                dp[i][j] = dp[i - 1][j];

                if (i >= x && dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
