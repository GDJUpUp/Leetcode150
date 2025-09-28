package Hot100.TwoPointers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class N42_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(monotonicStackTrap(height));
        int[] height2 = {4,2,0,3,2,5};
        System.out.println(monotonicStackTrap(height2));
    }

    public int trap(int[] height) {
//        return dynamicProgrammingTrap(height);
//        return monotonicStackTrap(height);
        return twoPointersDynamicProgrammingTrap(height);
    }

    public static int dynamicProgrammingTrap(int[] height) {
        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        leftmax[0] =  height[0];
        rightmax[height.length-1] =  height[height.length-1];
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            leftmax[i] = Math.max(leftmax[i-1], height[i]);
        }
        for (int i = height.length-2; i >=0 ; i--) {
            rightmax[i] = Math.max(rightmax[i+1], height[i]);
        }
        for (int i = 1; i < height.length; i++) {
            ans = ans+Math.min(leftmax[i], rightmax[i])-height[i];
        }
        return ans ;
    }


    public static int monotonicStackTrap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i);
            }else  {
                while(!stack.isEmpty()&&height[stack.peek()]<height[i] ){
                    int bottom = stack.pop();
                    if (stack.isEmpty() ) {
                        break;
                    }else {
                        ans += (i-stack.peek()-1)*(Math.min(height[stack.peek()], height[i])-height[bottom]);
                    }
                }
                stack.push(i);
            }
        }
        return ans;
    }


    public static int twoPointersDynamicProgrammingTrap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        int leftmax = height[left];
        int rightmax = height[right];
        while (left < right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if (leftmax < rightmax) {


                ans += leftmax-height[left];
//                System.out.println("->");
//                System.out.println("left:"+left);
//                System.out.println("right:"+right);
//                System.out.println("leftmax:"+leftmax);
//                System.out.println("rightmax:"+rightmax);
//                System.out.println("ans:"+ans);
//                System.out.println("---------------");
                left++;

            }else  {

                ans += rightmax-height[right];
//                System.out.println("<-");
//                System.out.println("left:"+left);
//                System.out.println("right:"+right);
//                System.out.println("leftmax:"+leftmax);
//                System.out.println("rightmax:"+rightmax);
//                System.out.println("ans:"+ans);
//                System.out.println("---------------");
                right--;
            }
        }
        return ans;

    }
}
