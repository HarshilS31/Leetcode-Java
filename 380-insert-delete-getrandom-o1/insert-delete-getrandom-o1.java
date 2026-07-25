class RandomizedSet {
    private ArrayList<Integer> list;
    private Map<Integer,Integer> map;
    private Random r;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;     
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        int lastElement = list.get(list.size()-1);    
        list.set(idx,lastElement);
        map.put(lastElement,idx);
        list.remove(list.size()-1);
        map.remove(val);
        return true; 
    }
    
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
        
    }
}
