package com.keyin.lrw.sprint2.BinaryTree;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tree {
    @Id
    @SequenceGenerator(name = "tree_sequence", sequenceName = "tree_sequence", allocationSize = 1)
    @GeneratedValue(generator = "tree_sequence")
    private long id;
    private final String input;

    @OneToOne(cascade = CascadeType.ALL)
    private Node root;

    public Tree() {
        this.root = null;
        this.input = null;
    }

    public Tree(String input) {
        this.root = null;
        this.input = input;
    }

    public long getId() { return id; }
    public Node getRoot() { return root; }
    public String getInput() { return input; }

    public void setId(long id) { this.id = id; }
    public void setRoot(Node root) { this.root = root; }

    public void insert(int value) {
        root = insertRecursion(root, value);
    }

    private Node insertRecursion(Node root, int value) {
        // If we're at an empty space in the tree, add the value into the space
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.getValue())
            root.setLeft(insertRecursion(root.getLeft(), value));
        else
            root.setRight(insertRecursion(root.getRight(), value));

        return root;
    }

    // Adds a given list of values to the tree using recursion
    // The list should be sorted in ascending order to result in a more balanced tree,
    //  but it is not a requirement
    public void insertList(List<Integer> values) {
        if (values.isEmpty())
            return;

        int midValue = values.remove(values.size()/2);
        int valuesRemaining = values.size();
        List<Integer> leftHalf = new ArrayList<>(values.subList(0, valuesRemaining/2));
        List<Integer> rightHalf = new ArrayList<>(values.subList(valuesRemaining/2, valuesRemaining));

        insert(midValue);
        insertList(leftHalf);
        insertList(rightHalf);
    }
}
