class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> temp = new Stack<>();
        for(int a:arr) {
            if(a>0) temp.push(a);
            else  {
                boolean destroyed=false;
                while(temp.size()>0 && temp.peek()>0) {
                    if(Math.abs(a)>temp.peek()) temp.pop();
                    else if(a + temp.peek()==0) {
                        destroyed=true;
                        temp.pop();
                        break;
                        
                    }
                    else {
                        destroyed=true;
                        break;
                    }
                }
                if(!destroyed) temp.push(a);
            }
        }
        int n=temp.size();
        int[] ans= new int[n];
        for(int i=n-1;i>=0;i--) {
            ans[i]=temp.pop();

        }
        return ans;
        
    }
}