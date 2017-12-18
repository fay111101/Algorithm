
class BSTree<T extends Comparable<T>> {
    private BSTNode<T> mRoot;

    public class BSTNode<T extends Comparable<T>> {
        T key;
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;

        public BSTNode(T key, BSTNode<T> left, BSTNode<T> right,
                       BSTNode<T>
                               parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public BSTNode<T> getLeft() {
            return left;
        }

        public void setLeft(BSTNode<T> left) {
            this.left = left;
        }

        public BSTNode<T> getRight() {
            return right;
        }

        public void setRight(BSTNode<T> right) {
            this.right = right;
        }

        public BSTNode<T> getParrent() {
            return parent;
        }

        public void setParrent(BSTNode<T> parrent) {
            this.parent = parrent;
        }
    }

    private BSTNode<T> search(BSTNode<T> x, T key) {
        if (x == null) {
            return x;
        }
        int compareT = key.compareTo(x.key);
        if (compareT < 0) {
            return search(x.left, key);
        } else if (compareT > 0) {
            return search(x.right, key);
        } else {
            return x;
        }
    }

    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    private BSTNode<T> iterativeSearch(BSTNode<T> x, T key) {
        while (x != null) {
            int compareT = key.compareTo(x.key);
            if (compareT < 0) {
                x = x.left;
            } else if (compareT > 0) {
                x = x.right;
            } else {
                return x;
            }
        }
        return x;
    }

    

    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /*
    * 查找最大结点：返回tree为根结点的二叉树的最大结点。
    */
    private BSTNode<T> maximum(BSTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    public T maximum() {
        BSTNode<T> p = maximum(mRoot);
        if (p != null) {
            return p.key;
        } else {
            return null;
        }

    }

    private BSTNode<T> minimum(BSTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public T minimum() {
        BSTNode<T> p = minimum(mRoot);
        if (p != null) {
            return p.key;
        } else {
            return null;
        }

    }

    public BSTNode<T> predecessor(BSTNode<T> x) {
        // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"
        if (x.left != null) {
            return maximum(x.left);
        }
        // 如果x没有左孩子。则x有以下两种可能：
        // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
        // (01) x是"一个左孩子"，则查找"x的最低的父结点"，找到的这个"最低的父结点"就是"x的前驱结点"。
        BSTNode<T> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public BSTNode<T> successor(BSTNode<T> x) {
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (x.right != null) {
            return minimum(x.right);
        }
        // 如果x没有右孩子。则x有以下两种可能：
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，"，找到的这个"最低的父结点"就是"x的后继结点"。
        BSTNode<T> y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public void treeInsert(BSTree<T> t, BSTNode<T> z) {
        BSTNode<T> x = t.mRoot;
        BSTNode<T> y = null;
        int compareT;
        //
        while (x != null) {
            y = x;
            compareT = z.key.compareTo(x.key);
            if (compareT < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        //
        z.parent = y;

        if (y == null) {
            t.mRoot = z;
        } else if ((compareT = z.key.compareTo(y.key)) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }
    }
    public void insert(T key) {
        BSTNode<T> z=new BSTNode<T>(key,null,null,null);

        // 如果新建结点失败，则返回。
        if (z != null)
            treeInsert(this, z);
    }

    public void transplant(BSTree<T> t, BSTNode<T> u, BSTNode<T> v) {
        if (u.parent == null) {
            t.mRoot = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }

    public void treeDelete(BSTree<T> t, BSTNode<T> z) {
        if (z.left == null) {
            transplant(t, z, z.right);
        } else if (z.right == null) {
            transplant(t, z, z.left);
        } else {
            BSTNode<T> y = successor(z);
            if (y != z.right) {
                transplant(t, z, z.right);
            }
            transplant(t, z, y);
        }
    }


    private void print(BSTNode<T> tree, T key, int direction) {

        if (tree != null) {

            if (direction == 0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key,
                        direction == 1 ? "right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }

    /*
    * 销毁二叉树
    */
    private void destroy(BSTNode<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree = null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }
}


public class BSTreeTest {

    private static final int arr[] = {1,5,4,3,2,6};

    public static void main(String[] args) {
        int i, ilen;
        BSTree<Integer> tree=new BSTree<Integer>();

        System.out.print("== 依次添加: ");
        ilen = arr.length;
        for(i=0; i<ilen; i++) {
            System.out.print(arr[i]+" ");
            tree.insert(arr[i]);
        }


        System.out.println("== 最小值: "+ tree.minimum());
        System.out.println("== 最大值: "+ tree.maximum());
        System.out.println("== 树的详细信息: ");
        tree.print();

//        System.out.print("\n== 删除根节点: "+ arr[3]);
//        tree.remove(arr[3]);
//


        // 销毁二叉树
        tree.clear();
    }
}