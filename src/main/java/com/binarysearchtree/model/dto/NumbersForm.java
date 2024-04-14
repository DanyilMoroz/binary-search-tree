package com.binarysearchtree.model.dto;


import com.binarysearchtree.validation.annotation.ValidNumbersString;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumbersForm {

    @NotBlank(message = "Please enter numbers")
    @ValidNumbersString
    private String numbersString;
}
