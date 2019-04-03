package 图论;

import java.util.*;


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Q133_clone_graph {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        //出现重复的节点,终止剪枝
        if (map.containsKey(node)) return map.get(node);
        //进行旧新映射
        Node temp = new Node(node.val, new ArrayList<>());
        map.put(node, temp);
        for (Node near : node.neighbors) temp.neighbors.add(cloneGraph(near));
        return temp;
    }
}
