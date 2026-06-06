class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int totalSum=0;
        int windowSum=0;
        for(int num:cardPoints) totalSum+=num;
        if(k==n) return totalSum;
        for(int i=0;i<(n-k);i++) windowSum+=cardPoints[i];
        int score=totalSum-windowSum;
        int left=0;
        int right=n-k;
        while(right<n) {
            windowSum+=(cardPoints[right]-cardPoints[left]);
            score=Math.max(score,totalSum-windowSum);
            left++;
            right++;
        }
        return score;
    }
}