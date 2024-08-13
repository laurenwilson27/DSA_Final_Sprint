package com.keyin.lrw.sprint2.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import java.util.Set;

// Exclusion strategy to prevent Tree and Node ids from being present in JSON represantations created using Gson
// The 'input' of the Tree is also suppressed, as it will be displayed elsewhere.
// This makes it easier to see that the binary tree is structured correctly at a glance :)
public class BinaryTreeExclusionStrategy implements ExclusionStrategy {

    Set<String> fieldsToSkip = Set.of("id", "input");

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return fieldsToSkip.contains(fieldAttributes.getName());
    }

    // No classes should be skipped by this strategy, but the strategy must implement shouldSkipClass method
    @Override
    public boolean shouldSkipClass(Class<?> skipClass) {
        return false;
    }
}
