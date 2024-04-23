class TimeMap {
    
    Map<String, List<Pair<Integer, String>>> keyMap;

    public TimeMap() {
        keyMap = new HashMap<String, List<Pair<Integer, String>>>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair<Integer, String>(timestamp, value);
        keyMap.computeIfAbsent(key, k -> new ArrayList<>()).add(pair);
    }
    
    public String get(String key, int timestamp) {
        if (!keyMap.containsKey(key)) {
            return "";
        }
        
        List<Pair<Integer, String>> list = keyMap.get(key);
        
        int left = 0;
        int right = list.size() - 1;
        int res = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            Pair<Integer, String> pair = list.get(mid);
            
            if (pair.getKey() <= timestamp) {
                res = mid;
                
                // We search the right subarray in an attempt to find a time that is closer
                // to the input timestamp.
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return (res == -1) ? "" : list.get(res).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */