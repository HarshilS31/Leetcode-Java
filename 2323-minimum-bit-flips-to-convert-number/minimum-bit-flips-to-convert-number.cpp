class Solution {
public:
    int minBitFlips(int start, int goal) {
        int res = start ^ goal;
        int flips=0;
        while(res>1) {
            flips+=(res&1);
            res >>=1;
        }
        if(res==1) flips++;
        return flips;
    }
};