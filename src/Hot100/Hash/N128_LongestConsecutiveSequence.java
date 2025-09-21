package Hot100.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N128_LongestConsecutiveSequence {
    public static void main(String[] args) {


    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxlen = 0;
        for (Integer i : set) {
            if (set.contains(i-1)){
                continue;
            }else {
                int len = 1;
                while (set.contains(i+1)){
                    len++;
                    i++;
                }
                maxlen = Math.max(maxlen,len);

            }
        }
        return maxlen;



    }
}
