#! usr/bin/env python3
from queue import Queue


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if root is None:
            return "[]"
        ans = []
        q = Queue()
        q.put(root)
        while not q.empty():
            tmp = q.get()
            if tmp is None:
                ans.append('null')
            else:
                ans.append(str(tmp.val))
                q.put(tmp.left)
                q.put(tmp.right)
        while ans[-1] is 'null':
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
        q = Queue()
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


if __name__ == '__main__':
    # Your Codec object will be instantiated and called as such:

    #  "[1,2,3,null,null,4,5]"
    root1 = TreeNode(1)
    root2 = TreeNode(2)
    root3 = TreeNode(3)
    root4 = TreeNode(4)
    root5 = TreeNode(5)

    root1.left = root2
    root1.right = root3

    root3.left = root4
    root3.right = root5

    codec = Codec()

    serialized = codec.serialize(root1)
    deserialized = codec.deserialize(serialized)
    print(deserialized)
