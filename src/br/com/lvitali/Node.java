package br.com.lvitali;

public class Node {

    private String value;
    private Node leftChild;
    private Node rightChild;

    public Node(String data) {
        value = data;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
}
