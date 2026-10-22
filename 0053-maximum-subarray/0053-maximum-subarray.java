class Solution {
    public int maxSubArray(int[] nums) {
        int currsum = nums[0];
        int maxSum = nums[0];
        for(int i=1; i<nums.length; i++){
            currsum=Math.max(nums[i],currsum+nums[i]);
            maxSum = Math.max(maxSum,currsum);
        }
        return maxSum;
    }
}