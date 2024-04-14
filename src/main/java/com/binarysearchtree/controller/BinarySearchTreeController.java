package com.binarysearchtree.controller;

import com.binarysearchtree.model.dto.Node;
import com.binarysearchtree.model.dto.NumbersForm;
import com.binarysearchtree.model.entity.ProcessedData;
import com.binarysearchtree.repository.ProcessedDataRepository;
import com.binarysearchtree.service.BinarySearchTreeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BinarySearchTreeController {

    private final BinarySearchTreeService binarySearchTreeService;
    private final ProcessedDataRepository processedDataRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/enter-numbers")
    public String enterNumbers(Model model) {
        model.addAttribute("numbersForm", new NumbersForm());
        return "enter-numbers";
    }

    @GetMapping("/previous-trees")
    public String getHistory(Model model) {
        List<ProcessedData> processedDataList = processedDataRepository.findAll();
        model.addAttribute("processedDataList", processedDataList);
        return "history";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@Valid NumbersForm numbersForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "enter-numbers";
        }
        String numbersString = numbersForm.getNumbersString();
        String[] split = numbersString.split(",");
        List<Double> numbers = Arrays.stream(split).mapToDouble(Double::parseDouble).boxed().toList();

        Node root = binarySearchTreeService.constructTree(numbers);
        String treeJson = binarySearchTreeService.convertTreeToJson(root);

        ProcessedData processedData = new ProcessedData();
        processedData.setNumbers(numbersString);
        processedData.setTreeJson(treeJson);
        processedDataRepository.save(processedData);

        model.addAttribute("numbers", "");
        model.addAttribute("processedData", processedData);
        return "enter-numbers";
    }
}
