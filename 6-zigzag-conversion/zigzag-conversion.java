class Solution {
    public String convert(String s, int numRows) {
        ArrayList<Character>[] zig_zag = new ArrayList[numRows];
        if (numRows == 1 || s.length() <= numRows) return s;
        int row=0;
        for(int i=0;i<numRows;i++) zig_zag[i] = new ArrayList<>();
        boolean  down = true;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            zig_zag[row].add(ch);
            if(row == 0) down=true;
            else if(row==numRows-1) down=false;
            row+= down ? 1 : -1;
   
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<numRows;i++) {
            for(char ch : zig_zag[i]) res.append(ch);
        }
        return res.toString();
    }
}