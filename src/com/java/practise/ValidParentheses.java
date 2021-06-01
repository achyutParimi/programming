
/*
Leet Code #20
Key Words: HashMap & Stack
 */
class ValidParanthesis{
    public boolean isValid(String s) {

        if(s == null) return false;
        if(s.length()<2) return false;


        //Approach is to create a Map of Valid Pairs( key, value)
        //Stack to track the order

        HashMap<Character, Character> hMap = new HashMap<Character, Character>();
        Stack<Character> st = new Stack<Character>();

        hMap.put('(', ')');
        hMap.put('{', '}');
        hMap.put('[', ']');



        for(int i=0; i < s.length(); i++)
            if(hMap.containsKey(s.charAt(i))){
                st.push(s.charAt(i));
            }else{
                if(!st.empty()){
                    Character c= st.pop();
                    if(hMap.get(c) != s.charAt(i))
                        return false;
                }else
                    return false;
            }

        if(!st.empty()) return false;

        return true;
    }

}