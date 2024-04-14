package com.binarysearchtree.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    private double data;
    private Node left;
    private Node right;

    public Node(double data) {
        this.data = data;
    }
}
