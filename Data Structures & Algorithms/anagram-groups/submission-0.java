class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            //sort
            char[] charToArray = str.toCharArray();
            Arrays.sort(charToArray);
            String sorted = String.valueOf(charToArray);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }
        
        //group by ascii 
        // List<List<String>> result = new ArrayList<>();
        // for(Map.Entry entry:map.entrySet()){
        //     result.add(entry.getValue());

        // }
        return new ArrayList<>(map.values());

    }
}
