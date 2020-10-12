public class Solution {
    public int NumJewelsInStones(string J, string S) {
        bool[] jewels = categorize(J);
        int numberOfJewels = 0;
        
        for(int i = 0; i < S.Length; i++){
            if( true == jewels[(int)S[i]]){
                numberOfJewels ++;
            }
        }
        
        return numberOfJewels;
    }
    
    private bool[] categorize(string s){
        
        // Assumme 256 characters.
        bool[] stones = new bool[256];
        
        for( int i = 0; i < s.Length; i++){
            stones[(int)s[i]] = true;
        }
        
        return stones;
    }
}
