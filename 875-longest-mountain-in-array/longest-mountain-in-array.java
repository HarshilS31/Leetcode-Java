class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        if(n<=2) return 0;
        int maxLen=0;
        int i=0;
        int j=1;
        while(j<n) {
            int up=0;
            int down=0;
            while(j<n && arr[j]>arr[i]) {
                up++;
                j++;  
                i++;
                  
            }
            while(j<n && arr[j]<arr[i]) {
                down++;
                j++;
                i++;
                
            }
            while(j<n && arr[i]==arr[j]) {
                j++;
                i++;
                
            }
            if(up==0 || down==0) continue;
            maxLen=Math.max(maxLen,up+down+1);
        }
        return maxLen;


        
    }
}