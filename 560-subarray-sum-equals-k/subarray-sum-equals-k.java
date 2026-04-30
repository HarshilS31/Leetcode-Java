class Solution {
    public int subarraySum(int[] arr, int k) {
        int ans = 0;
        int currSum = 0;
    // Map stores: <PrefixSum, HowManyTimesSeen>
        HashMap<Integer, Integer> map = new HashMap<>();
    
    // Crucial: A sum of 0 has been seen once (before we start)
        map.put(0, 1);
    
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            
        // If (currSum - k) exists in map, it means there's a 
        // subarray ending here that sums to k
            if (map.containsKey(currSum - k)) {
                ans += map.get(currSum - k);
            }
        
        // Record this current sum in the map
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
    
        return ans;
}    


}