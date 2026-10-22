class Solution {
    public int maxArea(int[] height) {
        int leftbound = 0;
        int rightbound = height.length-1;
        int maxWater=0;
        while(leftbound<rightbound){
            int area=Math.min(height[leftbound],height[rightbound])*(rightbound-leftbound);
            maxWater=Math.max(area,maxWater);
            if(height[leftbound]<height[rightbound]){
                leftbound++;
            }else{
                rightbound--;
            }
        }
        return maxWater;
    }
}