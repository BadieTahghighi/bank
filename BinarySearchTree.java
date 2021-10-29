import java.util.HashMap;

/**
 *
 * @author Hooman
 */
public class BinarySearchTree<K, V> extends SearchStructure<K, V> {
    class Node<K, V> {
        Item<K, V> item;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        public Node(K key, V data) {
            item = new Item<K, V>(key, data);
            left = null;
            right = null;
        }
    }

    public Node<K, V> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public V search(K key) {
        Node<K, V> current = root;
        while (current != null) {
            if (current.item.key.equals(key)) {
                return current.item.data;
            } else if (current.item.key.compareTo(key) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public boolean delete(Object key) {
        Node<K, V> parent = root;
        Node<K, V> current = root;
        boolean isLeftChild = false;
        while (!current.item.key.equals(key)) {
            parent = current;
            if (current.item.key.compareTo(key) > 0) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        // If program pointer is here that means we have found the node
        // Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {
            // now we have found the minimum element in the right sub-tree
            Node<K, V> successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node<K, V> getSuccessor(Node<K, V> deleleNode) {
        Node<K, V> successsor = null;
        Node<K, V> successsorParent = null;
        Node<K, V> current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        // Check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
        // successsorParent
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    public boolean insert(K key, V data) {
        if (search(key) != null)
            return false;
        Node<K, V> newNode = new Node<K, V>(key, data);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node<K, V> current = root;
        Node<K, V> parent = null;
        while (true) {
            parent = current;
            if (current.item.key.compareTo(key) > 0) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    newNode.parent = parent;
                    return true;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    newNode.parent = parent;
                    return true;
                }
            }
        }
    }

    public HashMap<K, V> iterator() {
        HashMap<K, V> result = new HashMap<>();
        Node<K, V> current = this.root;
        do {
            result.put(current.item.key, current.item.data);
            if (current.left != null) {
                current = current.left;
            } else {
                while (current.right == null) {
                    current = current.parent;
                }
                if (current != null) {
                    current = current.right;
                }
            }
        } while (current.parent != null);
        return result;
    }

    public void display(Node<K, V> root) {
        if (root != null) {
            display(root.left);
            System.out.print(root.item);
            display(root.right);
        }
    }

    public void print() {
        if (root != null) {
            display(root);
            System.out.println();
        } else {
            System.out.println("Empty Tree");
        }
    }
}
