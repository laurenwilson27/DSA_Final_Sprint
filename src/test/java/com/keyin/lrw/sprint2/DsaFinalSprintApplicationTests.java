package com.keyin.lrw.sprint2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.keyin.lrw.sprint2.BinaryTree.Node;
import com.keyin.lrw.sprint2.BinaryTree.Tree;
import com.keyin.lrw.sprint2.gson.BinaryTreeExclusionStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DsaFinalSprintApplicationTests {

	@Mock
	private TreeService treeService;

	@Mock
	Gson gson = new GsonBuilder()
			.setExclusionStrategies(new BinaryTreeExclusionStrategy())
			.create();

	@InjectMocks
	private PageController pageController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(pageController).build();
	}

	@Test
	void contextLoads() {
	}

	// Test that when a Tree is created and a series of numbers is inserted,
	//	the value 1 is left of 2 is left of the root, 3.
	@Test
	void testTreeStructure() {
		Tree testTree = new Tree();
		testTree.insert(3);
		testTree.insert(2);
		testTree.insert(1);
		testTree.insert(4);
		testTree.insert(5);

		assertEquals(1, testTree.getRoot().getLeft().getLeft().getValue());
	}

	// Test that the expected view ("index") is returned on the root ("/") path
	@Test
	void testIndex() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));
	}

	// Test that the "/previous-trees" path shows the "previousTrees" view with a model containing the previous trees
	@Test
	void testPreviousTrees() throws Exception {
		mockMvc.perform(get("/previous-trees"))
				.andExpect(status().isOk())
				.andExpect(view().name("previousTrees"))
				.andExpect(model().attributeExists("trees"));
	}

	// Test a mock creation of a new Tree through the app
	@Test
	void testNewTree() throws Exception {
		String input = "3, 2, 1";

		Tree testTree = new Tree(input);
		testTree.insert(2);
		testTree.insert(1);
		testTree.insert(3);
		testTree.setId(100L);

		String mockJson = "";

		when(treeService.createTreeFromValues(input)).thenReturn(testTree);
		when(gson.toJson(testTree)).thenReturn(mockJson);

		mockMvc.perform(post("/process-numbers")
				.param("values", input))
				.andExpect(status().isOk())
				.andExpect(view().name("processNumbers"))
				.andExpect(model().attribute("json", mockJson))
				.andExpect(model().attribute("treeId", 100L));
	}
}
