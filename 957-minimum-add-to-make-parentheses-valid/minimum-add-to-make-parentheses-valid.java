class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;
        int closeNeeded = 0;
        for(char ch : s.toCharArray()) {
            if(ch=='(') openNeeded++;
            else {
                if(openNeeded>0) openNeeded--;
                else closeNeeded++;
            }      
        }
        return openNeeded+closeNeeded;  
    }
}