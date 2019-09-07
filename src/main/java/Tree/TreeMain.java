package Tree;

public class TreeMain {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(5);
        tree.add(9);
        tree.remove(2);
        System.out.println(tree.search(2));
        System.out.println(tree.search(11));
    }
}
