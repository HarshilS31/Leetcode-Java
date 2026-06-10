class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<asteroids.length;i++) {
            int a =asteroids[i];
            if(a>0) {
                s.push(a);
            }
            else {
                boolean destroyed=false;
                while(s.size()>0 && s.peek()>0) {
                    if(Math.abs(a)>s.peek()) s.pop();
                    else if(a+s.peek()==0) {
                        destroyed=true;
                        s.pop();
                        break;
                    }
                    else {
                        destroyed=true;
                        break;

                    }
                }
                if(!destroyed) s.push(a);
            }
        }
        int[] ans= new int[s.size()];
        for(int i=ans.length-1;i>=0;i--) {
            ans[i]=s.pop();

        }
        return ans;
    }
}