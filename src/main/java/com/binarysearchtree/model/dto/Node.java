package com.binarysearchtree.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeDTO {

    private Long id;
    private NodeDTO left;
    private NodeDTO right;
}
