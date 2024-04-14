package com.binarysearchtree.service;

import com.binarysearchtree.model.dto.Node;

import java.util.List;

public interface BinarySearchTreeService {
    Node constructTree(List<Double> numbers);
    String convertTreeToJson(Node root);
}
