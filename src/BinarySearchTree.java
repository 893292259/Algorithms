public class BinarySearchTree
{
    node root;

    public BinarySearchTree(node root) {
        this.root = root;
    }

    public  BinarySearchTree(){

    }

    public class node{
        node parent;
        node left;
        node right;
        int value;
    }

    public void insert (int value){
        node a  = new node();
        a.value = value;
        if (root == null){
            root = a;
        }else{
            node x = root;
            node y = null;
            while (x!=null){
                y = x;
             if (a.value<x.value){
                 x = x.left;
             }
             else {
                 x = x.right;
             }
            }
            if (a.value<y.value){
                y.left = a;
                a.parent = y;
            }
            else{
                y.right = a;
                a.parent = y;
            }
        }
    }

    public node maximum(){
        node a = root;
        while (a.right != null){
            a = a.right;
        }
        return a;
    }

    public node minimum(){
        node a = root;
        while (a.left != null){
            a = a.left;
        }
        return a;
    }

    public node search(int value){
        node a = root;
        while (a.value!=value){
            if (a.value>value){
                a = a.left;
            }
            else{
                a = a.right;
            }
        }
        return a;
    }

    public node successor (node a){
        if (a.right!=null){
            BinarySearchTree newTree = new BinarySearchTree(a.right);
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
        if (a.left!=null){
            BinarySearchTree newTree = new BinarySearchTree(a.left);
            return newTree.maximum();
        }
        else {
            while (a.parent.left == a){
                a = a.parent;
            }
            return a.parent;
        }
    }

    public void transplant (node a, node b){
        if (a.parent == null) {
            root = b;
        }
        else {
            if (a.value < a.parent.value) {
                a.parent.left = b;
                b.parent = a.parent;
            } else {
                a.parent.right = b;
                b.parent = a.parent;
            }
        }
    }

    public void delete (node a){
        if (a.left == null && a.right==null){
            if (a == a.parent.left){
                a.parent.left = null;
            }  else{
                a.parent.right = null;
            }
        }
        else {
            if (a.right == null) {
                transplant(a, a.left);
            } else if (a.left == null) {
                transplant(a, a.right);
            } else {
                node b = successor(a);
                if (b != a.right) {
                    transplant(b, b.right);
                    b.right = a.right;
                    a.right.parent = b;
                }
                transplant(a, b);
                b.left = a.left;
                b.left.parent = b;
            }
        }
    }

}
