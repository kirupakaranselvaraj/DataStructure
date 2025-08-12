package tree;
class Anode {
    int data, height;
    Anode left, right;
    public Anode(int data) {
        this.data = data;
        height = 1;
        left = right = null;
    }
}
public class Avltree {
    static Anode root;
    static Anode createNode(int data) {
        return new Anode(data);
    }
    static int height(Anode root) {
        return root == null ? 0 : root.height;
    }
    public static int balance(Anode root) {
        return root == null ? 0 : height(root.left) - height(root.right);
    }
    public static Anode rightRotate(Anode y) {
        Anode x = y.left;
        Anode t2 = x.right;
        x.right = y;
        y.left = t2;
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;
    }
    public static Anode leftRotate(Anode x) {
        Anode y = x.right;
        Anode t2 = y.left;
        y.left = x;
        x.right = t2;
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }
    public static Anode insert(Anode root, int data) {
        if (root == null) return createNode(data);
        if (data < root.data) root.left = insert(root.left, data);
        else if (data > root.data) root.right = insert(root.right, data);
        else return root;
        root.height = 1 + Math.max(height(root.left), height(root.right));
        int bal = balance(root);
        if (bal > 1 && data < root.left.data) return rightRotate(root);
        if (bal < -1 && data > root.right.data) return leftRotate(root);
        if (bal > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (bal < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    public static void postOrder(Anode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }
    public static void insertAnode(int data) {
        root = insert(root, data);
    }
    public static void main(String[] args) {
        insertAnode(50);
        insertAnode(40);
        insertAnode(30);
        insertAnode(20);
        insertAnode(25);
        postOrder(root);
    }
}
