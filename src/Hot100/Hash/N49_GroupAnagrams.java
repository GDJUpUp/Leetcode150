package Hot100.Hash;

import java.util.*;

public class N49_GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists.toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str :strs){
            char[] charset = str.toCharArray();
            Arrays.sort(charset);
            String string = new String(charset);
            if (map.containsKey(string)){
                List<String> strings = map.getOrDefault(string,new ArrayList<String>());
                strings.add(str);
                map.put(string,strings);
            }else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(string, strings);
            }
        }
        List<List<String>> res = new ArrayList<>();
        Set<String> strings = map.keySet();
        for (String string : strings) {
            res.add(map.get(string));
        }

        return res;
    }
}
