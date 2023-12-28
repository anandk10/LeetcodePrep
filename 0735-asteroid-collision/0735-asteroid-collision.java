class Solution {


    /**
    Stack empty : push any num

    else
        check if num is positve 
     */
    // private int[] solution1(int[] nums) {
    //     Stack<Integer> stack = new Stack<Integer>();

    //     for (int i = 0; i < nums.length;) {

            
    //         if (stack.isEmpty() || nums[i] > 0 || stack.peek() < 0) {
    //             stack.push(nums[i]);
    //             i++;
    //         } else {
    //             // if (nums[i] > 0) {
    //             //     // no collision happen
    //             //     // -ve +ve
    //             //     // +ve +ve
    //             //     stack.push(nums[i]);
    //             //     i++;
    //             // } else {

    //                 // no collision 
    //                 // -ve -ve
    //                 // if (stack.peek() < 0) {
    //                 //     stack.push(nums[i]);
    //                 //     i++;
    //                 // } else {
    //                     // collision state
                        
    //                     if (stack.peek() > Math.abs(nums[i])) {
    //                         i++; // ignore the incoming asteroid
    //                     } else if(stack.peek() == Math.abs(nums[i])){
    //                         // increment i because incoming asteroid is destroyed
    //                         // also pop from stack because the stack top is also destroyed
    //                         stack.pop();
    //                         i++;
    //                     } else {
    //                         stack.pop();
    //                     }

    //                 // }

    //             // }

    //         }

    //     }

    //     int[] result = new int[stack.size()];
    //     for (int i = result.length - 1; i >= 0; i--) {
    //         result[i] = stack.pop();
    //     }
    //     return result;
    //     // return stack.stream().mapToInt(Integer::intValue).toArray();
    // }

    private int[] solution1(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums.length;) {
            if (stack.isEmpty() || nums[i] > 0 || stack.peek() < 0) {
                stack.push(nums[i]);
                i++;
            } else {

                if (stack.peek() > Math.abs(nums[i])) {
                    i++; // ignore the incoming asteroid
                } else if(stack.peek() == Math.abs(nums[i])){
                    // increment i because incoming asteroid is destroyed
                    // also pop from stack because the stack top is also destroyed
                    stack.pop();
                    i++;
                } else {
                    stack.pop();
                }
            }

        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;

    }


    private int[] solution2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.pop();
                if (top == Math.abs(asteroid)) {
                    // Both asteroids are destroyed
                    asteroid = 0;
                    break;
                } else if (top > Math.abs(asteroid)) {
                    // Current asteroid is destroyed
                    asteroid = top;
                    break;
                }
                // Continue checking with the next asteroid in the stack
            }

            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public int[] asteroidCollision(int[] asteroids) {
        return solution2(asteroids);
    }
}