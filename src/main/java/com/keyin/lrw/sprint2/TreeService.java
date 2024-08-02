package com.keyin.lrw.sprint2;

import com.keyin.lrw.sprint2.BinaryTree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class TreeService {
    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private NodeRepository nodeRepository;

    public Tree createTreeFromValues(List<Integer> values) {
        Tree newTree = new Tree();
        // Arrange the values in ascending order
        values.sort(Comparator.naturalOrder());
        newTree.insertList(values);

        treeRepository.save(newTree);

        return newTree;
    }
}
