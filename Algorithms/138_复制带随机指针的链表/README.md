
此解答和 [133克隆图](../133_克隆图)一个套路

```java
class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (!map.containsKey(head)){
            Node newOne = new Node(head.val);
            map.put(head, newOne); // map.put 要写在前面
            
            newOne.next = copyRandomList(head.next);
            newOne.random = copyRandomList(head.random);

        }
        return map.get(head);
    }

}
```
