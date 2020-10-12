class Solution {
    public int countOdds(int low, int high) {
        // If low and high are both odd
        if(low % 2 != 0 && high % 2 != 0){
            return ((high - low) / 2) + 1;
        }
        // If low and high are both even.
        else if(low % 2 == 0 && high % 2 == 0){
            return (high - low) / 2;
        }
        // Mixed
        else{
            return ((high - low) / 2) + 1;
        }
    }
}
