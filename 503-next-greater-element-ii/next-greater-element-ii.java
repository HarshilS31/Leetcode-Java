class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n=arr.length;
        int [] nge= new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            s.push(arr[i]);
        }
        for (int i=n-1;i>=0;i--) {
            while(s.size()>0 && arr[i]>=s.peek()) s.pop();
            if(s.size()==0) nge[i]=-1;
            else nge[i]=s.peek();
            s.push(arr[i]);
        }
        return nge;
    }
}