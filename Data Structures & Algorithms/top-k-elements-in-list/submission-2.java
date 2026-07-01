class Solution {
    //top k elements needs to be printed
    //[(1,1)(2,2)(3,3),(4,3)]
    //[()]
    public int[] topKFrequent(int[] nums, int k) {



        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // getOrDefault handles the 'if-else' check cleanly in one line
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Keep a min-heap of size k based on frequencies
        // The element with the lowest frequency stays at the top (peek) of the heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int num : map.keySet()) {
            heap.add(num);
            // If the heap grows larger than k, kick out the least frequent element
            if (heap.size() > k) {
                heap.poll(); 
            }
        }

        // 3. Convert the heap elements into the final result array
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll();
        }

        return res;
    }
}
    
