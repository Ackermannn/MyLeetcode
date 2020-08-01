
https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/

层次遍历法

```java
class Solution {
    public Node connect(Node root) {
        Node layerFirst = root;
        
        while (layerFirst != null) { // 层循环
            Node newLayerFirst = null; // 存放下一层的头节点
            Node p = layerFirst;
            Node pre = null; // 保存前一节点
            while (p != null) { // 同层的每一个循环
                if (p.left!= null) {
                    if (pre!= null) pre.next = p.left;
                    else newLayerFirst = p.left;
                    pre = p.left;
                }
                if (p.right!= null){
                    if (pre!= null) pre.next = p.right;
                    else newLayerFirst = p.right;
                    pre = p.right;
                }
                p = p.next;
            }
            layerFirst = newLayerFirst; // 本层循环结束更新下一层的头节点

        }
        return root;
    }
}
```
