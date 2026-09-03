class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int minOdd = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(nums1[i]%2!=0) minOdd = Math.min(minOdd,nums1[i]);  
        }
        boolean evenPossible = true;
        for(int i=0;i<n;i++) {
            if(nums1[i]%2!=0) {
                if((nums1[i]-minOdd)<1) {
                    evenPossible = false;
                    break;
                }
            } 
        }
        if(evenPossible) return true;
        boolean oddPossible = true;
        for(int i=0;i<n;i++) {
            if(nums1[i]%2==0) {
                if((nums1[i]-minOdd)<1) {
                    oddPossible = false;
                    break;
                }
            } 
        }
        if(oddPossible) return true;
        return false;

        
    }
}