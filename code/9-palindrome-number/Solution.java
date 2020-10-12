class Solution {
    public boolean isPalindrome(int x) {
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        
        if(x < 0){
            reversed += "-";
        }
        
        String current = new Integer(x).toString();
        
        return current.equals(reversed);
    }
}

