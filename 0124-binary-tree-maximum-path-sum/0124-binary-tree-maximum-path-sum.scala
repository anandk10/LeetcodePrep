/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {

    var res = 0

    def dfs(root: TreeNode): Int = {

        if (root == null) return 0;

        // consider the current node i.e. the root as the splitting point
        // in the max path sum, the current node needs to know what's the
        // max path sum of its left and right subtree without splitting

        var leftMax = dfs(root.left)
        var rightMax = dfs(root.right)

        // since we want the max path sum, we dont need negative values
        // so, lets insulate against the negative values
        import scala.math._
        leftMax = max(leftMax, 0)
        rightMax = max(rightMax, 0)

        // lets compute the max path sum WITH splitting
        // to note the maximum possible path
        var currMax = root.value + leftMax + rightMax
        res = max(currMax, res)

        // lets compute the max path sum WITHOUT splitting
        // because that what our caller node wants from this node
        root.value + max(leftMax, rightMax)
    }

    def maxPathSum(root: TreeNode): Int = {
        res = root.value
        dfs(root)
        res
    }
}