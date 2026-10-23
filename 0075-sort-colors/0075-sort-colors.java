class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int low=0; int mid=0; int high=n-1;
        while(mid<=high){
            if(nums[mid]==0){
                // swap(nums[mid],nums[low]);
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                // swap(nums[mid],nums[high]);
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
}