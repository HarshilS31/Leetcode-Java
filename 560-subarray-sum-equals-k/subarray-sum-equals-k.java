class Solution {
    public int subarraySum(int[] arr, int k) {
        
        int n=arr.length;
        if(n==1) {
            if(arr[0]==k) return 1;
            else return 0;
            
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += arr[j];
                if (currSum == k) {
                ans++; 

        }
    }
}

        return ans;
    }
}