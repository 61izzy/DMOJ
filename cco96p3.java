import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            Quadtree tree = new Quadtree();
            tree.add(scanner.next());
            tree.add(scanner.next());
            System.out.println("There are " + tree.getValue(tree.root, 1024) + " black pixels.");
        }
    }
}

class Node {
    char c;
    Node[] child;
    public Node(char c) {
        this.c = c;
        child = new Node[4];
    }
}

class Quadtree {
    int n;
    Node root;
    String s;
    public void add(String s) {
        n = 0;
        this.s = s;
        root = add(root);
    }
    public Node add(Node node) {
        n++;
        if (node == null) node = new Node(s.charAt(n - 1));
        if (s.charAt(n - 1) == 'f') node.c = 'f';
        else if (s.charAt(n - 1) == 'p') {
            if (node.c != 'f') node.c = 'p';
            for (int i = 0; i < 4; i++) node.child[i] = add(node.child[i]);
        }
        return node;
    }
    public int getValue(Node node, int val) {
        if (node.c == 'e') return 0;
        else if (node.c == 'f') return val;
        return getValue(node.child[0], val/4) + getValue(node.child[1], val/4) + getValue(node.child[2], val/4) + getValue(node.child[3], val/4);
    }
}
