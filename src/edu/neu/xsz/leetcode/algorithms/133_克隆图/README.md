# Question

[question address](https://leetcode-cn.com/problems/clone-graph/)

# code

use Map and depth-first-search

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (!map.containsKey(node.val)) { // 如果不在字典里
            Node newOne = new Node(node.val);
            map.put(node.val, newOne);

            for (Node old : node.neighbors) 
                newOne.neighbors.add(cloneGraph(old));
        }
        return map.get(node.val);
    }
}

```
