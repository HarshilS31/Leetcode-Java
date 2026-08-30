class Solution {
    public int[] singleNumber(int[] nums) {
        // Brute force
        int[] res = new int[2];
        int idx=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key : map.keySet()) {
            if(map.get(key)==1) res[idx++]=key;
            if (idx==2) break;
        }
        return res;
        
    }
}