/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
class CustomStack {
    
    private List<Integer> _stack = null;
    private int _maxSize;

    public CustomStack(int maxSize) {
        _stack = new ArrayList(maxSize);
        _maxSize = maxSize;
    }
    
    public void push(int x) {
        if(_stack.size() < _maxSize){
            _stack.add(x);
        }
    }
    
    public int pop() {
        if(_stack.size() == 0){
            return -1;
        }
        return _stack.remove(_stack.size() - 1);
    }
    
    public void increment(int k, int val) {
        if(_stack.size() < k){
            k = _stack.size();
        }
        
        for(int i = 0; i < k; i++){
            _stack.set(i, _stack.get(i) + val);
        }
    }
}
