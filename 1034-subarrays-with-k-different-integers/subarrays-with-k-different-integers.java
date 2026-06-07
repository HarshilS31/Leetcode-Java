class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countUnique(nums,k)-countUnique(nums,k-1);


    }
    public int countUnique(int[] nums, int k) {
        int count =0;
        int n=nums.length;
        int left=0;
        int unique=0;
        if(k<0) return 0;
        int[] freq = new int[n+1];
        for(int right=0;right<n;right++) {
            if(freq[nums[right]]==0) unique++;
            freq[nums[right]]++;
           
            while(unique>k) {
                freq[nums[left]]--;
                if(freq[nums[left]]==0)  unique--;   
                left++;  
            }
            
            count+=right-left+1;
        }
        return count;

    }
} 