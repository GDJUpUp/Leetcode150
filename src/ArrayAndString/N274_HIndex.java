package ArrayAndString;

import java.util.Arrays;

public class N274_HIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{3,0,6,1,5};
        int[] arr2 = new int[]{1,3,1};
        System.out.println(hIndexSortByCounting(arr));
        System.out.println("=======");
        System.out.println(hIndexSortByCounting(arr2));

    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h  = 0;
        for (int i = citations.length-1; i >= 0; i--) {
            if (citations[i]>h){
                h++;
            }
        }
        return h;
    }

    public static int hIndexSortByCounting(int[] citations) {
        int[] counter = new int[citations.length+1];
        for (int citation : citations) {
            int i = citation >= citations.length ? counter[citations.length]++ : counter[citation]++;
        }
        int h = 0;
        for (int i = citations.length; i >= 0; i--) {
            h+= counter[i];
            if (h>=i){
                return i;
            }
        }
        return h;
    }
}
