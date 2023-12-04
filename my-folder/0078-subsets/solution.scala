object Solution {
    def subsets(nums: Array[Int]): List[List[Int]] = {

        var res: List[List[Int]] = List()
        var subset: List[Int] = List()

        def dfs(i: Int) : Unit = {

            if (nums.length == i) {
                // println("Adding " + subset + " to " + res)
                res = res.appended(subset)
                return
            }

            // println("Before adding " + nums(i) + ": " + subset)
            // include this number
            subset = subset.appended(nums(i))
            dfs(i + 1)
            // println("After adding " + nums(i) + ": " + subset)
            // exclude this number
            subset = subset.dropRight(1)
            // println("After dropping " + nums(i) + ": " + subset)
            dfs(i + 1)
        }

        dfs(0)
        res
        
    }
}
