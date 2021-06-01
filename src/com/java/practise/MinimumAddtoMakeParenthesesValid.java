class MinimumAddtoMakeParenthesesValid{
    /*
    Leet count #921
     */
    public int minAddToMakeValid(String s) {
        //Approach use a stack to track OpenBraces(obStack)
        //if close brace comes, then we pop from the obStack
        //maintain a closedBrace count if the the stack is empty

        if(s.length() == 0) return 0;

        Stack<Character>obSt = new Stack<Character>();
        int cbCnt = 0;

        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                obSt.push('(');
            else{
                if(!obSt.empty())
                    obSt.pop();
                else
                    cbCnt++;
            }
        }

        return obSt.size() + cbCnt;

    }
}