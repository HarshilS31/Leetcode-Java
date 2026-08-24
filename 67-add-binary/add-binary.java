class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1,sum=0,carry=0;
        StringBuilder res = new StringBuilder();
        while(i>=0 || j>=0 || carry>0) {
            sum = carry;
            if(i>=0) sum+=a.charAt(i--)-'0';
            if(j>=0) sum+=b.charAt(j--)-'0';
            res.append(sum%2);
            carry=sum/2;
        };
        return res.reverse().toString();


        
    }
}