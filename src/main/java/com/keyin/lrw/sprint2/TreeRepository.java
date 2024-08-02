package com.keyin.lrw.sprint2;

import com.keyin.lrw.sprint2.BinaryTree.Tree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends CrudRepository<Tree, Long> {
}
