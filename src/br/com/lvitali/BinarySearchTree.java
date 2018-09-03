package br.com.lvitali;

public class BinarySearchTree {

    Node root;

    public void insert(Node parentNode, String value, boolean choice) {
        root = insertNewNode(parentNode, value, choice);
    }

    public void showTree(Node rootNode) {
        if (rootNode != null) {
            System.out.println(rootNode.getValue());
            showTree(rootNode.getLeftChild());
            showTree(rootNode.getRightChild());
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node insertNewNode(Node parentNode, String value, boolean choice) {
        if (parentNode == null) {
            parentNode = new Node(value);
            return parentNode;
        } else if (choice) {
            parentNode.setRightChild(insertNewNode(parentNode.getRightChild(), value, choice));
        } else {
            parentNode.setLeftChild(insertNewNode(parentNode.getLeftChild(), value, choice));
        }

        return parentNode;
    }
}
