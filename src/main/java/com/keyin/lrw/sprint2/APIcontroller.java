package com.keyin.lrw.sprint2;

import com.keyin.lrw.sprint2.BinaryTree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class APIcontroller {
    @Autowired
    TreeService treeService;

    /*@RequestMapping(value = "/process-numbers", method = RequestMethod.POST)
    public Tree processNumbers(@ModelAttribute("values") String values) {
        // The values sent by the HTML form are a plain string, parse it into a list of integers
        List<Integer> parsedValues = Arrays.stream(values.trim().split(", *"))
                .map(Integer::parseInt).collect(Collectors.toList());

        return treeService.createTreeFromValues(parsedValues);
    }*/

    /*
    @PostMapping("/tree")
    public Tree addTree(@RequestBody String values) {
        // A plain string is given to the server, parse it into a list of integers
        List<Integer> parsedValues = Arrays.stream(values.trim().split(", *"))
                .map(Integer::parseInt).collect(Collectors.toList());

        return treeService.createTreeFromValues(parsedValues);
    }
    */
}
