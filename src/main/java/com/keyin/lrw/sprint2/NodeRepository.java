package com.keyin.lrw.sprint2;

import com.keyin.lrw.sprint2.BinaryTree.Node;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends CrudRepository<Node, Long> {
}
