class Solution {

    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;

    static final long BASE1 = 911382323L;
    static final long BASE2 = 972663749L;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        int left = 1;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (hasUniqueSubarray(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean hasUniqueSubarray(int[] nums, int len) {

        int n = nums.length;

        long pow1 = 1;
        long pow2 = 1;

        for (int i = 0; i < len; i++) {
            pow1 = (pow1 * BASE1) % MOD1;
            pow2 = (pow2 * BASE2) % MOD2;
        }

        long hash1 = 0;
        long hash2 = 0;

        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * BASE1 + nums[i]) % MOD1;
            hash2 = (hash2 * BASE2 + nums[i]) % MOD2;
        }

        HashMap<Long, Integer> map = new HashMap<>();

        long key = hash1 * MOD2 + hash2;
        map.put(key, 1);

        for (int i = len; i < n; i++) {

            int oldNum = nums[i - len];
            int newNum = nums[i];

            hash1 = (hash1 * BASE1 + newNum
                    - (pow1 * oldNum) % MOD1 + MOD1) % MOD1;

            hash2 = (hash2 * BASE2 + newNum
                    - (pow2 * oldNum) % MOD2 + MOD2) % MOD2;

            key = hash1 * MOD2 + hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
