class Solution {
    
    private static HashMap<String, String> _entities = null;
    
    public String entityParser(String text) {
        
        if(null == text || 0 == text.length()){
            return text;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Loop through each character
        // and check for a starting token
        // &. If a start token is found
        // parse the entity and increment the
        // counter on the loop.
        for(int i = 0; i < text.length(); i++){
            
            char charAt = text.charAt(i);
            
            if(true == isStart(charAt)){
                i = i + parseEntity(i, text, sb) - 1;
            }
            else{
                sb.append(charAt);
            }
        }
        
        return sb.toString();        
    }
    
    private int parseEntity(int index, String text, StringBuilder sbRef){

        StringBuilder sb = null;
        
        // Loop from the index until
        // you find either a stopping token
        // or you've reached the end of the text,
        // or you've reached the max of all entites,
        // of you find a new start token
        for(int i = index; i < text.length(); i++){
                       
            char charAt = text.charAt(i);
            
           if(null == sb){
                sb = new StringBuilder();
            }
            else if(isStart(charAt)){
                break;
            }
            
            sb.append(charAt);
            
            if(isEnd(charAt) ||
               i - index >= maxLengthOfEntity()){
                break; 
            }
        }
        
        String result = sb.toString();
        
        sbRef.append(convert(result));
        
        return result.length();
    }
    
    private boolean isStart(char character){
        final char START = '&';
        
        return character == START;
    }
    
    private boolean isEnd(char character){
        final char END = ';';
        
        return character == END;
    }
    
    private int maxLengthOfEntity(){
        final int MAX = 8;
        
        return MAX;
    }
    
    private void loadEntites(){
        if(null == _entities){
            _entities =  new HashMap<String, String>(6);
            _entities.put("&quot;", "\"");
            _entities.put("&apos;", "'");
            _entities.put("&amp;", "&");
            _entities.put("&gt;", ">");
            _entities.put("&lt;", "<");
            _entities.put("&frasl;", "/");              
        }
    }
    
    private String convert(String input){
        loadEntites();
        return _entities.getOrDefault(input, input);
    }
}
