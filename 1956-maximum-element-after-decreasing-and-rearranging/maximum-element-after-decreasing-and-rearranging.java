class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==1 && i!=0) {
                int temp=arr[0];
                arr[0]=arr[i];
                arr[i]=temp;    
            }
        }
        Arrays.sort(arr);
        if(arr[0]!=1) arr[0]=1;
        for(int i=1;i<arr.length;i++) {
            // if(arr[i-1]-arr[i]>1) {
            //     arr[i]=arr[i-1]+1;
            // }
            if(arr[i]-arr[i-1]>1) arr[i]=arr[i-1]+1;
        }
        int max=Integer.MIN_VALUE;
        for(int num:arr) {
            max=Math.max(num,max);

        }
        return max;     
    }
}