class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        if(arr.length == 1){
            return true;
        }
        
        HashMap<Integer, Integer> groupByValue = 
            new HashMap<Integer, Integer>();
        
        for(int val : arr){
             groupByValue.put(val, 1 + groupByValue.getOrDefault(val, 0));
        }
        
        HashSet<Integer> occurrences = 
            new HashSet<Integer>(groupByValue.values());
        
        return occurrences.size() == groupByValue.size();
    }
}
