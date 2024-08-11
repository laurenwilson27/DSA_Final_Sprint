package com.keyin.lrw.sprint2.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

// Exclusion strategy to prevent Tree and Node ids from being present in JSON represantations created using Gson
// This makes it easier to see that the binary tree is structured correctly at a glance :)
public class BinaryTreeExclusionStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return fieldAttributes.getName().equals("id");
    }

    // No classes should be skipped by this strategy, but the strategy must implement shouldSkipClass method
    @Override
    public boolean shouldSkipClass(Class<?> skipClass) {
        return false;
    }
}
