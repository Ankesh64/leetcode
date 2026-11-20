class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for (int num : nums) {
            int same = dp.getOrDefault(num, 0);
            int prev = dp.getOrDefault(num - 1, 0);

            int next = Math.max(same, prev + 1);

            dp.put(num, next);
            dp.put(num + 1, Math.max(
                dp.getOrDefault(num + 1, 0),
                same + 1
            ));

            ans = Math.max(ans, Math.max(
                next,
                dp.get(num + 1)
            ));
        }

        return ans;
    }
}