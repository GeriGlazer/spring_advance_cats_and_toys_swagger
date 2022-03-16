package com.jb.spring_advance_cats_and_toys_swagger.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {
    private String error;
    private String description;
}
