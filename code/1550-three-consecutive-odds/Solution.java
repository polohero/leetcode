class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        
        int currentCount = 0;
        
        for(int i = 0; i < arr.length; i++){
            currentCount =
                arr[i] % 2 == 0
                    ? 0
                    : currentCount + 1;
            
            if(currentCount == 3){
                return true;
            }
        }
        
        return false;
    }
}
