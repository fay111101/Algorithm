import java.util.*;

public class GraphTest {
    public class Vertex {
        public char label;
        public boolean isVisted;
        public int index;
        private ArrayList<Vertex> next = null;

        public Vertex(char lab)  // constructor
        {
            label = lab;
            isVisted = false;
        }

        //为节点添加邻接点
        public void addAdj(Vertex ver) {
            if (next == null) next = new ArrayList<Vertex>();
            next.add(ver);
        }

        public ArrayList<Vertex> getAdj() {
            return next;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String toString() {
            return "顶点 " + label + ",下标：" + index + ".";
        }
    }
    public class Graph {
        private int MAX_VERTS = 20;
        //
        private Vertex vertexList[];
        private boolean bool = false;//是否为有向图
        private int nVerts = 0;


        public Graph() {
            vertexList = new Vertex[MAX_VERTS];

        }

        public Graph(int n) {
            vertexList = new Vertex[n];


        }

        public Graph(int n, boolean is) {
            this.bool = is;
            vertexList = new Vertex[n];

        }

        //////////////////////////////////////////////
        public boolean isBool() {
            return bool;
        }

        public void setBool(boolean bool) {
            this.bool = bool;
        }

        public Vertex[] getVertexList() {
            return vertexList;
        }



        ////////////////////////////////////////////////////

        /**
         * 添加顶点
         */
        public void addVertex(Vertex vertex) {
            vertex.setIndex(nVerts);
            vertexList[nVerts] = vertex;
            nVerts++;
        }

        /**
         * 添加边
         */
        public void addEdge(int start, int end) {
            vertexList[start].addAdj(vertexList[end]);
            if (!bool) {
                vertexList[end].addAdj(vertexList[start]);
            }
        }

        /**
         * 返回节点个数
         *
         * @return
         */
        public int getVertsCount() {
            return vertexList.length;
        }



        ////////////////////////////////////////////////////////
        public void displayGraph() {
            for (int i = 0; i < vertexList.length; i++) {
                printVertx(vertexList[i]);
            }
        }

        public void printVertx(Vertex vertex) {
            ArrayList<Vertex> next = vertex.getAdj();
            if (next == null) {
                System.out.println(vertex.toString() + " 无连接点");
            } else {
                System.out.print(vertex.toString() + "有邻接点:");
                for (int i = 0; i < next.size(); i++) {
                    System.out.print("顶点" + next.get(i).label + ", ");
                }
                System.out.println();
            }
        }


        /**
         * 得到一个邻接点
         *
         * @param vertex
         * @return
         */
        public Vertex getAdjVertex(Vertex vertex) {
            ArrayList<Vertex> adjVertexs = vertex.getAdj();
            for (int i = 0; i < adjVertexs.size(); i++) {
                if (!adjVertexs.get(i).isVisted) {
                    return adjVertexs.get(i);
                }
            }
            return null;
        }


    }


    public Vertex getVertex(char c){
        return new Vertex(c);
    }

    public Graph getGraph(int nVerts,boolean bool){
        return new Graph(nVerts,bool);
    }
    /////////////////////////////////////////////////////////
    public static void bfs(Vertex root){
        Queue<Vertex> queue=new LinkedList<Vertex>();
        root.isVisted=true;
        System.out.println(root.index);
        queue.add(root);
        while(!queue.isEmpty()){
            Vertex temp=queue.remove();
            for(Vertex n : temp.getAdj()){
                if(n.isVisted==false){
                    System.out.println(n.index);
                    n.isVisted=true;
                    queue.add(n);
                }
            }
        }
    }
    public static void dfs(Vertex root){
        if(root==null) return;
        System.out.println(root.index);
        root.isVisted=true;
        for(Vertex n : root.getAdj()){
            if(n.isVisted==false){
                dfs(n);
            }
        }
    }
    public static void main(String[] args) {
        int nVerts = 10;
        int c = 'A' - 1;
        GraphTest.Vertex vertex;
//        GraphTest.Graph myGraph = new GraphTest.Graph(nVerts, false);
        GraphTest.Graph myGraph = new GraphTest().getGraph(nVerts,false);
        for (int i = 0; i < nVerts; i++) {
            c++;
            vertex = new GraphTest().getVertex((char)c);
            myGraph.addVertex(vertex);
        }
        myGraph.addEdge(0, 1);
        myGraph.addEdge(0, 4);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(4, 6);
        myGraph.addEdge(5, 8);
        myGraph.addEdge(6, 7);
        myGraph.addEdge(7, 8);
        myGraph.addEdge(8, 9);
        GraphTest.Vertex root=myGraph.getVertexList()[0];
//        GraphTest.dfs(root);
        GraphTest.bfs(root);


    }
}
