package com.keyin.lrw.sprint2;

import com.keyin.lrw.sprint2.BinaryTree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeService {
    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private NodeRepository nodeRepository;

    public Tree createTreeFromValues(String values) {
        Tree newTree = new Tree(values);

        // The values sent by the HTML form are a plain string, parse it into a list of integers
        List<Integer> parsedValues = Arrays.stream(values.trim().split("[, ]+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        // Arrange the values in ascending order
        parsedValues.sort(Comparator.naturalOrder());
        newTree.insertList(parsedValues);

        treeRepository.save(newTree);

        return newTree;
    }
}
