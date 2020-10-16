
# QUESTION

https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/

# CODE

```python
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if root is None:
            return "[]"
        ans = []
        q = Queue() # 使用队列的层序遍历
        q.put(root)
        while not q.empty():
            tmp = q.get()
            if tmp is None:
                ans.append('null')
            else:
                ans.append(str(tmp.val))
                q.put(tmp.left)
                q.put(tmp.right)
        while ans[-1] is 'null': # 去除尾部的一堆 null
            ans.pop()
        return "[" + ",".join(ans) + "]"

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if data == "[]":
            return None
        l = data[1:-1].split(',')[::-1]
        q = Queue() # 使用队列的层序遍历
        root = TreeNode(int(l[-1]))
        q.put(root)
        l.pop()
        while len(l) > 0:
            tmp = q.get()

            if l[-1] != 'null':
                tmp.left = TreeNode(l[-1])
                q.put(tmp.left)
            else:
                tmp.left = None
            l.pop()

            if len(l) == 0:
                break
            if l[-1] != 'null':
                tmp.right = TreeNode(l[-1])
                q.put(tmp.right)
            else:
                tmp.right = None
            l.pop()
        return root

```