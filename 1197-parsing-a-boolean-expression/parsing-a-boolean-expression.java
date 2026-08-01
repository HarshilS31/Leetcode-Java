class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> s = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ',') continue;
            if (c != ')') {
                s.push(c);
            } else {
                ArrayList<Character> arr = new ArrayList<>();
                while (s.peek() != '(') arr.add(s.pop());
                s.pop(); 
                char operator = s.pop();
                s.push(solveExpression(operator, arr));
            }
        }
        return s.peek() == 't';
    }

    public char solveExpression(char operator, ArrayList<Character> arr) {
        char res;
        if (operator == '&') {
            res = 't';
            for (char e : arr) {
                if (e == 'f') { res = 'f'; break; }
            }
        } else if (operator == '|') {
            res = 'f';
            for (char e : arr) {
                if (e == 't') { res = 't'; break; }
            }
        } else {
            res = (arr.get(0) == 't') ? 'f' : 't';
        }
        return res;
    }
} 