package com.keyin.lrw.sprint2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.keyin.lrw.sprint2.BinaryTree.Tree;
import com.keyin.lrw.sprint2.forms.EnterNumbersForm;
import com.keyin.lrw.sprint2.gson.BinaryTreeExclusionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PageController {

    @Autowired
    TreeService treeService;

    // Use Gson to convert objects into pretty-printed JSON strings
    // keys with null values are ignored (gson default) and an exclusion strategy is used to omit Tree/Node ids
    Gson gson = new GsonBuilder()
            .setExclusionStrategies(new BinaryTreeExclusionStrategy())
            .setPrettyPrinting()
            .create();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/enter-numbers")
    public String enterNumbers(Model model) {
        model.addAttribute("form", new EnterNumbersForm(null));

        return "enterNumbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@ModelAttribute("values") String values, Model model) {
        Tree newTree = treeService.createTreeFromValues(values);
        String json = gson.toJson(newTree);

        model.addAttribute("json", json);
        model.addAttribute("treeId", newTree.getId());

        return "processNumbers";
    }

    @GetMapping("/previous-trees")
    public String previousTrees(Model model) {
        model.addAttribute("trees", treeService.getAllTrees());

        return "previousTrees";
    }

    @GetMapping("/previous-trees/{id}")
    public String singleTree(@PathVariable long id, Model model) {
        Tree tree = treeService.getTree(id);
        String json = gson.toJson(tree);

        model.addAttribute("tree", tree);
        model.addAttribute("json", json);

        return "singleTree";
    }
}
