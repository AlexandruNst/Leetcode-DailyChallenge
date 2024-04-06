class Solution {
    public String minRemoveToMakeValid(String s) {
        int p = s.length() - 1;
        StringBuilder pass1SB = new StringBuilder();
        int closed = 0;
        while(p >= 0){
            if(s.charAt(p) == ')'){
                pass1SB.append('(');
                closed++;
            } else if(s.charAt(p) == '('){
                if(closed > 0){
                    pass1SB.append(')');
                    closed--;
                }
            } else pass1SB.append(s.charAt(p));
            p--;
        }
        String pass1 = pass1SB.toString();

        p = pass1.length() - 1;
        StringBuilder pass2SB = new StringBuilder();
        closed = 0;
        while(p >= 0){
            if(pass1.charAt(p) == ')'){
                pass2SB.append('(');
                closed++;
            } else if(pass1.charAt(p) == '('){
                if(closed > 0){
                    pass2SB.append(')');
                    closed--;
                }
            } else pass2SB.append(pass1.charAt(p));
            p--;
        }

        String pass2 = pass2SB.toString();

        return pass2;
    }
}