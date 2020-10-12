class Solution {
    /**
     * Given a list of strings dict where all the strings are of 
     * the same length. Return True if there are 2 strings 
     * that only differ by 1 character in the same index, 
     * otherwise return False.
     * Solved this with a brute force triple nested loop
     * but haven't gone back to optimize it yet.
     */
    public boolean differByOne(String[] dict) {
        
        for(int i = 0; i < dict.length; i++){
            
            String compare = dict[i];
            
            for(int j = 0; j < dict.length; j++){
                
                String compareTo = dict[j];
                
                int numberOfDifferences = 0;
                
                for(int x = 0; x < compare.length(); x++){
                    if(compare.charAt(x) != compareTo.charAt(x)){
                        numberOfDifferences++;
                        if(numberOfDifferences > 1){
                            break;
                        }
                    }
                }

                if(numberOfDifferences == 1){
                    return true;
                }
            }
        }
        
        return false;
    }

}
