class Solution {
    public int removeElement(int[] arr, int val) {
        int i=0,j=arr.length;
        while(i<j) {
            if(arr[i]==val) {
                arr[i]=arr[j-1];
                j--;  
            }
            else i++;
        }
        return i;


        
        

        
    }
}