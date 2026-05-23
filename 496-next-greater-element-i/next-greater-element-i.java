class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge=new int[nums1.length];
        HashMap<Integer,Integer> n1= new HashMap<>();
        for(int i=0;i<nums1.length;i++) {
            n1.put(nums1[i],i);
        }
        Stack<Integer> temp= new Stack<>();

       
        for(int i=nums2.length-1;i>=0;i--) {
            while(temp.size()>0 && nums2[i]>temp.peek()) {
                temp.pop();
            }
            if(n1.containsKey(nums2[i])) {
                nge[n1.get(nums2[i])]= temp.size()>0? temp.peek():-1;
            }
            temp.push(nums2[i]);
        }

        
        return nge;
    }

}