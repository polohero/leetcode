class SolutionOne {
    public String reformat(String s) {
        
        final String EMPTY = "";
        
        if(null == s){
            throw new NullPointerException("The string cannot be null.");
        }
        if(0 == s.length()){
            return EMPTY;
        }
        
        StringBuilder sbDigits = new StringBuilder();
        StringBuilder sbLetters = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            if(true == isDigit(s.charAt(i))){
                sbDigits.append(s.charAt(i));
            }
            else{
                sbLetters.append(s.charAt(i));
            }
        }
        
        String digits = sbDigits.toString();
        String letters = sbLetters.toString();
        
        if(digits.length() == 0 && letters.length() > 1){
            return EMPTY;
        }
        if(letters.length() == 0 && digits.length() > 1){
            return EMPTY;
        }
        if(Math.abs(digits.length() - letters.length()) > 1){
            return EMPTY;
        }
        
        String larger = 
          digits.length() > letters.length()
                ? digits
                : letters;
        String smaller = 
          digits.length() > letters.length()
                ? letters 
                : digits;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < larger.length(); i++){
            if(i > smaller.length() - 1){
                sb.append(larger.charAt(i));
            }
            else{
                sb.append(larger.charAt(i));
                sb.append(smaller.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    private Boolean isDigit(char charAt){
        return Character.isDigit(charAt);
    }
    
}
