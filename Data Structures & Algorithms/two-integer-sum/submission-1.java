class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        // for(int i=0; i<nums.length ; i++){
            
        //     for(int j=i+1; j< nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             res[0] = i;
        //             res[1] = j;
        //             return res;
        //         }

        //     }

        // }
        // return res;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            map.put(nums[i], i);
        }

        //iterate map
        for(int i=0; i < nums.length ; i++){
            int val = target - nums[i];
            if(map.containsKey(val) && map.get(val) != i){
                res[0] = i;
                res[1] = map.get(val);
                return res;
            }
        }
    return res;
    }
}
