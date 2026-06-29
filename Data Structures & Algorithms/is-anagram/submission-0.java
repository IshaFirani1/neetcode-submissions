class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character,Integer> mapS = new HashMap<>();
        Map<Character,Integer> mapT = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            if(mapS.containsKey(s.charAt(i))){
                int count = mapS.get(s.charAt(i));
                mapS.put(s.charAt(i), count+1);
            }else{
                mapS.put(s.charAt(i), 1);
            }
            
        }

        for(int j=0; j < t.length(); j++){
            if(mapS.containsKey(t.charAt(j))){
                int count = mapS.get(t.charAt(j));
                mapS.put(t.charAt(j), count-1);
            }else{
                return false;
            }
        }

        for(Map.Entry<Character,Integer> entry: mapS.entrySet()){
            if(entry.getValue() != 0)
                return false;
        }
        return true;

    }
}
