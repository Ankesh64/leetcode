class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        // for (int i = 0; i<n; i++){
        //     int count = 1;
        //     for(int j=i+1; j<n; j++){
        //         if(nums[i]==nums[j]){
        //             count+=1;
        //         }
        //     }
        //     if(count>=n/2){
        //         return nums[i];
        //     }
        // }
        // return -1;

        int count=0;
        int candidate=0;
        for(int i=0; i<n; i++){
            if(count==0){
                candidate = nums[i];
            }
            if(nums[i]==candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}