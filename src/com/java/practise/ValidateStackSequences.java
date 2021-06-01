class ValidateStackSequences{
    /*
    Leet code#946
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /*
        Approach is using a stack to track both push and pop arrays
        */

        Stack <Integer> st = new Stack<Integer>();
        int i=0;
        int j=0;

        while(i < pushed.length){
            while(!st.empty() && (j < i)){
                if(st.peek() == popped[j]){
                    st.pop();
                    j++;
                }else
                    break;
            }

            st.push(pushed[i]);
            i++;
        }

        while(!st.empty()){
            if(st.peek() == popped[j]){
                st.pop();
                j++;
            }
            else
                return false;
        }

        return true;
    }

}