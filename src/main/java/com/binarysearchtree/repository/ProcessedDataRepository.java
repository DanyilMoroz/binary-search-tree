package com.binarysearchtree.repository;

import com.binarysearchtree.model.entity.ProcessedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessedDataRepository extends JpaRepository<ProcessedData, Long> {
}
