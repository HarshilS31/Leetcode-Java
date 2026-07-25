class Solution {
    public int hIndex(int[] citations) {
        int h_index=0;
        for(int i=1;i<=citations.length;i++) {
            int currCitations=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=i) currCitations++;
            }
            if(currCitations>=i) h_index=i;
        } 
        return h_index;

       
    }

}