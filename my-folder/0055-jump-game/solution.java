class Solution {

    public boolean canJump(int[] nums) {


        int goalIndex = nums.length - 1; // we have to reach here

        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (i + nums[i] >= goalIndex) // curr index + jumps
                goalIndex = i;
        }

        return goalIndex == 0;
        /**
        
            [3,3,3,3]
            |. ^. ^. |
            |. ^.   |


            [2,3,1,0,4]

            |  ^ ^ _ _
            |  ^     ^
            |  ^   _ _
            |    ^ _ _
            O(N^2)   


            Greedy - O(N)
            goalIndex = 4 (last index)
            [2,3,1,0,4]
                     i = 4
                     i + nums[4] (jumps) >= goal index
                     4 + 4 = 8 >= 4
                     i th location makes goal reachable
                     goalIndex = i
                     goalIndex = 4

            [2,3,1,0,4]
                   i = 3
                   i + nums[3] 
                   3 + 0 >= 4 -- no
                   3rd index is not making the goal

            [2,3,1,0,4]
                 i = 2
                 i + nums[2]
                 2 + 1 >= 4 -- no
                 2nd index is also not helpful

            [2,3,1,0,4]
               i = 1
               i + nums[1]
               1 + 3 >= 4 - yes
               1st index is reachable
            
                update goalIndex = i
                goalIndex = 1

            [2,3,1,0,4]
            i = 0
            i + nums[0]
            0 + 2 >= 1 - yes
            goalIndex = i
            goalIndex = 0

            Loop break, return true if goalIndex == 0
         */
        
    }
}
