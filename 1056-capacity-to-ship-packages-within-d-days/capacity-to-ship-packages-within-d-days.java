class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo=0;
        int hi=0;
        for(int ele:weights) {
            lo=Math.max(lo,ele);
            hi+=ele;    
        }
        int ans=hi;
        while(hi>=lo) {
            int mid=lo+(hi-lo)/2;
            if(canShip(weights,days,mid)) {
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }
        return ans;

    }
    public boolean canShip(int[] weights,int days,long val) {
        int day=1;
        int load=0;
        for(int w:weights) {
            if(w+load>val) {
                day++;
                load=0;
            }
            load+=w;
        }
        return (day<=days);


    }
}