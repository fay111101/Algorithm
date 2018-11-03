package leetcode.graph;
/**
 * 克隆一张无向图，图中的每个节点包含一个 label （标签）和一个 neighbors （邻接点）列表 。

 OJ的无向图序列化：

 节点被唯一标记。

 我们用 # 作为每个节点的分隔符，用 , 作为节点标签和邻接点的分隔符。

 例如，序列化无向图 {0,1,2#1,2#2,2}。

 该图总共有三个节点, 被两个分隔符  # 分为三部分。

 第一个节点的标签为 0，存在从节点 0 到节点 1 和节点 2 的两条边。
 第二个节点的标签为 1，存在从节点 1 到节点 2 的一条边。
 第三个节点的标签为 2，存在从节点 2 到节点 2 (本身) 的一条边，从而形成自环。
 我们将图形可视化如下：

 1
 / \
 /   \
 0 --- 2
 / \
 \_/

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*https://www.programcreek.com/2012/12/leetcode-clone-graph-java*/
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new
                ArrayList<UndirectedGraphNode>();
    }
};

public class _133_CloneGraph {
    //bfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<Integer, UndirectedGraphNode> map = new HashMap();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        queue.offer(node);
        map.put(node.label, newHead);

        while (!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.poll();
            ArrayList<UndirectedGraphNode> tempNeighbors = temp.neighbors;
            for (UndirectedGraphNode graphnode : tempNeighbors) {
                if (!map.containsKey(graphnode.label)) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode
                            (graphnode
                                    .label);
                    map.get(temp.label).neighbors.add(newNode);
                    queue.offer(graphnode);
                    map.put(graphnode.label, newNode);
                } else {
                    map.get(temp.label).neighbors.add(map.get(graphnode
                            .label));
                }

            }
        }
        return newHead;

    }
}
