class MinStack {
    private ArrayList<Integer> arr;
    private ArrayList<Integer> minVals = new ArrayList<>();
    private int minVal = Integer.MAX_VALUE;
    public MinStack() {
        arr = new ArrayList<>();
    }
    public void push(int value) {
        arr.add(value);
        if(minVals.size() == 0 || value <= minVals.get(minVals.size()-1)) minVals.add(value);
        
    }
    public void pop() {
       if (arr.get(arr.size() - 1).equals(minVals.get(minVals.size() - 1))) minVals.remove(minVals.size()-1);
        arr.remove(arr.size()-1);
    }
    
    public int top() {
        return arr.get(arr.size()-1);
        
    }
    public int getMin() {
        return minVals.get(minVals.size()-1);
    }
}
