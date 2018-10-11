package offer.tree;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 规则：
 * 1.当该结点有右子树，则从右子树出发沿着指向左子结点的指针一直找，直到该指针为null
 * 2.当该结点无右子树且该结点是父结点的左子树，则父节点为下一个结点
 * 3.当该节既没有右子树，也不是父节点的左子树，我们可以沿着指向父节点的指针一直向上遍历，直到找到一个结点，该节点是它父指针的左子结点，
 * 则该节点的父结点为下一个结点
 *
 * 2,3可以合并成一种，找左子结点的情况
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode pParent = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class _58_GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)return null;
        if(pNode.right!=null){
            pNode=pNode.right;
            while(pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }
        while(pNode.pParent !=null){
            if(pNode.pParent.left==pNode)return pNode.pParent;
            pNode=pNode.pParent;
        }
        return null;
    }
}
