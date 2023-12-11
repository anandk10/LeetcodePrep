/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

class Codec {
    // Encodes a list of strings to a single string.
    def serialize(root: TreeNode): String = {

        import scala.collection.mutable.ListBuffer
        val result : ListBuffer[String] = ListBuffer()

        def _serialize(root: TreeNode, result: ListBuffer[String]) : Unit = {
            if (root == null) {
                result += "N"
                return
            }

            result += root.value.toString
            _serialize(root.left, result)
            _serialize(root.right, result)
        }

        _serialize(root, result)

        result.mkString(",")
    }
    
    // Decodes a single string to a list of strings.
    def deserialize(data: String): TreeNode = {
        
        val nodes: Array[String] = data.split(",")
        import scala.collection.mutable.Queue
        val queue : Queue[String] = Queue.empty[String]
        nodes.foreach(element => queue.enqueue(element))
        

        def _deserialize(queue: Queue[String]) : TreeNode = {

            if (queue.isEmpty) {
                return null;
            }

            if (queue.front.equals("N")) {
                queue.dequeue
                return null;
            }

            val node : TreeNode = TreeNode(queue.dequeue.toInt)
            node.left = _deserialize(queue)
            node.right = _deserialize(queue)
            node
        }

        _deserialize(queue)

    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = new Codec()
 * var deser = new Codec()
 * val s = ser.serialize(root)
 * val ans = deser.deserialize(s)
 */