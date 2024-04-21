class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        
        // Map array elements onto their frequencies.
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        
        // Initialize buckets maintained as an array of arraylists.
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(key); 
        }
        
        // Fetch the top k frequent elements from the buckets.
        int[] res = new int[k];
        int resIdx = 0;
        for (int bucket_idx = buckets.length - 1; bucket_idx > 0 && resIdx < k; bucket_idx--) {
            if (buckets[bucket_idx] != null) {
                for (int num : buckets[bucket_idx]) {
                    res[resIdx++] = num;
                    if (resIdx == k) {
                        return res;
                    }
                }
            }
        }
        
        return null;
    }
}