public class BST<T, S> {
    public Node root;

    public BST() {

    }

    public boolean add(Node node) {
        boolean added = false;
        if (this.root == null) {
            root = node;
            added = true;
        } else {
            Node temp = root;
            while (temp != null) {
                if (node.key >= temp.key) {
                    if (temp.right == null) {
                        temp.right = node;
                        node.parent = temp;
                        added = true;
                        break;
                    } else {
                        temp = temp.right;
                    }
                } else {
                    if (temp.left == null) {
                        temp.left = node;
                        node.parent = temp;
                        added = true;
                        break;
                    } else {
                        temp = temp.left;
                    }
                }
            }
        }
        return added;
    }

    public Node get(int id) {
        Node result = null;
        if (this.root != null) {
            Node temp = this.root;
            while (temp != null) {
                if (id == temp.key) {
                    result = temp;
                    break;
                } else if (id > temp.key) {
                    temp = temp.right;
                } else {
                    temp = temp.right;
                }
            }
        }
        return result;
    }
}
