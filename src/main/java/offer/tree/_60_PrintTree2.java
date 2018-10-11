package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class _60_PrintTree2 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>lists=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null){
            return lists;
        }
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();

        queue.offer(pRoot);
        TreeNode last=pRoot;//last标志换行
        TreeNode nextLast=pRoot;//记录下一行的换行标志
        ArrayList<Integer>list=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            //入队
            if(node.left!=null){
                queue.offer(node.left);
                nextLast=node.left;
            }
            if(node.right!=null){
                queue.offer(node.right);
                nextLast=node.right;
            }

            //当node为last标志换行，同时更新下一行的换行标志
            if(node==last){
                lists.add(list);
                list=new ArrayList<Integer>();
                last=nextLast;
            }

        }

    /*  int n=lists.size();
      int[][]res=new int[n][];
      for(int i=0;i<n;i++){
          res[i]=new int[lists.get(i).size()];
          for(int j=0;j<lists.get(i).size();j++){
              res[i][j]=lists.get(i).get(j);
          }
      }
      */

        return lists;
    }
}
