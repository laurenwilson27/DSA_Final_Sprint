package com.keyin.lrw.sprint2;

import com.keyin.lrw.sprint2.BinaryTree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PageController {
    @Autowired
    TreeService treeService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("tree")
    public Tree addTree(@RequestBody String values) {
        // A plain string is given to the server, parse it into a list of integers
        List<Integer> parsedValues = Arrays.stream(values.trim().split(", *"))
                .map(Integer::parseInt).collect(Collectors.toList());

        return treeService.createTreeFromValues(parsedValues);
    }
}
