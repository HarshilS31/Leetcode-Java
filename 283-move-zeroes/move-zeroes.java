class Solution {  
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int temp=0;

        for(int i =1;i<=n;i++) {
            for (int j=1;j<=n-1;j++) {
                if(nums[j-1]==0) {
                    temp=nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                }
            }
        
        } 
        
    }
}