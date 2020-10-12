class Solution {
    public int numTeams(int[] ratings) {
        
        if(ratings.length < 3){
            return 0;
        }
        
        int numberOfTeams = 0;
        
        for(int i = 0; i < ratings.length; i++){
            
            for(int j = i + 1; j < ratings.length; j++){
                
                for(int k = j + 1; k < ratings.length; k++){

                    if((ratings[i] < ratings[j] && ratings[j] < ratings[k])|| 
                       (ratings[i] > ratings[j] && ratings[j] > ratings[k])){
                        numberOfTeams++;
                    }                    
                }
            }            
        }
        
        return numberOfTeams;        
    }
}
