package tree;

class BNode {
    int data;
    BNode left, right;

    public BNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class binarysearchtree {
    static BNode root = null;

    public static void insert(int data) {
        BNode node = new BNode(data);
        if (root == null) {
            root = node;
        } else {
            BNode cur = root;
            while (true) {
                if (data < cur.data) {
                    if (cur.left == null) {
                        cur.left = node;
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right == null) {
                        cur.right = node;
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }
    }

    public static BNode search(BNode root, int data) {
        BNode cur = root;
        while (cur != null) {
            if (cur.data == data) {
                return cur;
            } else if (cur.data < data) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }

    public static void print(BNode root) {
        if (root != null) {
            print(root.left);
            System.out.println(root.data);
            print(root.right);
        }
    }

    public static void main(String[] args) {
        insert(50);
        insert(48);
        insert(51);
        insert(52);
        insert(49);
        insert(89);

        System.out.println("Inorder Traversal:");
        print(root);

        if (search(root, 52) != null) {
            System.out.println("Data is present");
        } else {
            System.out.println("Data is not present");
        }
    }
}
