package ArrayAndString;

public class N3_LongestSubstringWithoutDuplicate {
    public static void main(String[] args) {

        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        //双指针
        int left = 0;
        int right = 0;
        int len = 0;


        for(left = 0;left<s.length();left++){
            for (right = left+1; right < s.length(); right++) {
                String substring = s.substring(left,right);
                if (substring.indexOf(s.charAt(right))>=0 && substring.indexOf(s.charAt(right))<right){
                    len = Math.max(right-left,len);
                    break;
                }
            }
            len = Math.max(right-left,len);
        }
        return len;
    }
}
