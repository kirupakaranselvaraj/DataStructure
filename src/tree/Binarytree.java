package tree;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class Binarytree {
    Node root;

    public Binarytree() {
        root = null;
    }

    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);
        return root;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    Node delete(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            Node temp = minValueNode(root.right);
            root.key = temp.key;
            root.right = delete(root.right, temp.key);
        }
        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Binarytree tree = new Binarytree();

        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("Inorder before deletion:");
        tree.inorder(tree.root);

        tree.root = tree.delete(tree.root, 20);
        tree.root = tree.delete(tree.root, 30);
        tree.root = tree.delete(tree.root, 50);

        System.out.println("\nInorder after deletion:");
        tree.inorder(tree.root);
    }
}
