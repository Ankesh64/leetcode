class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += Math.abs(nums[i] - median);
        }

        return count;
    }
}