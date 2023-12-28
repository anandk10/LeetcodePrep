class Solution {


    /**
    Stack empty : push any num

    else
        check if num is positve 
     */
    private int[] solution1(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < nums.length;) {

            
            if (stack.isEmpty() || nums[i] > 0) {
                stack.push(nums[i]);
                i++;
            } else {
                // if (nums[i] > 0) {
                //     // no collision happen
                //     // -ve +ve
                //     // +ve +ve
                //     stack.push(nums[i]);
                //     i++;
                // } else {

                    // no collision 
                    // -ve -ve
                    if (stack.peek() < 0) {
                        stack.push(nums[i]);
                        i++;
                    } else {
                        // collision state
                        
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

                // }

            }

        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] asteroidCollision(int[] asteroids) {
        return solution1(asteroids);
    }
}