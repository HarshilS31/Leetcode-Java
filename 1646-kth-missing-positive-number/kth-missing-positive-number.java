class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int ele:arr) {
            if (ele<=k) k++;
            else break;
        }
        return k;
   



        
    }
}