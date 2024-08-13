package com.keyin.lrw.sprint2.BinaryTree;

import jakarta.persistence.*;

@Entity
public class Node {
    @Id
    @SequenceGenerator(name = "node_sequence", sequenceName = "node_sequence", allocationSize = 1)
    @GeneratedValue(generator = "node_sequence")
    private long id;

    private final int value;

    @OneToOne(cascade = CascadeType.ALL)
    private Node left;
    @OneToOne(cascade = CascadeType.ALL)
    private Node right;

    public Node() {
        this.value = -1;
        this.left = null;
        this.right = null;
    }

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() { return value; }

    public Node getLeft() { return left; }
    public Node getRight() { return right; }

    public void setLeft(Node node) { left = node; }
    public void setRight(Node node) { right = node; }
}
