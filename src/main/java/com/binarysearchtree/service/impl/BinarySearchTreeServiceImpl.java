package com.binarysearchtree.service.impl;

import com.binarysearchtree.model.dto.Node;
import com.binarysearchtree.service.BinarySearchTreeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BinarySearchTreeServiceImpl implements BinarySearchTreeService {
    @Override
    public Node constructTree(List<Double> numbers) {
        Node root = null;
        for (Double num : numbers) {
            root = insertIntoBST(root, num);
        }
        return root;
    }

    @Override
    public String convertTreeToJson(Node root) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    private Node insertIntoBST(Node root, double value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.getData()) {
            root.setLeft(insertIntoBST(root.getLeft(), value));
        } else if (value > root.getData()) {
            root.setRight(insertIntoBST(root.getRight(), value));
        }
        // Ignore duplicates (do nothing if value == root.getData())
        return root;
    }
}
