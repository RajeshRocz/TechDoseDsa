package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {
        System.out.println(nextGreaterElements(new int[]{1,1,1,1,1}));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int[] nextGreater=new int[n];
        Arrays.fill(nextGreater,-1);

        int[] firstGreater=new int[n];
        Stack<Integer> stack=new Stack<>();
        stack.push(n-1);
        nextGreater[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[stack.peek()]>nums[i]){
                nextGreater[i]=nums[stack.peek()];
            }else{
               while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                   stack.pop();
               }
               nextGreater[i]=stack.isEmpty()?-1:nums[stack.peek()];
            }
            stack.push(i);

        }

        stack.clear();
        stack.push(0);
        firstGreater[0]=-1;
        for(int i=1;i<n;i++){
            if(nums[stack.peek()]>nums[i]){
                firstGreater[i]=nums[stack.peek()];
            }else{
                while (!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                    stack.pop();
                }
                firstGreater[i]=stack.isEmpty()?-1:nums[stack.peek()];
                stack.push(i);
            }
        }

        for(int i=0;i<n;i++){
            if(nextGreater[i]==-1){
                nextGreater[i]=firstGreater[i];
            }
        }

        return nextGreater;
    }
}
