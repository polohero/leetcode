class SolutionTwo {
    public String reformat(String s) {
        
        final String EMPTY = "";
        
        if(null == s){
            throw new NullPointerException("The string cannot be null.");
        }
        if(0 == s.length()){
            return EMPTY;
        }
        if(1 == s.length()){
            return s;
        }
        
        Deque<Character> larger = new ArrayDeque<Character>(s.length());
        Deque<Character> smaller = new ArrayDeque<Character>(s.length());
        
        for(int i = 0; i < s.length(); i++){
            char charAt = s.charAt(i);
            if(true == isDigit(charAt)){
                larger.add(charAt);
            }
            else{
                smaller.add(charAt);
            }
        }
        
        // We just abitrarily picked larger and smaller
        // above, so we need to check the sizes to
        // see which one is.
        if(smaller.size() > larger.size()){
            Deque<Character> save = larger;
            larger = smaller;
            smaller = save;
        }
        
        // Just some checks that avoid looping again.
        // If we know the queues are different by
        // more than 1 then we know that
        // it's not possible.
        if(larger.size() == 0 && smaller.size() > 1){
            return EMPTY;
        }
        if(smaller.size() == 0 && larger.size() > 1){
            return EMPTY;
        }
        if(larger.size() - smaller.size() > 1){
            return EMPTY;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(null != larger.peek()){
            
            sb.append(larger.poll());
            
            if(null != smaller.peek()){
                sb.append(smaller.poll());
            }
            
        }

        return sb.toString();
    }
    
    private Boolean isDigit(char charAt){
        return Character.isDigit(charAt);
    }
    
}
