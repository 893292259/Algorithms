public class BinarySearchTreeImpl {
    public static void main (String... args){
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(0);
        tree.insert(-1);
        tree.insert(11);
        tree.insert(2);
        int a = tree.maximum().value;
        tree.delete(tree.maximum());
        a = tree.maximum().value;
        int b = tree.minimum().value;
        
    }
}
