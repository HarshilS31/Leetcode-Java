class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0]!=1) arr[0]=1;
        for(int i=1;i<arr.length;i++) {
            if(arr[i]-arr[i-1]>1) arr[i]=arr[i-1]+1;
        }
        int max=Integer.MIN_VALUE;
        for(int num:arr) {
            max=Math.max(num,max);

        }
        return max;     
    }
}