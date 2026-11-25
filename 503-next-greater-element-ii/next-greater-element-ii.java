class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=(2*n)-1;i>=0;i--) {
            while(!s.isEmpty() && s.peek()<=nums[i%n]) {
                s.pop();
            }
            if(s.isEmpty()) {
                res[i%n]=-1;
            }else {
                res[i%n]=s.peek();
            }
            s.push(nums[i%n]);
        }
        return res;
    }
}