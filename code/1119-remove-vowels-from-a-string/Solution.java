class Solution {
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0; i < s.length(); i++){
            if(false == isVowl(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
               
        return sb.toString();
    }
    
    private boolean isVowl(char character){
        populateVowels();
                
        return _vowls.containsKey(character);
    }
    
    private void populateVowels(){
        if(null == _vowls){
            _vowls = new HashMap<Character, Object>(5);
            // Apparently we don't need to account for
            // capitals
            _vowls.put('a', null);
            //_vowls.put('A', null);
            _vowls.put('e', null);
            //_vowls.put('E', null);
            _vowls.put('i', null);
            // _vowls.put('I', null);
            _vowls.put('o', null);
            //_vowls.put('O', null);
            _vowls.put('u', null);
            //_vowls.put('U', null);
        }
    }
    
    private static HashMap<Character, Object> _vowls = null;
}
