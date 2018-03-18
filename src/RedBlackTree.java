public class RedBlackTree {
    public static final int RED = 0;
    public static final int BLACK = 1;
    public node root;
    public static node nil;
    static {
        nil.color = BLACK;
    }
    public RedBlackTree(node root) {
        this.root = root;
    }

    public  RedBlackTree(){

    }
    public class node {
        public int color;
        public node left;
        public node right;
        public int key;
        public node parent;
    }

    public node maximum(){
        node a = root;
        while (a.right != nil){
            a = a.right;
        }
        return a;
    }

    public node minimum(){
        node a = root;
        while (a.left != nil){
            a = a.left;
        }
        return a;
    }

    public node search(int value){
        node a = root;
        while (a.key!=value){
            if (a.key>value){
                a = a.left;
            }
            else{
                a = a.right;
            }
        }
        return a;
    }

    public node successor (node a){
        if (a.right!=nil){
            RedBlackTree newTree = new RedBlackTree(a.right);
            return newTree.minimum();
        }
        else {
            while (a.parent.right == a){
                a = a.parent;
            }
            return a.parent;
        }
    }

    public node presuccessor (node a){
        if (a.left!=nil){
            RedBlackTree newTree = new RedBlackTree(a.left);
            return newTree.maximum();
        }
        else {
            while (a.parent.left == a){
                a = a.parent;
            }
            return a.parent;
        }
    }

    public void insert(int key){
        node x = new node();
        x.key = key;
        x.left = nil;
        x.right =nil;
        if (root==null){
            x.color = BLACK;
            x.parent = null;
            root = x;
        }
        else{
            x.color = RED;
            node t = root;
            node y = null;
            while (t!=nil){
                y = t;
                if (x.key<t.key){
                    t = t.left;
                }
                else {
                    t = t.right;
                }
            }
            if (x.key<y.key){
                y.left = x;
                x.parent = y;
            }
            else{
                y.right = x;
                x.parent = y;
            }
            insertAdjustment(x);
        }
    }

    public void insertAdjustment(node x){
        if (x.parent!=null) {
            if (x.parent.color == RED) {


            }
        }
    }

}
