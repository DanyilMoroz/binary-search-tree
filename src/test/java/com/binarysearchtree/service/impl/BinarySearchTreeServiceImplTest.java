package com.binarysearchtree.service.impl;

import com.binarysearchtree.model.dto.Node;
import com.binarysearchtree.service.BinarySearchTreeService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeServiceImplTest {

    @Test
    public void testConstructTree_emptyInput() {
        BinarySearchTreeService service = new BinarySearchTreeServiceImpl();
        Node root = service.constructTree(Collections.emptyList());
        assertNull(root);
    }

    @Test
    public void testConstructTree_singleElement() {
        BinarySearchTreeService service = new BinarySearchTreeServiceImpl();
        List<Double> numbers = Collections.singletonList(10.0);
        Node root = service.constructTree(numbers);
        assertNotNull(root);
        assertEquals(10.0, root.getData());
        assertNull(root.getLeft());
        assertNull(root.getRight());
    }

    @Test
    public void testConstructTree_sortedInsertion() {
        BinarySearchTreeService service = new BinarySearchTreeServiceImpl();
        List<Double> numbers = Arrays.asList(5.0, 3.0, 7.0, 1.0, 9.0);
        Node root = service.constructTree(numbers);
        assertNotNull(root);
        assertEquals(5.0, root.getData());

        // Assert that the tree contains all expected values
        assertTrue(containsNode(root, 3.0));
        assertTrue(containsNode(root, 7.0));
        assertTrue(containsNode(root, 1.0));
        assertTrue(containsNode(root, 9.0));
    }

    // Helper method to check if a node with specific data exists in the tree
    private boolean containsNode(Node root, double value) {
        if (root == null) {
            return false;
        }
        if (value == root.getData()) {
            return true;
        } else if (value < root.getData()) {
            return containsNode(root.getLeft(), value);
        } else {
            return containsNode(root.getRight(), value);
        }
    }

    @Test
    public void testConstructTree_ignoresDuplicates() {
        BinarySearchTreeService service = new BinarySearchTreeServiceImpl();
        List<Double> numbers = Arrays.asList(5.0, 3.0, 5.0, 7.0, 5.0);
        Node root = service.constructTree(numbers);
        assertNotNull(root);
        assertEquals(5.0, root.getData());
    }
}