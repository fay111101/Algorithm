package leetcode.graph;
/*
Clone an undirected graph. Each node in the graph contains alabeland a list of
itsneighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.
We use#as a separator for each node, and,as a separator for node label and each
neighbor of the node.

As an example, consider the serialized graph{0,1,2# 1,2# 2,2}.
The graph has a total of three nodes, and therefore contains three parts as
separated by#.
First node is labeled as0. Connect node0to both nodes1and2.
Second node is labeled as1. Connect node1to node2.
Third node is labeled as2. Connect node2to node2(itself), thus forming a
self-cycle.

Visually, the graph looks like the following:
       1
      / \
     /   \
    0 --- 2
         / \
         \_/*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/*https://www.programcreek.com/2012/12/leetcode-clone-graph-java*/
class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new
             ArrayList<UndirectedGraphNode>(); }
 };

public class CloneGraph {
    //bfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        HashMap<Integer,UndirectedGraphNode> map=new HashMap();
        UndirectedGraphNode newHead=new UndirectedGraphNode(node.label);
        queue.offer(node);
        map.put(node.label,newHead);
        while(!queue.isEmpty()){
            UndirectedGraphNode temp=queue.poll();
            ArrayList<UndirectedGraphNode> tempNeighbors=temp.neighbors;
            for(UndirectedGraphNode graphnode:tempNeighbors){
                if(!map.containsKey(graphnode.label)){
                    UndirectedGraphNode newNode=new UndirectedGraphNode
                            (graphnode
                            .label);
                    map.get(temp.label).neighbors.add(newNode);
                    queue.offer(graphnode);
                    map.put(graphnode.label,newNode);
                }else{
                    map.get(temp.label).neighbors.add(map.get(graphnode
                            .label));
                }

            }
        }
        return newHead;

    }
}
