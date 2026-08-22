class Solution {
    public int[] sortArray(int[] nums) {
        int n= nums.length;
        mergeSort(0,n-1,nums);
        return nums;
    }
    public void mergeSort(int left,int right,int[] nums) {
        if(left>=right) return;
        int mid = left + (right-left)/2;
        mergeSort(left,mid,nums);
        mergeSort(mid+1,right,nums);
        merge(left,mid,right,nums);
    }
    public void merge(int left,int mid,int right,int[] nums) {
        int n1 = mid -left +1;
        int n2 = right-mid;
        int[] L= new int[n1];
        int[] R= new int[n2];
        System.arraycopy(nums,left,L,0,n1);
        System.arraycopy(nums,mid+1,R,0,n2);
        int i=0,j=0,k=left;
        while(i<n1 && j<n2) {
            if(L[i]<R[j]) nums[k]=L[i++];
            else nums[k]=R[j++];
            k++;
        }
        while(i<n1) nums[k++] =L[i++];
        while(j<n2) nums[k++] = R[j++];
    }
}