class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftBound[] = new int[n];
        int rightBound[] = new int[n];

        leftBound[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftBound[i] = Math.max(height[i], leftBound[i - 1]);
        }

        rightBound[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightBound[i] = Math.max(height[i], rightBound[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftBound[i], rightBound[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
}