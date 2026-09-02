class Solution {
    public boolean uniformArray(int[] nums1) {
        int n= nums1.length;
        if(n==1) return true;
        int[] nums2 = new int[n]; 
        boolean evenPossible = true;
        boolean oddPossible = true;
        for(int i=0;i<n;i++) {
            if(nums1[i]%2==0) {
                nums2[i]=2;
            }
            else {
                for(int j=0;j<n;j++) {
                    if(j==i) continue;
                    if((nums1[i]-nums1[j])%2==0) {
                        nums2[i]=2;
                        break;
                    }
                }
            }
        }
        for(int k : nums2) {
            if(k!=2) evenPossible=false;  
        }
        if(evenPossible) return true;
        Arrays.fill(nums2,0);
        for(int i=0;i<n;i++) {
            if(nums1[i]%2==1) {
                nums2[i]=1;
            }
            else {
                for(int j=0;j<n;j++) {
                    if(j==i) continue;
                    if((nums1[i]-nums1[j])%2!=0) {
                        nums2[i]=1;
                        break;
                    }
                }
            }
        }
        for(int k : nums2) {
            if(k!=1) oddPossible=false;  
        }
        return oddPossible;
  
    }
}