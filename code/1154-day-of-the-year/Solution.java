class Solution {
        
    public int dayOfYear(String date) {
        
        final String SPLITTER = "-";
        
        String[] split = date.split(SPLITTER);
        
        Integer currentDays = _monthDays.get(split[1]);
        currentDays += new Integer(split[2]);
        
        if(false == split[1].equals("01") &&
           false == split[1].equals("02") &&
           _leapYears.containsKey(split[0])){
            currentDays++;
        }
           
        return currentDays;
    }
    
    private static HashMap<String, Integer> _monthDays = null;
    private static HashMap<String, Object> _leapYears = null; 
                
    public Solution(){
        
        if(null == _monthDays){
            _monthDays = new HashMap<String, Integer>(12);
            _monthDays.put("01", 0);
            _monthDays.put("02", 31);
            _monthDays.put("03", 59);
            _monthDays.put("04", 90);
            _monthDays.put("05", 120);
            _monthDays.put("06", 151);
            _monthDays.put("07", 181);
            _monthDays.put("08", 212);
            _monthDays.put("09", 243);
            _monthDays.put("10", 273);
            _monthDays.put("11", 304);
            _monthDays.put("12", 334);
        }
        
        // This is a very silly way to do 
        // leap years. There's definitely a
        // better way to do it than to hard code 
        // which years are.
        if(null == _leapYears){
            _leapYears = new HashMap<String, Object>(31);
            _leapYears.put("1904", null);
            _leapYears.put("1908", null);
            _leapYears.put("1912", null);
            _leapYears.put("1916", null);
            _leapYears.put("1920", null);
            _leapYears.put("1924", null);
            _leapYears.put("1928", null);
            _leapYears.put("1932", null);
            _leapYears.put("1936", null);
            _leapYears.put("1940", null);
            _leapYears.put("1944", null);
            _leapYears.put("1948", null);
            _leapYears.put("1952", null);
            _leapYears.put("1956", null);
            _leapYears.put("1960", null);
            _leapYears.put("1964", null);
            _leapYears.put("1968", null);
            _leapYears.put("1972", null);
            _leapYears.put("1976", null);
            _leapYears.put("1980", null);
            _leapYears.put("1984", null);
            _leapYears.put("1988", null);
            _leapYears.put("1992", null);
            _leapYears.put("1996", null);
            _leapYears.put("2000", null);
            _leapYears.put("2004", null);
            _leapYears.put("2008", null);
            _leapYears.put("2012", null);
            _leapYears.put("2016", null);
            _leapYears.put("2020", null);
        }
    }
    

}
