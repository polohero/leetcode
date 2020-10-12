class Solution {
    public int maxPower(String s) {
        
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        
        int max = 1;
        int currentCount = 1;
        
        // Just something that shouldn't be able to be 
        // hit since we're constrained to
        // lowercase numbers. 
        char previous = 'A';
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(previous == c){
                currentCount++;
            }
            else{
                currentCount = 1;
                previous = c;
            }
            max = Math.max(max, currentCount);
        }
        
        return max;        
    }
}
